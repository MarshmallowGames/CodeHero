package com.example.zeltr.codehero;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zeltr.codehero.Persistence.DBHandler;

public class ChooseWorld extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_world);

        DBHandler db = new DBHandler(this);
        if(db.checkQuestCompletion()){
            ImageView imageView = (ImageView) findViewById(R.id.lock1);
            imageView.setVisibility(View.GONE);
       }
    }

    protected void startTheRoad(View view){
        Intent intent = new Intent(this, TheRoad.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left);
    }

    protected void startTheForest(View view){
        //Intent intent = new Intent(this, TheForest.class);
        //startActivity(intent);
    }

    protected void startTheCastle(View view){
        //Intent intent = new Intent(this, TheCastle.class);
        //startActivity(intent);
    }

    protected void showCharacter(View view){
        //Intent intent = new Intent(this, Character.class);
        //startActivity(intent);
    }
}
