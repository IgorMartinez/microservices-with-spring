package br.com.igormartinez.cambioservice.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.igormartinez.cambioservice.dto.response.CambioResponseDTO;
import br.com.igormartinez.cambioservice.exceptions.UnsupportedCurrencyException;
import br.com.igormartinez.cambioservice.models.Cambio;
import br.com.igormartinez.cambioservice.repositories.CambioRepository;

@Service
public class CambioService {
    
    private final Environment environment;
    private final CambioRepository repository;

    public CambioService(Environment environment, CambioRepository repository) {
        this.environment = environment;
        this.repository = repository;
    }

    public CambioResponseDTO getCambio(BigDecimal amount, String from, String to) {
        Cambio cambio = repository.findByFromAndTo(from, to)
            .orElseThrow(() -> new UnsupportedCurrencyException("Currency unsupported"));
        
        return new CambioResponseDTO(
            cambio.getId(), 
            cambio.getFrom(), 
            cambio.getTo(), 
            cambio.getConversionFactor(), 
            amount.multiply(cambio.getConversionFactor()).setScale(2, RoundingMode.CEILING), 
            environment.getProperty("local.server.port")
        );
    }
}
