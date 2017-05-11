package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class TaskActivity extends Activity {

    private int userId = 0;
    private int taskId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        userId = intent.getIntExtra("userId", 1);
        taskId = intent.getIntExtra("taskId", 1);
    }

    public static void start(Context context, int taskId,  int userId) {
        Intent intent = new Intent(context, TaskActivity.class);
        intent.putExtra("taskId", taskId);
        intent.putExtra("userId", userId);
        context.startActivity(intent);
    }
}
