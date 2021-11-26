package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import com.example.librarycontrolfx.models.Database;
import com.example.librarycontrolfx.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EditUserController {
    @FXML
    private Label successMessage;
    @FXML
    private ChoiceBox usersList;
    @FXML
    private TextField registrationField;
    @FXML
    private TextField nameField;

    private List<User> users;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("user-menu.fxml");
    }
    public void EditButton(ActionEvent e) throws IOException, SQLException {

        if(nameField.getText()!="" && registrationField.getText()!= ""){
            int selectedIndex = usersList.getSelectionModel().getSelectedIndex();
            User user = users.get(selectedIndex);
            user.setName(nameField.getText());
            user.setRegistration(registrationField.getText());
            Database.updateUser(user);
            successMessage.setText("Usuário editado com sucesso!");
            getUsersList();
            nameField.setText("");
            registrationField.setText("");
        }else{
            successMessage.setText("Preencha todos os dados!");
        }

    }
    public void initialize() throws SQLException {
        getUsersList();

        usersList.setOnAction((event) -> {
            int selectedIndex = usersList.getSelectionModel().getSelectedIndex();
            if(selectedIndex != -1) {
                registrationField.setText(users.get(selectedIndex).registration);
                nameField.setText(users.get(selectedIndex).name);
            }
        });
    }

    private void getUsersList() throws SQLException {
        users = Database.getAllUsers();

        usersList.getItems().clear();
        for(User users : users){
            usersList.getItems().add(users.registration+" - "+users.name);
        }
    }
}
