package com.wandev.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wandev.hrpayroll.entities.Payment;
import com.wandev.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	//Getting the application.properties property
	@Value("${hr-worker.host}")
	private String workerHost;
	
	// RestTemplate injection of the AppConfig class
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(Long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
