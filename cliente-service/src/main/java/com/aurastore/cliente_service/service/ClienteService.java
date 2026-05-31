package com.aurastore.cliente_service.service;

import com.aurastore.cliente_service.client.VendaClient;
import com.aurastore.cliente_service.dto.ClienteRequestDTO;
import com.aurastore.cliente_service.dto.VendaDTO;
import com.aurastore.cliente_service.model.Cliente;
import com.aurastore.cliente_service.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final VendaClient vendaClient;

    public ClienteService(ClienteRepository clienteRepository, VendaClient vendaClient) {
        this.clienteRepository = clienteRepository;
        this.vendaClient = vendaClient;
    }

    public Cliente criarCliente(ClienteRequestDTO dto) {

        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new RuntimeException("Nome é obrigatório.");
        }

        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());

        return clienteRepository.salvar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.listarTodos();
    }

    public Cliente buscarClientePorId(Long id) {

        Cliente cliente = clienteRepository.buscarPorId(id);

        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado.");
        }

        return cliente;
    }

    public List<VendaDTO> buscarVendasDoCliente(Long id) {
        buscarClientePorId(id);

        return vendaClient.buscarVendasPorClienteId(id);
    }

    public void removerCliente(Long id) {

        if (!clienteRepository.existePorId(id)) {
            throw new RuntimeException("Cliente não encontrado.");
        }

        clienteRepository.remover(id);
    }
}