package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zeltr.codehero.Entity.QuestEntity;

public class NormalReward extends Activity {

    private QuestEntity quest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_reward);

        Intent intent = this.getIntent();

        quest = (QuestEntity) intent.getSerializableExtra("quest");

        TextView xpView = (TextView) findViewById(R.id.xp);
        xpView.setText("EXP:" + String.valueOf(quest.getXp()));

        TextView coinsView = (TextView) findViewById(R.id.coins);
        coinsView.setText("Coins: " +String.valueOf(quest.getCoins()));
    }

    public static void start(Context context, QuestEntity quest) {
        Intent intent = new Intent(context, NormalReward.class);
        intent.putExtra("quest", quest);
        context.startActivity(intent);
    }

    public void btnNext(View view){

    }
}
