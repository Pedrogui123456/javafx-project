package com.example.javafxproject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MudancaPrecoDAO {

    public MudancaPreco cadastrar(String nome, String novoPreco) {
        MudancaPreco mudancaPreco = null;
        String sql = "INSERT INTO mudanca_preco (nome, novo_preco) VALUES (?, ?);";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, nome);
            statement.setString(2, novoPreco);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                mudancaPreco = new MudancaPreco(rs.getInt(1), nome, novoPreco);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mudancaPreco;
    }

    public List<MudancaPreco> listarTodas() {
        String sql = "SELECT * FROM mudanca_preco;";
        List<MudancaPreco> mudancasPreco = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                mudancasPreco.add(new MudancaPreco(rs.getInt("id"), rs.getString("nome"), rs.getString("novo_preco")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mudancasPreco;
    }

    public MudancaPreco buscarPorId(int id) {
        String sql = "SELECT * FROM mudanca_preco WHERE id = ?;";
        MudancaPreco mudancaPreco = null;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                mudancaPreco = new MudancaPreco(rs.getInt("id"), rs.getString("nome"), rs.getString("novo_preco"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mudancaPreco;
    }
}
