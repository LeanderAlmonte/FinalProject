package org.example.finalproject;

import java.util.Currency;

public class Ticket {
    private int TicketID;
    private int eventID;
    private int sectionID;
    private int seatID;
    private double price;
    User assignedUser;
    private boolean processing;
    private boolean assigned;

    public boolean isProcessing() {
        return processing;
    }

    public void setProcessing(boolean processing) {
        this.processing = processing;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public Ticket(int eventID, int sectionID, int seatID, double price) {
        this.eventID = eventID;
        this.sectionID = sectionID;
        this.seatID = seatID;
        this.price = price;
        this.assigned = false;
        this.processing = false;
    }

    public Ticket(int ticketID, int eventID, int sectionID, int seatID, double price) {
        TicketID = ticketID;
        this.eventID = eventID;
        this.sectionID = sectionID;
        this.seatID = seatID;
        this.price = price;
    }

    public int getTicketID() {
        return TicketID;
    }

    public void setTicketID(int ticketID) {
        TicketID = ticketID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }
}
