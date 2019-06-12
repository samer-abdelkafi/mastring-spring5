package com.mastering.spring.cloud.microservicea.controller;

import com.mastering.spring.cloud.microservicea.config.ApplicationConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class MessageController {

    private ApplicationConfiguration configuration;

    @RequestMapping("/message")
    public Map<String, String> welcome() {
        Map<String, String> map = new HashMap<>();
        map.put("message", configuration.getMessage());
        return map;
    }

}