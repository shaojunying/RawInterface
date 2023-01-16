package com.shao.rawinterface.controller;

import com.shao.rawinterface.entity.ResponseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SynchronousFailedTaskControllerTest {
    @Test
    void testSuccessfulTask() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/synchronous-failed-task/run?taskId=1";
        ResponseEntity response = restTemplate.postForObject(url, null, ResponseEntity.class);
        assertNotNull(response);
        System.out.println("response = " + response);
        assertEquals(500, response.getCode());
        assertEquals("Task 1 is failed", response.getMessage());
        assertEquals("{ \"status\": \"Failed\" }", response.getData());
    }
}