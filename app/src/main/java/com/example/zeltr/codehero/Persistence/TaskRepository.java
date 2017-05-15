package com.example.zeltr.codehero.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.zeltr.codehero.Entity.TaskEntity;

public class TaskRepository extends SQLiteOpenHelper {

    public TaskRepository(Context context) {
        super(context, DBInfo.DATABASE_NAME, null, DBInfo.DATABASE_VERSION);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public TaskEntity fetchTaskById(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM tasks WHERE tasks.id = ?";

        Cursor cursor = db.rawQuery(sql, new String[] {String.valueOf(id)});

        cursor.moveToFirst();

        TaskEntity task = new TaskEntity();
        task.setId(cursor.getInt(0));
        task.setContent(cursor.getString(1));
        task.setQuestId(cursor.getInt(2));
        task.setAnswer(cursor.getString(3));
        task.setDescription(cursor.getString(4));

        return task;
    }
}
