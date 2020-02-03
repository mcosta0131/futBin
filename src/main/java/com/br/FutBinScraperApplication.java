package com.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.service.ListarJogadoresService;

@SpringBootApplication
@EnableAutoConfiguration
public class FutBinScraperApplication {
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(FutBinScraperApplication.class, args);
		ListarJogadoresService.doLogin();
	
	}

}
