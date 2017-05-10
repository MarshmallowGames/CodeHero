package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TheRoad extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_road);
    }

    protected void startQuest1(View view){
        Intent intent = new Intent(this, TheRoadQuest1.class);
        startActivity(intent);
    }

    protected void startQuest2(View view){
        //Intent intent = new Intent(this, TheRoad2Activity.class);
        //startActivity(intent);
    }

    protected void startQuest3(View view){
        //Intent intent = new Intent(this, TheRoad3Activity.class);
        //startActivity(intent);
    }

    protected void startQuest4(View view){
        //Intent intent = new Intent(this, TheRoad4Activity.class);
        //startActivity(intent);
    }
}
