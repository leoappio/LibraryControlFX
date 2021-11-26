package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import com.example.librarycontrolfx.models.Database;
import com.example.librarycontrolfx.models.Publication;
import com.example.librarycontrolfx.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DeletePublicationController {
    @FXML
    private Label successMessage;
    @FXML
    private ChoiceBox publicationsList;

    private List<Publication> publications;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("publication-menu.fxml");
    }
    public void DeleteClick(ActionEvent e) throws IOException, SQLException {

        if(publicationsList.getSelectionModel().getSelectedItem() != null){
            int selectedIndex = publicationsList.getSelectionModel().getSelectedIndex();
            Database.deletePublication(publications.get(selectedIndex).id);
            successMessage.setText("Publicação apagada com sucesso!");
            getPublicationList();
        }else{
            successMessage.setText("Selecione uma publicação para apagar!");
        }

    }
    public void initialize() throws SQLException {
        getPublicationList();
    }

    private void getPublicationList() throws SQLException {
        publications = Database.getAllPublication();

        publicationsList.getItems().clear();
        for(Publication publication : publications){
            publicationsList.getItems().add(publication.title+" - "+publication.author);
        }
    }
}
