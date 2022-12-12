package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class AdministratorQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_questions);
    }

    public void AddQuestion(View view){
        EditText startDate = findViewById(R.id.setStartDate);
        EditText startTime = findViewById(R.id.setStartTime);
        EditText endDate = findViewById(R.id.setEndDate);
        EditText endTime = findViewById(R.id.setEndTime);
        EditText question = findViewById(R.id.VoteText);
        EditText option1 = findViewById(R.id.Option1);
        EditText option2 = findViewById(R.id.Option2);
        EditText option3 = findViewById(R.id.Option3);
        EditText option4 = findViewById(R.id.Option4);
        EditText option5 = findViewById(R.id.Option5);



        Button add_question =(Button)findViewById(R.id.addPollQuestion);
        add_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionModel questionModel;
                                                                    // questionModel.toString()
                try {
                    questionModel = new QuestionModel(-1, startDate.getText().toString(), startTime.getText().toString(), endDate.getText().toString(), endTime.getText().toString(), question.getText().toString(), option1.getText().toString(), option2.getText().toString(), option3.getText().toString(), option4.getText().toString(), option5.getText().toString());
                    Toast.makeText(AdministratorQuestions.this, "Question added!", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(AdministratorQuestions.this, "Error creating question", Toast.LENGTH_SHORT).show();
                    questionModel = new QuestionModel(-1, "error", "error", "error", "error", "error", "error", "error", "error", "error", "error");
                }

                DatabaseHandler databaseHandler=new DatabaseHandler(AdministratorQuestions.this);
                boolean success= databaseHandler.AddQuestion(questionModel);
                Toast.makeText(AdministratorQuestions.this, "Success= "+success, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ViewQuestions(View v) {
        //?DatabaseHandler db = new DatabaseHandler(this);
        Button view = (Button) findViewById(R.id.viewQuestions);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdministratorQuestions.this, UserMain.class));
            }
        });
    }
}
