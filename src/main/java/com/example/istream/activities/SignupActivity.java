package com.example.istream.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.istream.R;
import com.example.istream.db.*;

public class SignupActivity extends AppCompatActivity {

    EditText name, username, password, confirm;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = AppDatabase.getInstance(this);

        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);
    }

    public void signup(View v) {

        if (!password.getText().toString()
                .equals(confirm.getText().toString())) {

            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User();
        user.fullName = name.getText().toString();
        user.username = username.getText().toString();
        user.password = password.getText().toString();

        db.userDao().insert(user);

        Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
        finish();
    }
}
