package com.bitsbids.shoppingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class BitsBidsServer {
	public static void main(String[] args) {
		try {
			SendEmail.sendmail("aashreyrachaputi@gmail.com", "App was successfully deployed", "You are receiving this mail from BITSBIDS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SpringApplication.run(OopsieServer.class, args);
	}
}
