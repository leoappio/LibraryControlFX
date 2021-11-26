package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import com.example.librarycontrolfx.models.Database;
import com.example.librarycontrolfx.models.Publication;
import com.example.librarycontrolfx.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EditPublicationController {
    @FXML
    private Label successMessage;
    @FXML
    private ChoiceBox publicationsList;
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField quantityField;

    private List<Publication> publications;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("publication-menu.fxml");
    }
    public void EditButton(ActionEvent e) throws IOException, SQLException {

        if(titleField.getText()!="" && authorField.getText()!= "" && Integer.parseInt(quantityField.getText()) > 0){
            int selectedIndex = publicationsList.getSelectionModel().getSelectedIndex();
            Publication publication = publications.get(selectedIndex);
            publication.setTitle(titleField.getText());
            publication.setAuthor(authorField.getText());
            publication.setQuantity(Integer.parseInt(quantityField.getText()));
            Database.updatePublication(publication);
            successMessage.setText("Publicação editada com sucesso!");
            getPublicationList();
            titleField.setText("");
            authorField.setText("");
            quantityField.setText("");
        }else{
            successMessage.setText("Preencha todos os dados!");
        }

    }
    public void initialize() throws SQLException {
        getPublicationList();

        publicationsList.setOnAction((event) -> {
            int selectedIndex = publicationsList.getSelectionModel().getSelectedIndex();
            if(selectedIndex != -1) {
                titleField.setText(publications.get(selectedIndex).title);
                authorField.setText(publications.get(selectedIndex).author);
                quantityField.setText(Integer.toString(publications.get(selectedIndex).quantity));
            }
        });
    }

    private void getPublicationList() throws SQLException {
        publications = Database.getAllPublication();

        publicationsList.getItems().clear();
        for(Publication publication : publications){
            publicationsList.getItems().add(publication.title+" - "+publication.author+" - "+publication.quantity);
        }
    }
}
