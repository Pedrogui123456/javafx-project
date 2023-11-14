package com.example.javafxproject.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class FichaDAO {
    public Ficha create(Date dataDaCompra, int quantidade) {
        Ficha ficha = null;
        String sql = "INSERT INTO ficha (data_da_compra, quantidade) VALUES (?, ?);";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setDate(1, dataDaCompra);
            statement.setInt(2, quantidade);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                ficha = new Ficha(rs.getInt(1), dataDaCompra, quantidade);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ficha;
    }

    public List<Ficha> findAll() {
        String sql = "SELECT * FROM ficha;";
        List<Ficha> fichas = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                fichas.add(new Ficha(rs.getInt("id"), rs.getDate("data_da_compra"), rs.getInt("quantidade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fichas;
    }

    public Ficha findById(int id) {
        String sql = "SELECT * FROM ficha WHERE id = ?;";
        Ficha ficha = null;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                ficha = new Ficha(rs.getInt("id"), rs.getDate("data_da_compra"), rs.getInt("quantidade"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ficha;
    }
}
