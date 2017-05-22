package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.zeltr.codehero.Persistence.DBInitializer;
import com.example.zeltr.codehero.Services.BackgroundSoundService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent svc = new Intent(this, BackgroundSoundService.class);
        svc.setAction(BackgroundSoundService.class.getName());
        startService(svc);

        new DBInitializer(this);
    }

    protected void settingsClicked(View view) {
        Toast.makeText(this, "This function is not yet available", Toast.LENGTH_SHORT).show();
    }

    protected void readStory(View view) {
        Intent intent = new Intent(this, MainStory.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, 0);
    }

    protected void startQuest(View view) {
        Intent intent = new Intent(this, ChooseWorld.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_right, 0);
    }

    protected void showCharacter(View view) {
        Intent intent = new Intent(this, Character.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_left, 0);
    }

    protected void socialize(View view) {
        Toast.makeText(this, "This function is not yet available", Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(this, SocializeActivity.class);
        //startActivity(intent);
    }

    protected void showAchievements(View view) {
        Toast.makeText(this, "This function is not yet available", Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(this, AchievementsActivity.class);
        //startActivity(intent);
    }
}