package com.demisgomes.givemeconsolepricejhexagonal.application.port.in;

import com.demisgomes.givemeconsolepricejhexagonal.application.model.ConsolePriceRegisterRequest;
import com.demisgomes.givemeconsolepricejhexagonal.domain.models.ConsolePrice;

public interface RegisterConsolePriceUseCase {
    ConsolePrice register(ConsolePriceRegisterRequest consolePriceRegisterRequest);
}