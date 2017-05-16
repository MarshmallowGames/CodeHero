package com.example.zeltr.codehero.javascript.interfaces;

import android.content.Context;

import com.example.zeltr.codehero.Entity.TaskEntity;

public class JavascriptTaskInterface {

    Context context;
    TaskEntity task;

    /** Instantiate the interface and set the context */
    public JavascriptTaskInterface(Context c, TaskEntity task) {
        context = c;
        this.task = task;
    }

    @android.webkit.JavascriptInterface
    public String getContent() {
        return task.getContent();
    }
}