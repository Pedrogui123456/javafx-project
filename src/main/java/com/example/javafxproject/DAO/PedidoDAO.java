package com.example.javafxproject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public Pedido criar(int idCliente, String dataPedido) {
        Pedido pedido = null;
        String sql = "INSERT INTO pedidos (id_cliente, data_pedido) VALUES (?, ?);";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, idCliente);
            statement.setString(2, dataPedido);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                pedido = new Pedido(rs.getInt(1), idCliente, dataPedido);
            }

            rs.close();

            return pedido;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Pedido> listarTodos() {
        String sql = "SELECT * FROM pedidos;";
        List<Pedido> pedidos = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                pedidos.add(
                    new Pedido(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getString("data_pedido")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return pedidos;
        }

        return pedidos;
    }

    public Pedido buscarPorId(Integer id) {
        String sql = "SELECT * FROM pedidos WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Pedido(
                    rs.getInt("id"),
                    rs.getInt("id_cliente"),
                    rs.getString("data_pedido")
                );
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}
