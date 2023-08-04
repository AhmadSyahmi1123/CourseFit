package com.example.coursefitapp;

import static com.example.coursefitapp.bahagianA.a;
import static com.example.coursefitapp.bahagianA.e;
import static com.example.coursefitapp.bahagianA.i;
import static com.example.coursefitapp.bahagianA.k;
import static com.example.coursefitapp.bahagianA.r;
import static com.example.coursefitapp.bahagianA.s;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        // Get the container layout
        LinearLayout container = findViewById(R.id.container);

// Sample data (you can replace this with your data)
        List<ExpandableItem> expandableItems = new ArrayList<>();

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("r", r);
        hashMap.put("i", i);
        hashMap.put("a", a);
        hashMap.put("s", s);
        hashMap.put("e", e);
        hashMap.put("k", k);

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());

        // Sort the entryList based on values in descending order
        Collections.sort(entryList, (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Get the top N highest numbers
        int topN = 3;
        List<String> topNKeys = new ArrayList<>();
        for (int i = 0; i < Math.min(topN, entryList.size()); i++) {
            topNKeys.add(entryList.get(i).getKey());
        }

        if (topNKeys.contains("r")) {
            expandableItems.add(new ExpandableItem("Engineering", "Engineering is the practice of using natural science, mathematics, and the scientific method to solve problems, increase efficiency and productivity, and improve systems. Modern engineering comprises many subfields which include designing and creating infrastructure, machinery, vehicles, electronics, materials, and energy.[1]"));
        }
        if (topNKeys.contains("i")) {
            expandableItems.add(new ExpandableItem("Health and Medical Science", "broad and multidisciplinary field that focuses on understanding, promoting, and maintaining the well-being of individuals and populations. It encompasses a wide range of topics related to human health, disease prevention, diagnosis, treatment, and overall healthcare management"));
        }
        if (topNKeys.contains("a")) {
            expandableItems.add(new ExpandableItem("Art and Craft", "encompass a diverse range of creative activities that involve the use of various materials, techniques, and skills to produce visually appealing and expressive works. These activities often emphasize artistic expression, aesthetics, and the creation of objects that hold both functional and aesthetic value"));
        }
        if (topNKeys.contains("s")) {
            expandableItems.add(new ExpandableItem("Education", " encompasses a wide range of activities and practices related to teaching, learning, curriculum development, educational research, and the overall process of knowledge and skill transfer. It plays a crucial role in the development of individuals and societies by imparting knowledge, fostering critical thinking, and preparing learners for various aspects of life."));
        }
        if (topNKeys.contains("e")) {
            expandableItems.add(new ExpandableItem("Business", "encompasses a wide range of activities related to the organization, management, and operation of commercial and economic endeavors. It involves various aspects of creating, delivering, and capturing value in the form of goods and services. The business field is diverse and multifaceted, covering everything from entrepreneurship and management to marketing, finance, and more."));
        }
        if (topNKeys.contains("k")) {
            expandableItems.add(new ExpandableItem("Administrative", " involves managing and coordinating various administrative tasks and functions within an organization to ensure smooth operations and effective communication. Administrators play a critical role in supporting the overall functioning of an organization and facilitating collaboration among different departments."));
        }

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