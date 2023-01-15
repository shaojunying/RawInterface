package com.shao.rawinterface.service;


import com.shao.rawinterface.entity.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AsynchronousTaskService {

    private static final int SECONDS_TO_SLEEP = 5;

    private static final ConcurrentHashMap<Integer, Timestamp> taskMap = new ConcurrentHashMap<>();

    public ResponseEntity submit(int taskId) {
        taskMap.put(taskId, new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity(201, "Running", null);
    }

    public ResponseEntity check(int taskId, boolean shouldSuccess) {
        Timestamp timestamp = taskMap.get(taskId);
        if (timestamp == null) {
            return new ResponseEntity(404, "Not Found", null);
        }
        long currentTime = System.currentTimeMillis();
        long taskTime = timestamp.getTime();
        if (currentTime - taskTime < SECONDS_TO_SLEEP * 1000) {
            return new ResponseEntity(201, "Running", null);
        }
        if (shouldSuccess) {
            return new ResponseEntity(200, "Success", null);
        } else {
            return new ResponseEntity(500, "Failed", null);
        }
    }


}
