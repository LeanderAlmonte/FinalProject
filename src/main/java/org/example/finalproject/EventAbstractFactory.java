package org.example.finalproject;

public abstract class EventAbstractFactory {
    //abstract event creation method
    abstract Event getEvent(String eventType, String eventName);
}
