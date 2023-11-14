package com.example.javafxproject.DAO;


public class Ficha {
    private Integer id;
    private String dataDaCompra;
    private String quantidade;

    public Ficha(Integer  id, Date dataDaCompra, int quantidade) {
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

    public Date getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Ficha [id=" + id + ", dataDaCompra=" + dataDaCompra + ", quantidade=" + quantidade + "]";
    }
}
