package org.example.finalproject;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int idCounter = 1;
    private int userID;
    private String name;
    private String email;
    private String username;
    private String password;
    List<Ticket> myTickets = new ArrayList<>();
    List<Receipt> myReceipts = new ArrayList<>();

    public User(String name, String email, String username, String password) {
        userID = idCounter;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;

        idCounter++;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ticket> getMyTickets() {
        return myTickets;
    }

    public void setMyTickets(List<Ticket> myTickets) {
        this.myTickets = myTickets;
    }

    public List<Receipt> getMyReceipts() {
        return myReceipts;
    }

    public void setMyReceipts(List<Receipt> myReceipts) {
        this.myReceipts = myReceipts;
    }
}
