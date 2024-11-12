package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public  class TicketSystem {
   private static TicketSystem ticketSystem = new TicketSystem();
    private static   List<Ticket> unassignedTicket  = new ArrayList<>();
    private static  Queue<Ticket> pendingTicket = new PriorityQueue<>();
    private static  List<Ticket> processedTickets = new ArrayList<>();


    public static TicketSystem getInstance() {
        return ticketSystem;
    }

    public static List<Ticket> getUnassignedTicket() {
        return unassignedTicket;
    }

    public static void setUnassignedTicket(List<Ticket> unassignedTicket) {
        TicketSystem.unassignedTicket = unassignedTicket;
    }

    public static Queue<Ticket> getPendingTicket() {
        return pendingTicket;
    }

    public static void setPendingTicket(Queue<Ticket> pendingTicket) {
        TicketSystem.pendingTicket = pendingTicket;
    }

    public static List<Ticket> getProcessedTickets() {
        return processedTickets;
    }

    public static void setProcessedTickets(List<Ticket> processedTickets) {
        TicketSystem.processedTickets = processedTickets;
    }
}
