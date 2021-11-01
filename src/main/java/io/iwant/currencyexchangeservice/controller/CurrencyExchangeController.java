package io.iwant.currencyexchangeservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.result.DeleteResult;

import io.iwant.currencyexchangeservice.model.CurrencyExchange;
import io.iwant.currencyexchangeservice.service.CurrencyService;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	CurrencyService service;

	
	@PostMapping("/currency-exchange/create")
	public List<CurrencyExchange> create(@RequestBody CurrencyExchange object){
		return service.create(object);
	}
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchange(@PathVariable String from, @PathVariable String to) throws NotFoundException {
		return service.retrieve(from, to);
	}
	
	@GetMapping("/currency-exchange/findAll")
	public List<CurrencyExchange> findAll(){
		return service.findAll();
	}
	
	@DeleteMapping("/currency-exchange/delete/{id}")
	public DeleteResult delete(@PathVariable String id) {
		return service.delete(id);
	}
}