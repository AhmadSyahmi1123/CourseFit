package com.example.coursefitapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.checker.units.qual.A;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    View view;

    public FirebaseAuth mAuth;
    db db = new db();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    public HashMap data;
    public static ArrayList dataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_history, container, false);
        mAuth = FirebaseAuth.getInstance();
        String uid = mAuth.getCurrentUser().getUid();
        ArrayList<String> formattedDataList = new ArrayList<>();
        data = new HashMap<>();
        dataList = new ArrayList();

        // Create a reference to the RecyclerView in your XML layout
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewSessions);

        // Create an instance of your custom adapter and set it on the RecyclerView
        SessionAdapter adapter = new SessionAdapter(formattedDataList, new SessionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String sessionData) {
                // Handle the click event on a session card here
                // 'sessionData' contains the data for the clicked session
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        db.Users.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    ArrayList<String> timestamps = new ArrayList<>();
                    ArrayList<HashMap> sessionDataList = new ArrayList<>();

                    for (DataSnapshot pointsData : snapshot.child("points").getChildren()) {
                        // Check if the key exists under "points"
                        if (pointsData.exists()) {
                            try {
                                String timestamp = pointsData.child("timestamp").getValue(String.class);
                                data = (HashMap) pointsData.getValue();
                                if (timestamp != null) {
                                    timestamps.add(timestamp);
                                    sessionDataList.add(data);
                                } else {
                                    Log.d("DATAHF", "Timestamp is null");
                                }
                            } catch (NumberFormatException e) {
                                Log.d("DATAHF", "ERR: " + e);
                            }
                        }
                    }

                    // Sort timestamps and sessionDataList in ascending order
                    sortDataByTimestamp(timestamps, sessionDataList);

                    // Create formatted data list after sorting
                    formattedDataList.clear();
                    for (int i = 0; i < timestamps.size(); i++) {
                        String formattedSessionData = "Session " + (i + 1) + " - " + timestamps.get(i);
                        formattedDataList.add(formattedSessionData);
                    }

                    // Set the sorted data in the adapter
                    dataList.clear();
                    dataList.addAll(sessionDataList);
                    adapter.notifyDataSetChanged();
                }
            }

            private void sortDataByTimestamp(ArrayList<String> timestamps, ArrayList<HashMap> sessionDataList) {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm_dd-MM-yyyy");

                for (int i = 0; i < timestamps.size() - 1; i++) {
                    for (int j = i + 1; j < timestamps.size(); j++) {
                        String timestamp1 = timestamps.get(i);
                        String timestamp2 = timestamps.get(j);

                        try {
                            Date date1 = format.parse(timestamp1);
                            Date date2 = format.parse(timestamp2);

                            if (date1 != null && date2 != null && date1.after(date2)) {
                                // Swap timestamps
                                String tempTimestamp = timestamps.get(i);
                                timestamps.set(i, timestamps.get(j));
                                timestamps.set(j, tempTimestamp);

                                // Swap session data
                                HashMap tempData = sessionDataList.get(i);
                                sessionDataList.set(i, sessionDataList.get(j));
                                sessionDataList.set(j, tempData);
                            }
                        } catch (ParseException e) {
                            Log.e("SORT_TIMESTAMP_ERROR", "Error parsing timestamps: " + e.getMessage());
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("DATAHF", error.toString());
            }
        });
        Log.d("TEST", dataList.toString());

        return view;
    }


}