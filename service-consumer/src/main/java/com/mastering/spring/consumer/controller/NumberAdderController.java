package com.mastering.spring.consumer.controller;

import com.mastering.spring.consumer.service.RandomServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
public class NumberAdderController {

    private RandomServiceProxy randomServiceProxy;

    @HystrixCommand(fallbackMethod = "getDefaultResponse")
    @RequestMapping("/add")
    public Long add() {
//        long sum = 0;
        List<Integer> numbers = randomServiceProxy.getRandomNumbers();
//        for (int number : numbers) {
//            sum += number;
//        }

        long sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        log.info("Returning {}", sum);
        return sum;
    }

    public Long getDefaultResponse() {
        return 10000L;
    }
}