package com.example.javafxproject.DAO;

import java.sql.Date; // Importa java.sql.Date em vez de java.util.Date

public class Ficha {
    private int id;
    private Date dataDaCompra;
    private int quantidade;

    public Ficha(int id, Date dataDaCompra, int quantidade) {
        this.id = id;
        this.dataDaCompra = dataDaCompra;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public static void main(String[] args) {
        Ficha ficha1 = new Ficha(1, new Date(System.currentTimeMillis()), 10); // Alterado para utilizar java.sql.Date
        Ficha ficha2 = new Ficha(2, new Date(System.currentTimeMillis()), 5);  // Alterado para utilizar java.sql.Date

        System.out.println("Detalhes da Ficha 1: " + ficha1);
        System.out.println("Detalhes da Ficha 2: " + ficha2);
    }
}
