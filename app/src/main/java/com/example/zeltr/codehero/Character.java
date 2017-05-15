package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Character extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
    }

    public void equipItem(View v){
        //Hardcoded test before attempting db.
        ImageView item = (ImageView)findViewById(R.id.leftHand);
        item.setImageResource(R.drawable.sword);
        item.setVisibility(View.VISIBLE);
/*
        switch(category){
            case "weapon":
                View leftHand = findViewById(R.id.leftHand);
                break;
            case "offhand":
                View rightHand = findViewById(R.id.rightHand);
                break;
            case "armor":
                View character = findViewById(R.id.character);

        }

*/

    }

    public void unequipItem(View v){
        v.setVisibility(View.GONE);
    }
}
