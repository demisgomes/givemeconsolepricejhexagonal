package com.demisgomes.givemeconsolepricejhexagonal.application.usecase;

import com.demisgomes.givemeconsolepricejhexagonal.application.port.in.LoadConsolePriceUseCase;
import com.demisgomes.givemeconsolepricejhexagonal.application.port.out.LoadConsolePricePort;
import com.demisgomes.givemeconsolepricejhexagonal.domain.models.ConsolePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadConsolePrice implements LoadConsolePriceUseCase{
    private LoadConsolePricePort loadConsolePricePort;

    @Autowired
    public LoadConsolePrice(LoadConsolePricePort loadConsolePricePort) {
        this.loadConsolePricePort = loadConsolePricePort;
    }

    @Override
    public ConsolePrice getById(Integer id) {
        return loadConsolePricePort.getById(id);
    }
}