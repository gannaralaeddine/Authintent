package com.example.authintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity
{

    EditText usermail, userpass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usermail = findViewById(R.id.user_email);
        userpass = findViewById(R.id.user_password);

        findViewById(R.id.connect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String mail = usermail.getText().toString();
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(mail);
                if (!m.matches())
                {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.email_format_error), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (userpass.getText().toString().equals(""))
                    {
                        Toast.makeText(MainActivity.this,  getResources().getString(R.string.email_or_password_empty), Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if (userpass.getText().toString().length() <= 6)
                        {
                            Toast.makeText(MainActivity.this,  "the password should contain more than 6 characters", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Intent intent = new Intent(MainActivity.this, LoginDisplayActivity.class);
                            intent.putExtra("EXTRA_LOGIN", usermail.getText().toString());
                            intent.putExtra("EXTRA_PASSWORD", userpass.getText().toString());
                            startActivity(intent);
                        }
                    }
                }            }
        });

    }
}
