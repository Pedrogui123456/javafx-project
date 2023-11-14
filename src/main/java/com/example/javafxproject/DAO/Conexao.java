package com.example.javafxproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost/estudante1?user=estudante1&password=estudante1&useSSL=true";
     
       
       
        //String url = "jdbc:mysql://localhost:3306/pgestudante?user=root&password=estudante";
       //String url = "jdbc:mysql://localhost:3306/estudojava?user=root&password=estudante";

        try {
            return (Connection) DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}