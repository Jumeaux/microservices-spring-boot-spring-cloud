package com.hassane.apigateway.configRoutes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    

    @Bean
    public RouteLocator gateRouter(RouteLocatorBuilder builder){

        return builder.routes()
                        .route(p->p
                            .path("/get") 
                            .filters(f->f.addRequestHeader("MyHeader", "Test Header from API gateway")
                                         .addRequestParameter("Params", "ParamsValue"))
                            .uri("http://httpbin.org:80"))
                            
                        .route(p->p
                            .path("/currency-exchange/**")
                            .uri("lb://currency-exchange"))

                        .route(p->p
                            .path("/currency-conversion/**")
                            .uri("lb://currency-conversion"))

                        .route(p->p
                            .path("/currency-conversion-feign/**")
                            .uri("lb://currency-conversion"))
                            
                        .route(p->p
                            .path("/currency-conversion-new/**")
                            .filters(f->f.rewritePath("/currency-conversion-new/(?<segment>.*)", "/currency-conversion-feign/${segment}"))
                            .uri("lb://currency-conversion"))
                            
                        .route(p->p
                            .path("/publicCountries/**")
                            .filters(f->f
                                .addRequestHeader("X-RapidAPI-Key", "xx")
                                .addRequestHeader("X-RapidAPI-Host", "countries-cities.p.rapidapi.com"))
                                    
                            .uri("https://countries-cities.p.rapidapi.com")
                        )          
                        .route(p->p
                            .path("/muslim/**")
                            .filters(f->f
                                .addRequestHeader("X-RapidAPI-Key", "xxxx")
                                .addRequestHeader("X-RapidAPI-Host", "muslimsalat.p.rapidapi.com")
                                  
                        )
                        .uri("https://muslimsalat.p.rapidapi.com") )
                        
                        .build();
    }
}

