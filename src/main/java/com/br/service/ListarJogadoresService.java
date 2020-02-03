package com.br.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class ListarJogadoresService {

	public static void doLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setHeadless(true);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.easports.com/fifa/ultimate-team/web-app/");
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Login\"]/div/div/button[1]")));

		element.click();
		
		
		//TODO - IMPLEMENTAR PREENCHIMENTO DE LOGIN E SENHA
		driver.findElement(By.id("email")).sendKeys("mateus00131@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Sasalamel02@");
		driver.findElement(By.id("btnLogin")).click();
	
		WebDriverWait waitBtn = new WebDriverWait(driver, 40);
		WebElement transferBtn = waitBtn.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/nav/button[3]")));
		
		WebDriverWait waitBtn2 = new WebDriverWait(driver, 40);
		WebElement transferBtn2 = waitBtn2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/section/div[2]/div/div/div[3]/div[2]/div")));
	}
}
