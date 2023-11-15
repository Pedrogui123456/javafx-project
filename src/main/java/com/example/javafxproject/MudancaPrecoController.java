package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import com.example.javafxproject.DAO.MudancaPreco;
import com.example.javafxproject.DAO.MudancaPrecoDAO;


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


        MudancaPrecoDAO mudancaprecoDao = new MudancaPrecoDAO();
       MudancaPreco mudancapreco = mudancaprecoDao.cadastrar(nomeProduto, novoPreco);

        System.out.println(mudancapreco.getId());
        System.out.println(mudancapreco.getNome());
        System.out.println(mudancapreco.getNovoPreco());
    }
}
