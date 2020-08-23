package com.demisgomes.givemeconsolepricejhexagonal.core.usecase;

import com.demisgomes.givemeconsolepricejhexagonal.core.port.in.LoadConsolePriceUseCase;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.LoadConsolePricePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;

public class LoadConsolePrice implements LoadConsolePriceUseCase{
    private LoadConsolePricePort loadConsolePricePort;

    public LoadConsolePrice(LoadConsolePricePort loadConsolePricePort) {
        this.loadConsolePricePort = loadConsolePricePort;
    }

    @Override
    public ConsolePrice getById(Integer id) {
        return loadConsolePricePort.getById(id);
    }
}