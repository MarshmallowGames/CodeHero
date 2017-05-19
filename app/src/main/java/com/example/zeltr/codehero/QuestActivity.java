package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zeltr.codehero.Entity.QuestEntity;
import com.example.zeltr.codehero.Persistence.QuestRepository;

public class QuestActivity extends Activity {

    private int userId = 0;
    private int questId = 0;
    private QuestEntity quest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        Intent intent = this.getIntent();
        userId = intent.getIntExtra("userId", 1);
        questId = intent.getIntExtra("questId", 1);

        QuestRepository questRepo = new QuestRepository(this);

        quest = questRepo.fetchQuestById(questId);

        TextView storyView = (TextView) findViewById(R.id.questStory);
        TextView tipView = (TextView) findViewById(R.id.questTip);

        storyView.setText(quest.getStory());
        tipView.setText(quest.getTips().get(0).getContent());
    }

    public static void start(Context context, int worldId, int questId, int userId) {
        Intent intent = new Intent(context, QuestActivity.class);
        intent.putExtra("userId", userId);
        intent.putExtra("quest", questId);
        context.startActivity(intent);
    }

    protected void nextButtonOnClick(View view) {
        TaskActivity.start(this, questId, userId, quest);
    }

}
