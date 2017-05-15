package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.zeltr.codehero.Entity.QuestEntity;
import com.example.zeltr.codehero.Persistence.QuestRepository;

public class TaskActivity extends Activity {

    private int userId = 0;
    private int taskId = 0;
    private int questId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();

        userId = intent.getIntExtra("userId", 1);
        taskId = intent.getIntExtra("taskId", 1);
        questId = intent.getIntExtra("questId", 1);

        QuestRepository questRepository = new QuestRepository(this);

        //Dur ikke
        QuestEntity quest = questRepository.fetchQuestById(taskId);

        TextView tip = (TextView) findViewById(R.id.tip);
        TextView task = (TextView) findViewById(R.id.task);

        tip.setText(quest.getStory());
        task.setText(quest.getTips().get(0).getContent());
    }

    public static void start(Context context, int taskId,  int userId, int questId) {
        Intent intent = new Intent(context, TaskActivity.class);
        intent.putExtra("questId", questId);
        intent.putExtra("taskId", taskId);
        intent.putExtra("userId", userId);
        context.startActivity(intent);
    }
}
