package com.hassane.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
    

    private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    // @Retry(name = "sample-api", fallbackMethod = "fallbackResponse")
    // @CircuitBreaker(name = "default", fallbackMethod = "fallbackResponse")
    // @RateLimiter(name = "default", fallbackMethod = "fallbackResponse")

    @Bulkhead(name = "sample-api")
    public String testCircuitBreaker(){

        logger.info("sapmple API called receive");
/* 
        ResponseEntity<String> res= new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return res.getBody(); */

        return "Test RaterMimiter";
    }


    public String fallbackResponse(Exception e){
        return "falback method";
    }
}
