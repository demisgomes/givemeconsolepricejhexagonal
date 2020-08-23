package com.demisgomes.givemeconsolepricejhexagonal.adapters.repository;

import com.demisgomes.givemeconsolepricejhexagonal.adapters.repository.jpa.ConsolePriceJpaRepository;
import com.demisgomes.givemeconsolepricejhexagonal.adapters.repository.mapper.ConsolePriceMapper;
import com.demisgomes.givemeconsolepricejhexagonal.adapters.repository.model.ConsolePriceJpa;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.LoadConsolePricePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.out.SaveConsolePricePort;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.exception.ConsolePriceNotFoundException;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConsolePriceRepository implements SaveConsolePricePort, LoadConsolePricePort {

    private ConsolePriceJpaRepository consolePriceJpaRepository;
    private ConsolePriceMapper consolePriceMapper;

    @Autowired
    public ConsolePriceRepository(ConsolePriceJpaRepository consolePriceJpaRepository, ConsolePriceMapper consolePriceMapper) {
        this.consolePriceJpaRepository = consolePriceJpaRepository;
        this.consolePriceMapper = consolePriceMapper;
    }

    @Override
    public ConsolePrice getById(Integer id) {
        ConsolePriceJpa consolePriceJpa = consolePriceJpaRepository.findById(id).orElseThrow(ConsolePriceNotFoundException::new);
        return consolePriceMapper.toConsolePrice(consolePriceJpa);
    }

    @Override
    public ConsolePrice save(ConsolePrice consolePrice) {
        ConsolePriceJpa consolePriceJpa = consolePriceMapper.toConsolePriceJpa(consolePrice);
        ConsolePriceJpa consolePriceJpaSaved = consolePriceJpaRepository.save(consolePriceJpa);

        return consolePriceMapper.toConsolePrice(consolePriceJpaSaved);

    }
}