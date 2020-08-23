package com.demisgomes.givemeconsolepricejhexagonal.core.port.in;

import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;

public interface LoadConsolePriceUseCase{
    ConsolePrice getById(Integer id);
}