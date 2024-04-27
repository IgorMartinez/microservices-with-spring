package br.com.igormartinez.bookservice.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.igormartinez.bookservice.dto.cambioservice.CambioResponseDTO;

@Service
public class CambioService {
    
    public CambioResponseDTO getCambio(BigDecimal amount, String from, String to) {

        Map<String, String> params = new HashMap<>();
        params.put("amount", amount.toString());
        params.put("from", from);
        params.put("to", to);

        return new RestTemplate()
            .getForEntity(
                "http://localhost:8000/cambio-service/{amount}/{from}/{to}", 
                CambioResponseDTO.class,
                params
            ).getBody();
    }
}
