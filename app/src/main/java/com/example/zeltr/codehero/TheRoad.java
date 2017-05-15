package com.example.zeltr.codehero;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
                        Button quest2Btn = (Button) findViewById(R.id.button2);
                        quest2Btn.setEnabled(true);
                        break;
                    case 1:
                        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
                        imageView3.setVisibility(View.GONE);
                        Button quest3Btn = (Button) findViewById(R.id.button3);
                        quest3Btn.setEnabled(true);
                        break;
                    case 2:
                        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
                        imageView4.setVisibility(View.GONE);
                        Button quest4Btn = (Button) findViewById(R.id.button4);
                        quest4Btn.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    protected void startQuest1(View view){
        QuestActivity.start(this, 1, 1, 1);
    }

    protected void startQuest2(View view){
        QuestActivity.start(this, 2, 1, 2);
    }

    protected void startQuest3(View view){
        QuestActivity.start(this, 3, 1, 3);
    }

    protected void startQuest4(View view){
        QuestActivity.start(this, 4, 1, 4);
    }
}
