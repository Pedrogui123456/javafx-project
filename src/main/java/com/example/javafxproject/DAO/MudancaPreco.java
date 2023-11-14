package com.example.javafxproject.DAO;

public class MudancaPreco {
    private int id;
    private int idProduto;
    private double novoPreco;

    // Construtor para criar uma nova mudança de preço (usado ao recuperar dados do banco de dados)
    public MudancaPreco(int id, int idProduto, double novoPreco) {
        this.id = id;
        this.idProduto = idProduto;
        this.novoPreco = novoPreco;
    }

    // Construtor para criar uma nova mudança de preço (usado ao inserir dados no banco de dados)
    public MudancaPreco(int idProduto, double novoPreco) {
        this.idProduto = idProduto;
        this.novoPreco = novoPreco;
    }

    // Métodos getter e setter
    public int getId() {
        return id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public double getNovoPreco() {
        return novoPreco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNovoPreco(double novoPreco) {
        this.novoPreco = novoPreco;
    }

    @Override
    public String toString() {
        return "MudancaPreco{" +
                "id=" + id +
                ", idProduto=" + idProduto +
                ", novoPreco=" + novoPreco +
                '}';
    }
}
