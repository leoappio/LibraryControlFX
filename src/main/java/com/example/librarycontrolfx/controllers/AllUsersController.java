package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import com.example.librarycontrolfx.models.Database;
import com.example.librarycontrolfx.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AllUsersController {
    @FXML
    private ListView usersList;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("user-menu.fxml");
    }
    public void initialize() throws SQLException{

        ObservableList<String> usersListView = FXCollections.observableArrayList ();
        List<User> users = Database.getAllUsers();

        for(User user : users){
            usersListView.add(user.id+" - "+user.registration+" - "+user.name);
        }

        usersList.setItems(usersListView);

    }
}
