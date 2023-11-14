package com.example.javafxproject;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class RealizarPedidoController {

    @FXML
    private ChoiceBox<String> choiceBoxProdutos;

    @FXML
    private TableView<ItemPedido> tableViewPedido;

    @FXML
    private TableColumn<ItemPedido, String> colProduto;

    @FXML
    private TableColumn<ItemPedido, Double> colPreco;

    @FXML
    private TableColumn<ItemPedido, Integer> colQuantidade;

    @FXML
    private TableColumn<ItemPedido, Double> colTotal;

    @FXML
    private void initialize() {
        // Inicializa a ChoiceBox com alguns produtos de exemplo
        List<String> produtos = new ArrayList<>();
        produtos.add("Hambúrguer");
        produtos.add("Batata Frita");
        produtos.add("Refrigerante");
        choiceBoxProdutos.getItems().addAll(produtos);

        // Configura as colunas da TableView usando PropertyValueFactory
        colProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    @FXML
    private void onActionAdicionarAoPedido() {
        // Adicione a lógica para adicionar o item ao pedido
        String produtoSelecionado = choiceBoxProdutos.getValue();
        if (produtoSelecionado != null && !produtoSelecionado.isEmpty()) {
            // Adiciona o item à TableView
            tableViewPedido.getItems().add(new ItemPedido(produtoSelecionado, 10.0, 1));
        }
    }

    @FXML
    private void onActionFinalizarPedido() {
        // Adicione a lógica para finalizar o pedido
        // Isso pode envolver o cálculo do valor total do pedido, a gravação no banco de dados, etc.
        System.out.println("Pedido finalizado!");
    }

    public static class ItemPedido {
        private final SimpleStringProperty produto;
        private final SimpleDoubleProperty preco;
        private final SimpleIntegerProperty quantidade;

        public ItemPedido(String produto, double preco, int quantidade) {
            this.produto = new SimpleStringProperty(produto);
            this.preco = new SimpleDoubleProperty(preco);
            this.quantidade = new SimpleIntegerProperty(quantidade);
        }

        public String getProduto() {
            return produto.get();
        }

        public double getPreco() {
            return preco.get();
        }

        public int getQuantidade() {
            return quantidade.get();
        }

        public double getTotal() {
            return preco.get() * quantidade.get();
        }
    }
}
