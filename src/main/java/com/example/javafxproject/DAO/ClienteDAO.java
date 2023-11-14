package com.example.javafxproject.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO {
    public Cliente create(String nome, String email, String senha) {
        Cliente cliente = null;
        String sql = "INSERT INTO clientes (nome, email, senha) VALUES (?, ?, ?);";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.setString(3, senha);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                cliente = new Cliente(rs.getInt(1), nome, email, senha);
            }

            rs.close();

            return cliente;  
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM clientes;";
        List<Cliente> clientes = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                clientes.add(
                    new Cliente(
                        rs.getInt("id"), 
                        rs.getString("nome"), 
                        rs.getString("email"), 
                        rs.getString("senha")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return clientes;
        } 

        return clientes;
    }

    public Cliente findById(Integer id) {
        String sql = "SELECT * FROM clientes WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
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
