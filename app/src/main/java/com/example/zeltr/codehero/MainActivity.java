package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void startQuest(View view){
        Intent intent = new Intent(this, ChooseWorld.class);
        startActivity(intent);
    }
    protected void showCharacter(View view){
        //Intent intent = new Intent(this, CharacterActivity.class);
        //startActivity(intent);
    }
    protected void socialize(View view){
        //Intent intent = new Intent(this, SocializeActivity.class);
        //startActivity(intent);
    }
    protected void showAchievements(View view){
        //Intent intent = new Intent(this, AchievementsActivity.class);
        //startActivity(intent);
    }
}
