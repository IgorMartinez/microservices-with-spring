package br.com.igormartinez.bookservice.dto.cambioservice;

import java.math.BigDecimal;

public record CambioResponseDTO (
    Long id,
    String from,
    String to,
    BigDecimal conversionFactor,
    BigDecimal convertedValue,
    String environment
) {}

