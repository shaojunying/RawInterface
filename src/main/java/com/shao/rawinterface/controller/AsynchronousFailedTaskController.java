package com.shao.rawinterface.controller;

import com.shao.rawinterface.entity.ResponseEntity;
import com.shao.rawinterface.service.AsynchronousTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "asynchronous-failed-task")
public class AsynchronousFailedTaskController {
    private final AsynchronousTaskService AsynchronousTaskService;

    @Autowired
    public AsynchronousFailedTaskController(AsynchronousTaskService asynchronousTask) {
        this.AsynchronousTaskService = asynchronousTask;
    }

    @PostMapping(value = "submit")
    public ResponseEntity submit(@RequestParam("taskId") int taskId) {
        return AsynchronousTaskService.submit(taskId);
    }

    @GetMapping(value = "check")
    public ResponseEntity check(@RequestParam("taskId") int taskId) {
        return AsynchronousTaskService.check(taskId, false);
    }
}
