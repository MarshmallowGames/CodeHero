package com.example.zeltr.codehero.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.zeltr.codehero.Entity.QuestsEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by P on 11-05-2017.
 */

public class QuestRepository extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "codeHeroDB";
    private static final int DATABASE_VERSION = 1;

    public QuestRepository(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //context.deleteDatabase("codeHeroDB");
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<QuestsEntity> fetchQuests(int worldId) {

        SQLiteDatabase db = this.getReadableDatabase();
        String query =  "SELECT * FROM userQuests WHERE worldId = " + worldId;

        Cursor cursor = db.rawQuery(query, null);

        List<QuestsEntity> quests = new ArrayList<>();

        while(cursor.moveToNext()) {
            QuestsEntity quest = new QuestsEntity();
            quest.setId(cursor.getInt(1));
            quest.setName(cursor.getString(2));
            quest.setWorldID(cursor.getInt(3));
            quest.setCompleted(Boolean.valueOf(String.valueOf(cursor.getInt(4))));
            quests.add(quest);
        }

        cursor.close();
        db.close();

        return quests;
    }

}
