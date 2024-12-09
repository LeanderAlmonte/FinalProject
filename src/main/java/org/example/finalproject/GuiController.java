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
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class GuiController {

    int buttonpress = 0;
    public TableColumn<Ticket, Integer > SearchTicketID;
    public TableColumn<Ticket, String > SearchEvent_Name;
    public TableColumn<Ticket, Integer > SearchSection;
    public TableColumn<Ticket, Integer > SearchSeat;
    public TableColumn<Ticket, Double > SearchPrice;

    public TableView<Ticket> SearchTable;
    public TableView<Ticket> UserTable;
    public TableColumn<Ticket, Integer> UserTicketID;
    public TableColumn<Ticket, String> UserEvent;
    public TableColumn<Ticket, Integer> UserSection;
    public TableColumn<Ticket, Integer> UserSeat;
    public TableColumn<Ticket, Double> UserPrice;
    public TableView<Ticket> AssignTable;
    public TableColumn<Ticket, Integer> AssignTicketID;
    public TableColumn<Ticket, String> AssignEvent;
    public TableColumn<Ticket, Integer> AssignSection;
    public TableColumn<Ticket, Integer> AssignSeat;
    public TableColumn<Ticket, Double> AssignPrice;
    public TextField TicketBookField;
    private Stage stage;
    private Scene scene;
    private Parent root;

    TicketSystem ticketSystem;

    public GuiController() {
        this.ticketSystem = TicketSystem.getInstance();
    }

    LocaleManager currentLocale;

    @FXML
    private Button langButton;

    @FXML
    private Button logInButton;

    @FXML
    private Label projectTitle;

    @FXML
    private ComboBox<String> languageComboBox;

    @FXML
    private Label createEventErrorLabel;

    @FXML
    private TextField eventNameField;

    @FXML
    private ComboBox<String> eventTypeComboBox;

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
    private TableColumn<Ticket, Integer> RefundTableTicketID;
    @FXML
    private TableColumn<Ticket, String> RefundTableEvent_Name;
    @FXML
    private TableColumn<Ticket, Integer> RefundTableSection;
    @FXML
    private TableColumn<Ticket, Integer> RefundTableSeat;
    @FXML
    private TableColumn<Ticket, Double> RefundTablePrice;

    @FXML
    public void initialize() {

        if (eventTypeComboBox != null) {
            eventTypeComboBox.getItems().addAll("BasketballGame", "Concert", "HockeyGame", "Spectacle");
        }
    }

    private void onLangButtonClick(ActionEvent actionEvent) {
        LocaleManager.loadLocale();
        if(LocaleManager.getCurrentLocale() == LocaleManager.getEnLocale()) {
            langButton.setText(LocaleManager.getString("langButtonText"));
            updateUI();
        }
    }

    private void updateUI() {
        logInButton.setText(i18n.getString("logInButton"));
        projectTitle.setText(i18n.getString("projectTitle"));
    }


    @FXML
    protected void onLogInButtonClick(ActionEvent event) throws IOException {

        ticketSystem.displayUsers();

        if (ticketSystem.getUserByUsername(usernameTextField.getText()) != null) {
            if (ticketSystem.getUserByUsername(usernameTextField.getText()).getPassword().equals(passwordTextField.getText())) {
                root = FXMLLoader.load(getClass().getResource("UserMainMenu.fxml"));
                GUIApplication.ActiveUser = ticketSystem.getUserByUsername(usernameTextField.getText());
                GuiModel.loadUserTickets(GUIApplication.ActiveUser);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                errorLabel.setText("Incorrect Password");
            }
        } else if (ticketSystem.getTechnicianByUsername(usernameTextField.getText()) != null) {
            if (ticketSystem.getTechnicianByUsername(usernameTextField.getText()).getPassword().equals(passwordTextField.getText())) {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TechnicianMainMenu.fxml")));
                GUIApplication.ActiveTechnician = ticketSystem.getTechnicianByUsername(usernameTextField.getText());
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                errorLabel.setText("Incorrect Password");
            }
        } else if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
            errorLabel.setText("Username and Password are Empty");
        } else {
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
    protected void onBackTechButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TechnicianMainMenu.fxml")));
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
    protected void onSearchButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SearchTicket.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    protected void onRefundButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RefundTicket.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    public void loadRefundTable(ActionEvent event) {

        if(buttonpress<1) {
            buttonpress++;
            RefundTableTicketID.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("TicketID"));
            RefundTableSeat.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("seatID"));
            RefundTablePrice.setCellValueFactory(new PropertyValueFactory<Ticket, Double>("price"));
            RefundTableSection.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("sectionID"));
            RefundTableEvent_Name.setCellValueFactory(new PropertyValueFactory<Ticket, String>("eventName"));
            ObservableList<Ticket> refundList = RefundTable.getItems();

            for (int i = 0; i < GUIApplication.ActiveUser.myTickets.size(); i++) {

            refundList.add(GUIApplication.ActiveUser.myTickets.get(i));

        }


            RefundTable.setItems(refundList);
            System.out.println("Table was loaded");
        }

    }

    public void loadSearchTable(ActionEvent event) {

if(buttonpress<1){
    buttonpress++;
            SearchTicketID.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("TicketID"));
            SearchSeat.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("seatID"));
            SearchPrice.setCellValueFactory(new PropertyValueFactory<Ticket, Double>("price"));
            SearchSection.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("sectionID"));
            SearchEvent_Name.setCellValueFactory(new PropertyValueFactory<Ticket, String>("eventName"));
            ObservableList<Ticket> list = SearchTable.getItems();
            for (int i = 1; i < GUIApplication.ticketSystem.getUnassignedTicket().size(); i++) {

                list.add(GUIApplication.ticketSystem.getUnassignedTicket().get(i));

            }

            SearchTable.setItems(list);
            System.out.println("Table was loaded");

        }

    }

    public void loadReceiptTable(ActionEvent event) {


        SearchTicketID.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("TicketID"));
        SearchSeat.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("seatID"));
        SearchPrice.setCellValueFactory(new PropertyValueFactory<Ticket, Double>("price"));
        SearchSection.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("sectionID"));
        SearchEvent_Name.setCellValueFactory(new PropertyValueFactory<Ticket, String>("eventName"));
        ObservableList<Ticket> list = SearchTable.getItems();
        for (int i = 0; i < GUIApplication.ticketSystem.getUnassignedTicket().size(); i++) {

            list.add(GUIApplication.ticketSystem.getUnassignedTicket().get(i));

        }

        SearchTable.setItems(list);
        System.out.println("Table was loaded");

    }

    public void loadTicketsTable(ActionEvent event) {


        SearchTicketID.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("TicketID"));
        SearchSeat.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("seatID"));
        SearchPrice.setCellValueFactory(new PropertyValueFactory<Ticket,Double>("price"));
        SearchSection.setCellValueFactory(new PropertyValueFactory<Ticket,Integer>("sectionID"));
        SearchEvent_Name.setCellValueFactory(new PropertyValueFactory<Ticket,String>("eventName"));
        ObservableList<Ticket> list= SearchTable.getItems() ;
        for(int i = 0  ; i<GUIApplication.ActiveUser.getMyTickets().size();i++) {

            list.add(GUIApplication.ActiveUser.getMyTickets().get(i));

        }

        SearchTable.setItems(list);
        System.out.println("Table was loaded");

    }


    public void loadUserTickets(ActionEvent event) {
        if(buttonpress<1) {
            buttonpress++;
            UserTicketID.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("TicketID"));
            UserSeat.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("seatID"));
            UserPrice.setCellValueFactory(new PropertyValueFactory<Ticket, Double>("price"));
            UserSection.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("sectionID"));
            UserEvent.setCellValueFactory(new PropertyValueFactory<Ticket, String>("eventName"));
            ObservableList<Ticket> list = UserTable.getItems();
            for (int i = 0; i < GUIApplication.ActiveUser.myTickets.size(); i++) {

                list.add(GUIApplication.ActiveUser.myTickets.get(i));

            }

            UserTable.setItems(list);
            System.out.println("Table was loaded");

        }
    }

    public void loadAssignTable() {

        if(buttonpress<1) {
            buttonpress++;
            AssignTicketID.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("TicketID"));
            AssignSeat.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("seatID"));
            AssignPrice.setCellValueFactory(new PropertyValueFactory<Ticket, Double>("price"));
            AssignSection.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("sectionID"));
            AssignEvent.setCellValueFactory(new PropertyValueFactory<Ticket, String>("eventName"));
            ObservableList<Ticket> list = AssignTable.getItems();
            for (int i = 0; i < GUIApplication.ticketSystem.getPendingTicket().size(); i++) {

                list.add(GUIApplication.ticketSystem.getPendingTicket().get(i));


            }

            AssignTable.setItems(list);
            System.out.println("Table was loaded");
        }
    }

    public void BookTicket(ActionEvent event) {

        GuiModel.ticketToProcessing(TicketBookField.getText().trim(), GUIApplication.ActiveUser.getUserID() + "");


    }
    public void BookTicketSearch(ActionEvent event){

        int selectedID = SearchTable.getSelectionModel().getSelectedIndex();
        GuiModel.ticketToProcessing(SearchTable.getItems().get(selectedID).getTicketID()+"",GUIApplication.ActiveUser.getUserID()+"");


      GUIApplication.ticketSystem.getPendingTicket().add(GUIApplication.ticketSystem.getUnassignedTicket().remove(GUIApplication.ticketSystem.getUnassignedTicket().indexOf(SearchTable.getItems().get(selectedID))));
        SearchTable.getItems().remove(selectedID);


    }



    @FXML
    protected void onCreateButtonClick(ActionEvent event) {

        if (eventNameField.getText().isEmpty()) {
            createEventErrorLabel.setText("Please enter event name");
        } else {
            GUIApplication.ActiveTechnician.createEvent(eventTypeComboBox.getValue(), eventNameField.getText());
            createEventErrorLabel.setText("Event Created Successfully");
            GuiModel.displayUnsassignedTickets();
        }

    }

    @FXML
    protected void oncEventButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateEvent.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void LoadAssign(ActionEvent event) throws IOException {
        buttonpress=0;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AssignTickets.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AssignTicket(ActionEvent event) {
        int selectedID = AssignTable.getSelectionModel().getSelectedIndex();
        GuiModel.ticketToAssigned(AssignTable.getItems().get(selectedID).getTicketID()+"");
     AssignTable.getItems().remove(selectedID);
        GUIApplication.ActiveUser.myTickets.add(GUIApplication.ticketSystem.getPendingTicket().remove(GUIApplication.ticketSystem.getPendingTicket().indexOf(AssignTable.getItems().get(selectedID))));
    }
    public void loadTechView(ActionEvent event) throws IOException {
        buttonpress=0;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TechnicianMainMenu.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void refundTicket(ActionEvent event){

        int selectedID = RefundTable.getSelectionModel().getSelectedIndex();
        GuiModel.ticketToRefund(RefundTable.getItems().get(selectedID).getTicketID()+"");


        GUIApplication.ticketSystem.getUnassignedTicket().add(GUIApplication.ActiveUser.myTickets.remove(GUIApplication.ActiveUser.myTickets.indexOf(RefundTable.getItems().get(selectedID))));
        RefundTable.getItems().remove(selectedID);



    }

    public void loadDataView(ActionEvent event) throws IOException {

        buttonpress=0;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("data.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}



