package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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

            Button btn = (Button) findViewById(R.id.theForestBtn);
            btn.setEnabled(true);
       }
    }

    protected void readTheRoadStory(View view){
        Intent intent = new Intent(this, TheRoadStory.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, 0);
    }

    protected void startTheRoad(View view){
        Intent intent = new Intent(this, TheRoad.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, 0);
    }

    protected void startTheForest(View view){
        Toast.makeText(this, "This function is not yet available", Toast.LENGTH_LONG).show();
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
