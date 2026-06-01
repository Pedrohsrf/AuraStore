package com.aurastore.estoqueservice.repository;

import com.aurastore.estoqueservice.model.Estoque;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EstoqueRepository {

    private final List<Estoque> estoques = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public Estoque salvar(Estoque estoque) {
        estoque.setId(contador.getAndIncrement());
        estoques.add(estoque);
        return estoque;
    }

    public List<Estoque> listarTodos() {
        return estoques;
    }

    public Optional<Estoque> buscarPorId(Long id) {
        return estoques.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public void remover(Long id) {
        estoques.removeIf(e -> e.getId().equals(id));
    }
}