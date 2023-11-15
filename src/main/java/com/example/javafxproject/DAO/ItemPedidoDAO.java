package com.example.javafxproject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TableColumn;

public class ItemPedidoDAO {

    public ItemPedido cadastrarItemPedido(String produto, double preco, int quantidade) {
        ItemPedido itemPedido = null;
        String sql = "INSERT INTO itens_pedido (produto, preco, quantidade) VALUES (?, ?, ?);";

        try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, produto);
            statement.setDouble(2, preco);
            statement.setInt(3, quantidade);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                itemPedido = new ItemPedido(rs.getInt(1), produto, preco, quantidade);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemPedido;
    }

    public List<ItemPedido> findAll() {
        String sql = "SELECT * FROM itens_pedido;";
        List<ItemPedido> itensPedido = new ArrayList<>();

        try (
                Connection connection = Conexao.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                itensPedido.add(new ItemPedido(
                        rs.getInt("id"),
                        rs.getString("produto"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itensPedido;
    }

    public ItemPedido findById(int id) {
        String sql = "SELECT * FROM itens_pedido WHERE id = ?;";
        ItemPedido itemPedido = null;

        try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                itemPedido = new ItemPedido(
                        rs.getInt("id"),
                        rs.getString("produto"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemPedido;
    }

    public com.example.javafxproject.RealizarPedidoController.ItemPedido cadastrarItemPedido(
            TableColumn<com.example.javafxproject.RealizarPedidoController.ItemPedido, String> colProduto,
            TableColumn<com.example.javafxproject.RealizarPedidoController.ItemPedido, Double> colPreco,
            TableColumn<com.example.javafxproject.RealizarPedidoController.ItemPedido, Integer> colQuantidade) {
        return null;
    }
}
