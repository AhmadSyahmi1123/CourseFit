package com.example.coursefitapp;

import static com.example.coursefitapp.bahagianA.a;
import static com.example.coursefitapp.bahagianA.e;
import static com.example.coursefitapp.bahagianA.i;
import static com.example.coursefitapp.bahagianA.k;
import static com.example.coursefitapp.bahagianA.r;
import static com.example.coursefitapp.bahagianA.s;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class results extends AppCompatActivity {
    db db = new db();
    public static String timestamp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        // Get the container layout
        LinearLayout container = findViewById(R.id.container);

        Toast.makeText(this, "R:" + r + " I:" + i + " A:" + a + " S:" + s + " E:" + e + " K:" + k, Toast.LENGTH_LONG).show();
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

        String email = Objects.requireNonNull(mAuth.getCurrentUser()).getEmail();
        if (email != null) {
            db.Users.child(mAuth.getCurrentUser().getUid()).child("points").setValue(hashMap);
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());

        // Sort the entryList based on values in descending order
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Get the top N highest numbers
        int topN = 3;
        List<String> topNKeys = new ArrayList<>();
        for (int i = 0; i < Math.min(topN, entryList.size()); i++) {
            topNKeys.add(entryList.get(i).getKey());
        }

        if (topNKeys.contains("r")) {
            expandableItems.add(new ExpandableItem("Mechanical Engineering", """
                    Bertumpu pada reka bentuk, menganalisis, dan mengekalkan sistem mekanikal dan jentera.

                    Focuses on designing, analyzing, and maintaining mechanical systems and machinery.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -University Science Malaysia (USM)
                    -National University of Malaysia (UKM)
                    -University of Malaysia Kelantan (UMK)
                    -University of Malaysia Pahang (UMP)
                    -University of Malaysia Perlis (UniMAP)
                    -University of Malaysia Sabah (UMS)
                    -University of Malaysia Sarawak (UNIMAS)
                    -University of Malaysia Terengganu (UMT)
                    -University of Putra Malaysia (UPM)
                    -Technical University of Malaysia Malacca (UTeM)
                    -University of Technology Malaysia (UTM)
                    -MARA University of Technology (UITM)
                    -Tun Hussein Onn University of Malaysia (UTHM)
                    -Northern University of Malaysia (UUM)"""));
            expandableItems.add(new ExpandableItem("Automotive Technology", """
                    Merangkumi mekanik, elektronik, dan teknologi yang digunakan dalam kenderaan bermotor dan kenderaan lain.

                    Covers the mechanics, electronics, and technology used in automobiles and other vehicles.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Perlis (UniMAP)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Tun Hussein Onn Malaysia (UTHM)"""));
            expandableItems.add(new ExpandableItem("Electrical Engineering", """
                    Menumpukan kepada reka bentuk, pembangunan, dan penyelenggaraan sistem dan peranti elektrik.

                    Concentrates on designing, developing, and maintaining electrical systems and devices.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Perlis (UniMAP)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Tun Hussein Onn Malaysia (UTHM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Tenaga Nasional (UNITEN)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
            expandableItems.add(new ExpandableItem("Construction Management", """
                    Mengajar perancangan projek, teknik pembinaan, dan pengurusan projek pembinaan.

                    Teaches project planning, construction techniques, and management of construction projects.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -National University of Malaysia (UKM)
                    -University of Malaysia Kelantan (UMK)
                    -University of Malaysia Pahang (UMP)
                    -University of Malaysia Perlis (UniMAP)
                    -University of Malaysia Sabah (UMS)
                    -University of Malaysia Sarawak (UNIMAS)
                    -University of Malaysia Terengganu (UMT)
                    -University of Putra Malaysia (UPM)
                    -Technical University of Malaysia Malacca (UTeM)
                    -University of Technology Malaysia (UTM)
                    -MARA University of Technology (UITM)
                    -Tun Hussein Onn University of Malaysia (UTHM)"""));
            expandableItems.add(new ExpandableItem("Carpentry or Woodworking", """
                    Membangunkan kemahiran praktikal dalam membuat dan bekerja dengan kayu untuk mencipta struktur dan produk.

                    Develops practical skills in crafting and working with wood to create structures and products.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Advanced Technology Training Center (ADTEC)
                    -Institut Latihan Perindustrian Kuala Lumpur (ILPKL)
                    -Politeknik Malaysia
                    -Institut Latihan Perindustrian Kuantan (ILPKU)
                    -Institut Latihan Perindustrian Jitra (ILP Jitra)"""));
            expandableItems.add(new ExpandableItem("Plumbing or HVAC (Heating, Ventilation, and Air Conditioning)", """
                    Bertumpu pada pemasangan dan penyelenggaraan sistem pemipaan dan HVAC di dalam bangunan.

                    Focuses on installing and maintaining plumbing and HVAC systems in buildings.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Advanced Technology Training Center (ADTEC)
                    -Institut Latihan Perindustrian Kuala Lumpur (ILPKL)
                    -Politeknik Malaysia
                    -Institut Latihan Perindustrian Kuantan (ILPKU)
                    -Institut Latihan Perindustrian Jitra (ILP Jitra)"""));
            expandableItems.add(new ExpandableItem("Welding", """
                    Menyediakan latihan praktikal dalam penyambungan logam melalui pelbagai proses penyambungan.

                    Provides hands-on training in joining metals through various welding processes.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Advanced Technology Training Center (ADTEC)
                    -Institut Latihan Perindustrian Kuala Lumpur (ILPKL)
                    -Politeknik Malaysia
                    -Institut Latihan Perindustrian Kuantan (ILPKU)
                    -Institut Latihan Perindustrian Jitra (ILP Jitra)"""));
            expandableItems.add(new ExpandableItem("Agricultural Sciences", """
                    Merangkumi teknik pertanian, pengurusan tanaman, dan penternakan haiwan.

                    Covers farming techniques, crop management, and animal husbandry.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaysia Pahang (UMP)"""));
            expandableItems.add(new ExpandableItem("Aviation Technology", """
                    Bertumpu kepada mekanik kapal terbang, penyelenggaraan, dan teknologi.

                    Focuses on aircraft mechanics, maintenance, and technology.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Kuala Lumpur (UniKL)
                    -Malaysian Institute of Aviation Technology (MIAT)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Politeknik Nilai
                    -Asia Pacific University (APU)
                    -Management and Science University (MSU)"""));
            expandableItems.add(new ExpandableItem("Computer Hardware and \nNetworking", """
                    Melibatkan latihan praktikal dalam penyelenggaraan perkakasan komputer dan pentadbiran rangkaian.

                    Involves practical training in computer hardware maintenance and network administration.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Asia Pacific University (APU)
                    -Management and Science University (MSU)
                    -Multimedia University (MMU)
                    -Universiti Kuala Lumpur (UniKL)
                    -Malaysian Institute of Information Technology (MIIT)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Industrial Design", """
                    Menggabungkan kreativiti dan kemahiran teknikal untuk reka bentuk produk dan objek.

                    Combines creativity and technical skills to design products and objects.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
            expandableItems.add(new ExpandableItem("Geology or Environmental \nScience", """
                    Mempelajari struktur fizikal Bumi, sumber semulajadi, dan proses alam sekitar.

                    Studies Earth's physical structure, natural resources, and environmental processes.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
            expandableItems.add(new ExpandableItem("Physical Therapy/Occupational Therapy", """
                    Bertumpu pada membantu individu pulih daripada kecederaan dan meningkatkan keupayaan fizikal mereka.

                    Focuses on helping individuals recover from injuries and improve their physical abilities.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Sultan Zainal Abidin (UniSZA)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Sabah (UMS)"""));
            expandableItems.add(new ExpandableItem("Emergency Medical Technician \n(EMT)", "Melatih anda untuk memberikan penjagaan perubatan dalam situasi kecemasan.\n\nTrains you to provide medical care in emergency situations."));
            expandableItems.add(new ExpandableItem("Landscaping or Horticulture", """
                    Membangunkan kemahiran dalam penjagaan tumbuhan, reka bentuk landskap, dan pengurusan ruang luar.

                    Develops skills in plant care, landscape design, and outdoor space management.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Sains Malaysia (USM)"""));
        }
        if (topNKeys.contains("i")) {
            expandableItems.add(new ExpandableItem("Science \n(Physics, Chemistry, Biology, Mathematics)", """
                    Program ini menyediakan pemahaman asas tentang prinsip sains, teknik makmal, dan analisis data dalam salah satu disiplin sains utama.

                    This program provides a foundational understanding of scientific principles, laboratory techniques, and data analysis in one of the core scientific disciplines.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Perlis (UniMAP)
                    -Universiti Tun Hussein Onn Malaysia (UTHM)"""));
            expandableItems.add(new ExpandableItem("Computer Science/\nInformation Technology", """
                    Bertumpu pada pengaturcaraan komputer, pembangunan perisian, dan penyelesaian masalah berkaitan teknologi, termasuk analisis data dan penyiasatan.

                    Focuses on computer programming, software development, and technology-related problem-solving, including data analysis and investigation.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Perlis (UniMAP)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Teknologi MARA (UiTM)"""));
            expandableItems.add(new ExpandableItem("Forensic Science", """
                    Belajar teknik untuk mengumpul dan menganalisis bukti fizikal di tempat kejadian jenayah, membantu siasatan jenayah dan proses undang-undang.

                    Learn techniques for collecting and analyzing physical evidence in crime scenes, aiding criminal investigations and legal proceedings.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Sains Malaysia (USM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Terengganu (UMT)"""));
            expandableItems.add(new ExpandableItem("Environmental Science", """
                    Meneroka isu alam sekitar, ekosistem, dan amalan lestari melalui penyelidikan dan analisis saintifik.

                    Explores environmental issues, ecosystems, and sustainable practices through scientific investigation and analysis.

                    Universiti Malaya (UM)
                    Universiti Sains Malaysia (USM)
                    Universiti Kebangsaan Malaysia (UKM)
                    Universiti Putra Malaysia (UPM)
                    Universiti Teknologi Malaysia (UTM)
                    Universiti Malaysia Sabah (UMS)
                    Universiti Malaysia Terengganu (UMT)
                    Universiti Malaysia Kelantan (UMK)
                    Universiti Malaysia Sarawak (UNIMAS)
                    Universiti Malaysia Pahang (UMP)"""));
            expandableItems.add(new ExpandableItem("Medical Laboratory Technology", """
                    Melatih anda untuk menganalisis sampel perubatan, menjalankan ujian makmal, dan menyumbang kepada diagnosis perubatan.

                    Trains you to analyze medical samples, conduct laboratory tests, and contribute to medical diagnoses.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Sabah (UMS)"""));
            expandableItems.add(new ExpandableItem("Biotechnology/Pharmaceutical Science", """
                    Mempelajari proses biologi, genetik, dan teknik penyelidikan farmaseutikal untuk menyumbang kepada kemajuan dalam penjagaan kesihatan.

                    Study biological processes, genetics, and pharmaceutical research techniques to contribute to advancements in healthcare.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Malaya (UM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Kelantan (UMK)"""));
            expandableItems.add(new ExpandableItem("Statistics/Data Science", """
                    Membangunkan kemahiran dalam pengumpulan data, analisis, dan interpretasi, membantu pembuatan keputusan dan penyelesaian masalah di pelbagai bidang.

                    Develop skills in data collection, analysis, and interpretation, aiding decision-making and problem-solving across various fields.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaya (UM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Sabah (UMS)"""));
            expandableItems.add(new ExpandableItem("Geology/Earth Science", """
                    Meneroka sejarah, komposisi, dan proses geologi Bumi, termasuk penyiasatan mineral, batuan, dan bentuk-bentuk muka bumi.

                    Explore Earth's history, composition, and geological processes, including investigating minerals, rocks, and landforms.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
            expandableItems.add(new ExpandableItem("Psychology", """
                    Mempelajari tingkah laku manusia, emosi, dan proses mental, sering melibatkan penyelidikan dan analisis data psikologi.

                    Study human behavior, emotions, and mental processes, often involving research and analysis of psychological data.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -National University of Malaysia (UKM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
            expandableItems.add(new ExpandableItem("Applied Science (Various Specializations)", """
                    Program-program ini menyediakan kemahiran praktikal dalam penyelidikan saintifik dan mungkin merangkumi bidang seperti teknik makmal, kaedah penyelidikan, dan analisis data.

                    These programs offer practical skills in scientific investigation and may cover areas like laboratory techniques, research methods, and data analysis.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    University of Malaya (UM):

                    -Applied Geology
                    -Environmental Science
                    -Material Science
                    University Science Malaysia (USM):

                    -Applied Physics
                    -Applied Chemistry
                    -Industrial Mathematics
                    National University of Malaysia (UKM):

                    -Applied Biology
                    -Applied Chemistry
                    -Applied Physics
                    University of Putra Malaysia (UPM):

                    -Food Science and Technology
                    -Biotechnology
                    -Environmental Science
                    Universiti Teknologi Malaysia (UTM):

                    -Industrial Chemistry
                    -Industrial Biotechnology
                    -Applied Mathematics
                    Universiti Teknologi MARA (UiTM):

                    -Applied Physics
                    -Applied Chemistry
                    -Applied Biology
                    Universiti Sains Malaysia (USM):

                    -Applied Mathematics
                    -Applied Chemistry
                    -Applied Physics
                    Universiti Malaysia Sabah (UMS):

                    -Applied Physics
                    -Applied Chemistry
                    -Food Science and Nutrition
                    Universiti Malaysia Terengganu (UMT):

                    -Marine Science
                    -Environmental Management
                    Universiti Malaysia Pahang (UMP):

                    -Industrial Chemistry
                    -Industrial Physics
                    Universiti Malaysia Perlis (UniMAP):

                    -Applied Physics
                    -Applied Chemistry
                    -Industrial Biotechnology
                    Universiti Malaysia Kelantan (UMK):

                    -Industrial Chemistry
                    -Industrial Biotechnology"""));
            expandableItems.add(new ExpandableItem("Information Security/\nCybersecurity", """
                    Bertumpu pada penyiasatan dan perlindungan sistem digital, rangkaian, dan data daripada ancaman dan serangan siber.

                    Focuses on investigating and protecting digital systems, networks, and data from cyber threats and attacks.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Teknologi MARA (UiTM)
                    -Multimedia University (MMU)
                    -Universiti Kuala Lumpur (UniKL)
                    Malaysian Institute of Information Technology (MIIT)"""));
            expandableItems.add(new ExpandableItem("Business Analytics", """
                    Belajar menganalisis data perniagaan, mengekstrak wawasan, dan membuat keputusan yang berinformasi untuk kejayaan organisasi.

                    Learn to analyze business data, extract insights, and make informed decisions for organizational success.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaya (UM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
        }
        if (topNKeys.contains("a")) {
            expandableItems.add(new ExpandableItem("Fine Arts", """
                    Bertumpu pada membangunkan kemahiran dalam pelbagai medium seni seperti lukisan, seni lukis, seni patung, dan media campuran.

                    Focuses on developing skills in various artistic mediums such as drawing, painting, sculpture, and mixed media.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Kelantan (UMK)"""));
            expandableItems.add(new ExpandableItem("Graphic Design", """
                    Merangkumi komunikasi visual, reka bentuk susun atur, ilustrasi digital, dan pemberian jenama.

                    Covers visual communication, layout design, digital illustration, and branding.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Sabah (UMS)"""));
            expandableItems.add(new ExpandableItem("Multimedia Design", """
                    Menggabungkan pelbagai bentuk media, termasuk grafik, animasi, video, dan reka bentuk interaktif.

                    Combines various forms of media, including graphics, animation, video, and interactive design.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Limkokwing University of Creative Technology
                    -The One Academy
                    -Raffles University Iskandar
                    -SEGi University
                    -Asia Pacific University (APU)
                    -Taylor's University"""));
            expandableItems.add(new ExpandableItem("Fashion Design", """
                    Mengajar reka bentuk pakaian, pembuatan corak, pemilihan tekstil, dan ilustrasi fesyen.

                    Teaches garment design, pattern-making, textile selection, and fashion illustration.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Pendidikan Sultan Idris (UPSI)"""));
            expandableItems.add(new ExpandableItem("Interior Design", "Bertumpu pada reka bentuk ruang, estetika, dan mencipta ruang dalaman yang berfungsi dan menarik secara visual.\n\nFocuses on spatial design, aesthetics, and creating functional and visually appealing interior spaces."));
            expandableItems.add(new ExpandableItem("Photography", """
                    Merangkumi teknik fotografi, penyuntingan foto, dan penceritaan visual.

                    Covers techniques in photography, photo editing, and visual storytelling.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
            expandableItems.add(new ExpandableItem("Film and Television Production", """
                    Melibatkan pembuatan filem, sinematografi, penyuntingan, dan pengurusan produksi.

                    Involves filmmaking, cinematography, editing, and production management.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
            expandableItems.add(new ExpandableItem("Animation", """
                    Bertumpu pada teknik animasi 2D atau 3D, reka bentuk watak, dan penceritaan.

                    Focuses on 2D or 3D animation techniques, character design, and storytelling.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Perlis (UniMAP)"""));
            expandableItems.add(new ExpandableItem("Music Performance/Music Production", """
                    Menawarkan latihan dalam alat muzik, persembahan vokal, komposisi, atau teknologi muzik.

                    Offers training in musical instruments, vocal performance, composition, or music technology.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Pendidikan Sultan Idris (UPSI)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
            expandableItems.add(new ExpandableItem("Theatre Arts", """
                    Merangkumi lakonan, seni persembahan di pentas, pengarah, dan aspek produksi teater.

                    Covers acting, stagecraft, directing, and production aspects of theater.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Pendidikan Sultan Idris (UPSI)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Sabah (UMS)"""));
            expandableItems.add(new ExpandableItem("Creative Writing", """
                    Membangunkan kemahiran dalam menulis karya fiksyen, puisi, skrip filem, dan bentuk-bentuk kreatif literatur lain.

                    Develops skills in writing fiction, poetry, screenplays, and other forms of creative literature.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Utara Malaysia (UUM)"""));
            expandableItems.add(new ExpandableItem("Visual Communication", """
                    Meneroka pelbagai bentuk komunikasi visual, termasuk ilustrasi, tipografi, dan reka bentuk.

                    Explores various forms of visual communication, including illustration, typography, and design.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi MARA (UiTM) - Faculty of Art and Design
                    -Universiti Malaysia Sarawak (UNIMAS) - Faculty of Applied and Creative Arts
                    -Universiti Putra Malaysia (UPM) - Faculty of Modern Languages and Communication
                    -Universiti Sains Malaysia (USM) - School of the Arts
                    -Universiti Malaysia Kelantan (UMK) - Faculty of Creative Technology and Heritage"""));
            expandableItems.add(new ExpandableItem("Animation and Visual Effects", "Bertumpu pada mencipta kesan visual untuk filem, televisyen, dan media digital.\n\nFocuses on creating visual effects for film, television, and digital media."));
            expandableItems.add(new ExpandableItem("Culinary Arts", """
                    Menggabungkan kreativiti dan kemahiran kulinari untuk menyediakan dan mempersembahkan hidangan yang menarik secara estetik dan lazat.

                    Combines creativity and culinary skills to prepare and present aesthetically pleasing and delicious dishes.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi MARA (UiTM) - Some campuses offer hospitality and culinary-related programs.
                    -Politeknik Malaysia - Some polytechnics may offer programs related to hospitality, including culinary arts.
                    -Kolej Poly-Tech MARA (KPTM) - Offers various hospitality and culinary-related programs."""));
            expandableItems.add(new ExpandableItem("Art Education", """
                    Mempersiapkan individu untuk kerjaya mengajar seni kepada pelajar dari pelbagai kumpulan umur.

                    Prepares individuals for careers in teaching art to students of various age groups.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Pendidikan Sultan Idris (UPSI)
                    -Universiti Teknologi MARA (UiTM)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Seberang Perai
                    -Politeknik Sultan Haji Ahmad Shah"""));
        }
        if (topNKeys.contains("s")) {
            expandableItems.add(new ExpandableItem("Psychology", """
                    Bertumpu pada memahami tingkah laku manusia, emosi, dan proses mental.

                    Focuses on understanding human behavior, emotions, and mental processes.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -National University of Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
            expandableItems.add(new ExpandableItem("Social Work", """
                    Mengajar kemahiran dalam membantu individu, keluarga, dan komuniti mengatasi cabaran dan meningkatkan kesejahteraan mereka.

                    Teaches skills in helping individuals, families, and communities cope with challenges and improve their well-being.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Sains Islam Malaysia (USIM)
                    -Universiti Malaysia Kelantan (UMK)"""));
            expandableItems.add(new ExpandableItem("Counseling", """
                    Mempersiapkan individu untuk memberikan panduan dan sokongan kepada orang yang menghadapi masalah peribadi atau emosi.

                    Prepares individuals to provide guidance and support to people dealing with personal or emotional issues.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -National University of Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Pendidikan Sultan Idris (UPSI)
                    -Universiti Malaysia Terengganu (UMT)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Sultan Idris Shah
                    -Politeknik Seberang Perai
                    -Politeknik Sultan Mizan Zainal Abidin
                    -Politeknik Tuanku Sultanah Bahiyah
                    -Politeknik Kuching Sarawak
                    -Politeknik Sultan Azlan Shah
                    -Politeknik Kota Kinabalu
                    -Politeknik Metro Johor Bahru
                    -Politeknik Merlimau"""));
            expandableItems.add(new ExpandableItem("Early Childhood Education", """
                    Melibatkan kajian perkembangan kanak-kanak, kaedah pendidikan, dan bekerja dengan kanak-kanak muda.

                    Involves the study of child development, education methods, and working with young children.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Pendidikan Sultan Idris (UPSI)
                    -Politeknik Malaysia
                    -Politeknik Ibrahim Sultan
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Sultan Mizan Zainal Abidin
                    -Politeknik Sandakan"""));
            expandableItems.add(new ExpandableItem("Community Development", """
                    Bertumpu pada memberdayakan komuniti, mengatasi isu-isu sosial, dan mempromosikan perubahan sosial.

                    Focuses on empowering communities, addressing social issues, and promoting social change.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Pendidikan Sultan Idris (UPSI)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ungku Omar
                    -Politeknik Ibrahim Sultan
                    -Politeknik Seberang Perai
                    -Politeknik Sultan Azlan Shah
                    -Politeknik Balik Pulau
                    -Politeknik Sultan Haji Ahmad Shah"""));
            expandableItems.add(new ExpandableItem("International Relations", """
                    Meneroka politik global, diplomasi, dan kerjasama antarabangsa.

                    Explores global politics, diplomacy, and international cooperation.Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -National University of Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)"""));
            expandableItems.add(new ExpandableItem("Political Science", """
                    Merangkumi kajian sistem politik, struktur kerajaan, dan dasar-dasar awam.

                    Covers the study of political systems, government structures, and public policies.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -National University of Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Pahang (UMP)"""));
            expandableItems.add(new ExpandableItem("Media Studies", """
                    Mengkaji pelbagai aspek media, termasuk kewartawanan, komunikasi, dan pengeluaran media.

                    Examines various aspects of media, including journalism, communication, and media production.

                    Universiti Malaya (UM)
                    Universiti Putra Malaysia (UPM)
                    Universiti Kebangsaan Malaysia (UKM)
                    Universiti Sains Malaysia (USM)
                    Universiti Teknologi MARA (UiTM)
                    Universiti Tunku Abdul Rahman (UTAR)
                    Universiti Malaysia Sarawak (UNIMAS)
                    Universiti Malaysia Kelantan (UMK)
                    Universiti Malaysia Terengganu (UMT)
                    Universiti Malaysia Sabah (UMS)"""));
            expandableItems.add(new ExpandableItem("Public Relations", """
                    Bertumpu pada pengurusan komunikasi antara organisasi dan orang awam.

                    Focuses on managing communication between organizations and the public.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Perlis (UniMAP)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Tun Hussein Onn Malaysia (UTHM)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Seberang Perai
                    -Politeknik Sultan Haji Ahmad Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Tuanku Sultanah Bahiyah
                    -Politeknik Merlimau
                    -Politeknik Balik Pulau
                    -Politeknik Ungku Omar
                    -Politeknik Kota Kinabalu
                    -Politeknik Kuching Sarawak
                    -Politeknik Sultan Mizan Zainal Abidin"""));
            expandableItems.add(new ExpandableItem("Sociology", """
                    Mempelajari struktur masyarakat, interaksi sosial, dan dinamika budaya.

                    Studies societal structures, social interactions, and cultural dynamics.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -National University of Malaysia (UKM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)"""));
            expandableItems.add(new ExpandableItem("Anthropology", """
                    Meneroka masyarakat manusia, budaya, dan evolusinya dari semasa ke semasa.

                    Explores human societies, cultures, and their evolution over time.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -National University of Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)"""));
            expandableItems.add(new ExpandableItem("Human Resource Management", """
                    Melibatkan pengurusan dan pembangunan sumber manusia dalam organisasi.

                    Involves managing and developing human resources within organizations.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    Universiti Malaya (UM)
                    Universiti Putra Malaysia (UPM)
                    Universiti Kebangsaan Malaysia (UKM)
                    Universiti Sains Malaysia (USM)
                    Universiti Utara Malaysia (UUM)
                    Universiti Teknologi MARA (UiTM)
                    Universiti Malaysia Kelantan (UMK)
                    Universiti Malaysia Pahang (UMP)
                    Universiti Malaysia Sabah (UMS)
                    Universiti Malaysia Terengganu (UMT)
                    Politeknik Sultan Salahuddin Abdul Aziz Shah
                    Politeknik Malaysia
                    Politeknik Ungku Omar
                    Politeknik Port Dickson
                    Politeknik Sultan Haji Ahmad Shah
                    Politeknik Ibrahim Sultan
                    Politeknik Merlimau
                    Politeknik Mukah
                    Politeknik Kota Kinabalu
                    Politeknik Seberang Perai"""));
            expandableItems.add(new ExpandableItem("International Business", """
                    Merangkumi operasi perniagaan global, perdagangan, dan pengurusan lintas budaya.

                    Covers global business operations, trade, and cross-cultural management.

                    Universiti Malaya (UM)
                    Universiti Sains Malaysia (USM)
                    Universiti Putra Malaysia (UPM)
                    Universiti Teknologi Malaysia (UTM)
                    Universiti Kebangsaan Malaysia (UKM)
                    Universiti Utara Malaysia (UUM)
                    Universiti Teknologi MARA (UiTM)
                    Universiti Malaysia Sabah (UMS)"""));
            expandableItems.add(new ExpandableItem("Tourism Management", """
                    Bertumpu pada pengurusan dan promosi perkhidmatan pelancongan dan hospitaliti.

                    Focuses on managing and promoting tourism and hospitality services.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Perlis (UniMAP)
                    -Advanced Technology Training Center (ADTEC)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Sultan Azlan Shah
                    -Politeknik Seberang Perai
                    -Politeknik Port Dickson
                    -Politeknik Merlimau
                    -Politeknik Kuching Sarawak
                    -Politeknik Kota Kinabalu
                    -Politeknik Ibrahim Sultan
                    """));
            expandableItems.add(new ExpandableItem("Journalism", """
                    Membangunkan kemahiran dalam melaporkan berita, bercerita, dan etika media.

                    Develops skills in news reporting, storytelling, and media ethics.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -National University of Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Sabah (UMS)"""));
        }
        if (topNKeys.contains("e")) {
            expandableItems.add(new ExpandableItem("Business Administration", """
                    Merangkumi pelbagai aspek pengurusan perniagaan, termasuk pemasaran, kewangan, sumber manusia, dan keusahawanan.

                    Covers various aspects of business management, including marketing, finance, human resources, and entrepreneurship.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -University of Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Tun Hussein Onn Malaysia (UTHM)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Kota Bharu
                    -Politeknik Sultan Haji Ahmad Shah
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Sultan Azlan Shah
                    -Politeknik Balik Pulau
                    -Politeknik Merlimau
                    -Politeknik Nilai
                    -Politeknik Mukah"""));
            expandableItems.add(new ExpandableItem("Marketing", """
                    Bertumpu pada memahami tingkah laku pengguna, pengiklanan, pembentukan jenama, dan strategi promosi.

                    Focuses on understanding consumer behavior, advertising, branding, and promotional strategies.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Advanced Technology Training Center (ADTEC)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Mersing
                    -Politeknik Seberang Perai
                    -Politeknik Sultan Haji Ahmad Shah
                    -Politeknik Nilai"""));
            expandableItems.add(new ExpandableItem("Retail Management", """
                    Mengajar kemahiran dalam pengurusan operasi runcit, pemasaran, dan perkhidmatan pelanggan.

                    Teaches skills in managing retail operations, merchandising, and customer service.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Terengganu (UMT)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Seberang Perai
                    -Politeknik Kota Bharu
                    -Politeknik Kuching Sarawak
                    -Politeknik Kota Kinabalu"""));
            expandableItems.add(new ExpandableItem("Sales and Marketing", """
                    Merangkumi teknik jualan, analisis pasaran, dan pengurusan hubungan.

                    Covers sales techniques, market analysis, and relationship management.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Perlis (UniMAP)
                    -Universiti Tun Hussein Onn Malaysia (UTHM)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Seberang Perai
                    -Politeknik Sultan Haji Ahmad Shah
                    -Politeknik Merlimau
                    -Politeknik Kota Kinabalu
                    -Politeknik Sultan Azlan Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Port Dickson
                    -Politeknik Nilai"""));
            expandableItems.add(new ExpandableItem("Entrepreneurship", """
                    Mempersiapkan individu untuk memulakan dan menguruskan perniagaan sendiri, menekankan pada inovasi dan pembangunan perniagaan.

                    Prepares individuals to start and manage their own businesses, emphasizing innovation and business development.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Tun Hussein Onn Malaysia (UTHM)
                    -Universiti Teknologi MARA (UiTM)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Kota Kinabalu
                    -Politeknik Kuala Terengganu
                    -Politeknik Ibrahim Sultan
                    -Politeknik Sultan Mizan Zainal Abidin
                    -Politeknik Tuanku Syed Sirajuddin"""));
            expandableItems.add(new ExpandableItem("Finance", """
                    Melibatkan kajian pasaran kewangan, pelaburan, perakaunan, dan perancangan kewangan.

                    Involves studying financial markets, investments, accounting, and financial planning.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Utara Malaysia (UUM)"""));
            expandableItems.add(new ExpandableItem("International Business", """
                    Meneroka operasi perniagaan global, perdagangan, dan pengurusan lintas budaya.

                    Explores global business operations, trade, and cross-cultural management.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Tun Hussein Onn Malaysia (UTHM)"""));
            expandableItems.add(new ExpandableItem("Hospitality Management", """
                    Bertumpu pada pengurusan dan pengendalian perniagaan dalam industri hospitaliti dan pelancongan.

                    Focuses on managing and operating businesses in the hospitality and tourism industry.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Kelantan (UMK)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Seberang Perai
                    -Politeknik Ungku Omar
                    -Politeknik Sultan Mizan Zainal Abidin
                    -Politeknik Merlimau
                    -Politeknik Sultan Haji Ahmad Shah
                    -Politeknik Tuanku Sultanah Bahiyah"""));
            expandableItems.add(new ExpandableItem("Event Management", """
                    Mengajar kemahiran merancang, menganjurkan, dan mengurus acara dan persidangan.

                    Teaches skills in planning, organizing, and managing events and conferences.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Tun Hussein Onn Malaysia (UTHM)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Sultan Idris Shah
                    -Politeknik Sultan Haji Ahmad Shah
                    -Politeknik Sultan Azlan Shah
                    -Politeknik Tuanku Sultanah Bahiyah
                    -Politeknik Seberang Perai
                    -Politeknik Sandakan
                    -Politeknik Port Dickson"""));
            expandableItems.add(new ExpandableItem("Public Relations", """
                    Bertumpu pada pengurusan komunikasi antara organisasi dan orang awam.

                    Focuses on managing communication between organizations and the public.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Tunku Abdul Rahman (UTAR)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Politeknik Sultan Idris Shah
                    -Politeknik Sultan Haji Ahmad Shah
                    -Politeknik Sultan Mizan Zainal Abidin
                    -Politeknik Seberang Perai
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Real Estate Management", """
                    Merangkumi urus niaga hartanah, pengurusan harta tanah, dan undang-undang hartanah.

                    Covers real estate transactions, property management, and real estate law.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Banking and Finance", """
                    Melibatkan kajian operasi perbankan, perkhidmatan kewangan, dan pengurusan risiko.

                    Involves studying banking operations, financial services, and risk management.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Tun Hussein Onn Malaysia (UTHM)
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Seberang Perai
                    -Politeknik Sultan Haji Ahmad Shah
                    -Politeknik Ungku Omar
                    -Politeknik Ibrahim Sultan
                    -Politeknik Kota Bharu
                    -Politeknik Port Dickson
                    -Politeknik Muadzam Shah"""));
            expandableItems.add(new ExpandableItem("Human Resource Management", """
                    Bertumpu pada pengurusan dan pembangunan sumber manusia dalam organisasi.

                    Focuses on managing and developing human resources within organizations.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Sabah (UMS)
                    -Politeknik Sultan Haji Ahmad Shah
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Seberang Perai
                    -Politeknik Sultan Azlan Shah
                    -Politeknik Tuanku Sultanah Bahiyah
                    -Politeknik Metro Kuala Lumpur
                    -Politeknik Merlimau
                    -Politeknik Muadzam Shah
                    -Politeknik Sultan Idris Shah
                    -Politeknik Nilai"""));
            expandableItems.add(new ExpandableItem("Logistics and Supply Chain Management", """
                    Mengajar kemahiran dalam mengurus pergerakan barangan dan perkhidmatan dalam rantaian bekalan.

                    Teaches skills in managing the movement of goods and services within supply chains.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Teknikal Malaysia Melaka (UTeM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Pahang (UMP)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Terengganu (UMT)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Metro Johor Bahru
                    -Politeknik Sultan Mizan Zainal Abidin
                    -Politeknik Ibrahim Sultan"""));
            expandableItems.add(new ExpandableItem("International Trade", """
                    Merangkumi dasar perdagangan antarabangsa, prosedur import-eksport, dan kewangan perdagangan.

                    Covers international trade policies, import-export procedures, and trade finance.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"""));
        }
        if (topNKeys.contains("k")) {
            expandableItems.add(new ExpandableItem("Accounting", """
                    Bertumpu pada penyimpanan rekod kewangan, audit, cukai, dan pelaporan kewangan.

                    Focuses on financial record-keeping, auditing, taxation, and financial reporting.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Kelantan (UMK)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Business Administration", """
                    Merangkumi pelbagai aspek pengurusan perniagaan, termasuk fungsi pentadbiran, proses organisasi, dan pengurusan pejabat.

                    Covers various aspects of business management, including administrative functions, organizational processes, and office management.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Pendidikan Sultan Idris (UPSI)
                    -Universiti Malaysia Sabah (UMS)"""));
            expandableItems.add(new ExpandableItem("Office Management", """
                    Mengajar kemahiran dalam mengurus operasi pejabat, tugas pentadbiran, dan teknologi pejabat.

                    Teaches skills in managing office operations, administrative tasks, and office technology.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah
                    -Institut Latihan Perindustrian Kuala Lumpur (ILPKL)
                    -Institut Latihan Perindustrian Kuantan (ILPKU)
                    -Institut Latihan Perindustrian Jitra (ILP Jitra)"""));
            expandableItems.add(new ExpandableItem("Secretarial Studies", """
                    Bertumpu pada sokongan pentadbiran, prosedur pejabat, dan kemahiran komunikasi.

                    Focuses on administrative support, office procedures, and communication skills.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah
                    -Institut Latihan Perindustrian Kuala Lumpur (ILPKL)
                    -Institut Latihan Perindustrian Kuantan (ILPKU)
                    -Institut Latihan Perindustrian Jitra (ILP Jitra)"""));
            expandableItems.add(new ExpandableItem("Library Science", """
                    Melibatkan pengorganisasian dan pengurusan sumber maklumat dalam perpustakaan dan pusat maklumat.

                    Involves organizing and managing information resources in libraries and information centers.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)"""));
            expandableItems.add(new ExpandableItem("Logistics and Supply Chain Management", """
                    Mengajar kemahiran dalam mengurus pergerakan barang dan perkhidmatan dalam rantaian bekalan, termasuk kawalan inventori dan pengagihan.

                    Teaches skills in managing the movement of goods and services within supply chains, including inventory control and distribution.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Retail Management", """
                    Merangkumi pengurusan operasi runcit, pemasaran, dan perkhidmatan pelanggan.

                    Covers the management of retail operations, merchandising, and customer service.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Event Management", """
                    Bertumpu pada merancang, mengatur dan mengurus acara, mengikuti proses yang terstruktur.

                    Focuses on planning, organizing, and managing events, following structured processes.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Hotel Management", """
                    Melibatkan pengurusan operasi hotel, perkhidmatan tetamu, dan pentadbiran hospitaliti.

                    Involves managing hotel operations, guest services, and hospitality administration.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Pahang (UMP)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Medical Office Management", """
                    Mempersiapkan individu untuk mengurus tugas pentadbiran dalam persekitaran penjagaan kesihatan, termasuk rekod perubatan dan penagihan.

                    Prepares individuals to manage administrative tasks in healthcare settings, including medical records and billing.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Banking and Finance", """
                    Bertumpu pada operasi perbankan, perkhidmatan kewangan, dan urus niaga mengikut protokol yang ditetapk
                    an.

                    Focuses on banking operations, financial services, and transactions following established protocols.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Insurance Management", """
                    Merangkumi produk insurans, penilaian risiko, dan pemprosesan tuntutan.

                    Covers insurance products, risk assessment, and claims processing.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Universiti Malaysia Sarawak (UNIMAS)"""));
            expandableItems.add(new ExpandableItem("Computerized Accounting", """
                    Mengajar prinsip perakaunan menggunakan perisian dan teknologi moden.

                    Teaches accounting principles using modern software and technology.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Quality Management", """
                    Bertumpu pada mengekalkan dan meningkatkan kualiti produk dan perkhidmatan melalui prosedur yang ditetapkan.

                    Focuses on maintaining and improving product and service quality through established procedures.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Teknologi Malaysia (UTM)
                    -Universiti Malaysia Sarawak (UNIMAS)
                    -Universiti Malaysia Terengganu (UMT)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Kelantan (UMK)
                    -Politeknik Malaysia
                    -Politeknik Sultan Salahuddin Abdul Aziz Shah
                    -Politeknik Ibrahim Sultan
                    -Politeknik Premier Sultan Salahuddin Abdul Aziz Shah"""));
            expandableItems.add(new ExpandableItem("Legal Studies", """
                    Melibatkan penyelidikan undang-undang, penyediaan dokumen, dan membantu profesional undang-undang.

                    Involves legal research, document preparation, and assisting legal professionals.

                    Berikut merupakan senarai universiti yang menawarkan kursus ini:
                    Below is the list of universities that offers this course:

                    -Universiti Malaya (UM)
                    -Universiti Kebangsaan Malaysia (UKM)
                    -Universiti Sains Malaysia (USM)
                    -Universiti Putra Malaysia (UPM)
                    -Universiti Teknologi MARA (UiTM)
                    -Universiti Malaysia Sabah (UMS)
                    -Universiti Utara Malaysia (UUM)
                    -Universiti Malaysia Terengganu (UMT)"""));
        }

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
