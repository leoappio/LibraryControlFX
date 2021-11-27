package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import com.example.librarycontrolfx.models.Database;
import com.example.librarycontrolfx.models.Loan;
import com.example.librarycontrolfx.models.Publication;
import com.example.librarycontrolfx.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CreateLoanController {
    @FXML
    private Label successMessage;
    @FXML
    private ChoiceBox publicationsList;
    @FXML
    private ChoiceBox usersList;

    private List<Publication> publications;

    private List<User> users;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("loan-menu.fxml");
    }
    public void realizeLoanButton(ActionEvent e) throws IOException, SQLException {
        int selectedIndexUser = usersList.getSelectionModel().getSelectedIndex();
        int selectedIndexPublication = publicationsList.getSelectionModel().getSelectedIndex();

        if (selectedIndexUser != -1 && selectedIndexPublication != -1){
            User user = users.get(selectedIndexUser);
            Publication publication = publications.get(selectedIndexPublication);
            Loan verifyLoan = Database.getLoan(user.id, publication.id);
            if (verifyLoan == null || verifyLoan.isReturned.equals("s")) {
                Loan loan = new Loan(user.id, publication.id, 0, "n");
                Database.insertLoan(loan);
                publication.decreaseQuantity();
                Database.updatePublication(publication);
                successMessage.setText("Empréstimo Realizado!");
            }
        }else{
            successMessage.setText("selecione os dados primeiro!");
        }

    }
    public void initialize() throws SQLException {
        getPublicationList();
        getUserList();
    }

    private void getPublicationList() throws SQLException {
        publications = Database.getAllPublication();

        publicationsList.getItems().clear();
        for(Publication publication : publications){
            publicationsList.getItems().add(publication.title+" - "+publication.author +" - "+publication.quantity+" un.");
        }
    }

    private void getUserList() throws SQLException {
        users = Database.getAllUsers();

        usersList.getItems().clear();
        for(User user : users){
            usersList.getItems().add(user.registration+" - "+user.name);
        }
    }
}
