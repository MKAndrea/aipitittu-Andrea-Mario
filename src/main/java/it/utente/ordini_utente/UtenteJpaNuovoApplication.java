package it.utente.ordini_utente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "it.utente")
@EnableJpaRepositories(basePackages = "it.utente.repository")
@EntityScan(basePackages = "it.utente.entity")
public class UtenteJpaNuovoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtenteJpaNuovoApplication.class, args);
	}

}
