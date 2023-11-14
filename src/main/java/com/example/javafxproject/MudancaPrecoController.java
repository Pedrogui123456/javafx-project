package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MudancaPrecoController {

    @FXML
    private TextField txfNomeProduto;

    @FXML
    private TextField txfNovoPreco;

    @FXML
    private void onActionAplicarMudanca() {
        String nomeProduto = txfNomeProduto.getText();
        String novoPreco = txfNovoPreco.getText();
        // Adicione a lógica para aplicar a mudança de preço
        System.out.println("Mudança de preço para o produto " + nomeProduto + ": " + novoPreco);
    }
}
