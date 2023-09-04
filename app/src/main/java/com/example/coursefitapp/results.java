package com.example.coursefitapp;

import static com.example.coursefitapp.bahagianA.r;
import static com.example.coursefitapp.bahagianA.i;
import static com.example.coursefitapp.bahagianA.a;
import static com.example.coursefitapp.bahagianA.s;
import static com.example.coursefitapp.bahagianA.e;
import static com.example.coursefitapp.bahagianA.k;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class results extends AppCompatActivity {
    db db = new db();
    public static String timestamp;
    public Button backToMainMenuButton;

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

        Log.d("DATA", hashMap.toString());

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        if (email != null) {
            db.Users.child(email.toString().replace(".", "_dot_")).child("points").setValue(hashMap);
        }
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
            expandableItems.add(new ExpandableItem("Mechanical Engineering", "Bertumpu pada reka bentuk, menganalisis, dan mengekalkan sistem mekanikal dan jentera.\n\nFocuses on designing, analyzing, and maintaining mechanical systems and machinery.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" + "Below is the list of universities that offers this course:\n" + "\n" +
                    "-University of Malaya (UM)\n" +
                    "-University Science Malaysia (USM)\n" +
                    "-National University of Malaysia (UKM)\n" +
                    "-University of Malaysia Kelantan (UMK)\n" +
                    "-University of Malaysia Pahang (UMP)\n" +
                    "-University of Malaysia Perlis (UniMAP)\n" +
                    "-University of Malaysia Sabah (UMS)\n" +
                    "-University of Malaysia Sarawak (UNIMAS)\n" +
                    "-University of Malaysia Terengganu (UMT)\n" +
                    "-University of Putra Malaysia (UPM)\n" +
                    "-Technical University of Malaysia Malacca (UTeM)\n" +
                    "-University of Technology Malaysia (UTM)\n" +
                    "-MARA University of Technology (UITM)\n" +
                    "-Tun Hussein Onn University of Malaysia (UTHM)\n" +
                    "-Northern University of Malaysia (UUM)"));
            expandableItems.add(new ExpandableItem("Automotive Technology", "Merangkumi mekanik, elektronik, dan teknologi yang digunakan dalam kenderaan bermotor dan kenderaan lain.\n\nCovers the mechanics, electronics, and technology used in automobiles and other vehicles.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Perlis (UniMAP)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Tun Hussein Onn Malaysia (UTHM)"));
            expandableItems.add(new ExpandableItem("Electrical Engineering", "Menumpukan kepada reka bentuk, pembangunan, dan penyelenggaraan sistem dan peranti elektrik.\n\nConcentrates on designing, developing, and maintaining electrical systems and devices.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Perlis (UniMAP)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Tun Hussein Onn Malaysia (UTHM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Tenaga Nasional (UNITEN)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
            expandableItems.add(new ExpandableItem("Construction Management", "Mengajar perancangan projek, teknik pembinaan, dan pengurusan projek pembinaan.\n\nTeaches project planning, construction techniques, and management of construction projects.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-University of Malaya (UM)\n" +
                    "-National University of Malaysia (UKM)\n" +
                    "-University of Malaysia Kelantan (UMK)\n" +
                    "-University of Malaysia Pahang (UMP)\n" +
                    "-University of Malaysia Perlis (UniMAP)\n" +
                    "-University of Malaysia Sabah (UMS)\n" +
                    "-University of Malaysia Sarawak (UNIMAS)\n" +
                    "-University of Malaysia Terengganu (UMT)\n" +
                    "-University of Putra Malaysia (UPM)\n" +
                    "-Technical University of Malaysia Malacca (UTeM)\n" +
                    "-University of Technology Malaysia (UTM)\n" +
                    "-MARA University of Technology (UITM)\n" +
                    "-Tun Hussein Onn University of Malaysia (UTHM)"));
            expandableItems.add(new ExpandableItem("Carpentry or Woodworking", "Membangunkan kemahiran praktikal dalam membuat dan bekerja dengan kayu untuk mencipta struktur dan produk.\n\nDevelops practical skills in crafting and working with wood to create structures and products.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Advanced Technology Training Center (ADTEC)\n" +
                    "-Institut Latihan Perindustrian Kuala Lumpur (ILPKL)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Institut Latihan Perindustrian Kuantan (ILPKU)\n" +
                    "-Institut Latihan Perindustrian Jitra (ILP Jitra)"));
            expandableItems.add(new ExpandableItem("Plumbing or HVAC (Heating, Ventilation, and Air Conditioning)", "Bertumpu pada pemasangan dan penyelenggaraan sistem pemipaan dan HVAC di dalam bangunan.\n\nFocuses on installing and maintaining plumbing and HVAC systems in buildings.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Advanced Technology Training Center (ADTEC)\n" +
                    "-Institut Latihan Perindustrian Kuala Lumpur (ILPKL)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Institut Latihan Perindustrian Kuantan (ILPKU)\n" +
                    "-Institut Latihan Perindustrian Jitra (ILP Jitra)"));
            expandableItems.add(new ExpandableItem("Welding", "Menyediakan latihan praktikal dalam penyambungan logam melalui pelbagai proses penyambungan.\n\nProvides hands-on training in joining metals through various welding processes.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Advanced Technology Training Center (ADTEC)\n" +
                    "-Institut Latihan Perindustrian Kuala Lumpur (ILPKL)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Institut Latihan Perindustrian Kuantan (ILPKU)\n" +
                    "-Institut Latihan Perindustrian Jitra (ILP Jitra)"));
            expandableItems.add(new ExpandableItem("Agricultural Sciences", "Merangkumi teknik pertanian, pengurusan tanaman, dan penternakan haiwan.\n\nCovers farming techniques, crop management, and animal husbandry.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaysia Pahang (UMP)"));
            expandableItems.add(new ExpandableItem("Aviation Technology", "Bertumpu kepada mekanik kapal terbang, penyelenggaraan, dan teknologi.\n\nFocuses on aircraft mechanics, maintenance, and technology.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Kuala Lumpur (UniKL)\n" +
                    "-Malaysian Institute of Aviation Technology (MIAT)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Politeknik Nilai\n" +
                    "-Asia Pacific University (APU)\n" +
                    "-Management and Science University (MSU)"));
            expandableItems.add(new ExpandableItem("Computer Hardware and \nNetworking", "Melibatkan latihan praktikal dalam penyelenggaraan perkakasan komputer dan pentadbiran rangkaian.\n\nInvolves practical training in computer hardware maintenance and network administration.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Asia Pacific University (APU)\n" +
                    "-Management and Science University (MSU)\n" +
                    "-Multimedia University (MMU)\n" +
                    "-Universiti Kuala Lumpur (UniKL)\n" +
                    "-Malaysian Institute of Information Technology (MIIT)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Industrial Design", "Menggabungkan kreativiti dan kemahiran teknikal untuk reka bentuk produk dan objek.\n\nCombines creativity and technical skills to design products and objects.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
            expandableItems.add(new ExpandableItem("Geology or Environmental \nScience", "Mempelajari struktur fizikal Bumi, sumber semulajadi, dan proses alam sekitar.\n\nStudies Earth's physical structure, natural resources, and environmental processes.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
            expandableItems.add(new ExpandableItem("Physical Therapy/Occupational Therapy", "Bertumpu pada membantu individu pulih daripada kecederaan dan meningkatkan keupayaan fizikal mereka.\n\nFocuses on helping individuals recover from injuries and improve their physical abilities.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Sultan Zainal Abidin (UniSZA)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Sabah (UMS)"));
            expandableItems.add(new ExpandableItem("Emergency Medical Technician \n(EMT)", "Melatih anda untuk memberikan penjagaan perubatan dalam situasi kecemasan.\n\nTrains you to provide medical care in emergency situations."));
            expandableItems.add(new ExpandableItem("Landscaping or Horticulture", "Membangunkan kemahiran dalam penjagaan tumbuhan, reka bentuk landskap, dan pengurusan ruang luar.\n\nDevelops skills in plant care, landscape design, and outdoor space management.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Sains Malaysia (USM)"));
        }
        if (topNKeys.contains("i")) {
            expandableItems.add(new ExpandableItem("Science \n(Physics, Chemistry, Biology, Mathematics)", "Program ini menyediakan pemahaman asas tentang prinsip sains, teknik makmal, dan analisis data dalam salah satu disiplin sains utama.\n\nThis program provides a foundational understanding of scientific principles, laboratory techniques, and data analysis in one of the core scientific disciplines.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Perlis (UniMAP)\n" +
                    "-Universiti Tun Hussein Onn Malaysia (UTHM)"));
            expandableItems.add(new ExpandableItem("Computer Science/\nInformation Technology", "Bertumpu pada pengaturcaraan komputer, pembangunan perisian, dan penyelesaian masalah berkaitan teknologi, termasuk analisis data dan penyiasatan.\n\nFocuses on computer programming, software development, and technology-related problem-solving, including data analysis and investigation.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Perlis (UniMAP)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Teknologi MARA (UiTM)"));
            expandableItems.add(new ExpandableItem("Forensic Science", "Belajar teknik untuk mengumpul dan menganalisis bukti fizikal di tempat kejadian jenayah, membantu siasatan jenayah dan proses undang-undang.\n\nLearn techniques for collecting and analyzing physical evidence in crime scenes, aiding criminal investigations and legal proceedings.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Terengganu (UMT)"));
            expandableItems.add(new ExpandableItem("Environmental Science", "Meneroka isu alam sekitar, ekosistem, dan amalan lestari melalui penyelidikan dan analisis saintifik.\n\nExplores environmental issues, ecosystems, and sustainable practices through scientific investigation and analysis.\n\nUniversiti Malaya (UM)\n" +
                    "Universiti Sains Malaysia (USM)\n" +
                    "Universiti Kebangsaan Malaysia (UKM)\n" +
                    "Universiti Putra Malaysia (UPM)\n" +
                    "Universiti Teknologi Malaysia (UTM)\n" +
                    "Universiti Malaysia Sabah (UMS)\n" +
                    "Universiti Malaysia Terengganu (UMT)\n" +
                    "Universiti Malaysia Kelantan (UMK)\n" +
                    "Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "Universiti Malaysia Pahang (UMP)"));
            expandableItems.add(new ExpandableItem("Medical Laboratory Technology", "Melatih anda untuk menganalisis sampel perubatan, menjalankan ujian makmal, dan menyumbang kepada diagnosis perubatan.\n\nTrains you to analyze medical samples, conduct laboratory tests, and contribute to medical diagnoses.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Sabah (UMS)"));
            expandableItems.add(new ExpandableItem("Biotechnology/Pharmaceutical Science", "Mempelajari proses biologi, genetik, dan teknik penyelidikan farmaseutikal untuk menyumbang kepada kemajuan dalam penjagaan kesihatan.\n\nStudy biological processes, genetics, and pharmaceutical research techniques to contribute to advancements in healthcare.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)"));
            expandableItems.add(new ExpandableItem("Statistics/Data Science", "Membangunkan kemahiran dalam pengumpulan data, analisis, dan interpretasi, membantu pembuatan keputusan dan penyelesaian masalah di pelbagai bidang.\n\nDevelop skills in data collection, analysis, and interpretation, aiding decision-making and problem-solving across various fields.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Sabah (UMS)"));
            expandableItems.add(new ExpandableItem("Geology/Earth Science", "Meneroka sejarah, komposisi, dan proses geologi Bumi, termasuk penyiasatan mineral, batuan, dan bentuk-bentuk muka bumi.\n\nExplore Earth's history, composition, and geological processes, including investigating minerals, rocks, and landforms.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
            expandableItems.add(new ExpandableItem("Psychology", "Mempelajari tingkah laku manusia, emosi, dan proses mental, sering melibatkan penyelidikan dan analisis data psikologi.\n\nStudy human behavior, emotions, and mental processes, often involving research and analysis of psychological data.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-University of Malaya (UM)\n" +
                    "-National University of Malaysia (UKM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
            expandableItems.add(new ExpandableItem("Applied Science (Various Specializations)", "Program-program ini menyediakan kemahiran praktikal dalam penyelidikan saintifik dan mungkin merangkumi bidang seperti teknik makmal, kaedah penyelidikan, dan analisis data.\n\nThese programs offer practical skills in scientific investigation and may cover areas like laboratory techniques, research methods, and data analysis.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "University of Malaya (UM):\n" +
                    "\n" +
                    "-Applied Geology\n" +
                    "-Environmental Science\n" +
                    "-Material Science\n" +
                    "University Science Malaysia (USM):\n" +
                    "\n" +
                    "-Applied Physics\n" +
                    "-Applied Chemistry\n" +
                    "-Industrial Mathematics\n" +
                    "National University of Malaysia (UKM):\n" +
                    "\n" +
                    "-Applied Biology\n" +
                    "-Applied Chemistry\n" +
                    "-Applied Physics\n" +
                    "University of Putra Malaysia (UPM):\n" +
                    "\n" +
                    "-Food Science and Technology\n" +
                    "-Biotechnology\n" +
                    "-Environmental Science\n" +
                    "Universiti Teknologi Malaysia (UTM):\n" +
                    "\n" +
                    "-Industrial Chemistry\n" +
                    "-Industrial Biotechnology\n" +
                    "-Applied Mathematics\n" +
                    "Universiti Teknologi MARA (UiTM):\n" +
                    "\n" +
                    "-Applied Physics\n" +
                    "-Applied Chemistry\n" +
                    "-Applied Biology\n" +
                    "Universiti Sains Malaysia (USM):\n" +
                    "\n" +
                    "-Applied Mathematics\n" +
                    "-Applied Chemistry\n" +
                    "-Applied Physics\n" +
                    "Universiti Malaysia Sabah (UMS):\n" +
                    "\n" +
                    "-Applied Physics\n" +
                    "-Applied Chemistry\n" +
                    "-Food Science and Nutrition\n" +
                    "Universiti Malaysia Terengganu (UMT):\n" +
                    "\n" +
                    "-Marine Science\n" +
                    "-Environmental Management\n" +
                    "Universiti Malaysia Pahang (UMP):\n" +
                    "\n" +
                    "-Industrial Chemistry\n" +
                    "-Industrial Physics\n" +
                    "Universiti Malaysia Perlis (UniMAP):\n" +
                    "\n" +
                    "-Applied Physics\n" +
                    "-Applied Chemistry\n" +
                    "-Industrial Biotechnology\n" +
                    "Universiti Malaysia Kelantan (UMK):\n" +
                    "\n" +
                    "-Industrial Chemistry\n" +
                    "-Industrial Biotechnology"));
            expandableItems.add(new ExpandableItem("Information Security/\nCybersecurity", "Bertumpu pada penyiasatan dan perlindungan sistem digital, rangkaian, dan data daripada ancaman dan serangan siber.\n\nFocuses on investigating and protecting digital systems, networks, and data from cyber threats and attacks.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Multimedia University (MMU)\n" +
                    "-Universiti Kuala Lumpur (UniKL)\nMalaysian Institute of Information Technology (MIIT)"));
            expandableItems.add(new ExpandableItem("Business Analytics", "Belajar menganalisis data perniagaan, mengekstrak wawasan, dan membuat keputusan yang berinformasi untuk kejayaan organisasi.\n\nLearn to analyze business data, extract insights, and make informed decisions for organizational success.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
        }
        if (topNKeys.contains("a")) {
            expandableItems.add(new ExpandableItem("Fine Arts", "Bertumpu pada membangunkan kemahiran dalam pelbagai medium seni seperti lukisan, seni lukis, seni patung, dan media campuran.\n\nFocuses on developing skills in various artistic mediums such as drawing, painting, sculpture, and mixed media.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)"));
            expandableItems.add(new ExpandableItem("Graphic Design", "Merangkumi komunikasi visual, reka bentuk susun atur, ilustrasi digital, dan pemberian jenama.\n\nCovers visual communication, layout design, digital illustration, and branding.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Sabah (UMS)"));
            expandableItems.add(new ExpandableItem("Multimedia Design", "Menggabungkan pelbagai bentuk media, termasuk grafik, animasi, video, dan reka bentuk interaktif.\n\nCombines various forms of media, including graphics, animation, video, and interactive design.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Limkokwing University of Creative Technology\n" +
                    "-The One Academy\n" +
                    "-Raffles University Iskandar\n" +
                    "-SEGi University\n" +
                    "-Asia Pacific University (APU)\n" +
                    "-Taylor's University"));
            expandableItems.add(new ExpandableItem("Fashion Design", "Mengajar reka bentuk pakaian, pembuatan corak, pemilihan tekstil, dan ilustrasi fesyen.\n\nTeaches garment design, pattern-making, textile selection, and fashion illustration.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Pendidikan Sultan Idris (UPSI)"));
            expandableItems.add(new ExpandableItem("Interior Design", "Bertumpu pada reka bentuk ruang, estetika, dan mencipta ruang dalaman yang berfungsi dan menarik secara visual.\n\nFocuses on spatial design, aesthetics, and creating functional and visually appealing interior spaces."));
            expandableItems.add(new ExpandableItem("Photography", "Merangkumi teknik fotografi, penyuntingan foto, dan penceritaan visual.\n\nCovers techniques in photography, photo editing, and visual storytelling.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
            expandableItems.add(new ExpandableItem("Film and Television Production", "Melibatkan pembuatan filem, sinematografi, penyuntingan, dan pengurusan produksi.\n\nInvolves filmmaking, cinematography, editing, and production management.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
            expandableItems.add(new ExpandableItem("Animation", "Bertumpu pada teknik animasi 2D atau 3D, reka bentuk watak, dan penceritaan.\n\nFocuses on 2D or 3D animation techniques, character design, and storytelling.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Perlis (UniMAP)"));
            expandableItems.add(new ExpandableItem("Music Performance/Music Production", "Menawarkan latihan dalam alat muzik, persembahan vokal, komposisi, atau teknologi muzik.\n\nOffers training in musical instruments, vocal performance, composition, or music technology.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Pendidikan Sultan Idris (UPSI)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
            expandableItems.add(new ExpandableItem("Theatre Arts", "Merangkumi lakonan, seni persembahan di pentas, pengarah, dan aspek produksi teater.\n\nCovers acting, stagecraft, directing, and production aspects of theater.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Pendidikan Sultan Idris (UPSI)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Sabah (UMS)"));
            expandableItems.add(new ExpandableItem("Creative Writing", "Membangunkan kemahiran dalam menulis karya fiksyen, puisi, skrip filem, dan bentuk-bentuk kreatif literatur lain.\n\nDevelops skills in writing fiction, poetry, screenplays, and other forms of creative literature.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Utara Malaysia (UUM)"));
            expandableItems.add(new ExpandableItem("Visual Communication", "Meneroka pelbagai bentuk komunikasi visual, termasuk ilustrasi, tipografi, dan reka bentuk.\n\nExplores various forms of visual communication, including illustration, typography, and design.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi MARA (UiTM) - Faculty of Art and Design\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS) - Faculty of Applied and Creative Arts\n" +
                    "-Universiti Putra Malaysia (UPM) - Faculty of Modern Languages and Communication\n" +
                    "-Universiti Sains Malaysia (USM) - School of the Arts\n" +
                    "-Universiti Malaysia Kelantan (UMK) - Faculty of Creative Technology and Heritage"));
            expandableItems.add(new ExpandableItem("Animation and Visual Effects", "Bertumpu pada mencipta kesan visual untuk filem, televisyen, dan media digital.\n\nFocuses on creating visual effects for film, television, and digital media."));
            expandableItems.add(new ExpandableItem("Culinary Arts", "Menggabungkan kreativiti dan kemahiran kulinari untuk menyediakan dan mempersembahkan hidangan yang menarik secara estetik dan lazat.\n\nCombines creativity and culinary skills to prepare and present aesthetically pleasing and delicious dishes.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi MARA (UiTM) - Some campuses offer hospitality and culinary-related programs.\n" +
                    "-Politeknik Malaysia - Some polytechnics may offer programs related to hospitality, including culinary arts.\n" +
                    "-Kolej Poly-Tech MARA (KPTM) - Offers various hospitality and culinary-related programs."));
            expandableItems.add(new ExpandableItem("Art Education", "Mempersiapkan individu untuk kerjaya mengajar seni kepada pelajar dari pelbagai kumpulan umur.\n\nPrepares individuals for careers in teaching art to students of various age groups.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Pendidikan Sultan Idris (UPSI)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Sultan Haji Ahmad Shah"));
        }
        if (topNKeys.contains("s")) {
            expandableItems.add(new ExpandableItem("Psychology", "Bertumpu pada memahami tingkah laku manusia, emosi, dan proses mental.\n\nFocuses on understanding human behavior, emotions, and mental processes.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-University of Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-National University of Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
            expandableItems.add(new ExpandableItem("Social Work", "Mengajar kemahiran dalam membantu individu, keluarga, dan komuniti mengatasi cabaran dan meningkatkan kesejahteraan mereka.\n\nTeaches skills in helping individuals, families, and communities cope with challenges and improve their well-being.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Sains Islam Malaysia (USIM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)"));
            expandableItems.add(new ExpandableItem("Counseling", "Mempersiapkan individu untuk memberikan panduan dan sokongan kepada orang yang menghadapi masalah peribadi atau emosi.\n\nPrepares individuals to provide guidance and support to people dealing with personal or emotional issues.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-University of Malaya (UM)\n" +
                    "-National University of Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Pendidikan Sultan Idris (UPSI)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Sultan Idris Shah\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Sultan Mizan Zainal Abidin\n" +
                    "-Politeknik Tuanku Sultanah Bahiyah\n" +
                    "-Politeknik Kuching Sarawak\n" +
                    "-Politeknik Sultan Azlan Shah\n" +
                    "-Politeknik Kota Kinabalu\n" +
                    "-Politeknik Metro Johor Bahru\n" +
                    "-Politeknik Merlimau"));
            expandableItems.add(new ExpandableItem("Early Childhood Education", "Melibatkan kajian perkembangan kanak-kanak, kaedah pendidikan, dan bekerja dengan kanak-kanak muda.\n\nInvolves the study of child development, education methods, and working with young children.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Pendidikan Sultan Idris (UPSI)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Sultan Mizan Zainal Abidin\n" +
                    "-Politeknik Sandakan"));
            expandableItems.add(new ExpandableItem("Community Development", "Bertumpu pada memberdayakan komuniti, mengatasi isu-isu sosial, dan mempromosikan perubahan sosial.\n\nFocuses on empowering communities, addressing social issues, and promoting social change.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Pendidikan Sultan Idris (UPSI)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ungku Omar\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Sultan Azlan Shah\n" +
                    "-Politeknik Balik Pulau\n" +
                    "-Politeknik Sultan Haji Ahmad Shah"));
            expandableItems.add(new ExpandableItem("International Relations", "Meneroka politik global, diplomasi, dan kerjasama antarabangsa.\n\nExplores global politics, diplomacy, and international cooperation.Berikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-University of Malaya (UM)\n" +
                    "-National University of Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)"));
            expandableItems.add(new ExpandableItem("Political Science", "Merangkumi kajian sistem politik, struktur kerajaan, dan dasar-dasar awam.\n\nCovers the study of political systems, government structures, and public policies.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-University of Malaya (UM)\n" +
                    "-National University of Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Pahang (UMP)"));
            expandableItems.add(new ExpandableItem("Media Studies", "Mengkaji pelbagai aspek media, termasuk kewartawanan, komunikasi, dan pengeluaran media.\n\nExamines various aspects of media, including journalism, communication, and media production.\n\nUniversiti Malaya (UM)\n" +
                    "Universiti Putra Malaysia (UPM)\n" +
                    "Universiti Kebangsaan Malaysia (UKM)\n" +
                    "Universiti Sains Malaysia (USM)\n" +
                    "Universiti Teknologi MARA (UiTM)\n" +
                    "Universiti Tunku Abdul Rahman (UTAR)\n" +
                    "Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "Universiti Malaysia Kelantan (UMK)\n" +
                    "Universiti Malaysia Terengganu (UMT)\n" +
                    "Universiti Malaysia Sabah (UMS)"));
            expandableItems.add(new ExpandableItem("Public Relations", "Bertumpu pada pengurusan komunikasi antara organisasi dan orang awam.\n\nFocuses on managing communication between organizations and the public.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Perlis (UniMAP)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Tun Hussein Onn Malaysia (UTHM)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Sultan Haji Ahmad Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Tuanku Sultanah Bahiyah\n" +
                    "-Politeknik Merlimau\n" +
                    "-Politeknik Balik Pulau\n" +
                    "-Politeknik Ungku Omar\n" +
                    "-Politeknik Kota Kinabalu\n" +
                    "-Politeknik Kuching Sarawak\n" +
                    "-Politeknik Sultan Mizan Zainal Abidin"));
            expandableItems.add(new ExpandableItem("Sociology", "Mempelajari struktur masyarakat, interaksi sosial, dan dinamika budaya.\n\nStudies societal structures, social interactions, and cultural dynamics.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-University of Malaya (UM)\n" +
                    "-National University of Malaysia (UKM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)"));
            expandableItems.add(new ExpandableItem("Anthropology", "Meneroka masyarakat manusia, budaya, dan evolusinya dari semasa ke semasa.\n\nExplores human societies, cultures, and their evolution over time.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-University of Malaya (UM)\n" +
                    "-National University of Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)"));
            expandableItems.add(new ExpandableItem("Human Resource Management", "Melibatkan pengurusan dan pembangunan sumber manusia dalam organisasi.\n\nInvolves managing and developing human resources within organizations.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "Universiti Malaya (UM)\n" +
                    "Universiti Putra Malaysia (UPM)\n" +
                    "Universiti Kebangsaan Malaysia (UKM)\n" +
                    "Universiti Sains Malaysia (USM)\n" +
                    "Universiti Utara Malaysia (UUM)\n" +
                    "Universiti Teknologi MARA (UiTM)\n" +
                    "Universiti Malaysia Kelantan (UMK)\n" +
                    "Universiti Malaysia Pahang (UMP)\n" +
                    "Universiti Malaysia Sabah (UMS)\n" +
                    "Universiti Malaysia Terengganu (UMT)\n" +
                    "Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "Politeknik Malaysia\n" +
                    "Politeknik Ungku Omar\n" +
                    "Politeknik Port Dickson\n" +
                    "Politeknik Sultan Haji Ahmad Shah\n" +
                    "Politeknik Ibrahim Sultan\n" +
                    "Politeknik Merlimau\n" +
                    "Politeknik Mukah\n" +
                    "Politeknik Kota Kinabalu\n" +
                    "Politeknik Seberang Perai"));
            expandableItems.add(new ExpandableItem("International Business", "Merangkumi operasi perniagaan global, perdagangan, dan pengurusan lintas budaya.\n\nCovers global business operations, trade, and cross-cultural management.\n\nUniversiti Malaya (UM)\n" +
                    "Universiti Sains Malaysia (USM)\n" +
                    "Universiti Putra Malaysia (UPM)\n" +
                    "Universiti Teknologi Malaysia (UTM)\n" +
                    "Universiti Kebangsaan Malaysia (UKM)\n" +
                    "Universiti Utara Malaysia (UUM)\n" +
                    "Universiti Teknologi MARA (UiTM)\n" +
                    "Universiti Malaysia Sabah (UMS)"));
            expandableItems.add(new ExpandableItem("Tourism Management", "Bertumpu pada pengurusan dan promosi perkhidmatan pelancongan dan hospitaliti.\n\nFocuses on managing and promoting tourism and hospitality services.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Perlis (UniMAP)\n" +
                    "-Advanced Technology Training Center (ADTEC)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Sultan Azlan Shah\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Port Dickson\n" +
                    "-Politeknik Merlimau\n" +
                    "-Politeknik Kuching Sarawak\n" +
                    "-Politeknik Kota Kinabalu\n" +
                    "-Politeknik Ibrahim Sultan\n"));
            expandableItems.add(new ExpandableItem("Journalism", "Membangunkan kemahiran dalam melaporkan berita, bercerita, dan etika media.\n\nDevelops skills in news reporting, storytelling, and media ethics.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-University of Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-National University of Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Sabah (UMS)"));
        }
        if (topNKeys.contains("e")) {
            expandableItems.add(new ExpandableItem("Business Administration", "Merangkumi pelbagai aspek pengurusan perniagaan, termasuk pemasaran, kewangan, sumber manusia, dan keusahawanan.\n\nCovers various aspects of business management, including marketing, finance, human resources, and entrepreneurship.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-University of Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Tun Hussein Onn Malaysia (UTHM)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Kota Bharu\n" +
                    "-Politeknik Sultan Haji Ahmad Shah\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Sultan Azlan Shah\n" +
                    "-Politeknik Balik Pulau\n" +
                    "-Politeknik Merlimau\n" +
                    "-Politeknik Nilai\n" +
                    "-Politeknik Mukah"));
            expandableItems.add(new ExpandableItem("Marketing", "Bertumpu pada memahami tingkah laku pengguna, pengiklanan, pembentukan jenama, dan strategi promosi.\n\nFocuses on understanding consumer behavior, advertising, branding, and promotional strategies.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Advanced Technology Training Center (ADTEC)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Mersing\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Sultan Haji Ahmad Shah\n" +
                    "-Politeknik Nilai"));
            expandableItems.add(new ExpandableItem("Retail Management", "Mengajar kemahiran dalam pengurusan operasi runcit, pemasaran, dan perkhidmatan pelanggan.\n\nTeaches skills in managing retail operations, merchandising, and customer service.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Kota Bharu\n" +
                    "-Politeknik Kuching Sarawak\n" +
                    "-Politeknik Kota Kinabalu"));
            expandableItems.add(new ExpandableItem("Sales and Marketing", "Merangkumi teknik jualan, analisis pasaran, dan pengurusan hubungan.\n\nCovers sales techniques, market analysis, and relationship management.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Perlis (UniMAP)\n" +
                    "-Universiti Tun Hussein Onn Malaysia (UTHM)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Sultan Haji Ahmad Shah\n" +
                    "-Politeknik Merlimau\n" +
                    "-Politeknik Kota Kinabalu\n" +
                    "-Politeknik Sultan Azlan Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Port Dickson\n" +
                    "-Politeknik Nilai"));
            expandableItems.add(new ExpandableItem("Entrepreneurship", "Mempersiapkan individu untuk memulakan dan menguruskan perniagaan sendiri, menekankan pada inovasi dan pembangunan perniagaan.\n\nPrepares individuals to start and manage their own businesses, emphasizing innovation and business development.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Tun Hussein Onn Malaysia (UTHM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Kota Kinabalu\n" +
                    "-Politeknik Kuala Terengganu\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Sultan Mizan Zainal Abidin\n" +
                    "-Politeknik Tuanku Syed Sirajuddin"));
            expandableItems.add(new ExpandableItem("Finance", "Melibatkan kajian pasaran kewangan, pelaburan, perakaunan, dan perancangan kewangan.\n\nInvolves studying financial markets, investments, accounting, and financial planning.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Utara Malaysia (UUM)"));
            expandableItems.add(new ExpandableItem("International Business", "Meneroka operasi perniagaan global, perdagangan, dan pengurusan lintas budaya.\n\nExplores global business operations, trade, and cross-cultural management.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Tun Hussein Onn Malaysia (UTHM)"));
            expandableItems.add(new ExpandableItem("Hospitality Management", "Bertumpu pada pengurusan dan pengendalian perniagaan dalam industri hospitaliti dan pelancongan.\n\nFocuses on managing and operating businesses in the hospitality and tourism industry.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Ungku Omar\n" +
                    "-Politeknik Sultan Mizan Zainal Abidin\n" +
                    "-Politeknik Merlimau\n" +
                    "-Politeknik Sultan Haji Ahmad Shah\n" +
                    "-Politeknik Tuanku Sultanah Bahiyah"));
            expandableItems.add(new ExpandableItem("Event Management", "Mengajar kemahiran merancang, menganjurkan, dan mengurus acara dan persidangan.\n\nTeaches skills in planning, organizing, and managing events and conferences.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Tun Hussein Onn Malaysia (UTHM)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Sultan Idris Shah\n" +
                    "-Politeknik Sultan Haji Ahmad Shah\n" +
                    "-Politeknik Sultan Azlan Shah\n" +
                    "-Politeknik Tuanku Sultanah Bahiyah\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Sandakan\n" +
                    "-Politeknik Port Dickson"));
            expandableItems.add(new ExpandableItem("Public Relations", "Bertumpu pada pengurusan komunikasi antara organisasi dan orang awam.\n\nFocuses on managing communication between organizations and the public.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Tunku Abdul Rahman (UTAR)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Politeknik Sultan Idris Shah\n" +
                    "-Politeknik Sultan Haji Ahmad Shah\n" +
                    "-Politeknik Sultan Mizan Zainal Abidin\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Real Estate Management", "Merangkumi urus niaga hartanah, pengurusan harta tanah, dan undang-undang hartanah.\n\nCovers real estate transactions, property management, and real estate law.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Banking and Finance", "Melibatkan kajian operasi perbankan, perkhidmatan kewangan, dan pengurusan risiko.\n\nInvolves studying banking operations, financial services, and risk management.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Tun Hussein Onn Malaysia (UTHM)\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Sultan Haji Ahmad Shah\n" +
                    "-Politeknik Ungku Omar\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Kota Bharu\n" +
                    "-Politeknik Port Dickson\n" +
                    "-Politeknik Muadzam Shah"));
            expandableItems.add(new ExpandableItem("Human Resource Management", "Bertumpu pada pengurusan dan pembangunan sumber manusia dalam organisasi.\n\nFocuses on managing and developing human resources within organizations.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Politeknik Sultan Haji Ahmad Shah\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Seberang Perai\n" +
                    "-Politeknik Sultan Azlan Shah\n" +
                    "-Politeknik Tuanku Sultanah Bahiyah\n" +
                    "-Politeknik Metro Kuala Lumpur\n" +
                    "-Politeknik Merlimau\n" +
                    "-Politeknik Muadzam Shah\n" +
                    "-Politeknik Sultan Idris Shah\n" +
                    "-Politeknik Nilai"));
            expandableItems.add(new ExpandableItem("Logistics and Supply Chain Management", "Mengajar kemahiran dalam mengurus pergerakan barangan dan perkhidmatan dalam rantaian bekalan.\n\nTeaches skills in managing the movement of goods and services within supply chains.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Teknikal Malaysia Melaka (UTeM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Metro Johor Bahru\n" +
                    "-Politeknik Sultan Mizan Zainal Abidin\n" +
                    "-Politeknik Ibrahim Sultan"));
            expandableItems.add(new ExpandableItem("International Trade", "Merangkumi dasar perdagangan antarabangsa, prosedur import-eksport, dan kewangan perdagangan.\n\nCovers international trade policies, import-export procedures, and trade finance.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"));
        }
        if (topNKeys.contains("k")) {
            expandableItems.add(new ExpandableItem("Accounting", "Bertumpu pada penyimpanan rekod kewangan, audit, cukai, dan pelaporan kewangan.\n\nFocuses on financial record-keeping, auditing, taxation, and financial reporting.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Business Administration", "Merangkumi pelbagai aspek pengurusan perniagaan, termasuk fungsi pentadbiran, proses organisasi, dan pengurusan pejabat.\n\nCovers various aspects of business management, including administrative functions, organizational processes, and office management.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Pendidikan Sultan Idris (UPSI)\n" +
                    "-Universiti Malaysia Sabah (UMS)"));
            expandableItems.add(new ExpandableItem("Office Management", "Mengajar kemahiran dalam mengurus operasi pejabat, tugas pentadbiran, dan teknologi pejabat.\n\nTeaches skills in managing office operations, administrative tasks, and office technology.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Institut Latihan Perindustrian Kuala Lumpur (ILPKL)\n" +
                    "-Institut Latihan Perindustrian Kuantan (ILPKU)\n" +
                    "-Institut Latihan Perindustrian Jitra (ILP Jitra)"));
            expandableItems.add(new ExpandableItem("Secretarial Studies", "Bertumpu pada sokongan pentadbiran, prosedur pejabat, dan kemahiran komunikasi.\n\nFocuses on administrative support, office procedures, and communication skills.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Institut Latihan Perindustrian Kuala Lumpur (ILPKL)\n" +
                    "-Institut Latihan Perindustrian Kuantan (ILPKU)\n" +
                    "-Institut Latihan Perindustrian Jitra (ILP Jitra)"));
            expandableItems.add(new ExpandableItem("Library Science", "Melibatkan pengorganisasian dan pengurusan sumber maklumat dalam perpustakaan dan pusat maklumat.\n\nInvolves organizing and managing information resources in libraries and information centers.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)"));
            expandableItems.add(new ExpandableItem("Logistics and Supply Chain Management", "Mengajar kemahiran dalam mengurus pergerakan barang dan perkhidmatan dalam rantaian bekalan, termasuk kawalan inventori dan pengagihan.\n\nTeaches skills in managing the movement of goods and services within supply chains, including inventory control and distribution.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Retail Management", "Merangkumi pengurusan operasi runcit, pemasaran, dan perkhidmatan pelanggan.\n\nCovers the management of retail operations, merchandising, and customer service.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Event Management", "Bertumpu pada merancang, mengatur dan mengurus acara, mengikuti proses yang terstruktur.\n\nFocuses on planning, organizing, and managing events, following structured processes.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Hotel Management", "Melibatkan pengurusan operasi hotel, perkhidmatan tetamu, dan pentadbiran hospitaliti.\n\nInvolves managing hotel operations, guest services, and hospitality administration.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Pahang (UMP)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Medical Office Management", "Mempersiapkan individu untuk mengurus tugas pentadbiran dalam persekitaran penjagaan kesihatan, termasuk rekod perubatan dan penagihan.\n\nPrepares individuals to manage administrative tasks in healthcare settings, including medical records and billing.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Banking and Finance", "Bertumpu pada operasi perbankan, perkhidmatan kewangan, dan urus niaga mengikut protokol yang ditetapkan.\n\nFocuses on banking operations, financial services, and transactions following established protocols.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Insurance Management", "Merangkumi produk insurans, penilaian risiko, dan pemprosesan tuntutan.\n\nCovers insurance products, risk assessment, and claims processing.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)"));
            expandableItems.add(new ExpandableItem("Computerized Accounting", "Mengajar prinsip perakaunan menggunakan perisian dan teknologi moden.\n\nTeaches accounting principles using modern software and technology.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Quality Management", "Bertumpu pada mengekalkan dan meningkatkan kualiti produk dan perkhidmatan melalui prosedur yang ditetapkan.\n\nFocuses on maintaining and improving product and service quality through established procedures.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Teknologi Malaysia (UTM)\n" +
                    "-Universiti Malaysia Sarawak (UNIMAS)\n" +
                    "-Universiti Malaysia Terengganu (UMT)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Kelantan (UMK)\n" +
                    "-Politeknik Malaysia\n" +
                    "-Politeknik Sultan Salahuddin Abdul Aziz Shah\n" +
                    "-Politeknik Ibrahim Sultan\n" +
                    "-Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"));
            expandableItems.add(new ExpandableItem("Legal Studies", "Melibatkan penyelidikan undang-undang, penyediaan dokumen, dan membantu profesional undang-undang.\n\nInvolves legal research, document preparation, and assisting legal professionals.\n\nBerikut merupakan senarai universiti yang menawarkan kursus ini:\n" +
                    "Below is the list of universities that offers this course:\n" +
                    "\n" +
                    "-Universiti Malaya (UM)\n" +
                    "-Universiti Kebangsaan Malaysia (UKM)\n" +
                    "-Universiti Sains Malaysia (USM)\n" +
                    "-Universiti Putra Malaysia (UPM)\n" +
                    "-Universiti Teknologi MARA (UiTM)\n" +
                    "-Universiti Malaysia Sabah (UMS)\n" +
                    "-Universiti Utara Malaysia (UUM)\n" +
                    "-Universiti Malaysia Terengganu (UMT)"));
        }

        backToMainMenuButton = findViewById(R.id.backToMainMenuButton);
        backToMainMenuButton.setOnClickListener(v -> {
            // This method will be called when the button is clicked
            Intent intent = new Intent(results.this, MainMenu.class);
            startActivity(intent);
        });

        // Inflate and add each expandable item
        for (ExpandableItem item : expandableItems) {
            View expandableItemView = getLayoutInflater().inflate(R.layout.expandable_item_layout, null);

            TextView titleText = expandableItemView.findViewById(R.id.titleText);
            TextView descText = expandableItemView.findViewById(R.id.descText);
            ImageView arrowToggle = expandableItemView.findViewById(R.id.arrowToggle);

            titleText.setText(item.getTitle());
            descText.setText(item.getDescription());
            arrowToggle.setRotation(item.isExpanded() ? 180 : 0); // Set initial rotation

            // Set click listener to toggle visibility of description
            View.OnClickListener clickListener = v -> {
                item.setExpanded(!item.isExpanded());

                if (item.isExpanded()) {
                    descText.setVisibility(View.VISIBLE);
                } else {
                    descText.setVisibility(View.GONE);
                }

                // Rotate the arrow toggle
                float targetRotation = item.isExpanded() ? 180 : 0;
                ObjectAnimator rotation = ObjectAnimator.ofFloat(arrowToggle, "rotation", arrowToggle.getRotation(), targetRotation);
                rotation.setInterpolator(new DecelerateInterpolator());
                rotation.start();
            };

            arrowToggle.setOnClickListener(clickListener);
            titleText.setOnClickListener(clickListener);
            descText.setOnClickListener(clickListener);

            container.addView(expandableItemView);
        }
    }

    public class DateTimestampToString {
        public static void main(String[] args) {
            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Create a formatter to specify the desired date format with month name
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd", Locale.ENGLISH);

            // Format the date as a string with month name
            timestamp = formatter.format(currentDate);


        }
    }
}
