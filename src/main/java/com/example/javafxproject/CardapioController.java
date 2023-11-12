package com.example.javafxproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CardapioController {

    @FXML
    private ListView<String> listViewCardapio;

    @FXML
    private void initialize() {
        // Inicializa o cardápio com alguns itens de exemplo
        ObservableList<String> cardapioItems = FXCollections.observableArrayList(
                "Hamburguer - R$10.0",
                "Batata Frita - R$5.0",
                "Refrigerante - R$3.0"
        );

        listViewCardapio.setItems(cardapioItems);
    }
}
