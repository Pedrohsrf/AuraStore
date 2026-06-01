package com.aurastore.estoqueservice.controller;

import com.aurastore.estoqueservice.model.Estoque;
import com.aurastore.estoqueservice.service.EstoqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoques")
@CrossOrigin(origins = "*")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping
    public Estoque criarEstoque(@RequestBody Estoque estoque) {
        return estoqueService.criarEstoque(estoque);
    }

    @GetMapping
    public List<Estoque> listarEstoques() {
        return estoqueService.listarEstoques();
    }

    @GetMapping("/{id}")
    public Estoque buscarPorId(@PathVariable Long id) {
        return estoqueService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void removerEstoque(@PathVariable Long id) {
        estoqueService.removerEstoque(id);
    }
}