package mr_auspicious.shivam_kr_shiv.com.sqlite3.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static mr_auspicious.shivam_kr_shiv.com.sqlite3.data.Contract.SQL_CREATE_ENTRIES;
import static mr_auspicious.shivam_kr_shiv.com.sqlite3.data.Contract.SQL_DELETE_ENTRIES;

/**
 * Created by shivam on 04-03-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ENTRIES);
    }

    public Long addValues(int id,String name,String LastName){

        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Contract.FeedEntry._ID,id);
        values.put(Contract.FeedEntry.COLUMN_NAME,name);
        values.put(Contract.FeedEntry.COLUMN_LAST_NAME,LastName);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Contract.FeedEntry.TABLE_NAME, null, values);

        return newRowId;

    }

}
