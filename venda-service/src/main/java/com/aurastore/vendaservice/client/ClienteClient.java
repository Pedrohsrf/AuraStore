package com.aurastore.vendaservice.client;

import com.aurastore.vendaservice.dto.ClienteDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClienteClient {

    private final RestTemplate restTemplate;

    public ClienteClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ClienteDTO buscarClientePorId(Long clienteId) {
        String url = "http://localhost:8081/clientes/" + clienteId;

        return restTemplate.getForObject(url, ClienteDTO.class);
    }
}