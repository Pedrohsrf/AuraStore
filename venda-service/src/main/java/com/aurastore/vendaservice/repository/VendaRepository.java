package com.aurastore.vendaservice.repository;

import com.aurastore.vendaservice.model.Venda;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VendaRepository {

    private final Map<Long, Venda> vendas = new HashMap<>();
    private Long proximoId = 1L;

    public Venda salvar(Venda venda) {
        venda.setId(proximoId);
        vendas.put(proximoId, venda);
        proximoId++;
        return venda;
    }

    public List<Venda> listarTodas() {
        return new ArrayList<>(vendas.values());
    }

    public Venda buscarPorId(Long id) {
        return vendas.get(id);
    }

    public void remover(Long id) {
        vendas.remove(id);
    }

    public boolean existePorId(Long id) {
        return vendas.containsKey(id);
    }
}