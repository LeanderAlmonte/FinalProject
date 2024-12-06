package org.example.finalproject;

public class Technician {

    private static int idCounter = 1;
    private int technicianID;
    private String name;
    private String username;
    private String password;

    public Technician(String name, String username, String password) {

        this.technicianID = idCounter;
        this.name = name;
        this.username = username;
        this.password = password;

        idCounter++;
    }

    public int getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(int technicianID) {
        this.technicianID = technicianID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void createEvent(String eventType, String eventName){
        EventAbstractFactory factory = EventFactoryProducer.getEventFactory(eventType);

        Event event = factory.getEvent(eventType, eventName);


    }
}
