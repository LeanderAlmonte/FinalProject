package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ArenaTicketSystemControllerGUI extends Application {


    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ArenaTicketSystem.fxml"));

        Scene logInScene = new Scene(fxmlLoader.load(), 1280, 720);
        primaryStage.setTitle("Arena Ticket System");
        primaryStage.setScene(logInScene);
        primaryStage.show();
    }
}
