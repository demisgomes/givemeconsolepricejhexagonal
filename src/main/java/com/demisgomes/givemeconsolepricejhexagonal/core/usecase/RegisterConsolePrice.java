package com.demisgomes.givemeconsolepricejhexagonal.core.usecase;

import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePriceRegisterRequest;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.in.RegisterConsolePriceUseCase;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.FetchExchangeRatePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.FetchTaxPercentagePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.SaveConsolePricePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.behavior.ConsolePriceCalculator;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;

public class RegisterConsolePrice implements RegisterConsolePriceUseCase {
    private ConsolePriceCalculator consolePriceCalculator;
    private FetchExchangeRatePort fetchExchangeRatePort;
    private FetchTaxPercentagePort fetchTaxPercentagePort;
    private SaveConsolePricePort saveConsolePricePort;

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