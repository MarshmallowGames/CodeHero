package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.zeltr.codehero.Entity.TaskEntity;
import com.example.zeltr.codehero.Persistence.TaskRepository;
import com.example.zeltr.codehero.javascript.interfaces.JavascriptInterface;

public class TaskActivity extends Activity {

    private int userId = 0;
    private int taskId = 0;
    private int questId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = this.getIntent();

        userId = intent.getIntExtra("userId", 1);
        taskId = intent.getIntExtra("taskId", 1);
        questId = intent.getIntExtra("questId", 1);

        TaskRepository taskRepo = new TaskRepository(this);

        TaskEntity task = taskRepo.fetchTaskById(taskId);

        TextView descriptionView = (TextView) findViewById(R.id.taskDescription);
        TextView contentView = (TextView) findViewById(R.id.taskContent);

        TextView tipView = (TextView) findViewById(R.id.taskTip);

        descriptionView.setText(task.getDescription());
        //contentView.setText(task.getContent());

        WebView webView =(WebView) findViewById(R.id.codeEditor);
        webView.loadUrl("file:///android_asset/code-editor.html");
        webView.addJavascriptInterface(new JavascriptInterface(this), "android");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    public static void start(Context context, int taskId,  int userId, int questId) {
        Intent intent = new Intent(context, TaskActivity.class);
        intent.putExtra("questId", questId);
        intent.putExtra("taskId", taskId);
        intent.putExtra("userId", userId);
        context.startActivity(intent);
    }

    protected void checkCode(View view){

    }
}
