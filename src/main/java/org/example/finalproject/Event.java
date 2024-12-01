package org.example.finalproject;

public abstract class Event {

    private static int idCounter = 1;

    private int eventID;

    Arena eventArena;
    protected String eventName;
    private int totalSections;

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public Arena getEventArena() {
        return eventArena;
    }

    public void setEventArena(Arena eventArena) {
        this.eventArena = eventArena;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getTotalSections() {
        return totalSections;
    }

    public void setTotalSections(int totalSections) {
        this.totalSections = totalSections;
    }
}
