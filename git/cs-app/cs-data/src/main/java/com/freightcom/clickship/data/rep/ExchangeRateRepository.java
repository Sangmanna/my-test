package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, String> {

	public ExchangeRate findTopByOrderByDateStrDesc();
	
	public List<ExchangeRate> findByDateStr(String dateStr);
	
	public ExchangeRate findTopByCurrencyUnitOrderByDateStrDesc(String currencyUnit);
	
	public ExchangeRate findByCurrencyUnitAndDateStr(String currencyUnit, String dateStr);
	
}