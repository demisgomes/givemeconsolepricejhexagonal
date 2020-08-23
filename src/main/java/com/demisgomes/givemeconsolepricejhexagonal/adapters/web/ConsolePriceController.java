package com.demisgomes.givemeconsolepricejhexagonal.adapters.web;

import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePriceCalculateRequest;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePriceRegisterRequest;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.in.CalculateConsolePriceUseCase;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.in.LoadConsolePriceUseCase;
import com.demisgomes.givemeconsolepricejhexagonal.core.port.in.RegisterConsolePriceUseCase;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.exception.ConsolePriceNotFoundException;
import com.demisgomes.givemeconsolepricejhexagonal.core.domain.models.ConsolePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
class ConsolePriceController{
    private RegisterConsolePriceUseCase registerConsolePriceUseCase;
    private CalculateConsolePriceUseCase calculateConsolePriceUseCase;
    private LoadConsolePriceUseCase loadConsolePriceUseCase;

    @Autowired
    public ConsolePriceController(RegisterConsolePriceUseCase registerConsolePriceUseCase, CalculateConsolePriceUseCase calculateConsolePriceUseCase, LoadConsolePriceUseCase loadConsolePriceUseCase) {
        this.registerConsolePriceUseCase = registerConsolePriceUseCase;
        this.calculateConsolePriceUseCase = calculateConsolePriceUseCase;
        this.loadConsolePriceUseCase = loadConsolePriceUseCase;
    }

    @PostMapping("/consoles")
    public ResponseEntity<ConsolePrice> registerConsolePrice(@RequestBody ConsolePriceRegisterRequest consolePriceRegisterRequest) {
        ConsolePrice consolePrice = registerConsolePriceUseCase.register(consolePriceRegisterRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(consolePrice.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/calculate")
    public ResponseEntity<ConsolePrice> calculatePricefromBRL(@RequestBody ConsolePriceCalculateRequest consolePriceCalculateRequest) {
        ConsolePrice consolePrice = calculateConsolePriceUseCase.calculate(consolePriceCalculateRequest);
        return ResponseEntity.ok(consolePrice);
    }

    @GetMapping("/consoles/{id}")
    public ResponseEntity<ConsolePrice> getConsolePriceById(@PathVariable Integer id) {
        try {
            ConsolePrice consolePrice = loadConsolePriceUseCase.getById(id);
            return ResponseEntity.ok(consolePrice);
        } catch (ConsolePriceNotFoundException exception){
            return ResponseEntity.of(Optional.empty());
        }

    }
}