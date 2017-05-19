package com.example.zeltr.codehero.javascript.interfaces;

import android.content.Context;

import com.example.zeltr.codehero.Entity.QuestEntity;
import com.example.zeltr.codehero.Entity.TaskEntity;
import com.example.zeltr.codehero.ItemReward;
import com.example.zeltr.codehero.Persistence.QuestRepository;
import com.example.zeltr.codehero.utils.ActivityUtils;

public class JavascriptTaskInterface {

    private Context context;
    private TaskEntity task;
    private QuestEntity quest;
    private int userId;

    /** Instantiate the interface and set the context */
    public JavascriptTaskInterface(Context c, TaskEntity task, QuestEntity quest, int userId) {
        context = c;
        this.task = task;
        this.quest = quest;
        this.userId = userId;
    }

    @android.webkit.JavascriptInterface
    public String getContent() {
        return task.getContent();
    }

    @android.webkit.JavascriptInterface
    public void validateTask(String answer) {
        if (task.isSolved(answer)) {
            QuestRepository questRepo = new QuestRepository(context);
            questRepo.markAsCompleted(userId, quest.getId());
            ItemReward.start(context, quest);
        }
        else
            ActivityUtils.initiatePopupWindow(context, "Wrong answer, please try again.");
    }
}