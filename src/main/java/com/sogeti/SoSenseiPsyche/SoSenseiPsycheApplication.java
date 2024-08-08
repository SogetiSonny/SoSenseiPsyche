package com.sogeti.SoSenseiPsyche;

import com.sogeti.SoSenseiPsyche.model.Guesses;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoSenseiPsycheApplication {
	public static void main(String[] args) {
		SpringApplication.run(SoSenseiPsycheApplication.class, args);

		Guesses guesses = new Guesses();
		guesses.play();

	}

}
