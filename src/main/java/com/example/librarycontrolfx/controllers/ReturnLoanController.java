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
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReturnLoanController {
    @FXML
    private TextField lateDays;
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
    public void returnLoanButton(ActionEvent e) throws IOException, SQLException {
        int selectedIndexUser = usersList.getSelectionModel().getSelectedIndex();
        int selectedIndexPublication = publicationsList.getSelectionModel().getSelectedIndex();

        if (selectedIndexUser != -1 && selectedIndexPublication != -1 && lateDays.getText() != ""){
            User user = users.get(selectedIndexUser);
            Publication publication = publications.get(selectedIndexPublication);
            Loan loan = Database.getActualLoan(user.id, publication.id);
            loan.setLateDays(Integer.parseInt(lateDays.getText()));
            loan.setIsReturned("s");

            Database.updateLoan(loan);
            publication.increaseQuantity();
            Database.updatePublication(publication);
            successMessage.setText("Devolução Realizada!");
            usersList.setValue("");
            publicationsList.setValue("");
            lateDays.setText("");
            getPublicationList();
        }else{
            successMessage.setText("selecione os dados primeiro!");
        }

    }
    public void initialize() throws SQLException {
        getPublicationList();
        getUserList();
        usersList.setOnAction((event) -> {
            try {
                getPublicationList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void getPublicationList() throws SQLException {
        int selectedIndexUser = usersList.getSelectionModel().getSelectedIndex();
        if(selectedIndexUser != -1){
            User user = users.get(selectedIndexUser);
            publications = Database.getPublicationsFromUserId(user.id);
            publicationsList.getItems().clear();
            if(publications.size() > 0){
                successMessage.setText("");
                for(Publication publication : publications){
                    publicationsList.getItems().add(publication.title+" - "+publication.author);
                }
            }else{
                successMessage.setText("Este usuário não realizou nenhum empréstimo!");
            }

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
