package org.example.finalproject;

public class Seat {
    private static int seatID;

    public static int getSeatID() {
        return seatID;
    }

    public static void setSeatID(int seatID) {
        Seat.seatID = seatID;
    }

    public Seat() {
        seatID++;
    }
}
