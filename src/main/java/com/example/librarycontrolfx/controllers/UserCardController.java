package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import com.example.librarycontrolfx.models.Database;
import com.example.librarycontrolfx.models.Publication;
import com.example.librarycontrolfx.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCardController {
    @FXML
    private ChoiceBox userList;
    @FXML
    private ListView publicationsList;
    @FXML
    private Label registrationField;
    @FXML
    private Label nameField;
    @FXML
    private Label totalLoansField;

    private List<User> users;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("reports-menu.fxml");
    }
    public void initialize() throws SQLException{
        getUsers();

        userList.setOnAction((event) -> {
            try {
                attData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });


    }

    public void attData() throws SQLException {
        int selectedIndexClient = userList.getSelectionModel().getSelectedIndex();
        User user = users.get(selectedIndexClient);
        ArrayList<Publication> allPublications = Database.getAllPublicationsFromUserId(user.id);

        registrationField.setText("Matrícula: "+user.registration);
        nameField.setText("Nome: "+user.name);
        totalLoansField.setText("Total de empréstimos: "+allPublications.size());

        ObservableList<String> publicationListView = FXCollections.observableArrayList();

        for(Publication publication : allPublications){
            publicationListView.add(publication.id+" - "+publication.title+" - "+publication.author);
        }

        publicationsList.setItems(publicationListView);

    }

    public void getUsers() throws SQLException {
        users = Database.getAllUsers();

        userList.getItems().clear();
        for(User users : users){
            userList.getItems().add(users.registration+" - "+users.name);
        }
    }
}
