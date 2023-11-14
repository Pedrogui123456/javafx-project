package com.example.javafxproject;


import com.example.javafxproject.DAO.Ficha;
import com.example.javafxproject.DAO.FichaDAO;

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

        FichaDAO fichaDao = new FichaDAO();
        Ficha ficha = fichaDao.create(null, 0);

        System.out.println(ficha.getId());
        System.out.println(ficha.getQuantidade());
        System.out.println(ficha.getDataDaCompra());
    }
}
       