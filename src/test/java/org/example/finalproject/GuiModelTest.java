package org.example.finalproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuiModelTest {

    @Test
    void insertTicket() {
        Ticket t1 = new Ticket(100,2,3,4,5,"Event");
        GuiModel.insertTicket(t1);

    }

    @Test
    void insertUser() {

        User user1 = new User(10,"Luke","Email@gmail","luke","passwd");

       GuiModel.insertUser(user1);
    }

    @Test
    void insertTechnician() {
        Technician tech1 = new Technician(10,"Luke","pass","ads");
    }






    @Test
    void ticketToProcessing() {
        GuiModel.ticketToProcessing("10","10");

    }

    @Test
    void ticketToAssigned() {
        GuiModel.ticketToAssigned("10");

    }

    @Test
    void ticketToRefund() {
        GuiModel.ticketToRefund("10");

    }


    @Test
    void deleteUserById() {
        GuiModel.deleteUserById("10");
    }

    @Test
    void deleteTechnicianById() {
        GuiModel.deleteTechnicianById("10");
    }

    @Test
    void deleteTicketById() {
        GuiModel.deleteTicketById("100");
    }
}
