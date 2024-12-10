package org.example.finalproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketSystemTest {

    @Test
    void getUserByUsername() {
        User user1 = new User("Luke","Fakeemail@fake.com","Asuma","add");
        TicketSystem.getInstance().addUser(user1);
        assertTrue(user1.equals(TicketSystem.getInstance().getUserByUsername("Asuma")));
    }

    @Test
    void getUserByUserID() {
        User user1 = new User(1,"Luke","Fakeemail@fake.com","Asuma","add");
        TicketSystem.getInstance().addUser(user1);
        assertTrue(user1.equals(TicketSystem.getInstance().getUserByUserID(1)));
    }

    @Test
    void getTechnicianByUsername() {
        Technician tech1 = new Technician(1,"Luke","Asuma","add");
        TicketSystem.getInstance().addTechnician(tech1);
        assertTrue(tech1.equals(TicketSystem.getInstance().getTechnicianByUsername("Asuma")));
    }
}