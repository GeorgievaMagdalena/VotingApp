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
    private ArrayList question, op1, op2, op3, op4, op5, question1, op11, op21, op31, op41, op51, question2, op12, op22, op32, op42, op52;

    public AdapterRV(Context context, ArrayList question, ArrayList op1, ArrayList op2, ArrayList op3, ArrayList op4, ArrayList op5, ArrayList question1, ArrayList op11, ArrayList op21, ArrayList op31, ArrayList op41, ArrayList op51, ArrayList question2, ArrayList op12, ArrayList op22, ArrayList op32, ArrayList op42, ArrayList op52) {
        this.context = context;
        this.question = question;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.op5 = op5;
        this.question1 = question1;
        this.op11 = op11;
        this.op21 = op21;
        this.op31 = op31;
        this.op41 = op41;
        this.op51 = op51;
        this.question2 = question2;
        this.op12 = op12;
        this.op22 = op22;
        this.op32 = op32;
        this.op42 = op42;
        this.op52 = op52;
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

       holder.question1.setText(String.valueOf(question1.get(position)));
        holder.op11.setText(String.valueOf(op11.get(position)));
        holder.op21.setText(String.valueOf(op21.get(position)));
        holder.op31.setText(String.valueOf(op31.get(position)));
        holder.op41.setText(String.valueOf(op41.get(position)));
        holder.op51.setText(String.valueOf(op51.get(position)));

        holder.question2.setText(String.valueOf(question2.get(position)));
        holder.op12.setText(String.valueOf(op12.get(position)));
        holder.op22.setText(String.valueOf(op22.get(position)));
        holder.op32.setText(String.valueOf(op32.get(position)));
        holder.op42.setText(String.valueOf(op42.get(position)));
        holder.op52.setText(String.valueOf(op52.get(position)));
    }



    @Override
    public int getItemCount() {
        return question.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView question, op1, op2, op3, op4, op5, question1, op11, op21, op31, op41, op51, question2, op12, op22, op32, op42, op52;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.textQuestion);
            op1 = itemView.findViewById(R.id.textOption1);
            op2 = itemView.findViewById(R.id.textOption2);
            op3 = itemView.findViewById(R.id.textOption3);
            op4 = itemView.findViewById(R.id.textOption4);
            op5 = itemView.findViewById(R.id.textOption5);
            question1 = itemView.findViewById(R.id.textQuestion1);
            op11 = itemView.findViewById(R.id.textOption11);
            op21 = itemView.findViewById(R.id.textOption21);
            op31 = itemView.findViewById(R.id.textOption31);
            op41 = itemView.findViewById(R.id.textOption41);
            op51 = itemView.findViewById(R.id.textOption51);
            question2 = itemView.findViewById(R.id.textQuestion2);
            op12 = itemView.findViewById(R.id.textOption12);
            op22 = itemView.findViewById(R.id.textOption22);
            op32 = itemView.findViewById(R.id.textOption32);
            op42= itemView.findViewById(R.id.textOption42);
            op52 = itemView.findViewById(R.id.textOption52);
        }
    }
}
