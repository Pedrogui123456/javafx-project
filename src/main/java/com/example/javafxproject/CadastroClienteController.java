package com.example.javafxproject;


import com.example.javafxproject.DAO.Cliente;
import com.example.javafxproject.DAO.ClienteDAO;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class CadastroClienteController {
    @FXML
    private TextField txfNome;
    @FXML
    private TextField txfEmail;
    @FXML
    private TextField txfSenha;
    
    
    
    public void onActionCadastrar() {
        String nome = txfNome.getText();
        String email = txfEmail.getText();
        String senha = txfSenha.getText();


        System.out.println(nome);
        System.out.println(email);
        System.out.println(senha);

        ClienteDAO clienteDao = new ClienteDAO();
        Cliente cliente = clienteDao.create(nome, email, senha);

        System.out.println(cliente.getId());
        System.out.println(cliente.getNome());
        System.out.println(cliente.getEmail());
        System.out.println(cliente.getSenha());
 
    }
}   

