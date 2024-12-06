package org.example.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final String name = "Patterns Arena";
    private List<Section> sections;

    public Arena(int totalSections, int totalSeatsPerSection, Event event) {
        sections = new ArrayList<>();
        for (int i = 1; i <= totalSections; i++) {
            sections.add(new Section(i, totalSeatsPerSection, event));
        }
    }


    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
