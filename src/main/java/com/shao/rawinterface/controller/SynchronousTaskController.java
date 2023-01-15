package com.shao.rawinterface.controller;

import com.shao.rawinterface.entity.ResponseEntity;
import com.shao.rawinterface.service.SynchronousTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "synchronous-task")
public class SynchronousTaskController {
    private final SynchronousTaskService SynchronousTaskService;

    @Autowired
    public SynchronousTaskController(SynchronousTaskService synchronousTaskService) {
        this.SynchronousTaskService = synchronousTaskService;
    }

    @PostMapping(value = "run")
    public ResponseEntity run(@RequestParam("taskId") int taskId) throws InterruptedException {
        return SynchronousTaskService.run(taskId);
    }
}
