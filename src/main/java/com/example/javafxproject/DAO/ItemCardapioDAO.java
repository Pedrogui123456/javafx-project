package com.example.javafxproject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ItemCardapioDAO {

    public ItemCardapio create(String nome, double preco) {
        ItemCardapio itemCardapio = null;
        String sql = "INSERT INTO cardapio (nome, preco) VALUES (?, ?);";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, nome);
            statement.setDouble(2, preco);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                itemCardapio = new ItemCardapio(rs.getInt(1), nome, preco);
            }

            rs.close();

            return itemCardapio;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ItemCardapio> findAll() {
        String sql = "SELECT * FROM cardapio;";
        List<ItemCardapio> itensCardapio = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                itensCardapio.add(
                    new ItemCardapio(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return itensCardapio;
        }

        return itensCardapio;
    }

    public ItemCardapio findById(Integer id) {
        String sql = "SELECT * FROM cardapio WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new ItemCardapio(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDouble("preco")
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
