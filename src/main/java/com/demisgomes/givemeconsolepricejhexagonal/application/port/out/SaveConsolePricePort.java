package com.demisgomes.givemeconsolepricejhexagonal.application.port.out;

import com.demisgomes.givemeconsolepricejhexagonal.domain.models.ConsolePrice;

public interface SaveConsolePricePort {
    ConsolePrice save(ConsolePrice consolePrice);
}