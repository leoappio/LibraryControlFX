module com.example.librarycontrolfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.librarycontrolfx to javafx.fxml;
    exports com.example.librarycontrolfx;
    exports com.example.librarycontrolfx.controllers;
    opens com.example.librarycontrolfx.controllers to javafx.fxml;
}