package com.demisgomes.givemeconsolepricejhexagonal.core.port.in;

import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePriceCalculateRequest;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;

public interface CalculateConsolePriceUseCase {
    ConsolePrice calculate(ConsolePriceCalculateRequest consolePriceCalculateRequest);
}