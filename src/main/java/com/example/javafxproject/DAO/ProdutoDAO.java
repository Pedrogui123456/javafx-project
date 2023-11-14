package com.example.javafxproject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
    public Produto cadastrar(String nome, String preco, String categoria) {
        Produto produto = null;
        String sql = "INSERT INTO produtos (nome, preco, categoria) VALUES (?, ?, ?);";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, nome);
            statement.setString(2, preco);
            statement.setString(3, categoria);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                produto = new Produto(rs.getInt(1), nome, preco, categoria);
            }

            rs.close();

            return produto;  
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Produto> listarTodos() {
        String sql = "SELECT * FROM produtos;";
        List<Produto> produtos = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                produtos.add(
                    new Produto(
                        rs.getInt("id"), 
                        rs.getString("nome"), 
                        rs.getString("preco"), 
                        rs.getString("categoria")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return produtos;
        } 

        return produtos;
    }

    public Produto buscarPorId(Integer id) {
        String sql = "SELECT * FROM produtos WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("preco"),
                    rs.getString("categoria")
                );
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}
