package com.example.javafxproject;

import com.example.javafxproject.DAO.Produto;
import com.example.javafxproject.DAO.ProdutoDAO;

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

        ProdutoDAO produtoDao = new ProdutoDAO();
        Produto produto = produtoDao.cadastrar(nome, preco, categoria);

        System.out.println(produto.getId());
        System.out.println(produto.getNome());
        System.out.println(produto.getPreco());
        System.out.println(produto.getCategoria());
 
 
    }
    
}
