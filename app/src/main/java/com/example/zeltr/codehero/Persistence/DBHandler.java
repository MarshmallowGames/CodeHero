package com.example.zeltr.codehero.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "codeHeroDB";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS user ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "firstName VARCHAR(255), "
            + "lastName VARCHAR(255), "
            + "userName VARCHAR(255), "
            + "email VARCHAR(255))";
    private static final String INSERT_INTO_USER_TABLE = "INSERT INTO user (firstName, lastName, userName, email) "
            + "VALUES ('Dennis', 'Mikkelsen', 'Zeltres', 'Zeltres@hotmail.com')";

    private static final String CREATE_WORLD_TABLE = "CREATE TABLE IF NOT EXISTS worlds ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name VARCHAR(255))";
    private static final String INSERT_INTO_WORLD_TABLE = "INSERT INTO worlds (name) "
            + "VALUES ('The Road')";

    private static final String CREATE_QUEST_TABLE = "CREATE TABLE IF NOT EXISTS quests ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name VARCHAR(255), "
            + "worldID INTEGER, "
            + "FOREIGN KEY(worldID) REFERENCES worlds(id))";
    private static final String INSERT_QUESTS = "INSERT INTO quests (name, worldID) "
            + "VALUES ('quest1', 1), ('quest2', 1), ('quest3', 1), ('quest4', 1)";

    private static final String CREATE_USER_QUESTS_TABLE = "CREATE TABLE IF NOT EXISTS userQuests ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "userId INTEGER, "
            + "questId INTEGER, "
            + "worldId INTEGER, "
            + "completed BOOLEAN, "
            + "FOREIGN KEY(userId) REFERENCES user(id), "
            + "FOREIGN KEY(questId) REFERENCES quests(id), "
            + "FOREIGN KEY(worldId) REFERENCES worlds(id))";

    private static final String INSERT_USER_QUESTS1 = "INSERT INTO userQuests (userId, questId, worldId, completed) "
            + "VALUES (1, 1, 1, 0), (1, 2, 1, 0), (1, 3, 1, 0), (1, 4, 1, 0)";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //context.deleteDatabase("codeHeroDB");
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (!tableExists(db)) {
            db.execSQL(CREATE_USER_TABLE);
            db.execSQL(INSERT_INTO_USER_TABLE);

            db.execSQL(CREATE_WORLD_TABLE);
            db.execSQL(INSERT_INTO_WORLD_TABLE);

            db.execSQL(CREATE_QUEST_TABLE);
            db.execSQL(INSERT_QUESTS);

            db.execSQL(CREATE_USER_QUESTS_TABLE);
            db.execSQL(INSERT_USER_QUESTS1);
        }
    }

    public boolean tableExists(SQLiteDatabase db) {
        try {
            db.rawQuery("SELECT * FROM user", null);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean isQuestComplete(int worldId, int questId, int userId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT quests.id, quests.name, quests.worldId, userQuests.completed FROM quests "
                + "LEFT JOIN userQuests ON quests.id = userQuests.questId "
                + "WHERE userQuests.worldId = " + worldId + " "
                + "AND userQuests.questId = " + questId + " "
                + "AND userQuests.userId = " + userId;

        Cursor cursor = db.rawQuery(query, null);
        int isCompleted = 0;

        if (cursor.moveToFirst()) {
            isCompleted = cursor.getInt(cursor.getColumnIndex("completed"));
        }

        cursor.close();
        db.close();

        if (isCompleted == 0) {
            return false;
        } else {
            return true;
        }
    }

}
