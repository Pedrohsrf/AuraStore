package com.aurastore.estoqueservice.model;

public class Estoque {

    private Long id;
    private Long produtoId;
    private String nomeProduto;
    private Integer quantidade;

    public Estoque() {
    }

    public Estoque(Long id, Long produtoId, String nomeProduto, Integer quantidade) {
        this.id = id;
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }

    public Long getId() { return id; }
    public Long getProdutoId() { return produtoId; }
    public String getNomeProduto() { return nomeProduto; }
    public Integer getQuantidade() { return quantidade; }

    public void setId(Long id) { this.id = id; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}