package jv.triersistemas.reserva_restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReservaRestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservaRestauranteApplication.class, args);
	}

}
