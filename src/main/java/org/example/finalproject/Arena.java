package org.example.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final String name = "Patterns Arena";
    private List<Section> sections;
    private final int totalSeatsPerSection = 100;

    public Arena(int totalSections){

        sections = new ArrayList<>();

        for(int i = 0; i < totalSections; i++){
            sections.add(new Section(totalSeatsPerSection));
        }

    }


    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
