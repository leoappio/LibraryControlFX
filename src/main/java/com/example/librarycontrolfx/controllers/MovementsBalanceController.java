package com.example.librarycontrolfx.controllers;

import com.example.librarycontrolfx.HelloApplication;
import com.example.librarycontrolfx.models.Database;
import com.example.librarycontrolfx.models.Library;
import com.example.librarycontrolfx.models.Publication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovementsBalanceController {
    @FXML
    private ListView publicationsList;
    @FXML
    private Label totalUsers;
    @FXML
    private Label totalPublications;
    @FXML
    private Label totalLoans;
    @FXML
    private Label averageLateDays;
    @FXML
    private Label averageLoans;

    public void returnButton(ActionEvent e) throws IOException {
        HelloApplication.goToScreen("reports-menu.fxml");
    }
    public void initialize() throws SQLException{
        Library library = new Library();
        int lTotalUsers = library.getTotalUsers();
        int lTotalPublications = library.getTotalPublications();
        int lTotalLoans = Database.getTotalLoans();
        float lAverageLoans = (float)lTotalLoans / lTotalUsers;
        String strAvgLoans = String.format("%.2f",lAverageLoans);
        float lAverageLateDays = Database.getAverageLateDays();
        String strAvgLateDays = String.format("%.2f",lAverageLateDays);

        totalUsers.setText("Total de usuários: "+lTotalUsers);
        totalPublications.setText("Total de publicações no acervo: "+ lTotalPublications);
        totalLoans.setText("Total de empréstimos no mês: "+ lTotalLoans);
        averageLateDays.setText("Média de dias de atraso na devolução dos livros: "+strAvgLateDays);
        averageLoans.setText("Média de movimentações por usuario: "+strAvgLoans);

        ObservableList<String> publicationListView = FXCollections.observableArrayList();
        ArrayList<Publication> top10Publications = Database.getTop10Publications();

        for(int i = 0; i < top10Publications.size();i++){
            int TotalLoans = Database.getTotalLoanByPublicationId(top10Publications.get(i).id);
            publicationListView.add((i+1)+" - "+top10Publications.get(i).title+" - "+top10Publications.get(i).author+" - Nº de empréstimos: "+TotalLoans);
        }

        publicationsList.setItems(publicationListView);

    }
}
