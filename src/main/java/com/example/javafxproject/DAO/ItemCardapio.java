package com.example.javafxproject.DAO;

public class ItemCardapio {
    private int id;
    private String nome;
    private double preco;

    // Construtor para criar um novo item do cardápio (usado ao recuperar dados do banco de dados)
    public ItemCardapio(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // Construtor para criar um novo item do cardápio (usado ao inserir dados no banco de dados)
    public ItemCardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Métodos getter e setter
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ItemCardapio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
