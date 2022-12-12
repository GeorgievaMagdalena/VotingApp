package com.example.myapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.MyViewHolder> {
    private Context context;
    private ArrayList startDate, startTime, endDate, endTime, question, op1, op2, op3, op4, op5;

    //ArrayList startDate, ArrayList startTime, ArrayList endDate, ArrayList endTime, <- vo konstruktor
    public AdapterRV(Context context, ArrayList question, ArrayList op1, ArrayList op2, ArrayList op3, ArrayList op4, ArrayList op5) {
        this.context = context;
//        this.startDate = startDate;
//        this.startTime = startTime;
//        this.endDate = endDate;
//        this.endTime = endTime;
        this.question = question;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.op5 = op5;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.questionentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.question.setText(String.valueOf(question.get(position)));
        holder.op1.setText(String.valueOf(op1.get(position)));
        holder.op2.setText(String.valueOf(op2.get(position)));
        holder.op3.setText(String.valueOf(op3.get(position)));
        holder.op4.setText(String.valueOf(op4.get(position)));
        holder.op5.setText(String.valueOf(op5.get(position)));
    }//sdate, stime..

    @Override
    public int getItemCount() {
        return question.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView startDate, startTime, endDate, endTime, question, op1, op2, op3, op4, op5;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.textQuestion);
            op1 = itemView.findViewById(R.id.textOption1);
            op2 = itemView.findViewById(R.id.textOption2);
            op3 = itemView.findViewById(R.id.textOption3);
            op4 = itemView.findViewById(R.id.textOption4);
            op5 = itemView.findViewById(R.id.textOption5);

        }
    }
}
