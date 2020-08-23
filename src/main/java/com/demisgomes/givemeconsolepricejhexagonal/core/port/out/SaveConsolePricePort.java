package com.demisgomes.givemeconsolepricejhexagonal.core.port.out;

import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;

public interface SaveConsolePricePort {
    ConsolePrice save(ConsolePrice consolePrice);
}