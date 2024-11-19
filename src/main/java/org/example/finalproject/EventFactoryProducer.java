package org.example.finalproject;

public class EventFactoryProducer {
    public static EventAbstractFactory getEventFactory(String eventType) {
        if(eventType.equalsIgnoreCase("basketball")|| eventType.equalsIgnoreCase("hockey")){
            return new SportsEventFactory();
        }
        else{
            return new EventFactory();
        }
    }
}
