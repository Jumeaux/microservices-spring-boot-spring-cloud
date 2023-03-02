package com.hassane.limitsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Config {
    
   /*  private int minimun;
    private int maximum;

    public int getMinimun() {
        return minimun;
    }
    public void setMinimun(int minimun) {
        this.minimun = minimun;
    }
    public int getMaximum() {
        return maximum;
    }
    public void setMaximum(int maximum) {
        this.maximum = maximum;
    } */
}

