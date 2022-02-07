package com.wandev.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandev.hrpayroll.entities.Payment;
import com.wandev.hrpayroll.entities.Worker;
import com.wandev.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	
	// FeignClient injection of the WorkerFeignClient class
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, int days) {
		
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
