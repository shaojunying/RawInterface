package com.shao.rawinterface.controller;

import com.shao.rawinterface.entity.ResponseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsynchronousFailedTaskControllerTest {
    @Test
    void testFailedTask() throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/asynchronous-failed-task/submit?taskId=1";
        ResponseEntity entity = restTemplate.postForObject(url, null, ResponseEntity.class);
        assertNotNull(entity);
        System.out.println("entity = " + entity);
        assertEquals(201, entity.getCode());
        assertEquals("Running", entity.getStatus());
        assertNull(entity.getData());

        Thread.sleep(5000);

        String checkUrl = "http://localhost:8081/asynchronous-failed-task/check?taskId=1";
        ResponseEntity responseEntity = restTemplate.getForObject(checkUrl, ResponseEntity.class);
        assertNotNull(responseEntity);
        System.out.println("responseEntity = " + responseEntity);
        assertEquals(500, responseEntity.getCode());
        assertEquals("Failed", responseEntity.getStatus());
        assertNull(responseEntity.getData());

    }
}