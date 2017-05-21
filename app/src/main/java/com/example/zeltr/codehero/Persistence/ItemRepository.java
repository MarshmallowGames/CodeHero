package com.example.zeltr.codehero.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.zeltr.codehero.Entity.ItemEntity;

public class ItemRepository extends SQLiteOpenHelper {

    public ItemRepository(Context context) {
        super(context, DBInfo.DATABASE_NAME, null, DBInfo.DATABASE_VERSION);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ItemEntity getItemById(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM items WHERE id = ?";

        Cursor cursor = db.rawQuery(sql,  new String[] {String.valueOf(id)});

        cursor.moveToNext();

        ItemEntity item = new ItemEntity();

        item.setId(cursor.getInt(0));
        item.setUniqueId(cursor.getString(1));
        item.setPosition(cursor.getString(2));
        item.setType(cursor.getString(3));

        cursor.close();
        db.close();

        return item;
    }

}
