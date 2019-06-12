package com.mastring.spring.consumer.serviceconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class NumberAdderController {
    @Value("${number.service.url}")
    private String numberServiceUrl;

    @RequestMapping("/add")
    public Long add() {
        long sum = 0;
        ResponseEntity<Integer[]> responseEntity
                = new RestTemplate()
                .getForEntity(numberServiceUrl,
                        Integer[].class);
        Integer[] numbers = responseEntity.getBody();
        for (int number : numbers) {
            sum += number;
        }
        log.info("Returning {}", sum);
        return sum;
    }
}