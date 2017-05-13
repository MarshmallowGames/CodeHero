package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.zeltr.codehero.Persistence.QuestRepository;

public class ChooseWorld extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_world);

        QuestRepository questRepository = new QuestRepository(this);

        if(questRepository.isQuestComplete(1, 4, 1)){
            ImageView imageView = (ImageView) findViewById(R.id.lock1);
            imageView.setVisibility(View.GONE);
       }
    }

    protected void startTheRoad(View view){
        Intent intent = new Intent(this, TheRoad.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, 0);
    }

    protected void startTheForest(View view){
        //Intent intent = new Intent(this, TheForest.class);
        //startActivity(intent);
    }

    protected void startTheCastle(View view){
        //Intent intent = new Intent(this, TheCastle.class);
        //startActivity(intent);
    }

    protected void showCharacter(View view){
        Intent intent = new Intent(this, Character.class);
        startActivity(intent);
    }
}
