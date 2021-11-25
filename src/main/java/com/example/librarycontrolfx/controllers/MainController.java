package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {
    @FXML
    protected void userButtonClick() throws IOException {
        HelloApplication.goToScreen("user-menu.fxml");
    }

    @FXML
    protected void publicationButtonClick() throws IOException {
        HelloApplication.goToScreen("publication-menu.fxml");
    }

    @FXML
    protected void loanButtonClick() throws IOException {
        HelloApplication.goToScreen("loan-menu.fxml");
    }

    @FXML
    protected void ReportsButtonClick() throws IOException {
        HelloApplication.goToScreen("reports-menu.fxml");
    }

}