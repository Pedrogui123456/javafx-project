package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.SQLException;

import DAO.Cliente;
import DAO.ClienteDAO;

public class CadastroClienteController {
    @FXML
    private TextField txfNome;
    @FXML
    private TextField txfEmail;
    @FXML
    private TextField txfSenha;
    
     @FXML
    public void onActionCadastrarCliente() throws SQLException{
        String nome = txfNome.getText();
        String email = txfEmail.getText();
        String senha = txfSenha.getText();
        
        
        ClienteDAO clienteDao = new ClienteDAO();

        Cliente cliente = new Cliente(nome, email, senha);

        Cliente clienteCriado = clienteDao.create(cliente);

        System.out.println(nome + "\n" + email + "\n" + senha );
    }

    public void onActionCadastrar() {
        String nome = txfNome.getText();
        String email = txfEmail.getText();
        String senha = txfSenha.getText();


        System.out.println(nome);
        System.out.println(email);
        System.out.println(senha);
 
    }
    
}
