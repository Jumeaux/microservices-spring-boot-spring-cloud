package com.hassane.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hassane.currencyexchangeservice.domain.CurrencyExchange;
import com.hassane.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

private Logger log= LoggerFactory.getLogger(CurrencyExchange.class);
    @Autowired
   private Environment environment;

    @Autowired
   private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to ){
       // CurrencyExchange currencyExchange= new CurrencyExchange(100L, from, to, BigDecimal.valueOf(50f));

       // 2023-03-16 16:07:28.751  INFO [currency-exchange,1dafedd0556b6476,1dafedd0556b6476]  30920 --- [nio-8000-exec-2] c.h.c.domain.CurrencyExchange            : retrieve Exchange Value called with USD to GNF
       log.info("retrieve Exchange Value called with {} to {}",from, to);
        CurrencyExchange currencyExchange=currencyExchangeRepository.findByFromAndTo(from, to);

        if (currencyExchange==null) {
            throw new RuntimeException("Unable to find data for "+ from + " to "+ to); 
        }
        currencyExchange.setEnv(environment.getProperty("local.server.port"));

        return currencyExchange;
    }
    
}
