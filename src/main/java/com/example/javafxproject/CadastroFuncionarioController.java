package com.example.javafxproject;

import com.example.javafxproject.DAO.Funcionario;
import com.example.javafxproject.DAO.FuncionarioDAO;

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

        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        Funcionario funcionario = funcionarioDao.create(nome, email, senha);

        System.out.println(funcionario.getId());
        System.out.println(funcionario.getEmail());
        System.out.println(funcionario.getNome());
        System.out.println(funcionario.getSenha());
 
    }
    
}


