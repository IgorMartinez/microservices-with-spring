package br.com.igormartinez.bookservice.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookResponseDTO(
    Long id,
    String author,
    String title,
    LocalDateTime launchDate,
    BigDecimal price,
    String currency,
    String enviroment
) {}
