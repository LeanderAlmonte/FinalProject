package org.example.finalproject;

public abstract class EventAbstractFactory {
    abstract Event getEvent(String eventType, String eventName);
}
