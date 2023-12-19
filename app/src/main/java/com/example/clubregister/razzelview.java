package com.example.clubregister;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class razzelview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razzelview);

        // Initialize the TextView to display the data
        TextView razzelTextView = findViewById(R.id.list1);

        // Create an instance of the DataBaseHelper class
        DataBaseHelper dbHelper = new DataBaseHelper(this); // Replace `this` with the appropriate context

        // Retrieve the data from the "razzel" table using the getRazzelData() method
        Cursor razzelCursor = dbHelper.getRazzelData();
        int usnIndex = razzelCursor.getColumnIndex("usn");
        int nameIndex = razzelCursor.getColumnIndex("name");
        int phoneIndex = razzelCursor.getColumnIndex("phone");
        int branchIndex = razzelCursor.getColumnIndex("branch");
        int emailIndex = razzelCursor.getColumnIndex("email");


        StringBuilder stringBuilder = new StringBuilder();

        if (razzelCursor != null && razzelCursor.moveToFirst()) {
            do {
                String usn = razzelCursor.getString(usnIndex);
                String name = razzelCursor.getString(nameIndex);
                String phone = razzelCursor.getString(phoneIndex);
                String branch = razzelCursor.getString(branchIndex);
                String email = razzelCursor.getString(emailIndex);

                // Append the data to the StringBuilder
                stringBuilder.append("USN: ").append(usn).append("\n");
                stringBuilder.append("Name: ").append(name).append("\n");
                stringBuilder.append("Phone: ").append(phone).append("\n");
                stringBuilder.append("Branch: ").append(branch).append("\n");
                stringBuilder.append("Email: ").append(email).append("\n\n");
            } while (razzelCursor.moveToNext());
        }

        // Close the cursor
        razzelCursor.close();

        // Set the text in the TextView
        razzelTextView.setText(stringBuilder.toString());
    }
}
