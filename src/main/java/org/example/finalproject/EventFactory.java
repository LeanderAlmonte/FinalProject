package org.example;

public class EventFactory extends EventAbstractFactory{

    @Override
    public Event getEvent(String eventType){
        if( eventType == null){
            return null;
        }
        else if(eventType.equalsIgnoreCase("spectacle")){
            return new Spectacle();
        }
        else if(eventType.equalsIgnoreCase("concert")){
            return new Concert();
        }
        else{
            return null;
        }
    }
}
