package com.shao.rawinterface.task;

public class Task {
    private final int taskId;
    private final int sleepTime;

    public Task(int taskId, int sleepTime) {
        this.taskId = taskId;
        this.sleepTime = sleepTime;
    }

    public String run() throws InterruptedException {
        Thread.sleep(sleepTime);
        return "success";
    }
}
