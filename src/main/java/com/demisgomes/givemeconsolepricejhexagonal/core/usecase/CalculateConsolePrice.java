package com.demisgomes.givemeconsolepricejhexagonal.core.usecase;

import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePriceCalculateRequest;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.in.CalculateConsolePriceUseCase;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.FetchExchangeRatePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.FetchTaxPercentagePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.behavior.ConsolePriceCalculator;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;

public class CalculateConsolePrice implements CalculateConsolePriceUseCase{
    private ConsolePriceCalculator consolePriceCalculator;
    private FetchExchangeRatePort fetchExchangeRatePort;
    private FetchTaxPercentagePort fetchTaxPercentagePort;

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