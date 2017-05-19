package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.zeltr.codehero.Entity.QuestEntity;

public class ItemReward extends Activity {

    private QuestEntity quest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_reward);

        Intent intent = this.getIntent();

        quest = (QuestEntity) intent.getSerializableExtra("quest");
    }

    public static void start(Context context, QuestEntity quest) {
        Intent intent = new Intent(context, ItemReward.class);
        intent.putExtra("quest", quest);
        context.startActivity(intent);
    }

    public void btnNext(View view){
        NormalReward.start(this, quest);
    }
}
