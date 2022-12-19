package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserMyPolls extends AppCompatActivity {
    RecyclerView recyclerView1;
    ArrayList<String> question1, answer1, question2, answer2, question3, answer3;
    DatabaseHandler db;
    AdapterMyPolls adapterMyPolls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_my_polls);
        db=new DatabaseHandler(this);
        question1 = new ArrayList<>();
        answer1 = new ArrayList<>();
        question2 = new ArrayList<>();
        answer2 = new ArrayList<>();
        question3 = new ArrayList<>();
        answer3 = new ArrayList<>();

        recyclerView1=findViewById(R.id.RecyclerView1);
        adapterMyPolls = new AdapterMyPolls(this, question1, answer1, question2, answer2, question3, answer3);
        recyclerView1.setAdapter(adapterMyPolls);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        displayData1();

    }

    private void displayData1(){
        Intent intent = getIntent();
        String ques1=intent.getStringExtra("question");
        String ans1 = intent.getStringExtra("answer");
        String ques2=intent.getStringExtra("question1");
        String ans2 = intent.getStringExtra("answer1");
        String ques3=intent.getStringExtra("question2");
        String ans3 = intent.getStringExtra("answer2");
        question1.add(ques1);
        answer1.add(ans1);
        question2.add(ques2);
        answer2.add(ans2);
        question3.add(ques3);
        answer3.add(ans3);
    }




}