package com.demisgomes.givemeconsolepricejhexagonal.adapters.repository.jpa;

import com.demisgomes.givemeconsolepricejhexagonal.adapters.repository.model.ConsolePriceJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsolePriceJpaRepository extends JpaRepository<ConsolePriceJpa, Integer> {}