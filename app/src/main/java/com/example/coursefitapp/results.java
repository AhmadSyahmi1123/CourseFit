package com.example.coursefitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        // Get the container layout
        LinearLayout container = findViewById(R.id.container);

// Sample data (you can replace this with your data)
        List<ExpandableItem> expandableItems = new ArrayList<>();
        expandableItems.add(new ExpandableItem("Engineering", "Engineering is the practice of using natural science, mathematics, and the scientific method to solve problems, increase efficiency and productivity, and improve systems. Modern engineering comprises many subfields which include designing and creating infrastructure, machinery, vehicles, electronics, materials, and energy.[1]"));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));
        expandableItems.add(new ExpandableItem("Education", "In higher education a course is a unit of teaching that typically lasts one academic term, is led by one or more instructors, and has a fixed roster of students. A course usually covers an individual subject. Courses generally have a fixed program of sessions every week during the term, called lessons or classes."));

// Add more items

// Inflate and add each expandable item
        for (ExpandableItem item : expandableItems) {
            View expandableItemView = getLayoutInflater().inflate(R.layout.results, null);

            TextView questionTextView = expandableItemView.findViewById(R.id.questionTextView);
            TextView answerTextView = expandableItemView.findViewById(R.id.answerTextView);

            questionTextView.setText(item.getQuestion());
            answerTextView.setText(item.getAnswer());

            // Set click listener to toggle visibility of answer
            questionTextView.setOnClickListener(v -> {
                if (answerTextView.getVisibility() == View.VISIBLE) {
                    answerTextView.setVisibility(View.GONE);
                } else {
                    answerTextView.setVisibility(View.VISIBLE);
                }
            });

            container.addView(expandableItemView);
        }
    }
}