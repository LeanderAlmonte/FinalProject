package org.example.finalproject;

public class SportsEventFactory extends EventAbstractFactory {

    @Override
    public Event getEvent(String eventType, String eventName){
        if(eventType == null){
            return null;
        }
        else if(eventType.equalsIgnoreCase("basketball")){
            return new BasketballGame(5,5, eventName);
        }
        else if(eventType.equalsIgnoreCase("hockey")){
            return new HockeyGame();
        }
        else{
            return null;
        }
    }

}
