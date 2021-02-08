/**
 * 
 */
package com.in28minutes.currency.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.currency.exchange.beans.CurrencyExchange;
import com.in28minutes.currency.exchange.repository.CurrencyExchangeRepository;

/**
 * @author Sameer
 *
 */
@Service
public class CurrencyExchangeService {
	
	@Autowired private CurrencyExchangeRepository currencyExchangeRepository;
	
	public CurrencyExchange currencyExchange(String from, String to) {
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}

}
