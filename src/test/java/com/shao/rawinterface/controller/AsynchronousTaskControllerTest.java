package com.shao.rawinterface.controller;

import com.shao.rawinterface.RawInterfaceApplication;
import com.shao.rawinterface.entity.ResponseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsynchronousTaskControllerTest {
    @Test
    void testSuccessfulTask() throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/asynchronous-task/submit?taskId=1";
        ResponseEntity entity = restTemplate.postForObject(url, null, ResponseEntity.class);
        assertNotNull(entity);
        System.out.println("entity = " + entity);
        assertEquals(200, entity.getCode());
        assertEquals("Successfully submitted task 1", entity.getMessage());
        assertNull(entity.getData());

        Thread.sleep(5000);

        String checkUrl = "http://localhost:8081/asynchronous-task/check?taskId=1";
        ResponseEntity responseEntity = restTemplate.getForObject(checkUrl, ResponseEntity.class);
        assertNotNull(responseEntity);
        System.out.println("responseEntity = " + responseEntity);
        assertEquals(200, responseEntity.getCode());
        assertEquals("Task 1 is successfully finished", responseEntity.getMessage());
        assertEquals("{ \"status\": \"Success\" }", responseEntity.getData());

    }
}