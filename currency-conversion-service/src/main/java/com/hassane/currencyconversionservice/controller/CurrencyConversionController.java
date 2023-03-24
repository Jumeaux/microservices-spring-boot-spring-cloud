package com.hassane.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hassane.currencyconversionservice.domain.CurrencyConversion;
import com.hassane.currencyconversionservice.proxy.CurrencyExchangeProxy;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {
    
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}



@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;
  
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to, @PathVariable(value = "quantity") BigDecimal quantity){

        HashMap<String,String> uriVariables= new HashMap<>();

        uriVariables.put("from", from);
        uriVariables.put("to", to);
        
        ResponseEntity<CurrencyConversion> responseEntity= restTemplate.getForEntity("http://currency-exchange:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
       // ResponseEntity<CurrencyConversion> responseEntity= restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion=responseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnv()+"  Rest Template");
    }


    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to, @PathVariable(value = "quantity") BigDecimal quantity){
    
        CurrencyConversion currencyConversion=currencyExchangeProxy.retrieveExchangeValue(from, to);

        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnv() + " feign");
    }
}
