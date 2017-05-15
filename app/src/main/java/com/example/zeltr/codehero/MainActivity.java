package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.zeltr.codehero.Persistence.DBInitializer;
import com.example.zeltr.codehero.Persistence.TaskRepository;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DBInitializer(this);
    }

    protected void startQuest(View view){
        Intent intent = new Intent(this, ChooseWorld.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_right, 0);
    }
    protected void showCharacter(View view){
        Intent intent = new Intent(this, Character.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_left, 0);
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
