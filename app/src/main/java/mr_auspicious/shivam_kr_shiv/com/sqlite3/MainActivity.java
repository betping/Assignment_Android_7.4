package mr_auspicious.shivam_kr_shiv.com.sqlite3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import mr_auspicious.shivam_kr_shiv.com.sqlite3.data.Contract;
import mr_auspicious.shivam_kr_shiv.com.sqlite3.data.DBHelper;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        dbHelper.addValues(1,"Russell","Kumar");
        dbHelper.addValues(2,"Jose","Kumar");
        dbHelper.addValues(3," Anusha","Sharma");
        dbHelper.addValues(4,"Ayesha","Sinha");

        displayDatabaseInfo();

    }

    private void displayDatabaseInfo(){

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] projection = {Contract.FeedEntry._ID,
                Contract.FeedEntry.COLUMN_NAME,
                Contract.FeedEntry.COLUMN_LAST_NAME};

        Cursor cursor = db.query(Contract.FeedEntry.TABLE_NAME,projection,null,null,null,null,null);

        TextView textView = (TextView) findViewById(R.id.txt);

        try{

            textView.setText("The table contains " + cursor.getCount() + " details\n\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(Contract.FeedEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(Contract.FeedEntry.COLUMN_NAME);
            int breedColumnIndex = cursor.getColumnIndex(Contract.FeedEntry.COLUMN_LAST_NAME);


            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String lastName = cursor.getString(breedColumnIndex);
                // Display the values from each column of the current row in the cursor in the TextView
                textView.append((  "ID : "+currentID + "  -  " +
                        "Name : "+currentName + "  -  " +
                        "LastName : "+lastName + "\n"
                           ));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }



    }
}
