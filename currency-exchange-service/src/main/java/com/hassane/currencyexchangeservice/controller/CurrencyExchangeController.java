package com.hassane.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hassane.currencyexchangeservice.domain.CurrencyExchange;

@RestController
public class CurrencyExchangeController {


    @Autowired
    Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to ){
        CurrencyExchange currencyExchange= new CurrencyExchange(100L, from, to, BigDecimal.valueOf(50f));

        currencyExchange.setEnv(environment.getProperty("local.server.port"));

        return currencyExchange;
    }
    
}
