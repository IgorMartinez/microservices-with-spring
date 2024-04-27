package br.com.igormartinez.cambioservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igormartinez.cambioservice.dto.response.CambioResponseDTO;
import br.com.igormartinez.cambioservice.services.CambioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Cambio endpoint")
@RestController
@RequestMapping("/cambio-service")
public class CambioController {

    private final CambioService service;

    public CambioController(CambioService service) {
        this.service = service;
    }

    @Operation(summary = "Get cambio from currency")
    @GetMapping("/{amount}/{from}/{to}")
    public CambioResponseDTO getCambio(
        @PathVariable("amount") BigDecimal amount,
        @PathVariable("from") String from,
        @PathVariable("to") String to
    ) {
        return service.getCambio(amount, from, to);
    }
}
