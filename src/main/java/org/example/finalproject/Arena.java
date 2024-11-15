package org.example.finalproject;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    String name;
   private List<Section> sections = new ArrayList<>();

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
