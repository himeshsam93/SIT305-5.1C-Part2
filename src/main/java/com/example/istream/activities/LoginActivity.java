package com.example.istream.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.istream.R;
import com.example.istream.db.*;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        db = AppDatabase.getInstance(this);
    }

    public void login(View v) {

        User user = db.userDao().login(
                username.getText().toString(),
                password.getText().toString()
        );

        if (user != null) {
            Intent i = new Intent(this, HomeActivity.class);
            i.putExtra("userId", user.id);
            startActivity(i);
        } else {
            Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show();
        }
    }

    public void goSignup(View v) {
        startActivity(new Intent(this, SignupActivity.class));
    }
}
