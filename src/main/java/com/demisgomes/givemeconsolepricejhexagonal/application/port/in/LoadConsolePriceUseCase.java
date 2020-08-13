package com.demisgomes.givemeconsolepricejhexagonal.application.port.in;

import com.demisgomes.givemeconsolepricejhexagonal.domain.models.ConsolePrice;

public interface LoadConsolePriceUseCase{
    ConsolePrice getById(Integer id);
}