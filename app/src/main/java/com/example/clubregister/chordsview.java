package com.example.clubregister;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class chordsview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chordsview);

        // Initialize the TableLayout to display the data
        TableLayout chordsTable = findViewById(R.id.table);

        // Create an instance of the DataBaseHelper class
        DataBaseHelper dbHelper = new DataBaseHelper(this);

        // Retrieve the data from the "razzel" table using the getRazzelData() method
        Cursor chordsCursor = dbHelper.getChordsData();
        int usnIndex = chordsCursor.getColumnIndex("usn");
        int nameIndex = chordsCursor.getColumnIndex("name");
        int phoneIndex = chordsCursor.getColumnIndex("phone");
        int branchIndex = chordsCursor.getColumnIndex("branch");
        int emailIndex = chordsCursor.getColumnIndex("email");

        if (chordsCursor != null && chordsCursor.moveToFirst()) {
            do {
                String usn = chordsCursor.getString(usnIndex);
                String name = chordsCursor.getString(nameIndex);
                String phone = chordsCursor.getString(phoneIndex);
                String branch = chordsCursor.getString(branchIndex);
                String email = chordsCursor.getString(emailIndex);

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
                chordsTable.addView(row);
            } while (chordsCursor.moveToNext());
        }

        // Close the cursor
        chordsCursor.close();
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(8, 8, 8, 8);
        return textView;
    }
}
