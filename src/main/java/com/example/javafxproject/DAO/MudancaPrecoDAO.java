package com.example.javafxproject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class MudancaPrecoDAO {

    public MudancaPreco create(int idProduto, double novoPreco) {
        MudancaPreco mudancaPreco = null;
        String sql = "INSERT INTO mudanca_preco (id_produto, novo_preco) VALUES (?, ?);";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, idProduto);
            statement.setDouble(2, novoPreco);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                mudancaPreco = new MudancaPreco(rs.getInt(1), idProduto, novoPreco);
            }

            rs.close();

            return mudancaPreco;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MudancaPreco> findAll() {
        String sql = "SELECT * FROM mudanca_preco;";
        List<MudancaPreco> mudancasPreco = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                mudancasPreco.add(
                    new MudancaPreco(
                        rs.getInt("id"),
                        rs.getInt("id_produto"),
                        rs.getDouble("novo_preco")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return mudancasPreco;
        }

        return mudancasPreco;
    }

    public MudancaPreco findById(Integer id) {
        String sql = "SELECT * FROM mudanca_preco WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new MudancaPreco(
                    rs.getInt("id"),
                    rs.getInt("id_produto"),
                    rs.getDouble("novo_preco")
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

