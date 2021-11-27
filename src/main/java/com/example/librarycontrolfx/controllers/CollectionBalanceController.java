package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import com.example.librarycontrolfx.models.Database;
import com.example.librarycontrolfx.models.Publication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CollectionBalanceController {
    @FXML
    private ListView publicationsList;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("reports-menu.fxml");
    }
    public void initialize() throws SQLException{

        ObservableList<String> publicationListView = FXCollections.observableArrayList ();
        List<Publication> publications = Database.getAllPublication();

        for(Publication publication : publications){
            publicationListView.add(publication.id+" - "+publication.title+" - "+publication.author+" - "+publication.quantity);
        }

        publicationsList.setItems(publicationListView);

    }
}
