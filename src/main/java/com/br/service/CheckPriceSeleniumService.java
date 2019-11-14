package com.br.service;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
		driver.get("https://www.futbin.com/20/player/43729/alex-telles");
		String price = driver.findElement(By.id("ps-lowest-1")).getText();
		String precoTratado = price.replace(",", "");
		fillEntity(Long.parseLong(precoTratado));
		driver.close();
		driver.quit();

	}

	public void fillEntity(Long preco) {

		Players jogador = new Players();
		jogador.setNome("Alex telles IF");
		jogador.setPreco(preco);
		jogador.setDataAtualizacaoPreco(new Date());
		rep.insert(jogador);

		if(preco >= 120000) {
			sendEmail(preco);
		}else{
			System.out.println("JOGADOR NÃO ESTA A CIMA DO PREÇO BASE");
		}

	}

	public void sendEmail(Long preco) {
		final String username = "mateus.csantos-ext@viavarejo.com.br";
		final String password = "Sasalamel01@";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("mateus.csantos-ext@viavarejo.com.br"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mateus.csantos-ext@viavarejo.com.br"));
			message.setSubject("FUT FIFA 20");
			message.setText("MANE ESTA ABAIXO DO PREÇO BASE ------- PREÇO : " + preco);

			Transport.send(message);

			System.out.println("EMAIL ENVIADO");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
