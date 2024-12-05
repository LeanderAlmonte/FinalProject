package org.example.finalproject;

import java.sql.*;


public class GuiModel {

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

    private static void TicketTable(){
        String sql = " create table if not exists Ticket (\n"
                + "TicketID integer primary key, \n"
                + "EventID integer not null, \n"
                + "SeatID integer not null,\n"
                + "UserID integer ,\n"
                + "SectionID integer not null,\n"
                + "Price double not null,\n"
                + "Processing Boolean not null,\n"
                + "Assigned Boolean not null,\n"
                + " foreign key (UserID) references User (UserID) on delete set null, \n"
                + " foreign key (EventID) references Event (EventID) on delete cascade, \n"
                + " foreign key (SectionID) references Section (SectionID) on delete cascade, \n"
                + " foreign key (SeatID) references Seat (SeatID) on delete cascade \n);";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Ticket table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

public static void insertTicket(Ticket ticket){
    String sql = " insert into Ticket (TicketID,EventID,SeatID,SectionID,Price,Processing,Assigned) values (?, ?, ?, ?,?,?,?)";
    try(Connection conn= connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, ticket.getTicketID());
        pstmt.setInt(2, ticket.getEventID());
        pstmt.setInt(3, ticket.getSeatID());
        pstmt.setInt(4, ticket.getSectionID());
        pstmt.setDouble(5, ticket.getPrice());
        pstmt.setBoolean(6,ticket.isProcessing());
        pstmt.setBoolean(7,ticket.isAssigned());
        pstmt.executeUpdate();
        System.out.println("Ticket has been added");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }


}

