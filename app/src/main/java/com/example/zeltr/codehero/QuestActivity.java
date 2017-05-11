package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class QuestActivity extends Activity {

    private int worldId = 0;
    private int userId = 0;
    private int questId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        worldId = intent.getIntExtra("worldId", 1);
        userId = intent.getIntExtra("userId", 1);
        questId = intent.getIntExtra("questId", 1);
    }

    public static void start(Context context, int worldId, int questId, int userId) {
        Intent intent = new Intent(context, QuestActivity.class);
        intent.putExtra("worldId", worldId);
        intent.putExtra("userId", userId);
        intent.putExtra("questId", questId);
        context.startActivity(intent);
    }

}
