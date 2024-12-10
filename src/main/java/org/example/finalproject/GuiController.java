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

//    @FXML
//    private Button backRefundbutton;
//
//    @FXML
//    private Button loadRefundbutton;
//
//    @FXML
//    private Button refundButton;
//
//    @FXML
//    private Label

    @FXML
    private Button searchBackButton;

    @FXML
    private Button loadSearchTicketButton;

    @FXML
    private Button bookButton;

    @FXML
    private Label searchTitle;

    @FXML
    private Button logOutButton;

    @FXML
    private Button refundTicket;

    @FXML
    private Button viewTicket;

    @FXML
    private Button searchButton;

    @FXML
    private Label projectTitleUser;

    @FXML
    private Label welcomeTextUser;

    @FXML
    private Button langButton;

    @FXML
    private Button logInButton;

    @FXML
    private Label projectTitle;

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

    @FXML
    protected void onLangButtonClick(ActionEvent actionEvent) {
        LocaleManager.loadLocale();
        if(LocaleManager.getCurrentLocale() == LocaleManager.getEnLocale()) {
            LocaleManager.setLocale(LocaleManager.getFrLocale());
            updateUI();
        }
        else{
            LocaleManager.setLocale(LocaleManager.getEnLocale());
            updateUI();
        }
    }

    private void updateUI() {
        if (logInButton != null) {
            logInButton.setText(LocaleManager.getString("logInButton"));
        }

        if (langButton != null) {
            langButton.setText(LocaleManager.getString("langButtonText"));
        }

        if (projectTitle != null) {
            projectTitle.setText(LocaleManager.getString("projectTitle"));
        }

        if (usernameTextField != null) {
            usernameTextField.setPromptText(LocaleManager.getString("usernamePlaceholder"));
        }


    }

    //Method to check  a user's log in credentials
    @FXML
    protected void onLogInButtonClick(ActionEvent event) throws IOException {

        LocaleManager.loadLocale();

        ticketSystem.displayUsers();

        if (ticketSystem.getUserByUsername(usernameTextField.getText()) != null) {
            if (ticketSystem.getUserByUsername(usernameTextField.getText()).getPassword().equals(passwordTextField.getText())) {
                root = FXMLLoader.load(getClass().getResource("UserMainMenu.fxml"), LocaleManager.getBundle());
                GUIApplication.ActiveUser = ticketSystem.getUserByUsername(usernameTextField.getText());
                GuiModel.loadUserTickets(GUIApplication.ActiveUser);
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                errorLabel.setText(LocaleManager.getString("errorPass"));
            }
        } else if (ticketSystem.getTechnicianByUsername(usernameTextField.getText()) != null) {
            if (ticketSystem.getTechnicianByUsername(usernameTextField.getText()).getPassword().equals(passwordTextField.getText())) {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TechnicianMainMenu.fxml")), LocaleManager.getBundle());
                GUIApplication.ActiveTechnician = ticketSystem.getTechnicianByUsername(usernameTextField.getText());
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                errorLabel.setText(LocaleManager.getString("errorPass"));
            }
        } else if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
            errorLabel.setText(LocaleManager.getString("errorUsernamePass"));
        } else {
            errorLabel.setText(LocaleManager.getString("errorUsername"));
        }
    }

    //Method to log out
    @FXML
    protected void onLogOutButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Log In.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onBackTechButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TechnicianMainMenu.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Method to go back to the User main Menu
    @FXML
    protected void onBackUserButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UserMainMenu.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onBookTicketButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BookTicket.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//Method to go to the View Ticket Page
    @FXML
    protected void onViewTicketsButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ViewTickets.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//Method to go to the Search Page
    @FXML
    protected void onSearchButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SearchTicket.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
//Method to go to the Refund Ticket Page
    @FXML
    protected void onRefundButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RefundTicket.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

// Mehthod to load data into the refund table
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

            refundList.addAll(GUIApplication.ActiveUser.myTickets);
            RefundTable.setItems(refundList);
            System.out.println("Table was loaded");
        }

    }

    public void loadSearchTable(ActionEvent event) {
        if (buttonpress < 1) {
            buttonpress++;
            SearchTicketID.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("TicketID"));
            SearchSeat.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("seatID"));
            SearchPrice.setCellValueFactory(new PropertyValueFactory<Ticket, Double>("price"));
            SearchSection.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("sectionID"));
            SearchEvent_Name.setCellValueFactory(new PropertyValueFactory<Ticket, String>("eventName"));
            ObservableList<Ticket> list = SearchTable.getItems();
            list.addAll(GUIApplication.ticketSystem.getUnassignedTicket());

            SearchTable.setItems(list);
            System.out.println("Table was loaded");

        }

    }


