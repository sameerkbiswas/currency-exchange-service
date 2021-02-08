package com.in28minutes.currency.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.currency.exchange.beans.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	CurrencyExchange findByFromAndTo(String from, String to);
}
