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

public class DeleteUserController {
    @FXML
    private Label successMessage;
    @FXML
    private ChoiceBox usersList;

    private List<User> users;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("user-menu.fxml");
    }
    public void DeleteClick(ActionEvent e) throws IOException, SQLException {

        if(usersList.getSelectionModel().getSelectedItem() != null){
            int selectedIndex = usersList.getSelectionModel().getSelectedIndex();
            Database.deleteUser(users.get(selectedIndex).id);
            successMessage.setText("Usuário apagado com sucesso!");
            getUsersList();
        }else{
            successMessage.setText("Selecione um usuário para apagar!");
        }

    }
    public void initialize() throws SQLException {
        getUsersList();
    }

    private void getUsersList() throws SQLException {
        users = Database.getAllUsers();

        usersList.getItems().clear();
        for(User users : users){
            usersList.getItems().add(users.registration+" - "+users.name);
        }
    }
}
