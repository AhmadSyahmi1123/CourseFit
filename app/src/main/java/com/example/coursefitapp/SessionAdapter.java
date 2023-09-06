package com.example.coursefitapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.SessionViewHolder> {

    private ArrayList<String> dataList;
    private OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onItemClick(String sessionData);
    }

    public SessionAdapter(ArrayList<String> dataList, OnItemClickListener clickListener) {
        this.dataList = dataList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.session_item, parent, false);
        return new SessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionViewHolder holder, int position) {
        String sessionData = dataList.get(position);
        holder.bind(sessionData);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class SessionViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView sessionTextView;

        public SessionViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewSession);
            sessionTextView = itemView.findViewById(R.id.sessionTextView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        clickListener.onItemClick(dataList.get(position));
                    }
                }
            });
        }

        public void bind(String sessionData) {
            sessionTextView.setText(sessionData);
        }


    }
}

