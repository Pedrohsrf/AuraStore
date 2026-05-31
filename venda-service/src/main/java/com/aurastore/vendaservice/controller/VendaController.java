package com.aurastore.vendaservice.controller;

import com.aurastore.vendaservice.dto.VendaRequestDTO;
import com.aurastore.vendaservice.model.Venda;
import com.aurastore.vendaservice.service.VendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
@CrossOrigin(origins = "*")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public Venda criarVenda(@RequestBody VendaRequestDTO dto) {
        return vendaService.criarVenda(dto);
    }

    @GetMapping
    public List<Venda> listarVendas() {
        return vendaService.listarVendas();
    }

    @GetMapping("/{id}")
    public Venda buscarVendaPorId(@PathVariable Long id) {
        return vendaService.buscarVendaPorId(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Venda> buscarVendasPorClienteId(@PathVariable Long clienteId) {
        return vendaService.buscarVendasPorClienteId(clienteId);
    }

    @PutMapping("/{id}/cancelar")
    public Venda cancelarVenda(@PathVariable Long id) {
        return vendaService.cancelarVenda(id);
    }

    @DeleteMapping("/{id}")
    public void removerVenda(@PathVariable Long id) {
        vendaService.removerVenda(id);
    }
}