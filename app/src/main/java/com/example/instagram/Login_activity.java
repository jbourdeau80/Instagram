package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Login_activity extends AppCompatActivity {
    public static final String TAG = "Login_activity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnbLogin;
    private Button btnsignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() != null) {
            goMainActivity();
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnbLogin = findViewById(R.id.btnLogin);
        btnsignUp = findViewById(R.id.btnSignUp);

//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setTitle("         Instagram");



        btnbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);

            }
        });

        btnsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick sign up button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                singnupUser(username, password);

            }
        });
    }


    private void singnupUser(String username, String password) {
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        // Invoque singnupInbackground
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                   Log.e(TAG, "Issue with sign up", e);
                    Toast.makeText(Login_activity.this, "Issue with sign up", Toast.LENGTH_SHORT).show();
                   return;

                }
                goMainActivity();
                Toast.makeText(Login_activity.this, "Success!", Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user" + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    // TODO: navigate better error handling
                    Log.e(TAG, "Issue with login", e);
                    Toast.makeText(Login_activity.this, "Issue with login!", Toast.LENGTH_SHORT).show();
                    return;

                }
                // TODO: navigate to the main activity if the user has signed in property
                goMainActivity();
                Toast.makeText(Login_activity.this, "Success!", Toast.LENGTH_SHORT).show();

            }
        });
        }
            private void goMainActivity() {
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                finish();
            }


}