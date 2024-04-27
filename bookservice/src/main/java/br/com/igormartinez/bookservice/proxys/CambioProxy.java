package br.com.igormartinez.bookservice.proxys;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.igormartinez.bookservice.dto.cambioservice.CambioResponseDTO;

@FeignClient(name = "cambio-service")
public interface CambioProxy {
    
    @GetMapping("/cambio-service/{amount}/{from}/{to}")
    public CambioResponseDTO getCambio(
        @PathVariable("amount") BigDecimal amount,
        @PathVariable("from") String from,
        @PathVariable("to") String to
    );
}
