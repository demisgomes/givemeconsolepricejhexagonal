package com.demisgomes.givemeconsolepricejhexagonal.application.port.out;

import com.demisgomes.givemeconsolepricejhexagonal.domain.models.ConsolePrice;

public interface LoadConsolePricePort{
    ConsolePrice getById(Integer id);
}