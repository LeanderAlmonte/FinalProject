package org.example.finalproject;

public class Seat {
    private int seatID;

    public Seat(int seatID, int sectionNumber, Event event, double price) {
        this.seatID = seatID;

        // Create a Ticket object
        Ticket ticket = new Ticket(
                event,
                sectionNumber,
                seatID,
                price
        );
        GUIApplication.ticketSystem.getUnassignedTicket().add(ticket);

        // Add the ticket to the unassigned tickets in TicketSystem
        TicketSystem.getInstance().addUnassignedTicket(ticket);
        GuiModel.insertTicket(ticket);
    }




}
