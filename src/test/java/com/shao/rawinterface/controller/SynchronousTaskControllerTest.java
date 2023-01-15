package com.shao.rawinterface.controller;

import com.shao.rawinterface.RawInterfaceApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SynchronousTaskControllerTest {
    @Test
    void testSuccessfulTask() throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/synchronous-task/run?taskId=1";
        String response = restTemplate.postForObject(url, null, String.class);
        assertNotNull(response);
        System.out.println("response = " + response);
        assertEquals("Success from synchronous task 1", response);
    }
}