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
	
//	@Scheduled(cron = "${scheduler.cron.buscaPreco}")
//	@Scheduled(cron = "*/5 * * * * *") // 5 SEGUNDOS - ATIVAR PARA TESTES
	public void testSelenium() {
		System.out.println("INICIANDO SINCRONIZAÇÃO DE BUSCA DE PREÇOS");
		service.getPrice();
		
	}
}
