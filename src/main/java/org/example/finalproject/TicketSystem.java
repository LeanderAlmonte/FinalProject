package org.example.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public  class TicketSystem {
   private static TicketSystem instance;

    private List<Ticket> unassignedTicket;
    private List<Ticket> pendingTicket ;
    private List<Ticket> processedTickets;

    private List<Event> events;

    public static void setInstance(TicketSystem instance) {
        TicketSystem.instance = instance;
    }

    public List<Technician> getTechnicians() {
        return technicians;
    }

    public void setTechnicians(List<Technician> technicians) {
        this.technicians = technicians;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    private List<User> users;
    private List<Technician> technicians;

    private TicketSystem() {
        unassignedTicket = new ArrayList<>();
        processedTickets = new ArrayList<>();
        pendingTicket = new ArrayList<>();
        events = new ArrayList<>();

        users = new ArrayList<>();
        technicians = new ArrayList<>();

        GuiModel.loadUsers(this);
        GuiModel.loadTechnicians(this);
        GuiModel.loadUnsassignedTickets(this);
        GuiModel.loadProcessingTickets(this);
        GuiModel.loadAssignedTickets(this);
        GuiModel.loadEvents(this);
    }


    public static TicketSystem getInstance() {
        if (instance == null) {
            return new TicketSystem();
        }
        return instance;
    }

    public List<Ticket> getUnassignedTicket() {
        return unassignedTicket;
    }

    public void setUnassignedTicket(List<Ticket> unassignedTicket) {
        this.unassignedTicket = unassignedTicket;
    }

    public List<Ticket> getPendingTicket() {
        return pendingTicket;
    }

    public void setPendingTicket(List<Ticket> pendingTicket) {
        this.pendingTicket = pendingTicket;
    }

    public List<Ticket> getProcessedTickets() {
        return processedTickets;
    }

    public void setProcessedTickets(List<Ticket> processedTickets) {
        this.processedTickets = processedTickets;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void addTechnician(Technician technician){
        technicians.add(technician);
    }

    public User getUserByUsername(String username){
        for (User user : users) {
            if(user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByUserID(int userID){
        for (User user : users) {
            if(user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }

    public Technician getTechnicianByUsername(String username){
        for (Technician technician : technicians) {
            if(technician.getUsername().equals(username)) {
                return technician;
            }
        }
        return null;
    }

    public void displayUsers(){
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }

    public Event getEventByEventID(int eventId){
        for (Event event: instance.events){
            if(event.getEventID() == eventId){
                return event;
            }
        }
        return null;
    }

    public void addUnassignedTicket(Ticket ticket){

        unassignedTicket.add(ticket);
    }

    public void addPendingTicket(Ticket ticket){
        pendingTicket.add(ticket);
    }

    public void addProcessedTicket(Ticket ticket){
        processedTickets.add(ticket);
    }

    public void addEvent(Event event) {
        events.add(event);
    }
}
