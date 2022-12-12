package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void RegisterUser(View view){

        EditText name = findViewById(R.id.areaName);
        EditText surname = findViewById(R.id.areaSurname);
        EditText username = findViewById(R.id.areaUsername);
        EditText email = findViewById(R.id.areaEmailNew);
        EditText password = findViewById(R.id.areaPassNew);

        Button button_add=(Button)findViewById(R.id.registerButton);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserModel userModel;
                                                            //userModel.toString()
                try{
                    userModel = new UserModel(-1, name.getText().toString(), surname.getText().toString(), username.getText().toString(), email.getText().toString(), password.getText().toString() );
                    Toast.makeText(Registration.this, "User added!", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(Registration.this, "Error creating user", Toast.LENGTH_SHORT).show();
                    userModel = new UserModel(-1, "error", "error", "error", "error", "error");
                }

                DatabaseHandler databaseHandler=new DatabaseHandler(Registration.this);
                boolean success = databaseHandler.RegisterUser(userModel);
                Toast.makeText(Registration.this, "Success= "+success, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void BackToLogin(View view) {
        TextView text= (TextView)findViewById(R.id.accountLink);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivityIntent = new Intent(Registration.this, Login.class);
                startActivity(newActivityIntent);
            }
        });

    }
}