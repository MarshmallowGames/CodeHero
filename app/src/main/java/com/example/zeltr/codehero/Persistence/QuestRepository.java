package com.example.zeltr.codehero.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.zeltr.codehero.Entity.QuestEntity;
import com.example.zeltr.codehero.Entity.TipEntity;

import java.util.ArrayList;
import java.util.List;

public class QuestRepository extends SQLiteOpenHelper {

    public QuestRepository(Context context) {
        super(context, DBInfo.DATABASE_NAME, null, DBInfo.DATABASE_VERSION);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<QuestEntity> fetchQuests(int worldId) {

        SQLiteDatabase db = this.getReadableDatabase();
        String query =  "SELECT * FROM userQuests WHERE worldId = " + worldId;

        Cursor cursor = db.rawQuery(query, null);

        List<QuestEntity> quests = new ArrayList<>();

        // Add more setters if needed
        while(cursor.moveToNext()) {
            QuestEntity quest = new QuestEntity();
            quest.setId(cursor.getInt(2));
            quest.setWorldID(cursor.getInt(3));

            int isCompleted = cursor.getInt(4);
            if(isCompleted == 1) {
                quest.setCompleted(true);
            } else {
                quest.setCompleted(false);
            }

            quests.add(quest);
        }

        cursor.close();
        db.close();

        return quests;
    }

    public QuestEntity fetchQuestById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT quests.id, quests.story, quests.worldId, userQuests.completed, tips.id, tips.content FROM quests "
                + "INNER JOIN userQuests ON quests.id = userQuests.questId "
                + "INNER JOIN tips ON quests.id = tips.questId"
                + "WHERE userQuests.id = ?";

        Cursor cursor = db.rawQuery(sql, new String[] {String.valueOf(id)});

        cursor.moveToFirst();

        QuestEntity quest = new QuestEntity();
        quest.setId(cursor.getInt(1));
        quest.setStory(cursor.getString(2));
        quest.setWorldID(cursor.getInt(3));
        quest.setCompleted(Boolean.valueOf(String.valueOf(cursor.getInt(4))));

        TipEntity tip = new TipEntity();
        tip.setId(cursor.getInt(5));
        tip.setContent(cursor.getString(6));

        //quest.setTip(tip);

        cursor.close();
        db.close();

        return quest;
    }

    public boolean isQuestComplete(int worldId, int questId, int userId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT quests.id, quests.story, quests.worldId, userQuests.completed FROM quests "
                + "LEFT JOIN userQuests ON quests.id = userQuests.questId "
                + "WHERE userQuests.worldId = ? "
                + "AND userQuests.questId = ? "
                + "AND userQuests.userId = ? ";

        Cursor cursor = db.rawQuery(query,  new String[] {String.valueOf(worldId), String.valueOf(questId), String.valueOf(userId)});
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
