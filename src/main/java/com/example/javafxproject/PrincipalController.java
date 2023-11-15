package com.example.javafxproject;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalController {
    
    @FXML
    public void onActionCadastrarCliente()  throws IOException {
        FXMLLoader loader = new FXMLLoader(PrincipalController.class.getResource("cadastro-cliente.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Cliente");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    @FXML
    public void onActionCadastrarFuncionario() throws IOException {
        FXMLLoader loader = new FXMLLoader(PrincipalController.class.getResource("cadastro-funcionario.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Funcionario");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    @FXML
    public void onActionCadastrarProduto() throws IOException {
        FXMLLoader loader = new FXMLLoader(PrincipalController.class.getResource("cadastro-produto.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Produto");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    @FXML
    public void onActionCadastrarFicha() throws IOException {
        FXMLLoader loader = new FXMLLoader(PrincipalController.class.getResource("cadastro-ficha.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Ficha");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

     @FXML
    public void onActionCardapio() throws IOException {
        FXMLLoader loader = new FXMLLoader(PrincipalController.class.getResource("cardapio.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Cardapio");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

     @FXML
    public void onActionMenuProduto() throws IOException {
        FXMLLoader loader = new FXMLLoader(PrincipalController.class.getResource("menu-produto.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Menu do Produto");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

      @FXML
    public void onActionRealizarPedido() throws IOException {
        FXMLLoader loader = new FXMLLoader(PrincipalController.class.getResource("realizar-pedido.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Realize seu Pedido");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

      @FXML
    public void onActionMudancaPreco() throws IOException {
        FXMLLoader loader = new FXMLLoader(PrincipalController.class.getResource("mudanca-preco.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("Mudança Preço");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }






   
}
