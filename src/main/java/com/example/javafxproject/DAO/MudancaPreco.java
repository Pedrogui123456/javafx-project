package com.example.javafxproject.DAO;

public class MudancaPreco {
    private int id;
    private String nome;
    private String novoPreco;

    // Construtor para criar uma nova mudança de preço (usado ao recuperar dados do banco de dados)
    public MudancaPreco(int id, String nome, String novoPreco) {
        this.id = id;
        this.nome = nome;
        this.novoPreco = novoPreco;
    }

    // Construtor para criar uma nova mudança de preço (usado ao inserir dados no banco de dados)
    public MudancaPreco(String nome, String novoPreco) {
        this.nome = nome;
        this.novoPreco = novoPreco;
    }

    // Métodos getter e setter
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNovoPreco() {
        return novoPreco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNovoPreco(String novoPreco) {
        this.novoPreco = novoPreco;
    }

    @Override
    public String toString() {
        return "MudancaPreco{" +
                "id=" + id +
                ", nome=" + nome +
                ", novoPreco=" + novoPreco +
                '}';
    }
}
