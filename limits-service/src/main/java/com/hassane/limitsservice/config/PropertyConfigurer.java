package com.hassane.limitsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PropertyConfigurer {
    

    @Bean
    @ConfigurationProperties("limits-service")
    ApplicationProperties limitsProperties(){

        return new ApplicationProperties();
    }
   

    @Bean
    @ConfigurationProperties("globale.properties")
    ApplicationProperties appProperties(){

        return new ApplicationProperties();
    }
}
