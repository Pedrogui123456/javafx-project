package com.example.javafxproject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public Funcionario create(String nome, String email, String senha) {
        Funcionario funcionario = null;
        String sql = "INSERT INTO funcionarios (nome, email, senha) VALUES (?, ?, ?);";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.setString(3, senha);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                funcionario = new Funcionario(rs.getInt(1), nome, email, senha);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }

    public List<Funcionario> findAll() {
        String sql = "SELECT * FROM funcionarios;";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                funcionarios.add(new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    public Funcionario findById(int id) {
        String sql = "SELECT * FROM funcionarios WHERE id = ?;";
        Funcionario funcionario = null;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                funcionario = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }
}
