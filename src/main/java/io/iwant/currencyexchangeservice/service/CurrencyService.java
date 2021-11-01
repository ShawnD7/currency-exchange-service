package io.iwant.currencyexchangeservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.client.model.FindOneAndDeleteOptions;
import com.mongodb.client.result.DeleteResult;

import io.iwant.currencyexchangeservice.model.CurrencyExchange;

@Component
public class CurrencyService {
	
	@Autowired
	private MongoTemplate mongoService;
	
	@Autowired
	private Environment environment;
	
	private static Class<CurrencyExchange> model = CurrencyExchange.class;
	
	public List<CurrencyExchange> create(CurrencyExchange object){
		List<CurrencyExchange> response = new ArrayList<>();
		CurrencyExchange data = mongoService.insert(object);
		response.add(data);
		return response;
		
	}
	
	public List<CurrencyExchange> findAll(){
		return mongoService.findAll(CurrencyExchange.class);
	}

	public CurrencyExchange retrieve(String from, String to) throws NotFoundException {
		Query query = new Query();
		query.addCriteria(Criteria.where("from").is(from));
		CurrencyExchange selected = mongoService.findOne(query, model);
		if (selected == null) {
			throw new NotFoundException();
		}
		selected.setEnvironmnet(environment.getProperty("local.server.port"));

		return selected;

		
	}

	public DeleteResult delete(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		DeleteResult obj = mongoService.remove(query, CurrencyExchange.class);
		return obj;
	}
}
