package com.example.javafxproject.DAO;

public class Pedido {
    private int id;
    private int idCliente;
    private String dataPedido;

    // Construtor para criar um novo pedido (usado ao recuperar dados do banco de dados)
    public Pedido(int id, int idCliente, String dataPedido) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataPedido = dataPedido;
    }

    // Construtor para criar um novo pedido (usado ao inserir dados no banco de dados)
    public Pedido(int idCliente, String dataPedido) {
        this.idCliente = idCliente;
        this.dataPedido = dataPedido;
    }

    // Métodos getter e setter
    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", dataPedido='" + dataPedido + '\'' +
                '}';
    }
}
