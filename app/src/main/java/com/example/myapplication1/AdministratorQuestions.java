package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
import android.widget.LinearLayout;
import android.widget.TextView;
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

                try {
                    questionModel = new QuestionModel(-1, question.getText().toString(), option1.getText().toString(), option2.getText().toString(), option3.getText().toString(), option4.getText().toString(), option5.getText().toString());
                    Toast.makeText(AdministratorQuestions.this, "Question added!", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(AdministratorQuestions.this, "Error creating question", Toast.LENGTH_SHORT).show();
                    questionModel = new QuestionModel(-1, "error", "error", "error", "error", "error", "error");
                }

                DatabaseHandler databaseHandler=new DatabaseHandler(AdministratorQuestions.this);
                boolean success= databaseHandler.AddQuestion(questionModel);
                Toast.makeText(AdministratorQuestions.this, "Success= "+success, Toast.LENGTH_SHORT).show();
            }
        });
    }
//vtoro
        public void AnotherQuestion(View v){
            Button anotherQ = (Button)findViewById(R.id.anotherQuestion);
            anotherQ.setVisibility(View.VISIBLE);
            anotherQ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     AddView();
                    view.setVisibility(View.GONE);
                }
            });
        }

        public void AddView(){
            LinearLayout layoutQuestions = findViewById(R.id.placeLayout);
            View questionView = getLayoutInflater().inflate(R.layout.row_add_question, null, false);

            EditText editText = (EditText)questionView.findViewById(R.id.VoteTextNew);
            EditText editText1 = (EditText)questionView.findViewById(R.id.Option11);
            EditText editText2 = (EditText)questionView.findViewById(R.id.Option21);
            EditText editText3 = (EditText)questionView.findViewById(R.id.Option31);
            EditText editText4 = (EditText)questionView.findViewById(R.id.Option41);
            EditText editText5 = (EditText)questionView.findViewById(R.id.Option51);

            layoutQuestions.addView(questionView);

            Button addbutton=(Button)findViewById(R.id.addPollQuestion1);
            AddQuestion1(addbutton, editText, editText1, editText2, editText3, editText4, editText5);

        }

        public void AddQuestion1(View view, EditText editText, EditText editText1, EditText editText2, EditText editText3, EditText editText4, EditText editText5)  {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    QuestionModel questionModel;

                    try {
                        questionModel = new QuestionModel(-1, editText.getText().toString(), editText1.getText().toString(), editText2.getText().toString(), editText3.getText().toString(), editText4.getText().toString(), editText5.getText().toString());
                        Toast.makeText(AdministratorQuestions.this, "Question added!", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        Toast.makeText(AdministratorQuestions.this, "Error creating question", Toast.LENGTH_SHORT).show();
                        questionModel = new QuestionModel(-1, "error", "error", "error", "error", "error", "error");
                    }

                    DatabaseHandler databaseHandler=new DatabaseHandler(AdministratorQuestions.this);
                    boolean success= databaseHandler.AddQuestion(questionModel);
                    Toast.makeText(AdministratorQuestions.this, "Success= "+success, Toast.LENGTH_SHORT).show();
                }
            });
        }

    //treto
    public void QuestionThree(View v){
        Button anotherQ = (Button)findViewById(R.id.QuestionThree);
        anotherQ.setVisibility(View.VISIBLE);
        anotherQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddViewThree();
                view.setVisibility(View.GONE);
            }
        });
    }

    public void AddViewThree(){
        LinearLayout layoutQuestions = findViewById(R.id.placeLayoutThree);
        View questionView = getLayoutInflater().inflate(R.layout.row_add_question_new, null, false);

        EditText editText = (EditText)questionView.findViewById(R.id.VoteText2);
        EditText editText1 = (EditText)questionView.findViewById(R.id.Option12);
        EditText editText2 = (EditText)questionView.findViewById(R.id.Option22);
        EditText editText3 = (EditText)questionView.findViewById(R.id.Option32);
        EditText editText4 = (EditText)questionView.findViewById(R.id.Option42);
        EditText editText5 = (EditText)questionView.findViewById(R.id.Option52);

        layoutQuestions.addView(questionView);

        Button addbutton=(Button)findViewById(R.id.addPollQuestion2);
        AddQuestionThree(addbutton, editText, editText1, editText2, editText3, editText4, editText5);

    }

    public void AddQuestionThree(View view, EditText editText, EditText editText1, EditText editText2, EditText editText3, EditText editText4, EditText editText5)  {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                QuestionModel questionModel;

                try {
                    questionModel = new QuestionModel(-1, editText.getText().toString(), editText1.getText().toString(), editText2.getText().toString(), editText3.getText().toString(), editText4.getText().toString(), editText5.getText().toString());
                    Toast.makeText(AdministratorQuestions.this, "Question added!", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(AdministratorQuestions.this, "Error creating question", Toast.LENGTH_SHORT).show();
                    questionModel = new QuestionModel(-1, "error", "error", "error", "error", "error", "error");
                }

                DatabaseHandler databaseHandler=new DatabaseHandler(AdministratorQuestions.this);
                boolean success= databaseHandler.AddQuestion(questionModel);
                Toast.makeText(AdministratorQuestions.this, "Success= "+success, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
