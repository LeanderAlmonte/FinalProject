package org.example.finalproject;

public class SportsEventFactory extends EventAbstractFactory {

    @Override
    public Event getEvent(String eventType, String eventName){
        if(eventType == null){
            return null;
        }
        else if(eventType.equalsIgnoreCase("BasketballGame")){
            return new BasketballGame(5,5, eventName);
        }
        else if(eventType.equalsIgnoreCase("HockeyGame")){
            return new HockeyGame(5,7, eventName);
        }
        else{
            return null;
        }
    }

}
