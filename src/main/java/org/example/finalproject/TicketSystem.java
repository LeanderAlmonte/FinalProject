package org.example.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public  class TicketSystem {
   private static TicketSystem instance;

    private List<Ticket> unassignedTicket;
    private Queue<Ticket> pendingTicket;
    private List<Ticket> processedTickets;

    private List<User> users;
    private List<Technician> technicians;

    private TicketSystem() {
        unassignedTicket = new ArrayList<>();
        pendingTicket = new PriorityQueue<>();
        processedTickets = new ArrayList<>();

        users = new ArrayList<>();
        technicians = new ArrayList<>();

        GuiModel.loadUsers(this);
        GuiModel.loadTechnicians(this);
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

    public Queue<Ticket> getPendingTicket() {
        return pendingTicket;
    }

    public void setPendingTicket(Queue<Ticket> pendingTicket) {
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
}
