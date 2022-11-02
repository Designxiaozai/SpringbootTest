package com.ljm.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
public class RabbitmqController {
    @Autowired
    private sent sender;

    @GetMapping("hello")
    public String helloTest() throws IOException, TimeoutException {
       sender.send();
       return "hello";
    }
}
