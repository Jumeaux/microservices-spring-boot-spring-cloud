package com.hassane.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hassane.limitsservice.config.Configuration;
import com.hassane.limitsservice.domain.Limits;

@RestController
@RefreshScope
public class LimitsController {


    @Autowired
    private  Configuration configuration;

    @Value("${limits-service.minimun}")
    private int minimun;

    
    @Value("${limits-service.maximum}")
    private int maximum;

    @Value("${globale.params.min}")
    private int min;

    @Value("${globale.params.max}")
    private int max;

    @GetMapping("/limits")
    public  Limits retriveLimits(){
        return new Limits( min,max,minimun,maximum);

        // return new Limits(configuration.getMinimun(),configuration.getMaximum());
        
        // return new Limits(20,45);
    }
    
}
