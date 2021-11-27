package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ReportsMenuController {

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("hello-view.fxml");
    }
    public void UserCardButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("user-card.fxml");
    }

    public void collectionBalanceButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("collection-balance.fxml");
    }
    public void movementsBalanceButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("movements-balance.fxml");
    }
}
