package com.br.service;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.model.mongo.Players;
import com.br.repository.PlayersRepository;

@Component
public class CheckPriceSeleniumService {

	@Autowired
	private PlayersRepository rep;
	
	
	
	public void getPrice() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setHeadless(true);
		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://www.futbin.com/20/player/466");

		String price = driver.findElement(By.id("ps-lowest-1")).getText().replace(",", "");
		
		fillEntity(Long.parseLong(price));
		
		
		driver.quit();
		
	}


	public void fillEntity(Long preco) {
		
		Players jogador = new Players();
		jogador.setNome("Mané");
		jogador.setPreco(preco);
		jogador.setDataAtualizacaoPreco(new Date());
		rep.insert(jogador);
	}
}
