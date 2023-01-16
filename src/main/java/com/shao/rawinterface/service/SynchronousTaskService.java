package com.shao.rawinterface.service;

import com.shao.rawinterface.entity.ResponseEntity;
import com.shao.rawinterface.task.Task;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SynchronousTaskService {

    private final Random random = new Random();

    public ResponseEntity run(int taskId, boolean shouldSuccess) throws InterruptedException {
        new Task(1000, random.nextInt(5000)).run();
        System.out.println("task " + taskId + " is finished");
        if (shouldSuccess) {
            return new ResponseEntity(200, "Task " + taskId + " is successfully finished", "{ \"status\": \"Success\" }");
        } else {
            return new ResponseEntity(500, "Task " + taskId + " is failed", "{ \"status\": \"Failed\" }");
        }
    }
}
