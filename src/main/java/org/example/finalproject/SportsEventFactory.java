package org.example;

public class SportsEventFactory extends EventAbstractFactory {

    @Override
    public Event getEvent(String eventType){
        if(eventType == null){
            return null;
        }
        else if(eventType.equalsIgnoreCase("basketball")){
            return new BasketballGame();
        }
        else if(eventType.equalsIgnoreCase("hockey")){
            return new HockeyGame();
        }
        else{
            return null;
        }
    }

}
