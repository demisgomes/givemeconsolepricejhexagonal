package com.demisgomes.givemeconsolepricejhexagonal;

import com.demisgomes.givemeconsolepricejhexagonal.domain.behavior.ConsolePriceCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GivemeconsolepricejhexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GivemeconsolepricejhexagonalApplication.class, args);
	}

	@Bean
	public ConsolePriceCalculator consolePriceCalculator(){
		return new ConsolePriceCalculator();
	}
}
