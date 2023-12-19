package com.example.clubregister;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class speakersview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakersview);

        // Initialize the TableLayout to display the data
        TableLayout speakersTable = findViewById(R.id.table);

        // Create an instance of the DataBaseHelper class
        DataBaseHelper dbHelper = new DataBaseHelper(this);

        // Retrieve the data from the "razzel" table using the getRazzelData() method
        Cursor speakersCursor = dbHelper.getspeakersData();
        int usnIndex = speakersCursor.getColumnIndex("usn");
        int nameIndex = speakersCursor.getColumnIndex("name");
        int phoneIndex = speakersCursor.getColumnIndex("phone");
        int branchIndex = speakersCursor.getColumnIndex("branch");
        int emailIndex = speakersCursor.getColumnIndex("email");

        if (speakersCursor != null && speakersCursor.moveToFirst()) {
            do {
                String usn = speakersCursor.getString(usnIndex);
                String name = speakersCursor.getString(nameIndex);
                String phone = speakersCursor.getString(phoneIndex);
                String branch = speakersCursor.getString(branchIndex);
                String email = speakersCursor.getString(emailIndex);

                // Create a new TableRow
                TableRow row = new TableRow(this);

                // Create TextViews for each column and set the data
                TextView usnTextView = createTextView(usn);
                TextView nameTextView = createTextView(name);
                TextView phoneTextView = createTextView(phone);
                TextView branchTextView = createTextView(branch);
                TextView emailTextView = createTextView(email);

                // Add TextViews to the TableRow
                row.addView(usnTextView);
                row.addView(nameTextView);
                row.addView(phoneTextView);
                row.addView(branchTextView);
                row.addView(emailTextView);

                // Add the TableRow to the TableLayout
                speakersTable.addView(row);
            } while (speakersCursor.moveToNext());
        }

        // Close the cursor
        speakersCursor.close();
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(8, 8, 8, 8);
        return textView;
    }
}
