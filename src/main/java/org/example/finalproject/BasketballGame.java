package org.example.finalproject;

public class BasketballGame extends Event{

    public BasketballGame(int totalSections, int seatsPerSection, String eventName) {
        super();
        this.setEventName(eventName);
        this.setTotalSections(totalSections);
        this.eventArena = new Arena(totalSections, seatsPerSection, this);
    }
}
