package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.zeltr.codehero.Entity.QuestEntity;
import com.example.zeltr.codehero.Persistence.QuestRepository;

public class QuestActivity extends Activity {

    private int userId = 0;
    private int questId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        userId = intent.getIntExtra("userId", 1);
        questId = intent.getIntExtra("questId", 1);

        QuestRepository questRepo = new QuestRepository(this);

        QuestEntity quest = questRepo.fetchQuestById(questId);

        TextView story = (TextView) findViewById(R.id.questStory);
        TextView tip = (TextView) findViewById(R.id.questTip);

        story.setText(quest.getStory());
        tip.setText(quest.getTips().get(0).getContent());
    }

    public static void start(Context context, int worldId, int questId, int userId) {
        Intent intent = new Intent(context, QuestActivity.class);
        intent.putExtra("userId", userId);
        intent.putExtra("questId", questId);
        context.startActivity(intent);
    }

}
