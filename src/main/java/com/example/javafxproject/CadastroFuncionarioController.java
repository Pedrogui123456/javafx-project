package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastroFuncionarioController {
    @FXML
    private TextField txfEmail;
    @FXML
    private TextField txfNome;
    @FXML
    private TextField txfSenha;

    public void onActionCadastrar() {
        String email = txfEmail.getText();
        String nome = txfNome.getText();
        String senha = txfSenha.getText();


        System.out.println(email);
        System.out.println(nome);
        System.out.println(senha);
 
    }
    
}


