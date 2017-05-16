package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TheRoadStory extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_road_story);
    }

    protected void startQuest(View view){
        Intent intent = new Intent(this, TheRoad.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_right, 0);
    }

}
