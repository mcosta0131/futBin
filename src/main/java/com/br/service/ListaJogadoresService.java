package com.br.service;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class ListaJogadoresService {

	public void doLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setHeadless(true);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.easports.com/fifa/ultimate-team/web-app/");
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Login\"]/div/div/button[1]")));

		element.click();
		
	}
}
