package com.demisgomes.givemeconsolepricejhexagonal.application.port.in;

import com.demisgomes.givemeconsolepricejhexagonal.application.model.ConsolePriceCalculateRequest;
import com.demisgomes.givemeconsolepricejhexagonal.domain.models.ConsolePrice;

public interface CalculateConsolePriceUseCase {
    ConsolePrice calculate(ConsolePriceCalculateRequest consolePriceCalculateRequest);
}