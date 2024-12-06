package org.example.finalproject;

public class HockeyGame extends Event{
    public HockeyGame(int totalSections, int seatsPerSection, String eventName) {
        super();
        this.setEventName(eventName);
        this.setTotalSections(totalSections);
        this.eventArena = new Arena(totalSections, seatsPerSection, this);
    }

    public HockeyGame(String eventName, String eventType) {
        super();
        this.setEventName(eventName);
        this.setEventType(eventType);
    }
}
