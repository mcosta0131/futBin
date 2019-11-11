package com.br.infrastructure.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.br.service.CheckPriceSeleniumService;

@Component
@EnableScheduling
public class CheckPriceSeleniumScheduler {

	@Autowired
	private CheckPriceSeleniumService service;
	
	@Scheduled(cron = "${scheduler.cron.buscaPreco}")
	public void testSelenium() {
		System.out.println("TESTE SCHEDULER COM SELENIUM");
		service.getPrice();
		
	}
}
