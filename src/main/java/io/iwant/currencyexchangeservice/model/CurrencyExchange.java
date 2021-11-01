package io.iwant.currencyexchangeservice.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("currency-exchange")
public class CurrencyExchange {
	
	@Id
	private String id;
	
	private String from;
	private String to;
	private float conversionMultiple;
	private String environmnet;
	
	public CurrencyExchange() {
		super();
	}

	public CurrencyExchange( String from, String to, float conversionMultiple) {
		super();
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public float getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(float conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnvironmnet() {
		return environmnet;
	}

	public void setEnvironmnet(String port) {	
		this.environmnet = port;
	}

}
