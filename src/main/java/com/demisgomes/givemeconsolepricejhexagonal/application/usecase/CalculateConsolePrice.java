package com.demisgomes.givemeconsolepricejhexagonal.application.usecase;

import com.demisgomes.givemeconsolepricejhexagonal.application.model.ConsolePriceCalculateRequest;
import com.demisgomes.givemeconsolepricejhexagonal.application.port.in.CalculateConsolePriceUseCase;
import com.demisgomes.givemeconsolepricejhexagonal.application.port.out.FetchExchangeRatePort;
import com.demisgomes.givemeconsolepricejhexagonal.application.port.out.FetchTaxPercentagePort;
import com.demisgomes.givemeconsolepricejhexagonal.domain.behavior.ConsolePriceCalculator;
import com.demisgomes.givemeconsolepricejhexagonal.domain.models.ConsolePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateConsolePrice implements CalculateConsolePriceUseCase{
    private ConsolePriceCalculator consolePriceCalculator;
    private FetchExchangeRatePort fetchExchangeRatePort;
    private FetchTaxPercentagePort fetchTaxPercentagePort;

    @Autowired
    public CalculateConsolePrice(ConsolePriceCalculator consolePriceCalculator, FetchExchangeRatePort fetchExchangeRatePort, FetchTaxPercentagePort fetchTaxPercentagePort) {
        this.consolePriceCalculator = consolePriceCalculator;
        this.fetchExchangeRatePort = fetchExchangeRatePort;
        this.fetchTaxPercentagePort = fetchTaxPercentagePort;
    }

    @Override
    public ConsolePrice calculate(ConsolePriceCalculateRequest consolePriceCalculateRequest) {
        double exchangeRate = fetchExchangeRatePort.get();
        double taxPercentage = fetchTaxPercentagePort.get();

        return consolePriceCalculator.calculateFromPriceInBRL(
                consolePriceCalculateRequest.getConsoleName(),
                consolePriceCalculateRequest.getPriceInUSD(),
                consolePriceCalculateRequest.getPriceInBRL(),
                exchangeRate,
                taxPercentage
        );
    }

}