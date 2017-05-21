package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.zeltr.codehero.Entity.ItemEntity;
import com.example.zeltr.codehero.Entity.QuestEntity;
import com.example.zeltr.codehero.Persistence.ItemRepository;
import com.example.zeltr.codehero.Persistence.UserRepository;

public class ItemReward extends Activity {

    private QuestEntity quest;
    private int userId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_reward);

        Intent intent = this.getIntent();

        quest = (QuestEntity) intent.getSerializableExtra("quest");
        userId = intent.getIntExtra("userId", 1);

        ItemRepository itemRep = new ItemRepository(this);
        ItemEntity item = itemRep.getItemById(quest.getItemId());

        ImageView itemView = (ImageView) findViewById(R.id.imgReward);
        itemView.setImageResource(this.getResources().getIdentifier("drawable/" + item.getUniqueId(), null, this.getPackageName()));

        UserRepository userRep = new UserRepository(this);
        userRep.insertUserItems(userId, item.getId());
    }

    public static void start(Context context,  QuestEntity quest, int userId) {
        Intent intent = new Intent(context, ItemReward.class);
        intent.putExtra("quest", quest);
        intent.putExtra("userId", userId);
        context.startActivity(intent);
    }

    public void btnNext(View view){
        NormalReward.start(this, quest, userId);
    }

    @Override
    public void onBackPressed() {

    }
}
