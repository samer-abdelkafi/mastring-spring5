package com.mastring.spring.cloud.microservicea.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class RandomNumberController {

    @RequestMapping("/random")
    public List<Integer> random() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            numbers.add(generateRandomNumber());
        }
        log.info("Returning : {} ", numbers);
        return numbers;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 1000);
    }
}