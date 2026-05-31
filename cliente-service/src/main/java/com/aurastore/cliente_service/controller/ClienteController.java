package com.aurastore.cliente_service.controller;

import com.aurastore.cliente_service.dto.ClienteRequestDTO;
import com.aurastore.cliente_service.dto.VendaDTO;
import com.aurastore.cliente_service.model.Cliente;
import com.aurastore.cliente_service.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody ClienteRequestDTO dto) {
        return clienteService.criarCliente(dto);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @GetMapping("/{id}/vendas")
    public List<VendaDTO> buscarVendasDoCliente(@PathVariable Long id) {
        return clienteService.buscarVendasDoCliente(id);
    }

    @DeleteMapping("/{id}")
    public void removerCliente(@PathVariable Long id) {
        clienteService.removerCliente(id);
    }
}