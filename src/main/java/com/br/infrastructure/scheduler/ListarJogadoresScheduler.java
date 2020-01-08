package com.br.infrastructure.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.br.service.ListarJogadoresService;


@Component
@EnableScheduling
public class ListarJogadoresScheduler {
	
	
	@Autowired
	private ListarJogadoresService service;
	
	
	@Scheduled(cron = "*/5 * * * * *") // 5 SEGUNDOS - ATIVAR PARA TESTES
	public void listaJogadores() {
		System.out.println("INICIANDO PROCESSO DE LISTAR JOGADORES");
		service.doLogin();
		
	}
}
