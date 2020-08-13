package com.demisgomes.givemeconsolepricejhexagonal.application.usecase;

import com.demisgomes.givemeconsolepricejhexagonal.application.model.ConsolePriceRegisterRequest;
import com.demisgomes.givemeconsolepricejhexagonal.application.port.in.RegisterConsolePriceUseCase;
import com.demisgomes.givemeconsolepricejhexagonal.application.port.out.FetchExchangeRatePort;
import com.demisgomes.givemeconsolepricejhexagonal.application.port.out.FetchTaxPercentagePort;
import com.demisgomes.givemeconsolepricejhexagonal.application.port.out.SaveConsolePricePort;
import com.demisgomes.givemeconsolepricejhexagonal.domain.behavior.ConsolePriceCalculator;
import com.demisgomes.givemeconsolepricejhexagonal.domain.models.ConsolePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterConsolePrice implements RegisterConsolePriceUseCase {
    private ConsolePriceCalculator consolePriceCalculator;
    private FetchExchangeRatePort fetchExchangeRatePort;
    private FetchTaxPercentagePort fetchTaxPercentagePort;
    private SaveConsolePricePort saveConsolePricePort;

    @Autowired
    public RegisterConsolePrice(ConsolePriceCalculator consolePriceCalculator, FetchExchangeRatePort fetchExchangeRatePort, FetchTaxPercentagePort fetchTaxPercentagePort, SaveConsolePricePort saveConsolePricePort) {
        this.consolePriceCalculator = consolePriceCalculator;
        this.fetchExchangeRatePort = fetchExchangeRatePort;
        this.fetchTaxPercentagePort = fetchTaxPercentagePort;
        this.saveConsolePricePort = saveConsolePricePort;
    }

    @Override
    public ConsolePrice register(ConsolePriceRegisterRequest consolePriceRegisterRequest) {
        double exchangeRate = fetchExchangeRatePort.get();
        double taxPercentage = fetchTaxPercentagePort.get();
        ConsolePrice consolePrice =
                consolePriceCalculator.calculateFromProfit(
                        consolePriceRegisterRequest.getConsoleName(),
                        consolePriceRegisterRequest.getPriceInUSD(),
                        consolePriceRegisterRequest.getProfitPercentage(),
                        exchangeRate,
                        taxPercentage
                );

        return saveConsolePricePort.save(consolePrice);
    }
}