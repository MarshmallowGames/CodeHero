package com.example.zeltr.codehero.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "codeHeroDB";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS users ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "firstName VARCHAR(255), "
            + "lastName VARCHAR(255), "
            + "userName VARCHAR(255), "
            + "email VARCHAR(255))";
    private static final String INSERT_INTO_USER_TABLE = "INSERT INTO users (firstName, lastName, userName, email) "
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
            + "FOREIGN KEY(userId) REFERENCES users(id), "
            + "FOREIGN KEY(questId) REFERENCES quests(id), "
            + "FOREIGN KEY(worldId) REFERENCES worlds(id))";

    private static final String INSERT_USER_QUESTS = "INSERT INTO userQuests (userId, questId, worldId, completed) "
            + "VALUES (1, 1, 1, 0), (1, 2, 1, 0), (1, 3, 1, 0), (1, 4, 1, 0)";

    private static final String CREATE_TIPS_TABLE = "CREATE TABLE IF NOT EXISTS tips ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "content VARCHAR(255), "
            + "questId INTEGER, "
            + "FOREIGN KEY(questId) REFERENCES quests(id))";

    private static final String CREATE_TASKS_TABLE = "CREATE TABLE IF NOT EXISTS tasks ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "content VARCHAR(255), "
            + "worldId INTEGER, "
            + "answer VARCHAR(500), "
            + "description VARCHAR(500), "
            + "FOREIGN KEY(worldId) REFERENCES worlds(id))";

    private static final String CREATE_ITEMS_TABLE = "CREATE TABLE IF NOT EXISTS items ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "userId INTEGER, "
            + "category VARCHAR(255), "
            + "FOREIGN KEY(userId) REFERENCES user(id))";

    private static final String CREATE_USER_ITEMS_TABLE = "CREATE TABLE IF NOT EXISTS userItems ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "userId INTEGER, "
            + "FOREIGN KEY(userId) REFERENCES user(id))";

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
            db.execSQL(INSERT_USER_QUESTS);

            db.execSQL(CREATE_TIPS_TABLE);

            db.execSQL(CREATE_TASKS_TABLE);

            db.execSQL(CREATE_ITEMS_TABLE);

            db.execSQL(CREATE_USER_ITEMS_TABLE);
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
