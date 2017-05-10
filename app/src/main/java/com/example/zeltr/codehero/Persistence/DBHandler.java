package com.example.zeltr.codehero.Persistence;

import android.content.Context;
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
    private static final String INSERT_QUEST1 = "INSERT INTO quests (name, worldID) "
            + "VALUES ('quest1', 1)";
    private static final String INSERT_QUEST2 = "INSERT INTO quests (name, worldID) "
            + "VALUES ('quest2', 1)";
    private static final String INSERT_QUEST3 = "INSERT INTO quests (name, worldID) "
            + "VALUES ('quest3', 1)";
    private static final String INSERT_QUEST4 = "INSERT INTO quests (name, worldID) "
            + "VALUES ('quest4', 1)";

    private static final String CREATE_USER_QUESTS_TABLE = "CREATE TABLE IF NOT EXISTS userQuests ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "userId INTEGER, "
            + "questId INTEGER, "
            + "worldId INTEGER, "
            + "completed BOOLEAN)";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        context.deleteDatabase("codeHeroDB");
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(INSERT_INTO_USER_TABLE);

        db.execSQL(CREATE_WORLD_TABLE);
        db.execSQL(INSERT_INTO_WORLD_TABLE);

        db.execSQL(CREATE_QUEST_TABLE);
        db.execSQL(INSERT_QUEST1);
        db.execSQL(INSERT_QUEST2);
        db.execSQL(INSERT_QUEST3);
        db.execSQL(INSERT_QUEST4);

        db.execSQL(CREATE_USER_QUESTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
