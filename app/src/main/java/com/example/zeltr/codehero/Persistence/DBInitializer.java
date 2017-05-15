package com.example.zeltr.codehero.Persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBInitializer extends SQLiteOpenHelper {

    public DBInitializer(Context context) {
        super(context, DBInfo.DATABASE_NAME, null, DBInfo.DATABASE_VERSION);
        context.deleteDatabase(DBInfo.DATABASE_NAME);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (!tableUsersExists(db)) {
            db.execSQL(DBCreationQueries.CREATE_USER_TABLE);
            db.execSQL(DBCreationQueries.INSERT_INTO_USER_TABLE);

            db.execSQL(DBCreationQueries.CREATE_WORLD_TABLE);
            db.execSQL(DBCreationQueries.INSERT_INTO_WORLD_TABLE);

            db.execSQL(DBCreationQueries.CREATE_QUEST_TABLE);
            db.execSQL(DBCreationQueries.INSERT_QUESTS);

            db.execSQL(DBCreationQueries.CREATE_USER_QUESTS_TABLE);
            db.execSQL(DBCreationQueries.INSERT_USER_QUESTS);

            db.execSQL(DBCreationQueries.CREATE_TIPS_TABLE);
            db.execSQL(DBCreationQueries.INSERT_TIPS);

            db.execSQL(DBCreationQueries.CREATE_TASKS_TABLE);
            db.execSQL(DBCreationQueries.INSERT_TASKS);

            db.execSQL(DBCreationQueries.CREATE_ITEMS_TABLE);

            db.execSQL(DBCreationQueries.CREATE_USER_ITEMS_TABLE);

            db.execSQL(DBCreationQueries.INSERT_ITEMS);
        }
    }

    public boolean tableUsersExists(SQLiteDatabase db) {
        try {
            db.rawQuery("SELECT * FROM users", null);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
