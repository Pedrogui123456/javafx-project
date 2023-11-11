package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastroFichaController {
    @FXML
    private TextField txfQuantidade;
    @FXML
    private TextField txfData;

    public void onActionCadastrar() {
        String quantidade = txfQuantidade.getText();
        String data = txfData.getText();



        System.out.println(quantidade);
        System.out.println(data);
 
    }
}
