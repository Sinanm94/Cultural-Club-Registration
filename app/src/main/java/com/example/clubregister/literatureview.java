package com.example.clubregister;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class literatureview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_literatureview);

        // Initialize the TableLayout to display the data
        TableLayout literatureTable = findViewById(R.id.table);

        // Create an instance of the DataBaseHelper class
        DataBaseHelper dbHelper = new DataBaseHelper(this);

        // Retrieve the data from the "razzel" table using the getRazzelData() method
        Cursor literatureCursor = dbHelper.getliteratureData();
        int usnIndex = literatureCursor.getColumnIndex("usn");
        int nameIndex = literatureCursor.getColumnIndex("name");
        int phoneIndex = literatureCursor.getColumnIndex("phone");
        int branchIndex = literatureCursor.getColumnIndex("branch");
        int emailIndex = literatureCursor.getColumnIndex("email");

        if (literatureCursor != null && literatureCursor.moveToFirst()) {
            do {
                String usn = literatureCursor.getString(usnIndex);
                String name = literatureCursor.getString(nameIndex);
                String phone = literatureCursor.getString(phoneIndex);
                String branch = literatureCursor.getString(branchIndex);
                String email = literatureCursor.getString(emailIndex);

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
                literatureTable.addView(row);
            } while (literatureCursor.moveToNext());
        }

        // Close the cursor
        literatureCursor.close();
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(8, 8, 8, 8);
        return textView;
    }
}
