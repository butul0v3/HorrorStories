package com.github.batulovandrey.horrorstories;

/**
 * @author Batulov Andrey on 19.06.17.
 */

public class Story {
    private String name;
    private String text;

    public Story(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
