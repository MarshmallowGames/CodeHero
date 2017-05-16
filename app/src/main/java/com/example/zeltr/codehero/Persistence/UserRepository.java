package com.example.zeltr.codehero.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.zeltr.codehero.Entity.ItemEntity;
import com.example.zeltr.codehero.Entity.QuestEntity;
import com.example.zeltr.codehero.Entity.TipEntity;
import com.example.zeltr.codehero.Entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserRepository extends SQLiteOpenHelper {

    public UserRepository(Context context){
        super(context, DBInfo.DATABASE_NAME, null, DBInfo.DATABASE_VERSION);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public UserEntity fetchUserById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM users WHERE id = ?";

        UserEntity user = new UserEntity();

        Cursor cursor = db.rawQuery(query,  new String[] {String.valueOf(id)});
        if (cursor.moveToFirst()) {
            user.setId(cursor.getInt(0));
            user.setFirstName(cursor.getString(1));
            user.setLastName(cursor.getString(2));
            user.setUsername(cursor.getColumnName(3));
            user.setEmail(cursor.getString(4));
            user.setExp(cursor.getInt(5));
            user.setCoins(cursor.getInt(6));
        }

        cursor.close();
        db.close();

        return user;
    }

    public List<ItemEntity> fetchUserItemsById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT items.id, items.uniqueId, items.position, items.itemType, userItems.isActive  FROM items "
                + "LEFT JOIN userItems ON items.id = userItems.itemId "
                + "WHERE userId = ?";

        List<ItemEntity> items = new ArrayList<>();

        Cursor cursor = db.rawQuery(query,  new String[] {String.valueOf(id)});

        while(cursor.moveToNext()) {
            ItemEntity item = new ItemEntity();

            item.setId(cursor.getInt(0));
            item.setUniqueId(cursor.getString(1));
            item.setPosition(cursor.getString(2));
            item.setType(cursor.getString(3));
            item.setActive(cursor.getInt(4) != 0);

            items.add(item);
        }

        cursor.close();
        db.close();

        return items;
    }

    public void setActive(int id, boolean isActive) {
        SQLiteDatabase db = this.getReadableDatabase();
        int active;

        if(isActive) active = 1;
        else active = 0;

        String query = "UPDATE userItems SET isActive = " + active + " WHERE itemId = " + id;
        db.execSQL(query);
        db.close();
    }
}
