package org.example.finalproject;

public class Ticket {
    private static int idCounter = 1;
    private int TicketID;
    private int eventID;
    private int sectionID;
    private int seatID;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    private double price;
    User assignedUser;
    private boolean processing;
    private boolean assigned;
    private String eventName;
    private String eventType;

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

    public Ticket(Event event, int sectionID, int seatID, double price) {
        this.TicketID = idCounter;
        this.eventID = event.getEventID();
        this.eventName = event.getEventName();
        this.eventType = event.getEventType();
        this.sectionID = sectionID;
        this.seatID = seatID;
        this.price = price;
        this.assigned = false;
        this.processing = false;
        this.assignedUser = null;
        idCounter++;
    }

    public Ticket(int ticketID, int eventID, int sectionID, int seatID, double price,String eventName, boolean assigned, boolean processing) {
        TicketID = ticketID;
        this.eventID = eventID;
        this.sectionID = sectionID;
        this.seatID = seatID;
        this.price = price;
        this.assigned = assigned;
        this.processing = processing;
        this.eventName=eventName;
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
