package com.hassane.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hassane.currencyconversionservice.domain.CurrencyConversion;


// @FeignClient(name = "currency-exchange",url = "http://localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
    
    @GetMapping(value="/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to);
    
}
