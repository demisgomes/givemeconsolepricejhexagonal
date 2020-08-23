package com.demisgomes.givemeconsolepricejhexagonal.core.port.out;

import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;

public interface LoadConsolePricePort{
    ConsolePrice getById(Integer id);
}