package org.example.finalproject;

public class Spectacle extends Event{
    public Spectacle(int totalSections, int seatsPerSection, String eventName) {
        super();
        this.setEventName(eventName);
        this.setTotalSections(totalSections);
        this.eventArena = new Arena(totalSections, seatsPerSection, this);
    }

    public Spectacle(String eventName, String eventType) {
        super();
        this.setEventName(eventName);
        this.setEventType(eventType);
    }
}
