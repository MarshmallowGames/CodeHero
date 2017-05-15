package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.zeltr.codehero.Entity.QuestEntity;
import com.example.zeltr.codehero.Persistence.QuestRepository;

import java.util.List;

public class TheRoad extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_road);

        QuestRepository qr = new QuestRepository(this);
        List<QuestEntity> quests = qr.fetchQuests(1);

        for (int i = 0; i < quests.size(); i++) {
            if(quests.get(i).isCompleted()) {
                switch (i) {
                    case 0:
                        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
                        imageView2.setVisibility(View.GONE);
                        break;
                    case 1:
                        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
                        imageView3.setVisibility(View.GONE);
                        break;
                    case 2:
                        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
                        imageView4.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }


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
