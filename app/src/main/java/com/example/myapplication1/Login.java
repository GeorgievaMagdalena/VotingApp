package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DatabaseHandler DB;
        DB = new DatabaseHandler(this);
        EditText emailOb = (EditText) findViewById(R.id.areaEmail);
        EditText passOb= (EditText) findViewById(R.id.areaPass);
        Button button= (Button)findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String emailText = emailOb.getText().toString().trim();
                String passText= passOb.getText().toString().trim();

                if (emailText.matches("")||passText.matches("")) {
                    Toast.makeText(Login.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    return;

                }else if(emailText.matches("admin@admin.com")){
                    emailOb.setText("");
                    passOb.setText("");
                    if(passText.matches("admin")){
                        Intent intent = new Intent(view.getContext(), AdministratorMain.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Boolean checkemail=DB.checkEmail(emailText);
                    if(checkemail==false) {
                        Toast.makeText(Login.this, "You don't have an account. Please click on the button below to register!", Toast.LENGTH_SHORT).show();
                    }else{
                        Boolean checkemail_password=DB.checkEmailPassword(emailText, passText);
                        if(checkemail_password==false){
                            Toast.makeText(Login.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent=new Intent(getApplicationContext(), UserMain.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }


    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }


    //Moving button from registration to login page
    public void BackToRegistation(View view) {
        TextView text= (TextView)findViewById(R.id.newuserLink);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivityIntent = new Intent(Login.this, Registration.class);
                startActivity(newActivityIntent);
            }
        });
    }
}