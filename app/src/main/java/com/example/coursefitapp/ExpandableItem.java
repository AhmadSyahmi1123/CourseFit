package com.example.coursefitapp;

public class ExpandableItem {
    private final String title;
    private final String description;
    private boolean expanded;

    public ExpandableItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}

