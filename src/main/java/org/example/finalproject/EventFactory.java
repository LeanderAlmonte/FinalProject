package org.example.finalproject;

public class EventFactory extends EventAbstractFactory{
//Event Creation Factory Method
    @Override
    public Event getEvent(String eventType, String eventName){
        if( eventType == null){
            return null;
        }
        else if(eventType.equalsIgnoreCase("Spectacle")){
            return new Spectacle(5,6, eventName);
        }
        else if(eventType.equalsIgnoreCase("Concert")){
            return new Concert(3,10, eventName);
        }
        else{
            return null;
        }
    }
}
