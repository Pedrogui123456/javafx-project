package com.example.javafxproject.DAO;


public class Ficha {
    private Integer id;
    private String dataDaCompra;
    private String quantidade;

    public Ficha(Integer  id, String dataDaCompra, String quantidade) {
        this.id = id;
        this.dataDaCompra = dataDaCompra;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public String getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(String dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Ficha [id=" + id + ", dataDaCompra=" + dataDaCompra + ", quantidade=" + quantidade + "]";
    }
}
