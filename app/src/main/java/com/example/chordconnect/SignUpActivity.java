package com.example.chordconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {


    Button signUp;
    EditText etUsername;
    EditText etPassword;
    EditText etConfirmPassword;

    LoginActivity loginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Getting the view
        signUp = findViewById(R.id.btnSignUpPage);
        etUsername = findViewById(R.id.ptSignUpUsername);
        etPassword = findViewById(R.id.etSignUpPassword);
        etConfirmPassword = findViewById(R.id.etSignUpConfirm);


        // Extracting the string format for username, password, and confirm password

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser newUser = new ParseUser();

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if(password.equals(confirmPassword)){

                    newUser.setPassword(password);
                    newUser.setUsername(username);

                    newUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e == null){
                                Toast.makeText(SignUpActivity.this, "Welcome to Chord Connect!", Toast.LENGTH_SHORT).show();
                                goMainActivity();
                                return;
                            }
                            else{
                                Toast.makeText(SignUpActivity.this, "Oops..." + e.getMessage(), Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Oops...Make sure that your passwords match each other.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}