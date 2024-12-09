package org.example.finalproject;

public class Concert extends Event{

    // Class Specific Constructor
    public Concert(int totalSections, int seatsPerSection, String eventName) {
        super();
        this.setEventName(eventName);
        this.setTotalSections(totalSections);
        this.eventArena = new Arena(totalSections, seatsPerSection, this);
    }
    //Constructor without initializing Sections
    public Concert(String eventName, String eventType) {
        super();
        this.setEventName(eventName);
        this.setEventType(eventType);
    }

}
