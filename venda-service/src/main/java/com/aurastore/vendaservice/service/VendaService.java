package com.aurastore.vendaservice.service;

import com.aurastore.vendaservice.dto.VendaRequestDTO;
import com.aurastore.vendaservice.model.Venda;
import com.aurastore.vendaservice.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda criarVenda(VendaRequestDTO dto) {
        validarVenda(dto);

        BigDecimal valorTotal = dto.getValorUnitario()
                .multiply(BigDecimal.valueOf(dto.getQuantidade()));

        Venda venda = new Venda();
        venda.setProdutoId(dto.getProdutoId());
        venda.setQuantidade(dto.getQuantidade());
        venda.setValorUnitario(dto.getValorUnitario());
        venda.setValorTotal(valorTotal);
        venda.setStatus("REALIZADA");

        return vendaRepository.salvar(venda);
    }

    public List<Venda> listarVendas() {
        return vendaRepository.listarTodas();
    }

    public Venda buscarVendaPorId(Long id) {
        Venda venda = vendaRepository.buscarPorId(id);

        if (venda == null) {
            throw new RuntimeException("Venda não encontrada.");
        }

        return venda;
    }

    public Venda cancelarVenda(Long id) {
        Venda venda = buscarVendaPorId(id);
        venda.setStatus("CANCELADA");
        return venda;
    }

    public void removerVenda(Long id) {
        if (!vendaRepository.existePorId(id)) {
            throw new RuntimeException("Venda não encontrada.");
        }

        vendaRepository.remover(id);
    }

    private void validarVenda(VendaRequestDTO dto) {
        if (dto.getProdutoId() == null) {
            throw new RuntimeException("O produto é obrigatório.");
        }

        if (dto.getQuantidade() == null || dto.getQuantidade() <= 0) {
            throw new RuntimeException("A quantidade deve ser maior que zero.");
        }

        if (dto.getValorUnitario() == null || dto.getValorUnitario().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("O valor unitário deve ser maior que zero.");
        }
    }
}