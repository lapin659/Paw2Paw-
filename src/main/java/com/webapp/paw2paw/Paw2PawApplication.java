package com.webapp.paw2paw;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.webapp.paw2paw.model")
@SpringBootApplication
public class Paw2PawApplication {
	public static void main(String[] args) {
		SpringApplication.run(Paw2PawApplication.class, args);
	}

}
