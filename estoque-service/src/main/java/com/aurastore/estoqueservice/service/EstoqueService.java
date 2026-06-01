package com.aurastore.estoqueservice.service;

import com.aurastore.estoqueservice.model.Estoque;
import com.aurastore.estoqueservice.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public Estoque criarEstoque(Estoque estoque) {
        return estoqueRepository.salvar(estoque);
    }

    public List<Estoque> listarEstoques() {
        return estoqueRepository.listarTodos();
    }

    public Estoque buscarPorId(Long id) {
        return estoqueRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
    }

    public void removerEstoque(Long id) {
        estoqueRepository.remover(id);
    }
}