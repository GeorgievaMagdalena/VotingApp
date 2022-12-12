package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AdministratorMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_main);
    }

        public void goToAddQuestion (View view){
            Button button1 = (Button) findViewById(R.id.goToQuestions);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent newActivityIntent = new Intent(AdministratorMain.this, AdministratorQuestions.class);
                    startActivity(newActivityIntent);
                }
            });
        }

        public void goToActiveResults (View view){
            Button button2 = (Button) findViewById(R.id.goToActiveResult);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent newActivityIntent = new Intent(AdministratorMain.this, AdministratorResults.class);
                    startActivity(newActivityIntent);
                }
            });
        }

    //ova e za mapata
//    public void goToMap(){
//        Button button = (Button)findViewById(R.id.goToMap);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(), ?.class);
//                startActivity(intent);
//            }
//        });
//    }


}

