package org.example.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Section {

    private int idCounter = 1;

    private int sectionID;
    private List<Seat> seats;

    public Section(int totalSeatsPerSection){

        sectionID = idCounter;

        seats = new ArrayList<>();

        for(int i = 0; i < totalSeatsPerSection; i++){
         Seat  seat =  new Seat();
            seats.add(seat);
            GuiModel.insertTicket(new Ticket(i,1,sectionID,Seat.getSeatID(),100));


        }

        idCounter++;

    }



}
