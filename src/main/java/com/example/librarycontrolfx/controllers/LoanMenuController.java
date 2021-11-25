package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoanMenuController {

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("hello-view.fxml");
    }
    public void LoanButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("create-loan.fxml");
    }

    public void returnLoanButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("return-loan.fxml");
    }
}
