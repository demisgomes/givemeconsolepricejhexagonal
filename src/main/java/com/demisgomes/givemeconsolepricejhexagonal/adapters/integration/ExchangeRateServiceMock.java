package com.demisgomes.givemeconsolepricejhexagonal.adapters.integration;

import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.FetchExchangeRatePort;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceMock implements FetchExchangeRatePort {

    @Override
    public double get() {
        return 5.43;
    }
}