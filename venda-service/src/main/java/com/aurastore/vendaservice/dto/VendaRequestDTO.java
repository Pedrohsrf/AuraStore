package com.aurastore.vendaservice.dto;

import java.math.BigDecimal;

public class VendaRequestDTO {

    private Long produtoId;
    private Integer quantidade;
    private BigDecimal valorUnitario;

    public VendaRequestDTO() {
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}