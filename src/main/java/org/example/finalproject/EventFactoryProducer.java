package org.example.finalproject;

public class EventFactoryProducer {
    public static EventAbstractFactory getEventFactory(String eventType) {
        if(eventType.equalsIgnoreCase("BasketballGame")|| eventType.equalsIgnoreCase("HockeyGame")){
            return new SportsEventFactory();
        }
        else{
            return new EventFactory();
        }
    }
}
