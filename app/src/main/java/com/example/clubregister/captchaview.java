package com.example.clubregister;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class captchaview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razzelview);

        // Initialize the TextView to display the data
        TextView captchaTextView = findViewById(R.id.list1);

        // Create an instance of the DataBaseHelper class
        DataBaseHelper dbHelper = new DataBaseHelper(this); // Replace `this` with the appropriate context

        // Retrieve the data from the "razzel" table using the getRazzelData() method
        Cursor captchaCursor = dbHelper.getcaptchaData();
        int usnIndex = captchaCursor.getColumnIndex("usn");
        int nameIndex = captchaCursor.getColumnIndex("name");
        int phoneIndex = captchaCursor.getColumnIndex("phone");
        int branchIndex = captchaCursor.getColumnIndex("branch");
        int emailIndex = captchaCursor.getColumnIndex("email");


        StringBuilder stringBuilder = new StringBuilder();

        if (captchaCursor != null && captchaCursor.moveToFirst()) {
            do {
                String usn = captchaCursor.getString(usnIndex);
                String name = captchaCursor.getString(nameIndex);
                String phone = captchaCursor.getString(phoneIndex);
                String branch = captchaCursor.getString(branchIndex);
                String email = captchaCursor.getString(emailIndex);

                // Append the data to the StringBuilder
                stringBuilder.append("USN: ").append(usn).append("\n");
                stringBuilder.append("Name: ").append(name).append("\n");
                stringBuilder.append("Phone: ").append(phone).append("\n");
                stringBuilder.append("Branch: ").append(branch).append("\n");
                stringBuilder.append("Email: ").append(email).append("\n\n");
            } while (captchaCursor.moveToNext());
        }

        // Close the cursor
        captchaCursor.close();

        // Set the text in the TextView
        captchaTextView.setText(stringBuilder.toString());
    }
}
