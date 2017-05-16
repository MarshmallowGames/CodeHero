package com.example.zeltr.codehero;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class Character extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
    }

    public void equipItem(View v){
        //Hardcoded test before attempting db.
        ImageView left = (ImageView)findViewById(R.id.leftHand);
        ImageView right = (ImageView)findViewById(R.id.rightHand);
        ImageView character = (ImageView)findViewById(R.id.character);

        switch(v.getId()){
            case R.id.sword:
                left.setImageResource(R.drawable.sword);
                left.setVisibility(View.VISIBLE);
                break;
            case R.id.shield:
                right.setImageResource(R.drawable.button_round);
                right.setVisibility(View.VISIBLE);
                break;
            case R.id.armor:
                character.setImageResource(R.drawable.code_hero_logo);
                break;
        }
    }

    public void unequipItem(View v){
        if(v.getId() == R.id.character){
            ImageView character = (ImageView)findViewById(R.id.character);
            character.setImageResource(R.drawable.boy_character);
        }else{
            v.setVisibility(View.GONE);
        }
    }
}