//Method to load the table of the current user
    public void loadUserTickets(ActionEvent event) {
        if(buttonpress<1) {
            buttonpress++;
            UserTicketID.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("TicketID"));
            UserSeat.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("seatID"));
            UserPrice.setCellValueFactory(new PropertyValueFactory<Ticket, Double>("price"));
            UserSection.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("sectionID"));
            UserEvent.setCellValueFactory(new PropertyValueFactory<Ticket, String>("eventName"));
            ObservableList<Ticket> list = UserTable.getItems();
            list.addAll(GUIApplication.ActiveUser.myTickets);

            UserTable.setItems(list);
            System.out.println("Table was loaded");

        }
    }
//Method that Loads data into the  Assign Table
    public void loadAssignTable() {
        if(buttonpress<1) {
            buttonpress++;
            AssignTicketID.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("TicketID"));
            AssignSeat.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("seatID"));
            AssignPrice.setCellValueFactory(new PropertyValueFactory<Ticket, Double>("price"));
            AssignSection.setCellValueFactory(new PropertyValueFactory<Ticket, Integer>("sectionID"));
            AssignEvent.setCellValueFactory(new PropertyValueFactory<Ticket, String>("eventName"));
            ObservableList<Ticket> list = AssignTable.getItems();
            list.addAll(GUIApplication.ticketSystem.getPendingTicket());
            AssignTable.setItems(list);
            System.out.println("Table was loaded");
        }
    }


    //Method that allows a user to Book a ticket
    public void BookTicketSearch(ActionEvent event){
        int selectedID = SearchTable.getSelectionModel().getSelectedIndex();
        GuiModel.ticketToProcessing(SearchTable.getItems().get(selectedID).getTicketID()+"",GUIApplication.ActiveUser.getUserID()+"");
      GUIApplication.ticketSystem.getPendingTicket().add(GUIApplication.ticketSystem.getUnassignedTicket().remove(GUIApplication.ticketSystem.getUnassignedTicket().indexOf(SearchTable.getItems().get(selectedID))));
        SearchTable.getItems().remove(selectedID);


    }


//Method that creates an Event
    @FXML
    protected void onCreateButtonClick(ActionEvent event) {
        if (eventNameField.getText().isEmpty()) {
            createEventErrorLabel.setText(LocaleManager.getString("createEventError"));
        } else {
            GUIApplication.ActiveTechnician.createEvent(eventTypeComboBox.getValue(), eventNameField.getText());
            createEventErrorLabel.setText(LocaleManager.getString("eventSuccess"));
        }

    }
    //Method that opens the event Creation Page
    @FXML
    protected void oncEventButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateEvent.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //Method that opens the Assign Ticket page
    public void LoadAssign(ActionEvent event) throws IOException {
        buttonpress=0;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AssignTickets.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Method that assigns a ticket
    public void AssignTicket(ActionEvent event) {
        int selectedID = AssignTable.getSelectionModel().getSelectedIndex();
        GuiModel.ticketToAssigned(AssignTable.getItems().get(selectedID).getTicketID()+"");
     AssignTable.getItems().remove(selectedID);
        GUIApplication.ActiveUser.myTickets.add(GUIApplication.ticketSystem.getPendingTicket().remove(GUIApplication.ticketSystem.getPendingTicket().indexOf(AssignTable.getItems().get(selectedID))));
    }
    //Method that loads the Technician Main Menu
    public void loadTechView(ActionEvent event) throws IOException {
        buttonpress=0;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TechnicianMainMenu.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //Method that allows a user to refund a table
    public void refundTicket(ActionEvent event){
        int selectedID = RefundTable.getSelectionModel().getSelectedIndex();
        GuiModel.ticketToRefund(RefundTable.getItems().get(selectedID).getTicketID()+"");
        GUIApplication.ticketSystem.getUnassignedTicket().add(GUIApplication.ActiveUser.myTickets.remove(GUIApplication.ActiveUser.myTickets.indexOf(RefundTable.getItems().get(selectedID))));
        RefundTable.getItems().remove(selectedID);



    }

    //Method that loads the Data page
    public void loadDataView(ActionEvent event) throws IOException {
        buttonpress=0;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("data.fxml")), LocaleManager.getBundle());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}



