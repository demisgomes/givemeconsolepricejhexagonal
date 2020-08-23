package com.demisgomes.givemeconsolepricejhexagonal;

import com.demisgomes.givemeconsolepricejhexagonal.core.domain.behavior.ConsolePriceCalculator;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.FetchExchangeRatePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.FetchTaxPercentagePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.LoadConsolePricePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.SaveConsolePricePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.usecase.CalculateConsolePrice;
import com.demisgomes.givemeconsolepricejhexagonal.core.usecase.LoadConsolePrice;
import com.demisgomes.givemeconsolepricejhexagonal.core.usecase.RegisterConsolePrice;
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

	@Bean
	public CalculateConsolePrice calculateConsolePrice(
			ConsolePriceCalculator consolePriceCalculator,
			FetchExchangeRatePort fetchExchangeRatePort,
			FetchTaxPercentagePort fetchTaxPercentagePort){

		return new CalculateConsolePrice(
				consolePriceCalculator,
				fetchExchangeRatePort,
				fetchTaxPercentagePort
		);
	}

	@Bean
	public LoadConsolePrice loadConsolePrice(LoadConsolePricePort loadConsolePricePort){
		return new LoadConsolePrice(loadConsolePricePort);
	}

	@Bean
	public RegisterConsolePrice registerConsolePrice(
			ConsolePriceCalculator consolePriceCalculator,
			FetchExchangeRatePort fetchExchangeRatePort,
			FetchTaxPercentagePort fetchTaxPercentagePort,
			SaveConsolePricePort saveConsolePricePort){

		return new RegisterConsolePrice(
				consolePriceCalculator,
				fetchExchangeRatePort,
				fetchTaxPercentagePort,
				saveConsolePricePort
		);
	}
}
