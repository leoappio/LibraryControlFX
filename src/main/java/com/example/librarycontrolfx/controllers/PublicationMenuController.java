package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class PublicationMenuController {

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("hello-view.fxml");
    }
    public void CreateButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("create-publication.fxml");
    }

    public void AllPublicationsButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("all-publications.fxml");
    }

    public void DeletePublicationButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("delete-publication.fxml");
    }
    public void EditPublicationButtonClick(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("edit-publication.fxml");
    }
}
