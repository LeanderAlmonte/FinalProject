package org.example.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIApplication extends Application {

     static TicketSystem ticketSystem;
     static  User ActiveUser;

     static Technician ActiveTechnician;

    @Override
    public void start(Stage stage) throws IOException {

        ticketSystem = TicketSystem.getInstance();

        GuiModel.loadUnsassignedTickets(ticketSystem);
        GuiModel.loadProcessingTickets(ticketSystem);
        GuiModel.loadAssignedTickets(ticketSystem);
        FXMLLoader fxmlLoader = new FXMLLoader(GUIApplication.class.getResource("Log In.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Arena Ticket Booking System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}