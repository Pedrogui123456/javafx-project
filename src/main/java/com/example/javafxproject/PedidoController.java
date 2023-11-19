package com.example.javafxproject;

import com.example.javafxproject.DAO.ProdutoDAO;
import com.example.javafxproject.DAO.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    @FXML
    private ListView<Produto> produtoListView;

    @FXML
    private Label lblProdutosNoPedido;

    private ProdutoDAO produtoDAO;
    private ObservableList<Produto> produtosDisponiveis;
    private List<Produto> produtosNoPedido;

    public PedidoController() {
        this.produtoDAO = new ProdutoDAO();
        this.produtosDisponiveis = FXCollections.observableArrayList(produtoDAO.listarTodos());
        this.produtosNoPedido = new ArrayList<>();
    }

    @FXML
    public void initialize() {
        produtoListView.setItems(produtosDisponiveis);
        produtoListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           
        });
    }

    @FXML
    public void adicionarAoPedido() {
        Produto produtoSelecionado = produtoListView.getSelectionModel().getSelectedItem();
        if (produtoSelecionado != null) {
            produtosNoPedido.add(produtoSelecionado);
            exibirAlerta("Produto Adicionado", produtoSelecionado.getNome() + " foi adicionado ao pedido.", Alert.AlertType.INFORMATION);
            atualizarLabelProdutosNoPedido();
        } else {
            exibirAlerta("Erro", "Selecione um produto para adicionar ao pedido.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void finalizarPedido() {
      
        exibirAlerta("Pedido Finalizado", "Pedido finalizado com sucesso!", Alert.AlertType.INFORMATION);
    }

    private void atualizarLabelProdutosNoPedido() {
        lblProdutosNoPedido.setText(String.valueOf(produtosNoPedido.size()));
    }

    private void exibirAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
