package com.example.clubregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class adminenter extends AppCompatActivity {

   EditText adminNameEditText;
   EditText passwordEditText;

    // Predefined admin credentials
    private static final String ADMIN_NAME = "Admin";
    private static final String ADMIN_PASSWORD = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminenter);

        adminNameEditText = findViewById(R.id.adminName);
        passwordEditText = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad="ADMIN";
                String ps="PASSWORD";
                String enteredAdminName = adminNameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                if (enteredAdminName.equals(ad) && enteredPassword.equals(ps)) {
                    // Admin credentials are correct, grant access to admin functionality
                    Toast.makeText(adminenter.this, "", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getApplicationContext(),adminview.class);
                    startActivity(intent);
                    // Start the admin activity or perform necessary actions
                } else {
                    // Invalid admin credentials, display error message
                    Toast.makeText(adminenter.this, "Invalid Admin Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}