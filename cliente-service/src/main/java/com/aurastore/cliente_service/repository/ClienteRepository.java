package com.aurastore.cliente_service.repository;

import com.aurastore.cliente_service.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteRepository {

    private final Map<Long, Cliente> clientes = new HashMap<>();

    private Long proximoId = 1L;

    public Cliente salvar(Cliente cliente) {

        cliente.setId(proximoId);

        clientes.put(proximoId, cliente);

        proximoId++;

        return cliente;
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes.values());
    }

    public Cliente buscarPorId(Long id) {
        return clientes.get(id);
    }

    public void remover(Long id) {
        clientes.remove(id);
    }

    public boolean existePorId(Long id) {
        return clientes.containsKey(id);
    }
}
