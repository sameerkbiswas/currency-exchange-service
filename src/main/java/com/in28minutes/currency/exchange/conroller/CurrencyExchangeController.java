/**
 * 
 */
package com.in28minutes.currency.exchange.conroller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.currency.exchange.beans.CurrencyExchange;
import com.in28minutes.currency.exchange.service.CurrencyExchangeService;

/**
 * @author Sameer
 *
 */
@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	
	@Autowired private Environment environment;
	
	@Autowired private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange currencyExthange(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = currencyExchangeService.currencyExchange(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException("Data not found for " + from + " to " + to);
		}
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}
}
