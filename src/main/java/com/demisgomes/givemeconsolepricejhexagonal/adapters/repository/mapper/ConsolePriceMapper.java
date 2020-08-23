package com.demisgomes.givemeconsolepricejhexagonal.adapters.repository.mapper;

import com.demisgomes.givemeconsolepricejhexagonal.adapters.repository.model.ConsolePriceJpa;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;
import org.springframework.stereotype.Component;

@Component
public class ConsolePriceMapper{
    public ConsolePriceJpa toConsolePriceJpa(ConsolePrice consolePrice) {
        return new ConsolePriceJpa(
                consolePrice.getId(),
                consolePrice.getConsoleName(),
                consolePrice.getPriceInUSD(),
                consolePrice.getExchangeRate(),
                consolePrice.getTaxPercentage(),
                consolePrice.getTaxAmount(),
                consolePrice.getProfitPercentage(),
                consolePrice.getProfitAmount(),
                consolePrice.getPriceInBRL()
        );
    }


    public ConsolePrice toConsolePrice(ConsolePriceJpa consolePriceJpa) {
        return new ConsolePrice(
                consolePriceJpa.getId(),
                consolePriceJpa.getConsoleName(),
                consolePriceJpa.getPriceInUSD(),
                consolePriceJpa.getExchangeRate(),
                consolePriceJpa.getTaxPercentage(),
                consolePriceJpa.getTaxAmount(),
                consolePriceJpa.getProfitPercentage(),
                consolePriceJpa.getProfitAmount(),
                consolePriceJpa.getPriceInBRL()
        );
    }
}