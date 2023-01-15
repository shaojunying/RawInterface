package com.shao.rawinterface.service;

import com.shao.rawinterface.entity.ResponseEntity;
import com.shao.rawinterface.task.Task;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SynchronousTaskService {

    private final Random random = new Random();

    public ResponseEntity run(int taskId) throws InterruptedException {
        new Task(1000, random.nextInt(5000)).run();
        System.out.println("task " + taskId + " is finished");
        return new ResponseEntity(200, "Success", null);
    }
}
