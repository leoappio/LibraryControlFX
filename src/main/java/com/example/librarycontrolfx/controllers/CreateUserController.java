package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import com.example.librarycontrolfx.models.Database;
import com.example.librarycontrolfx.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class CreateUserController {
    @FXML
    private Label successMessage;
    @FXML
    private TextField nameField;
    @FXML
    private TextField registrationField;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("user-menu.fxml");
    }
    public void onCreateButton(ActionEvent e) throws IOException, SQLException {

        if(registrationField.getText() != "" && nameField.getText() != ""){
            User user = new User(registrationField.getText(), nameField.getText());
            Database.insertUser(user);
            successMessage.setText("Usuário cadastrado com sucesso!");
            registrationField.setText("");
            nameField.setText("");
        }

    }
}
