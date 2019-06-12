package com.mastering.spring.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "microservice-a", url = "localhost:8080")
public interface RandomServiceProxy {

    @GetMapping(value = "/random")
    List<Integer> getRandomNumbers();

}