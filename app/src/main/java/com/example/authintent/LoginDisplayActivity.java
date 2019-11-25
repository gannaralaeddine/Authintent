package com.example.authintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LoginDisplayActivity extends AppCompatActivity
{

    TextView mail, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_display);

        mail = findViewById(R.id.email_display);
        pass = findViewById(R.id.password_display);

        Intent intent = getIntent();

        if (intent != null)
        {
            mail.setText(getIntent().getStringExtra("EXTRA_LOGIN"));
            pass.setText(getIntent().getStringExtra("EXTRA_PASSWORD"));
        }


    }
}
