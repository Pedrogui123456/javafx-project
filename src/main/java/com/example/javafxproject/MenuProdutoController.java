package com.example.javafxproject;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class MenuProdutoController {

    @FXML
    private void onActionCadastrarProduto() {
        // Implemente a lógica para abrir a tela de cadastro de produtos
        System.out.println("Cadastrar Produto clicado!");
    }

    @FXML
    private void onActionListarProdutos() {
        // Implemente a lógica para abrir a tela de listagem de produtos
        System.out.println("Listar Produtos clicado!");
    }

    @FXML
    private void onActionSair() {
        // Implemente a lógica para fechar a aplicação
        Platform.exit();
    }
}
