package com.example.coursefitapp;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Optional;

public class db {
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://coursefit-e05ca-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference Users = database.getReference("Users");


    }
    /*
    public Boolean checkData(String data, String path) {

        ValueEventListener checkData = new ValueEventListener() {
            boolean result;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        String fetchedData = userSnapshot.child(path).getValue(String.class);

                        if (fetchedData.equals(data)) {
                            result = true;
                        } else {
                            result = false;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("DataCheck", "loadPost:onCancelled", databaseError.toException());
            }
        };
    }*/
}
