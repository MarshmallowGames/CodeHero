package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zeltr.codehero.Entity.QuestEntity;
import com.example.zeltr.codehero.Persistence.UserRepository;

public class NormalReward extends Activity {

    private QuestEntity quest;
    private int userId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_reward);

        Intent intent = this.getIntent();

        quest = (QuestEntity) intent.getSerializableExtra("quest");
        userId = intent.getIntExtra("userId", 1);

        UserRepository userRep = new UserRepository(this);
        int exp = quest.getXp();
        int coins = quest.getCoins();

        userRep.insertUserRewards(userId, exp, coins);

        TextView xpView = (TextView) findViewById(R.id.xp);
        xpView.setText("EXP:" + String.valueOf(exp));

        TextView coinsView = (TextView) findViewById(R.id.coins);
        coinsView.setText("Coins: " +String.valueOf(coins));
    }

    public static void start(Context context, QuestEntity quest, int userId) {
        Intent intent = new Intent(context, NormalReward.class);
        intent.putExtra("quest", quest);
        intent.putExtra("userId", userId);
        context.startActivity(intent);
    }

    public void btnNext(View view){
        Intent intent = new Intent(this, TheRoad.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }
}
