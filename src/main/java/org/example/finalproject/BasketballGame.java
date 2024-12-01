package org.example.finalproject;

public class BasketballGame extends Event{

    public BasketballGame(int totalSections, String eventName){

        eventArena = new Arena(totalSections);
        this.eventName = eventName;
        this.setEventName(eventName);
        this.setTotalSections(totalSections);

    }

    public BasketballGame() {
    }
}
