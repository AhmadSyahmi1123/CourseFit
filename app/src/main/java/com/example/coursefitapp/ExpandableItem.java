package com.example.coursefitapp;

public class ExpandableItem {
    private String question;
    private String answer;

    public ExpandableItem(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}

