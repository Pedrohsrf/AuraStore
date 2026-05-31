package com.aurastore.cliente_service.client;

import com.aurastore.cliente_service.dto.VendaDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class VendaClient {

    private final RestTemplate restTemplate;

    public VendaClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<VendaDTO> buscarVendasPorClienteId(Long clienteId) {
        String url = "http://localhost:8080/vendas/cliente/" + clienteId;

        ResponseEntity<List<VendaDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<VendaDTO>>() {}
        );

        return response.getBody();
    }
}