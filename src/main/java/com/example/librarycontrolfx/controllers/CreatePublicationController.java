package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import com.example.librarycontrolfx.models.Database;
import com.example.librarycontrolfx.models.Publication;
import com.example.librarycontrolfx.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class CreatePublicationController {
    @FXML
    private Label successMessage;
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField quantityField;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("publication-menu.fxml");
    }
    public void onCreateButton(ActionEvent e) throws IOException, SQLException {

        if(titleField.getText() != "" && authorField.getText() != "" && Integer.parseInt(quantityField.getText()) > 0){
            Publication publication = new Publication(titleField.getText(), authorField.getText(),Integer.parseInt(quantityField.getText()));
            Database.insertPublication(publication);
            successMessage.setText("Publicação cadastrada com sucesso!");
            titleField.setText("");
            authorField.setText("");
            quantityField.setText("");
        }else{
            successMessage.setText("Preencha todos os dados!");
        }

    }
}
