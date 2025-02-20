package com.example.zdorovieappshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.zdorovieappshop.R;

public class LoginActivity extends AppCompatActivity {
private EditText userEdt,passEdt;
private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        setVariable();
    }
    private void setVariable() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userEdt.getText().toString();
                String password = passEdt.getText().toString();
                if (userEdt.getText().toString().isEmpty() && passEdt.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Пожалуйста, заполните поля", Toast.LENGTH_SHORT).show();
                } else if (userEdt.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Пожалуйста, заполните поле c почтой", Toast.LENGTH_SHORT).show();
                } else if (passEdt.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Пожалуйста, заполните поле с паролем", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        });
    }

    private void initView()
    {
        userEdt=findViewById(R.id.editTextTextPersonName);
        passEdt=findViewById(R.id.editTextTextPassword);
        loginBtn=findViewById(R.id.loginBtn);
    }
}