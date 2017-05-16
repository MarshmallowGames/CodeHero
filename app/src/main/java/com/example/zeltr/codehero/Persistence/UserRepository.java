package com.example.zeltr.codehero.Persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.zeltr.codehero.Entity.TipEntity;
import com.example.zeltr.codehero.Entity.UserEntity;

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


}