    private static void EventTable(){
        String sql = " create table if not exists Event ( \n"
                + " EventID integer primary key, \n"
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

    private static void ArenaTable(){
        String sql = " create table if not exists Arena ( \n"
                + " ArenaID integer primary key, \n"
                + " name text not null \n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Arena table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void SectionTable(){
        String sql = " create table if not exists Section ( \n"
                + " SectionID integer primary key, \n"
                + " name text not null, \n"
                + " ArenaID integer not null,\n"
                + " foreign key (ArenaID) references Arena (ArenaID) on delete cascade\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Section table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void SeatTable(){
        String sql = " create table if not exists Seat ( \n"
                + " SeatID integer primary key, \n"
                + " SectionID integer not null, \n"
                + " foreign key (SectionID) references Section (SectionID) on delete cascade\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Seat table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ReceiptTable(){
        String sql = " create table if not exists Receipt ( \n"
                + " ReceiptID integer primary key, \n"
                + " SectionID integer not null, \n"
                + " SeatID integer not null, \n"
                + " UserID integer not null, \n"
                + " TechnicianID integer not null, \n"
                + " payment int not null, \n"
                + " foreign key (TechnicianID) references Technician (TechnicianID) on delete cascade, \n"
                + " foreign key (UserID) references User (UserID) on delete cascade, \n"
                + " foreign key (SectionID) references Section (SectionID) on delete cascade, \n"
                + " foreign key (SeatID) references Seat (SeatID) on delete cascade\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Receipt table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertUser(String name, String email, String username, String password) {
        String sql = " insert into User (name,email,username,password) values (?, ?, ?, ?)";
        try(Connection conn= connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            pstmt.executeUpdate();
            System.out.println(name+" has been added to the database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

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
//DELETE FROM table_name WHERE condition
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
    public static void deleteUsers() {
        String sql = "delete from User";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            System.out.println("Data deleted from User Table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displayUsers() {
        String sql = "select * from User";
        try (Connection conn =connect(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println(" User :");
            while(rs.next()) {
                System.out.println("Id : " + rs.getInt("UserID") + ", Name: " + rs.getString("name") + " " +
                        ", Email : " + rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dropReceiptTable(){
        String sql = " drop table Receipt";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            System.out.println("Receipt table dropped successfully");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dropTicketTable(){
        String sql = " drop table Ticket";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            System.out.println("Ticket table dropped successfully");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
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

    private static void dropUserTable(){
        String sql = " drop table User";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            System.out.println("User table dropped successfully");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dropTechTable(){
        String sql = " drop table Technician";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            System.out.println("Technician table dropped successfully");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadUsers(TicketSystem system){
        String sql = "select * from User";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                system.addUser(new User(rs.getString("name"),rs.getString("email"), rs.getString("username"),rs.getString("password")));
            }
            System.out.println("Loaded User data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadTechnicians(TicketSystem system){
        String sql = "select * from Technician";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                system.addTechnician(new Technician(rs.getString("name"), rs.getString("username"),rs.getString("password")));
            }
            System.out.println("Loaded Technician data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void loadUnsassignedTickets(TicketSystem system){
        String sql = "select * from Ticket WHERE Processing = false AND Assigned = false;";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                system.getUnassignedTicket().add(new Ticket(rs.getInt("TicketID"), rs.getInt("EventID"), rs.getInt("SectionID"),rs.getInt("SeatID"),rs.getDouble("Price")));
                System.out.println("ticket Added");
            }
            System.out.println("Loaded Technician data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadProcessingTickets(TicketSystem system){
        String sql = "select * from Ticket WHERE Processing = true AND Assigned = false;";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                system.getProcessedTickets().add(new Ticket(rs.getInt("TicketID"), rs.getInt("EventID"), rs.getInt("SectionID"),rs.getInt("SeatID"),rs.getDouble("Price")));
                System.out.println("ticket Added");
            }
            System.out.println("Loaded Technician data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void loadAssignedTickets(TicketSystem system){
        String sql = "select * from Ticket WHERE Processing = false AND Assigned = true;";
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                system.getProcessedTickets().add(new Ticket(rs.getInt("TicketID"), rs.getInt("EventID"), rs.getInt("SectionID"),rs.getInt("SeatID"),rs.getDouble("Price")));
                System.out.println("ticket Added");
            }
            System.out.println("Loaded Technician data to system");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displayUnsassignedTickets(){
        String sql = "SELECT * FROM Ticket  WHERE Processing = false AND Assigned = false;";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                System.out.println(rs.getInt("TicketID")+" "+ rs.getInt("EventID")+" "+rs.getInt("SectionID")+" "+rs.getInt("SeatID")+" "+rs.getDouble("Price"));

            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void displayProcessingTickets(){
        String sql = "SELECT * FROM Ticket  WHERE Processing = true AND Assigned = false;";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                System.out.println(rs.getInt("TicketID")+" "+ rs.getInt("EventID")+" "+rs.getInt("SectionID")+" "+rs.getInt("SeatID")+" "+rs.getDouble("Price"));

            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displayAssignedTickets(){
        String sql = "SELECT * FROM Ticket  WHERE Processing = false AND Assigned = true;";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                System.out.println(rs.getInt("TicketID")+" "+ rs.getInt("EventID")+" "+rs.getInt("SectionID")+" "+rs.getInt("SeatID")+" "+rs.getDouble("Price"));

            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void displayAssignedTicketsByUser(String id){
        String sql = "SELECT * FROM Ticket  WHERE Processing = false AND Assigned = true And UserID = "+ id;
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                System.out.println(rs.getInt("TicketID")+" "+ rs.getInt("EventID")+" "+rs.getInt("SectionID")+" "+rs.getInt("SeatID")+" "+rs.getDouble("Price"));

            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ticketToProcessing(String id) {
        String sql = " UPDATE Ticket SET  Processing = true WHERE TicketId = "+id;
        try(Connection conn= connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(id+" has been removed to the database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void ticketToAssigned(String id,String uId) {
        String sql = " UPDATE Ticket SET  Processing = false,Assigned = true,UserID="+uId+"WHERE TicketId = "+id;
        try(Connection conn= connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(id+" has been removed to the database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void ticketToRefund(String id) {
        String sql = " UPDATE Ticket SET  Processing = false,Assigned = false,UserID = null WHERE TicketId = "+id;
        try(Connection conn= connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(id+" has been removed to the database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


public static void main(String[] args) {
//UserTable();
//TechTable();

//    dropUserTable();
//    dropTechTable();
//EventTable();
//ArenaTable();
//SectionTable();
//SeatTable();
//TicketTable();
//ReceiptTable();

//    dropTicketTable();
//    insertUser("Leander Almonte", "almontel@gmail.com", "almontel","user1");
 // insertUser("Luke Nwantoly", "nwantolyl@gmail.com", "nwantolyl","user2");
//
//    insertTechnician("John Doe", "doej","technician1");
//    insertTechnician("Bruce Wayne", "wayneb","technician2");

//insertTicket(new Ticket(1,2,3,4,5));
//Ticket t1 =     new Ticket(2,2,3,4,5);
//t1.setAssigned(true);
//Ticket t2 =     new Ticket(3,2,3,4,5);
  //  t2.setProcessing(true);
  //  insertTicket(t1);
   // insertTicket(t2);

    displayUnsassignedTickets();
    displayAssignedTickets();
    displayProcessingTickets();
}

}



