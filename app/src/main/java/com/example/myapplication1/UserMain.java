package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class UserMain extends AppCompatActivity {
    RecyclerView recyclerView;
    //sdate stime...
    ArrayList<String> question, op1, op2, op3, op4, op5;
    DatabaseHandler db;
    AdapterRV adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        db = new DatabaseHandler(this);
        question = new ArrayList<>();
        op1 = new ArrayList<>();
        op2 = new ArrayList<>();
        op3 = new ArrayList<>();
        op4 = new ArrayList<>();
        op5 = new ArrayList<>();

        recyclerView=findViewById(R.id.RecyclerView);
        adapter = new AdapterRV(this, question, op1, op2, op3, op4, op5);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData() {
        Cursor cursor = db.getQuestion();
        if(cursor.getCount()==0){
            Toast.makeText(UserMain.this, "No entry exists", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while(cursor.moveToNext()){
                question.add(cursor.getString(5));
                op1.add(cursor.getString(6));
                op2.add(cursor.getString(7));
                op3.add(cursor.getString(8));
                op4.add(cursor.getString(9));
                op5.add(cursor.getString(10));

            }
        }
    }
}