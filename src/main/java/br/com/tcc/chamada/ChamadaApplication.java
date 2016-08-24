package br.com.tcc.chamada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ChamadaApplication{

	public static void main(String[] args) {
		SpringApplication.run(ChamadaApplication.class, args);
	}

}
