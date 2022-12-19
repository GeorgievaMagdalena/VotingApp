package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserMain extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> question, op1, op2, op3, op4, op5, question1, op11, op21, op31, op41, op51, question2, op12, op22, op32, op42, op52;
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
        question1 = new ArrayList<>();
        op11 = new ArrayList<>();
        op21 = new ArrayList<>();
        op31 = new ArrayList<>();
        op41 = new ArrayList<>();
        op51 = new ArrayList<>();
        question2 = new ArrayList<>();
        op12 = new ArrayList<>();
        op22 = new ArrayList<>();
        op32 = new ArrayList<>();
        op42 = new ArrayList<>();
        op52 = new ArrayList<>();

        recyclerView=findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterRV(this, question, op1, op2, op3, op4, op5, question1, op11, op21, op31, op41, op51, question2, op12, op22, op32, op42, op52);
        recyclerView.setAdapter(adapter);
        displayData();
    }

    private void displayData() {
        Cursor cursor = db.getQuestion();
        if(cursor.getCount()==0){
            Toast.makeText(UserMain.this, "No entry exists", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while(cursor.moveToNext()) {
                question.add(cursor.getString(1));
                op1.add(cursor.getString(2));
                op2.add(cursor.getString(3));
                op3.add(cursor.getString(4));
                op4.add(cursor.getString(5));
                op5.add(cursor.getString(6));

                cursor.moveToNext();
                question1.add(cursor.getString(1));
                op11.add(cursor.getString(2));
                op21.add(cursor.getString(3));
                op31.add(cursor.getString(4));
                op41.add(cursor.getString(5));
                op51.add(cursor.getString(6));


                cursor.moveToNext();

                question2.add(cursor.getString(1));
                op12.add(cursor.getString(2));
                op22.add(cursor.getString(3));
                op32.add(cursor.getString(4));
                op42.add(cursor.getString(5));
                op52.add(cursor.getString(6));

            }
        }
    }

    public void function(Intent intent){
        RadioButton opt1 = findViewById(R.id.opt1);
        RadioButton opt2 = findViewById(R.id.opt2);
        RadioButton opt3 = findViewById(R.id.opt3);
        RadioButton opt4 = findViewById(R.id.opt4);
        RadioButton opt5 = findViewById(R.id.opt5);

        RadioButton option1 = findViewById(R.id.opt11);
        RadioButton option2 = findViewById(R.id.opt21);
        RadioButton option3 = findViewById(R.id.opt31);
        RadioButton option4 = findViewById(R.id.opt41);
        RadioButton option5 = findViewById(R.id.opt51);

        RadioButton op1 = findViewById(R.id.opt12);
        RadioButton op2 = findViewById(R.id.opt22);
        RadioButton op3 = findViewById(R.id.opt32);
        RadioButton op4 = findViewById(R.id.opt42);
        RadioButton op5 = findViewById(R.id.opt52);


        TextView QuestionQ=findViewById(R.id.textQuestion);
        String Question=QuestionQ.getText().toString();

        intent.putExtra("question", Question);



        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opt1.isChecked()) {
                    TextView op1Text = findViewById(R.id.textOption1);
                    String text = op1Text.getText().toString();
                    if (text != null) {
                        opt1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                intent.putExtra("answer", text);
                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opt2.isChecked()) {
                    TextView op2Text = findViewById(R.id.textOption2);
                    String text = op2Text.getText().toString();
                    if (text != null) {
                        opt2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                intent.putExtra("answer", text);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opt3.isChecked()) {
                    TextView op3Text = findViewById(R.id.textOption3);
                    String text = op3Text.getText().toString();
                    if (text != null) {
                        opt3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                intent.putExtra("answer1", text);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opt4.isChecked()) {
                    TextView op4Text = findViewById(R.id.textOption4);
                    String text = op4Text.getText().toString();
                    if (text != null) {
                        opt4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                intent.putExtra("answer1", text);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        opt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opt5.isChecked()) {
                    TextView op5Text = findViewById(R.id.textOption5);
                    String text = op5Text.getText().toString();
                    if (text != null) {
                        opt5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                intent.putExtra("answer1", text);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        TextView QuestionQ1=findViewById(R.id.textQuestion1);
        String Question1=QuestionQ1.getText().toString();
        //Intent intent = new Intent(getApplicationContext(), UserMyPolls.class);
        intent.putExtra("question1", Question1);




        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option1.isChecked()) {
                    TextView op1Text1 = findViewById(R.id.textOption11);
                    String text1 = op1Text1.getText().toString();
                    if (text1 != null) {
                        option1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                intent.putExtra("answer", text1);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option2.isChecked()) {
                    TextView op2Text1 = findViewById(R.id.textOption21);
                    String text1 = op2Text1.getText().toString();
                    if (text1 != null) {
                        option2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                intent.putExtra("answer", text1);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option3.isChecked()) {
                    TextView op3Text1 = findViewById(R.id.textOption31);
                    String text1 = op3Text1.getText().toString();
                    if (text1 != null) {
                        option3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                intent.putExtra("answer1", text1);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option4.isChecked()) {
                    TextView op4Text1 = findViewById(R.id.textOption41);
                    String text1 = op4Text1.getText().toString();
                    if (text1 != null) {
                        option4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                intent.putExtra("answer1", text1);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option5.isChecked()) {
                    TextView op5Text1 = findViewById(R.id.textOption51);
                    String text1 = op5Text1.getText().toString();
                    if (text1 != null) {
                        option5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                intent.putExtra("answer1", text1);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        TextView QuestionQ2=findViewById(R.id.textQuestion2);
        String Question2=QuestionQ2.getText().toString();
        intent.putExtra("question2", Question2);



        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op1.isChecked()) {
                    TextView op1Text = findViewById(R.id.textOption12);
                    String text = op1Text.getText().toString();
                    if (text != null) {
                        op1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                intent.putExtra("answer", text);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op2.isChecked()) {
                    TextView op2Text = findViewById(R.id.textOption22);
                    String text = op2Text.getText().toString();
                    if (text != null) {
                        op2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                intent.putExtra("answer", text);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op3.isChecked()) {
                    TextView op3Text = findViewById(R.id.textOption32);
                    String text = op3Text.getText().toString();
                    if (text != null) {
                        op3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                intent.putExtra("answer1", text);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op4.isChecked()) {
                    TextView op4Text = findViewById(R.id.textOption42);
                    String text = op4Text.getText().toString();
                    if (text != null) {
                        op4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                intent.putExtra("answer1", text);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        op5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op5.isChecked()) {
                    TextView op5Text = findViewById(R.id.textOption52);
                    String text = op5Text.getText().toString();
                    if (text != null) {
                        op5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                intent.putExtra("answer1", text);

                            }
                        });
                    } else {
                        Toast.makeText(UserMain.this, "null", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void CheckedAnswerFirst(View view) {
        Intent intent = new Intent(getApplicationContext(), UserMyPolls.class);
        function(intent);
        startActivity(intent);
    }


    public void goToMyPolls (View view){
        Button button1 = (Button) findViewById(R.id.MyPolls);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivityIntent = new Intent(UserMain.this, UserMyPolls.class);
                startActivity(newActivityIntent);
            }
        });
    }

}