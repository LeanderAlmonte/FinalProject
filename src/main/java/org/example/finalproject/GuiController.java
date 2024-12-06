package org.example.finalproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GuiController {
    public TableColumn<Ticket, Integer > SearchTicketID;
    public TableColumn<Ticket, String > SearchEvent_Name;
    public TableColumn<Ticket, Integer > SearchSection;
    public TableColumn<Ticket, Integer > SearchSeat;
    public TableColumn<Ticket, Double > SearchPrice;
    public TableView<Ticket> SearchTable;
    public TableView<Ticket> UserTable;
    public TableColumn<Ticket,Integer> UserTicketID;
    public TableColumn<Ticket,String > UserEvent;
    public TableColumn<Ticket, Integer> UserSection;
    public TableColumn<Ticket ,Integer> UserSeat;
    public TableColumn<Ticket, Integer> UserPrice;
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
    private Label usernameUser;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TableView<Ticket> RefundTable;
    @FXML
    private TableColumn<Ticket, Integer > RefundTableTicketID;
    @FXML
    private TableColumn<Ticket, String > RefundTableEvent_Name;
    @FXML
    private TableColumn<Ticket, Integer > RefundTableSection;
    @FXML
    private TableColumn<Ticket, Integer > RefundTableSeat;
    @FXML
    private TableColumn<Ticket, Double > RefundTablePrice;
    @FXML
    protected void onLogInButtonClick(ActionEvent event) throws IOException {

        ticketSystem.displayUsers();

        if(ticketSystem.getUserByUsername(usernameTextField.getText()) != null){
            if(ticketSystem.getUserByUsername(usernameTextField.getText()).getPassword().equals(passwordTextField.getText())){
                root = FXMLLoader.load(getClass().getResource("UserMainMenu.fxml"));
                GUIApplication.ActiveUser = ticketSystem.getUserByUsername(usernameTextField.getText());
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
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TechnicianMainMenu.fxml")));
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
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Log In.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onLogOutTechButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Log In.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onBackUserButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UserMainMenu.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onBookTicketButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BookTicket.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onViewTicketsButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ViewTickets.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onSearchButtonClick(ActionEvent event)  throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SearchTicket.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

    @FXML
    protected void onRefundButtonClick(ActionEvent event)  throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RefundTicket.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    public void loadRefundTable(ActionEvent event){

        Cell<String> id = new Cell<>();
        RefundTableTicketID.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("TicketID"));
        RefundTableSeat.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("seatID"));
        RefundTablePrice.setCellValueFactory(new PropertyValueFactory<Ticket,Double>("price"));
        RefundTableSection.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("sectionID"));
        RefundTableEvent_Name.setCellValueFactory(new PropertyValueFactory<Ticket,String>("eventID"));
        ObservableList<Ticket> refundList= RefundTable.getItems() ;

            for(int i = 0  ; i<GUIApplication.ticketSystem.getUnassignedTicket().size();i++) {

                refundList.add(GUIApplication.ticketSystem.getUnassignedTicket().get(i));

            }


        RefundTable.setItems(refundList);
        System.out.println("Table was loaded");

    }

    public void loadSearchTable(ActionEvent event) {

        Cell<String> id = new Cell<>();
        SearchTicketID.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("TicketID"));
        SearchSeat.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("seatID"));
        SearchPrice.setCellValueFactory(new PropertyValueFactory<Ticket,Double>("price"));
        SearchSection.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("sectionID"));
        SearchEvent_Name.setCellValueFactory(new PropertyValueFactory<Ticket,String>("eventID"));
        ObservableList<Ticket> list= SearchTable.getItems() ;
        for(int i = 0  ; i<GUIApplication.ticketSystem.getUnassignedTicket().size();i++) {

            list.add(GUIApplication.ticketSystem.getUnassignedTicket().get(i));

        }

        SearchTable.setItems(list);
        System.out.println("Table was loaded");

    }

    public void loadReceiptTable(ActionEvent event) {

        Cell<String> id = new Cell<>();
        SearchTicketID.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("TicketID"));
        SearchSeat.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("seatID"));
        SearchPrice.setCellValueFactory(new PropertyValueFactory<Ticket,Double>("price"));
        SearchSection.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("sectionID"));
        SearchEvent_Name.setCellValueFactory(new PropertyValueFactory<Ticket,String>("eventID"));
        ObservableList<Ticket> list= SearchTable.getItems() ;
        for(int i = 0  ; i<GUIApplication.ticketSystem.getUnassignedTicket().size();i++) {

            list.add(GUIApplication.ticketSystem.getUnassignedTicket().get(i));

        }

        SearchTable.setItems(list);
        System.out.println("Table was loaded");

    }

    public void loadTicketsTable(ActionEvent event) {

        Cell<String> id = new Cell<>();
        SearchTicketID.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("TicketID"));
        SearchSeat.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("seatID"));
        SearchPrice.setCellValueFactory(new PropertyValueFactory<Ticket,Double>("price"));
        SearchSection.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("sectionID"));
        SearchEvent_Name.setCellValueFactory(new PropertyValueFactory<Ticket,String>("eventName"));
        ObservableList<Ticket> list= SearchTable.getItems() ;
        for(int i = 0  ; i<activeUser.getMyTickets().size();i++) {

            list.add(activeUser.getMyTickets().get(i));

        }

        SearchTable.setItems(list);
        System.out.println("Table was loaded");

    }


    public void loadUserTickets(ActionEvent event) {

        UserTicketID.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("TicketID"));
        UserSeat.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("seatID"));
        UserPrice.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("price"));
        UserPrice.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("sectionID"));
        UserEvent.setCellValueFactory(new PropertyValueFactory<Ticket, String>("eventID"));
        ObservableList<Ticket> list = UserTable.getItems();
        for (int i = 0; i < GUIApplication.ActiveUser.myTickets.size(); i++) {

            list.add(GUIApplication.ActiveUser.myTickets.get(i));

        }

        UserTable.setItems(list);
        System.out.println("Table was loaded");


    }

    public void BookTicket(ActionEvent event){

        GuiModel.ticketToAssigned(GUIApplication.ActiveUser.getUserID()+"",TicketBookField.getText());




    }
}