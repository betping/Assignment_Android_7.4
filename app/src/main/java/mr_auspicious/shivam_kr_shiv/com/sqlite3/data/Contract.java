package mr_auspicious.shivam_kr_shiv.com.sqlite3.data;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public final class Contract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Contract() {

    }

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME + " TEXT," +
                    FeedEntry.COLUMN_LAST_NAME + " TEXT)";

    static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "Entry";
        public static final String _ID = "Id";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_LAST_NAME = "LastName";
    }
}