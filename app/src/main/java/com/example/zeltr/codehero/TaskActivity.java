package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.zeltr.codehero.Entity.QuestEntity;
import com.example.zeltr.codehero.Entity.TaskEntity;
import com.example.zeltr.codehero.Persistence.TaskRepository;
import com.example.zeltr.codehero.javascript.interfaces.JavascriptTaskInterface;

public class TaskActivity extends Activity {

    private int userId = 0;
    private int taskId = 0;
    private QuestEntity quest;
    private WebView webView;
    private TaskEntity task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = this.getIntent();

        userId = intent.getIntExtra("userId", 1);
        taskId = intent.getIntExtra("taskId", 1);
        quest = (QuestEntity) intent.getSerializableExtra("quest");

        TaskRepository taskRepo = new TaskRepository(this);

        this.task = taskRepo.fetchTaskById(taskId);

        TextView descriptionView = (TextView) findViewById(R.id.taskDescription);
        TextView contentView = (TextView) findViewById(R.id.taskContent);

        TextView tipView = (TextView) findViewById(R.id.taskTip);

        descriptionView.setText(task.getDescription());
        //contentView.setText(task.getContent());

        webView = (WebView) findViewById(R.id.codeEditor);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setBackgroundColor(Color.TRANSPARENT);

        webView.loadUrl("file:///android_asset/code-editor.html");

        this.webView.addJavascriptInterface(new JavascriptTaskInterface(this, task, quest, userId), "Task");
    }

    public static void start(Context context, int taskId,  int userId, QuestEntity quest) {
        Intent intent = new Intent(context, TaskActivity.class);
        intent.putExtra("quest", quest);
        intent.putExtra("taskId", taskId);
        intent.putExtra("userId", userId);
        context.startActivity(intent);
    }

    protected void validateTask(){

    }
}
