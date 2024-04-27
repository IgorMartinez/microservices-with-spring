package br.com.igormartinez.cambioservice.dto.response;

import java.math.BigDecimal;

public record CambioResponseDTO (
    Long id,
    String from,
    String to,
    BigDecimal conversionFactor,
    BigDecimal convertedValue,
    String environment
) {}
