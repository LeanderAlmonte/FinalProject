package org.example.finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



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
                + " email text \n"
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
                + " name text not null \n"
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
                + "UserID integer not null ,\n"
                + "SectionID integer not null,\n"
                + "Price double not null, "
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

public static void main(String[] args) {
//UserTable();
//TechTable();
//EventTable();
//ArenaTable();
//SectionTable();
//SeatTable();
TicketTable();
}

}



