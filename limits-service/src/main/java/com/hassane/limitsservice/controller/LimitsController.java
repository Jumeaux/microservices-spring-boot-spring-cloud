package com.hassane.limitsservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hassane.limitsservice.config.ApplicationProperties;
import com.hassane.limitsservice.domain.Limits;

@RestController
@RefreshScope
public class LimitsController {


    @Autowired
    private  ApplicationProperties appProperties;

    @Autowired
    private  ApplicationProperties limitsProperties;
  

    @GetMapping("/limits")
    public  Limits retriveLimits(){

        return new Limits( appProperties.getMin(),appProperties.getMax(), limitsProperties.getMinimun(), limitsProperties.getMaximum());
        
        // return new Limits(0,1,20,45);
    }
    
}
