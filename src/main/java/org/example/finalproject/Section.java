package org.example.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Section {

    private int sectionNumber;
    private List<Seat> seats;

    public Section(int sectionNumber, int totalSeats, Event event) {
        this.sectionNumber = sectionNumber;
        this.seats = new ArrayList<>();

        // Determine the price based on the section number
        double price = calculatePrice(sectionNumber);

        // Create seats and tickets
        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i, sectionNumber, event, price));
        }
    }

    private double calculatePrice(int sectionNumber) {
        // Example price logic: decreasing price based on section number
        switch (sectionNumber) {
            case 1:
                return 200.0; // Section 1 has the highest price
            case 2:
                return 175.0;
            case 3:
                return 150.0;
            case 4:
                return 125.0;
            case 5:
                return 100.0;
            default:
                return 75.0; // Default price for other sections
        }
    }



}
