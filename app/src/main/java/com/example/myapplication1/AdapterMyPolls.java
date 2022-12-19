package com.example.myapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMyPolls extends RecyclerView.Adapter<AdapterMyPolls.MyViewHolder> {
    private Context context;
    private ArrayList question1, answer1, question2, answer2, question3, answer3;

    public AdapterMyPolls(Context context, ArrayList question1, ArrayList answer1, ArrayList question2, ArrayList answer2, ArrayList question3, ArrayList answer3) {
        this.context = context;
        this.question1 = question1;
        this.answer1 = answer1;
        this.question2 = question2;
        this.answer2 = answer2;
        this.question3 = question3;
        this.answer3 = answer3;
    }

    @NonNull
    @Override
    public AdapterMyPolls.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.mypollsentry, parent, false);
        return new AdapterMyPolls.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMyPolls.MyViewHolder holder, int position) {
        holder.question1.setText(String.valueOf(question1.get(position)));
        holder.answer1.setText(String.valueOf(answer1.get(position)));
        holder.question2.setText(String.valueOf(question2.get(position)));
        holder.answer2.setText(String.valueOf(answer2.get(position)));
        holder.question3.setText(String.valueOf(question3.get(position)));
        holder.answer3.setText(String.valueOf(answer3.get(position)));
    }

    @Override
    public int getItemCount() {
        return question1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView question1, answer1, question2, answer2, question3, answer3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            question1=itemView.findViewById(R.id.showQuestion1);
            answer1=itemView.findViewById(R.id.showAnswer1);
            question2=itemView.findViewById(R.id.showQuestion2);
            answer2=itemView.findViewById(R.id.showAnswer2);
            question3=itemView.findViewById(R.id.showQuestion3);
            answer3=itemView.findViewById(R.id.showAnswer3);

        }
    }
}
