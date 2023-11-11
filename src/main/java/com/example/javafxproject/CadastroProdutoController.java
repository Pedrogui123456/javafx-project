package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastroProdutoController {
    @FXML
    private TextField txfNome;
    @FXML
    private TextField txfPreco;
    @FXML
    private TextField txfCategoria;

    public void onActionCadastrar() {
        String nome = txfNome.getText();
        String preco = txfPreco.getText();
        String categoria = txfCategoria.getText();


        System.out.println(nome);
        System.out.println(preco);
        System.out.println(categoria);
 
    }
    
}
