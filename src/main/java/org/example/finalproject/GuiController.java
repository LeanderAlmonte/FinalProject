package org.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    TicketSystem ticketSystem;

    public GuiController() {
        this.ticketSystem = TicketSystem.getInstance();
    }


    @FXML
    private Label welcomeText;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    protected void onLogInButtonClick(ActionEvent event) throws IOException {

        ticketSystem.displayUsers();

        if(ticketSystem.getUserByUsername(usernameTextField.getText()) != null){
            if(ticketSystem.getUserByUsername(usernameTextField.getText()).getPassword().equals(passwordTextField.getText())){
                root = FXMLLoader.load(getClass().getResource("UserMainMenu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                errorLabel.setText("Incorrect Password");
            }
        }
        else if(ticketSystem.getTechnicianByUsername(usernameTextField.getText()) != null){
            if(ticketSystem.getTechnicianByUsername(usernameTextField.getText()).getPassword().equals(passwordTextField.getText())){
                root = FXMLLoader.load(getClass().getResource("TechnicianMainMenu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                errorLabel.setText("Incorrect Password");
            }
        }
        else if(usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()){
            errorLabel.setText("Username and Password are Empty");
        }
        else{
            errorLabel.setText("Invalid Username");
        }
    }

    @FXML
    protected void onLogOutButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onLogOutTechButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}