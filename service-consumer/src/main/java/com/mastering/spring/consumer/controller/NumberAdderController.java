package com.mastering.spring.consumer.controller;

import com.mastering.spring.consumer.service.RandomServiceProxy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class NumberAdderController {

    private RandomServiceProxy randomServiceProxy;

    @RequestMapping("/add")
    public Long add() {
        long sum = 0;
        List<Integer> numbers = randomServiceProxy.getRandomNumbers();
        for (int number : numbers) {
            sum += number;
        }
        log.info("Returning {}", sum);
        return sum;
    }
}