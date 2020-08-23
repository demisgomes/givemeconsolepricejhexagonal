package com.demisgomes.givemeconsolepricejhexagonal.adapters.integration;

import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.FetchTaxPercentagePort;
import org.springframework.stereotype.Service;

@Service
public class TaxServiceMock implements FetchTaxPercentagePort {
    @Override
    public double get() {
        return 0.4;
    }
}