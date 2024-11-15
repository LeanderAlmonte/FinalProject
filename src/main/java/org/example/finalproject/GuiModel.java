package org.example.finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class GuiModel {
    //s

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
                + " id integer primary key, \n"
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
                + " id integer primary key, \n"
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
                + " id integer primary key, \n"
                + " EventID int not null, \n"
                + "SeatID int not null,\n"
                + "UserID int ,\n"
                + "SectionID int not null,\n"
                + "Price double not null"
                + ");";
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
                + " id integer primary key, \n"
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

public static void main(String[] args) {
UserTable();
TechTable();
EventTable();
TicketTable();
}

}



