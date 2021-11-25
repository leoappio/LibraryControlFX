package com.example.librarycontrolfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage globalStage;
    @Override
    public void start(Stage stage) throws IOException {
        globalStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Library Control");
        stage.setScene(scene);
        stage.show();
    }

    private static Scene getSceneByScreen(String screenName) throws IOException {
        FXMLLoader fxmlAllClients = new FXMLLoader(HelloApplication.class.getResource(screenName));
        Scene sceneToReturn = new Scene(fxmlAllClients.load(), 700, 500);
        return sceneToReturn;
    }

    public static void goToScreen(String screen) throws IOException {
        Scene screenToShow = getSceneByScreen(screen);
        globalStage.setScene(screenToShow);
    }

    public static void main(String[] args) {
        launch();
    }
}