package org.example.finalproject;

import java.sql.*;


public class GuiModel {
    //Establishing a connection to Sqlite
    private static Connection connect() {
        String url = "jdbc:sqlite:FinalProject.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println(" Connection to Sqlite has been established");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    //Creation of the user Table
    private static void UserTable(){
        String sql = " create table if not exists User (\n"
                + " UserID integer primary key, \n"
                + " name text not null, \n"
                + " email text not null, \n"
                + " username text not null, \n"
                + " password text not null \n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" User table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Creation of the Technician Table
    private static void TechTable(){
        String sql = " create table if not exists Technician (\n"
                + " TechnicianID integer primary key, \n"
                + " name text not null, \n"
                + " username text not null, \n"
                + " password text not null \n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Technician table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Creation of the Ticket table
    private static void TicketTable(){
        String sql = " create table if not exists Ticket (\n"
                + "TicketID integer primary key, \n"
                + "EventID integer not null, \n"
                + "EventName Text not null, \n"
                + "UserID integer ,\n"
                + "SeatID int not null,\n"
                + "SectionID int not null,\n"
                + "Price double not null,\n"
                + "Processing Boolean not null,\n"
                + "Assigned Boolean not null,\n"
                + " foreign key (UserID) references User (UserID) on delete set null, \n"
                + " foreign key (EventID) references Event (EventID) on delete cascade \n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Ticket table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that inserts a new entry into the Ticket Table
    public static void insertTicket(Ticket ticket){
    String sql = " insert into Ticket (TicketID,EventID,UserID,SeatID,SectionID,Price,Processing,Assigned,EventName) values (?, ?, ?, ?,?,?,?, ?,?)";
    try(Connection conn= connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, ticket.getTicketID());
        pstmt.setInt(2, ticket.getEventID());
        pstmt.setInt(3, ticket.getAssignedUser() != null ? ticket.getAssignedUser().getUserID() : -1);
        pstmt.setInt(4, ticket.getSeatID());
        pstmt.setInt(5, ticket.getSectionID());
        pstmt.setDouble(6, ticket.getPrice());
        pstmt.setBoolean(7,ticket.isProcessing());
        pstmt.setBoolean(8,ticket.isAssigned());
        pstmt.setString(9,ticket.getEventName());
        pstmt.executeUpdate();
        System.out.println("Ticket has been added");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
    private static void dropTicketTable() {
        String sql = "DROP TABLE IF EXISTS Ticket;";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Ticket table dropped successfully.");
        } catch (SQLException e) {
            System.out.println("Error dropping Ticket table: " + e.getMessage());
        }
    }
    //Creation of the event Table
    private static void EventTable(){
        String sql = " create table if not exists Event ( \n"
                + " EventID integer primary key, \n"
                + " eventType text not null, \n"
                + " name text not null \n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Event table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that inserts a User
    public static void insertUser(User user) {
        String sql = " insert into User (name,email,username,password) values (?, ?, ?, ?)";
        try(Connection conn= connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.executeUpdate();
            System.out.println(user.getName()+" has been added to the database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that inserts a Technician
    public static void insertTechnician(String name, String username, String password) {
        String sql = " insert into Technician (name, username, password) values (?, ?, ?)";
        try(Connection conn= connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            System.out.println(name+" has been added to the database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that uses an ID to delete a specific user
    public static void deleteUserById(String id) {
        String sql = " DELETE FROM User WHERE UserID = "+id;
        try(Connection conn= connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(id+" has been removed to the database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that uses an ID to delete a specific technician
    public static void deleteTechnicianById(String id) {
        String sql = " DELETE FROM Technician WHERE TechnicianID = "+id;
        try(Connection conn= connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(id+" has been removed to the database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that uses an ID to deletes every User
    public static void deleteUsers() {
        String sql = "delete from User";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            System.out.println("Data deleted from User Table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that inserts an Event
    private static void insertIntoEventTable(int eventID, String eventType, String name) {
        String sql = "INSERT INTO Event(EventID, eventType, name) VALUES(?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventID);
            pstmt.setString(2, eventType);
            pstmt.setString(3, name);
            pstmt.executeUpdate();
            System.out.println("Record inserted into Event table successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that load every event
    public static void loadEvents(TicketSystem system) {
        String sql = "select * from Event";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("EventType").equalsIgnoreCase("BasketballGame")) {
                    system.addEvent(new BasketballGame(rs.getString("name"), rs.getString("eventType")));
                } else if (rs.getString("EventType").equalsIgnoreCase("Concert")) {
                    system.addEvent(new Concert(rs.getString("name"), rs.getString("eventType")));
                } else if (rs.getString("EventType").equalsIgnoreCase("HockeyGame")) {
                    system.addEvent(new HockeyGame(rs.getString("name"), rs.getString("eventType")));
                } else if (rs.getString("EventType").equalsIgnoreCase("Spectacle")) {
                    system.addEvent(new Spectacle(rs.getString("name"), rs.getString("eventType")));
                }
            }
            System.out.println("Loaded Event data to system");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that deletes a specific ticket using an Id
    public static void deleteTicketById(String id) {
        String sql = " DELETE FROM Ticket WHERE TicketID = "+id;
        try(Connection conn= connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(id+" has been removed to the database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that loads Every user into the User list
    public static void loadUsers(TicketSystem system){
        String sql = "select * from User";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                system.addUser(new User(rs.getInt("UserID"),rs.getString("name"),rs.getString("email"), rs.getString("username"),rs.getString("password")));
            }
            System.out.println("Loaded User data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that loads Every technician into the technician list
    public static void loadTechnicians(TicketSystem system){
        String sql = "select * from Technician";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                system.addTechnician(new Technician(rs.getInt("TechnicianID"),rs.getString("name"), rs.getString("username"),rs.getString("password")));
            }
            System.out.println("Loaded Technician data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that loads unassigned Tickets
    public static void loadUnsassignedTickets(TicketSystem system){
        String sql = "select * from Ticket WHERE Processing = false AND Assigned = false;";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                system.getUnassignedTicket().add(new Ticket(rs.getInt("TicketID"), rs.getInt("EventID"), rs.getInt("SectionID"),rs.getInt("SeatID"),rs.getDouble("Price"),rs.getString("EventName"), rs.getBoolean("Processing"), rs.getBoolean("Assigned")));
                System.out.println("ticket Added");
            }
            System.out.println("Loaded Technician data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that loads ProcessingTickets Tickets
    public static void loadProcessingTickets(TicketSystem system){
        String sql = "select * from Ticket WHERE Processing = true AND Assigned = false;";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                system.getPendingTicket().add(new Ticket(rs.getInt("TicketID"), rs.getInt("EventID"), rs.getInt("SectionID"),rs.getInt("SeatID"),rs.getDouble("Price"),rs.getString("EventName"), rs.getBoolean("Processing"), rs.getBoolean("Assigned")));
                System.out.println("ticket Added");
            }
            System.out.println("Loaded Technician data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that loads Assigned Tickets
    public static void loadAssignedTickets(TicketSystem system){
        String sql = "select * from Ticket WHERE Processing = false AND Assigned = true;";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                system.getProcessedTickets().add(new Ticket(rs.getInt("TicketID"), rs.getInt("EventID"), rs.getInt("SectionID"),rs.getInt("SeatID"),rs.getDouble("Price"),rs.getString("EventName"), rs.getBoolean("Processing"), rs.getBoolean("Assigned")));
                System.out.println("ticket Added");
            }
            System.out.println("Loaded Technician data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that changes a ticket Unassigned -> Processing
    public static void ticketToProcessing(String id ,String uId) {
        String sql = " UPDATE Ticket SET  Processing = true,Assigned = false,UserID = "+uId+" WHERE TicketId = "+id;
        try(Connection conn= connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(id+" is processing...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that changes a ticket Processing -> Assigned
    public static void ticketToAssigned(String id) {
        String sql = " UPDATE Ticket SET  Processing = false, Assigned = true WHERE TicketId = "+id;
        try(Connection conn= connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(id+" has been Assigned");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that changes a ticket Assigned -> Unassigned
    public static void ticketToRefund(String id) {
        String sql = " UPDATE Ticket SET  Processing = false,Assigned = false WHERE TicketId = "+id;
        try(Connection conn= connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(id+" has been removed to the database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Method that loads the ticket of a specific User
    public static void loadUserTickets(User user){
        String sql = "SELECT * FROM Ticket  WHERE Processing = false AND Assigned = true And UserID = "+ user.getUserID();
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                user.myTickets.add(new Ticket(rs.getInt("TicketID"), rs.getInt("EventID"), rs.getInt("SectionID"),rs.getInt("SeatID"),rs.getDouble("Price"),rs.getString("EventName"), rs.getBoolean("Processing"), rs.getBoolean("Assigned")));
                System.out.println("ticket Added");
            }
            System.out.println("Loaded User data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


public static void main(String[] args) {
//UserTable();
//TechTable();
//
//EventTable();
//TicketTable();
//    dropTicketTable();

// insertUser(new User("Leander Almonte", "almontel@gmail.com", "almontel","user1"));
// insertUser(new User("Luke Nwantoly", "nwantolyl@gmail.com", "nwantolyl","user2"));
//
//  insertTechnician("John Doe", "doej","technician1");
//   insertTechnician("Bruce Wayne", "wayneb","technician2");

}

}



