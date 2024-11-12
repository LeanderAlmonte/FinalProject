package org.example;

public class EventFactoryProducer {
    public static EventAbstractFactory getEventFactory(boolean sports) {
        if(sports){
            return new SportsEventFactory();
        }
        else{
            return new EventFactory();
        }
    }
}
