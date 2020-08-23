package com.demisgomes.givemeconsolepricejhexagonal.core.port.in;

import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePriceRegisterRequest;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;

public interface RegisterConsolePriceUseCase {
    ConsolePrice register(ConsolePriceRegisterRequest consolePriceRegisterRequest);
}