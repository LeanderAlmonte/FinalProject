package org.example.finalproject;

public class BasketballGame extends Event{
    // Class Specific Constructor
    public BasketballGame(int totalSections, int seatsPerSection, String eventName) {
        super();
        this.setEventName(eventName);
        this.setTotalSections(totalSections);
        this.eventType = "BasketballGame";
        this.eventArena = new Arena(totalSections, seatsPerSection, this);
    }
    //Constructor without initializing Sections
    public BasketballGame(String eventName, String eventType) {
        super();
        this.setEventName(eventName);
        this.setEventType(eventType);
    }
}
