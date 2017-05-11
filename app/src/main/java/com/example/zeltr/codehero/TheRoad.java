package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.zeltr.codehero.Entity.QuestsEntity;
import com.example.zeltr.codehero.Persistence.DBHandler;
import com.example.zeltr.codehero.Persistence.QuestRepository;

import java.util.List;

public class TheRoad extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_road);

        QuestRepository qr = new QuestRepository(this);
        List<QuestsEntity> quests = qr.fetchQuests(1);
        for (int i = 0; i < quests.size(); i++) {
            if(quests.get(i).isCompleted()) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView2);
                imageView.setVisibility(View.GONE);
            }
        }



    }

    protected void startQuest1(View view){
        Intent intent = new Intent(this, TheRoadQuest1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left);
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
