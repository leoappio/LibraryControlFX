package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class UserMenuController {

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("hello-view.fxml");
    }
    public void CreateButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("create-user.fxml");
    }

    public void AllUsersButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("all-users.fxml");
    }

    public void DeleteUserButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("delete-user.fxml");
    }
    public void EditUserButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("edit-user.fxml");
    }
}
