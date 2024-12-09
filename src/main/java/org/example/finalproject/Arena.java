package org.example.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Arena {

    // Name of the Arena
    private final String name = "Patterns Arena";

    //Creating a list of sections
    private List<Section> sections;


    //Arena Constructor
    public Arena(int totalSections, int totalSeatsPerSection, Event event) {
        sections = new ArrayList<>();
        for (int i = 1; i <= totalSections; i++) {
            sections.add(new Section(i, totalSeatsPerSection, event));
        }
    }

    // Getter Setter for the Section list
    public List<Section> getSections() {
        return sections;
    }
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
