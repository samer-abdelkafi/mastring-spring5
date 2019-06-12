package com.mastering.spring.consumer.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "zuul-api-gateway")
//@FeignClient(name = "microservice-a")
@RibbonClient(name = "microservice-a")
public interface RandomServiceProxy {

    //    @GetMapping(value = "/random")
    @GetMapping(value = "/microservice-a/random")
    List<Integer> getRandomNumbers();

}