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
        int topN = 1;
        List<String> topNKeys = new ArrayList<>();
        for (int i = 0; i < Math.min(topN, entryList.size()); i++) {
            topNKeys.add(entryList.get(i).getKey());
        }

        if (topNKeys.contains("r")) {
            expandableItems.add(new ExpandableItem("Mechanical Engineering", "Focuses on designing, analyzing, and maintaining mechanical systems and machinery."));
            expandableItems.add(new ExpandableItem("Automotive Technology", "Covers the mechanics, electronics, and technology used in automobiles and other vehicles."));
            expandableItems.add(new ExpandableItem("Electrical Engineering", "Concentrates on designing, developing, and maintaining electrical systems and devices."));
            expandableItems.add(new ExpandableItem("Construction Management", "Teaches project planning, construction techniques, and management of construction projects."));
            expandableItems.add(new ExpandableItem("Carpentry or Woodworking", "Develops practical skills in crafting and working with wood to create structures and products."));
            expandableItems.add(new ExpandableItem("Plumbing or HVAC (Heating, Ventilation, and Air Conditioning)", "Focuses on installing and maintaining plumbing and HVAC systems in buildings."));
            expandableItems.add(new ExpandableItem("Welding", "Provides hands-on training in joining metals through various welding processes."));
            expandableItems.add(new ExpandableItem("Agricultural Sciences", "Covers farming techniques, crop management, and animal husbandry."));
            expandableItems.add(new ExpandableItem("Aviation Technology", "Focuses on aircraft mechanics, maintenance, and technology."));
            expandableItems.add(new ExpandableItem("Computer Hardware and Networking", "Involves practical training in computer hardware maintenance and network administration."));
            expandableItems.add(new ExpandableItem("Industrial Design", "Combines creativity and technical skills to design products and objects."));
            expandableItems.add(new ExpandableItem("Geology or Environmental Science", "Studies Earth's physical structure, natural resources, and environmental processes."));
            expandableItems.add(new ExpandableItem("Physical Therapy or Occupational Therapy", "Focuses on helping individuals recover from injuries and improve their physical abilities."));
            expandableItems.add(new ExpandableItem("Emergency Medical Technician (EMT) or Paramedic", "Trains you to provide medical care in emergency situations."));
            expandableItems.add(new ExpandableItem("Landscaping or Horticulture", "Develops skills in plant care, landscape design, and outdoor space management."));
        }
        if (topNKeys.contains("i")) {
            expandableItems.add(new ExpandableItem("Science (Physics, Chemistry, Biology, Mathematics)", "This program provides a foundational understanding of scientific principles, laboratory techniques, and data analysis in one of the core scientific disciplines."));
            expandableItems.add(new ExpandableItem("Computer Science/Information Technology", "Focuses on computer programming, software development, and technology-related problem-solving, including data analysis and investigation."));
            expandableItems.add(new ExpandableItem("Forensic Science", "Learn techniques for collecting and analyzing physical evidence in crime scenes, aiding criminal investigations and legal proceedings."));
            expandableItems.add(new ExpandableItem("Environmental Science", "Explores environmental issues, ecosystems, and sustainable practices through scientific investigation and analysis."));
            expandableItems.add(new ExpandableItem("Medical Laboratory Technology", "Trains you to analyze medical samples, conduct laboratory tests, and contribute to medical diagnoses."));
            expandableItems.add(new ExpandableItem("Biotechnology/Pharmaceutical Science", "Study biological processes, genetics, and pharmaceutical research techniques to contribute to advancements in healthcare."));
            expandableItems.add(new ExpandableItem("Statistics/Data Science", "Develop skills in data collection, analysis, and interpretation, aiding decision-making and problem-solving across various fields."));
            expandableItems.add(new ExpandableItem("Geology/Earth Science", "Explore Earth's history, composition, and geological processes, including investigating minerals, rocks, and landforms."));
            expandableItems.add(new ExpandableItem("Psychology", "Study human behavior, emotions, and mental processes, often involving research and analysis of psychological data."));
            expandableItems.add(new ExpandableItem("Applied Science (Various Specializations)", "These programs offer practical skills in scientific investigation and may cover areas like laboratory techniques, research methods, and data analysis."));
            expandableItems.add(new ExpandableItem("Information Security/Cybersecurity", "Focuses on investigating and protecting digital systems, networks, and data from cyber threats and attacks."));
            expandableItems.add(new ExpandableItem("Business Analytics", "Learn to analyze business data, extract insights, and make informed decisions for organizational success."));
        }
        if (topNKeys.contains("a")) {
            expandableItems.add(new ExpandableItem("Fine Arts", "Focuses on developing skills in various artistic mediums such as drawing, painting, sculpture, and mixed media."));
            expandableItems.add(new ExpandableItem("Graphic Design", "Covers visual communication, layout design, digital illustration, and branding."));
            expandableItems.add(new ExpandableItem("Multimedia Design", "Combines various forms of media, including graphics, animation, video, and interactive design."));
            expandableItems.add(new ExpandableItem("Fashion Design", "Teaches garment design, pattern-making, textile selection, and fashion illustration."));
            expandableItems.add(new ExpandableItem("Interior Design", "Focuses on spatial design, aesthetics, and creating functional and visually appealing interior spaces."));
            expandableItems.add(new ExpandableItem("Photography", "Covers techniques in photography, photo editing, and visual storytelling."));
            expandableItems.add(new ExpandableItem("Film and Television Production", "Involves filmmaking, cinematography, editing, and production management."));
            expandableItems.add(new ExpandableItem("Animation", "Focuses on 2D or 3D animation techniques, character design, and storytelling."));
            expandableItems.add(new ExpandableItem("Music Performance or Music Production", "Offers training in musical instruments, vocal performance, composition, or music technology."));
            expandableItems.add(new ExpandableItem("Theatre Arts", "Covers acting, stagecraft, directing, and production aspects of theater."));
            expandableItems.add(new ExpandableItem("Creative Writing", "Develops skills in writing fiction, poetry, screenplays, and other forms of creative literature."));
            expandableItems.add(new ExpandableItem("Visual Communication", "Explores various forms of visual communication, including illustration, typography, and design."));
            expandableItems.add(new ExpandableItem("Animation and Visual Effects", "Focuses on creating visual effects for film, television, and digital media."));
            expandableItems.add(new ExpandableItem("Culinary Arts", "Combines creativity and culinary skills to prepare and present aesthetically pleasing and delicious dishes."));
            expandableItems.add(new ExpandableItem("Art Education", "Prepares individuals for careers in teaching art to students of various age groups."));
        }
        if (topNKeys.contains("s")) {
            expandableItems.add(new ExpandableItem("Psychology", "Focuses on understanding human behavior, emotions, and mental processes."));
            expandableItems.add(new ExpandableItem("Social Work", "Teaches skills in helping individuals, families, and communities cope with challenges and improve their well-being."));
            expandableItems.add(new ExpandableItem("Counseling", "Prepares individuals to provide guidance and support to people dealing with personal or emotional issues."));
            expandableItems.add(new ExpandableItem("Early Childhood Education", "Involves the study of child development, education methods, and working with young children."));
            expandableItems.add(new ExpandableItem("Community Development", "Focuses on empowering communities, addressing social issues, and promoting social change."));
            expandableItems.add(new ExpandableItem("International Relations", "Explores global politics, diplomacy, and international cooperation."));
            expandableItems.add(new ExpandableItem("Political Science", "Covers the study of political systems, government structures, and public policies."));
            expandableItems.add(new ExpandableItem("Media Studies", "Examines various aspects of media, including journalism, communication, and media production."));
            expandableItems.add(new ExpandableItem("Public Relations", "Focuses on managing communication between organizations and the public."));
            expandableItems.add(new ExpandableItem("Sociology", "Studies societal structures, social interactions, and cultural dynamics."));
            expandableItems.add(new ExpandableItem("Anthropology", "Explores human societies, cultures, and their evolution over time."));
            expandableItems.add(new ExpandableItem("Human Resource Management", "Involves managing and developing human resources within organizations."));
            expandableItems.add(new ExpandableItem("International Business", "Covers global business operations, trade, and cross-cultural management."));
            expandableItems.add(new ExpandableItem("Tourism Management", "Focuses on managing and promoting tourism and hospitality services."));
            expandableItems.add(new ExpandableItem("Journalism", "Develops skills in news reporting, storytelling, and media ethics."));
        }
        if (topNKeys.contains("e")) {
            expandableItems.add(new ExpandableItem("Business Administration", "Covers various aspects of business management, including marketing, finance, human resources, and entrepreneurship."));
            expandableItems.add(new ExpandableItem("Marketing", "Focuses on understanding consumer behavior, advertising, branding, and promotional strategies."));
            expandableItems.add(new ExpandableItem("Retail Management", "Teaches skills in managing retail operations, merchandising, and customer service."));
            expandableItems.add(new ExpandableItem("Sales and Marketing", "Covers sales techniques, market analysis, and relationship management."));
            expandableItems.add(new ExpandableItem("Entrepreneurship", "            expandableItems.add(new ExpandableItem(\"EntrepreneurshipPrepares individuals to start and manage their own businesses, emphasizing innovation and business development.\", \"\"));\n"));
            expandableItems.add(new ExpandableItem("Finance", "Involves studying financial markets, investments, accounting, and financial planning."));
            expandableItems.add(new ExpandableItem("International Business", "Explores global business operations, trade, and cross-cultural management."));
            expandableItems.add(new ExpandableItem("Hospitality Management", "Focuses on managing and operating businesses in the hospitality and tourism industry."));
            expandableItems.add(new ExpandableItem("Event Management", "Teaches skills in planning, organizing, and managing events and conferences."));
            expandableItems.add(new ExpandableItem("Public Relations", "Focuses on managing communication between organizations and the public."));
            expandableItems.add(new ExpandableItem("Real Estate Management", "Covers real estate transactions, property management, and real estate law."));
            expandableItems.add(new ExpandableItem("Banking and Finance", "Involves studying banking operations, financial services, and risk management."));
            expandableItems.add(new ExpandableItem("Human Resource Management", "Focuses on managing and developing human resources within organizations."));
            expandableItems.add(new ExpandableItem("Logistics and Supply Chain Management", "Teaches skills in managing the movement of goods and services within supply chains."));
            expandableItems.add(new ExpandableItem("International Trade", "Covers international trade policies, import-export procedures, and trade finance."));
        }
        if (topNKeys.contains("k")) {
            expandableItems.add(new ExpandableItem("Accounting", "Focuses on financial record-keeping, auditing, taxation, and financial reporting."));
            expandableItems.add(new ExpandableItem("Business Administration", "Covers various aspects of business management, including administrative functions, organizational processes, and office management."));
            expandableItems.add(new ExpandableItem("Office Management", "Teaches skills in managing office operations, administrative tasks, and office technology."));
            expandableItems.add(new ExpandableItem("Secretarial Studies", "Focuses on administrative support, office procedures, and communication skills."));
            expandableItems.add(new ExpandableItem("Library Science", "Involves organizing and managing information resources in libraries and information centers."));
            expandableItems.add(new ExpandableItem("Logistics and Supply Chain Management", "Teaches skills in managing the movement of goods and services within supply chains, including inventory control and distribution."));
            expandableItems.add(new ExpandableItem("Retail Management", "Covers the management of retail operations, merchandising, and customer service."));
            expandableItems.add(new ExpandableItem("Event Management", "Focuses on planning, organizing, and managing events, following structured processes."));
            expandableItems.add(new ExpandableItem("Hotel Management", "Involves managing hotel operations, guest services, and hospitality administration."));
            expandableItems.add(new ExpandableItem("Medical Office Management", "Prepares individuals to manage administrative tasks in healthcare settings, including medical records and billing."));
            expandableItems.add(new ExpandableItem("Banking and Finance", "Focuses on banking operations, financial services, and transactions following established protocols."));
            expandableItems.add(new ExpandableItem("Insurance Management", "Covers insurance products, risk assessment, and claims processing."));
            expandableItems.add(new ExpandableItem("Computerized Accounting", "Teaches accounting principles using modern software and technology."));
            expandableItems.add(new ExpandableItem("Quality Management", "Focuses on maintaining and improving product and service quality through established procedures."));
            expandableItems.add(new ExpandableItem("Legal Studies", "Involves legal research, document preparation, and assisting legal professionals."));
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