package com.example.zeltr.codehero;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeltr.codehero.Entity.ItemEntity;
import com.example.zeltr.codehero.Entity.UserEntity;
import com.example.zeltr.codehero.Persistence.UserRepository;

import java.util.ArrayList;
import java.util.List;


public class Character extends Activity {

    List<ItemEntity> items = new ArrayList<>();
    ImageView left;
    ImageView right;
    ImageView character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        EditText exp = (EditText)findViewById(R.id.expText);
        EditText coins = (EditText)findViewById(R.id.coinsText);

        left = (ImageView)findViewById(R.id.leftHand);
        right = (ImageView)findViewById(R.id.rightHand);
        character = (ImageView)findViewById(R.id.character);

        UserRepository ur = new UserRepository(this);
        items = ur.fetchUserItemsById(1);
        isActive();

        UserEntity user = ur.fetchUserById(1);

        String expInput = "Exp: " + user.getExp();
        exp.setText(expInput, TextView.BufferType.EDITABLE);

        String sm = "Coins: " + user.getCoins();
        coins.setText(sm, TextView.BufferType.EDITABLE);
    }

    public void equipItem(View v){
        //Hardcoded test before attempting db.
        switch(v.getId()){
            case R.id.sword:
                left.setImageResource(R.drawable.sword);
                left.setVisibility(View.VISIBLE);
                setActive(0, true);
                break;
            case R.id.shield:
                right.setImageResource(R.drawable.shield);
                right.setVisibility(View.VISIBLE);
                setActive(1, true);
                break;
            case R.id.armor:
                character.setImageResource(R.drawable.boy_character_armor);
                setActive(2, true);
                break;
        }
    }

    public void unequipItem(View v){
        //Hardcoded test before attempting db.
        switch(v.getId()){
            case R.id.leftHand:
                left.setVisibility(View.GONE);
                setActive(0, false);
                break;
            case R.id.rightHand:
                right.setVisibility(View.GONE);
                setActive(1, false);
                break;
            case R.id.character:
                character.setImageResource(R.drawable.boy_character);
                setActive(2, false);
                break;

        }
    }

    public void setActive(int index, boolean isActive) {
        int id = items.get(index).getId();

        UserRepository ur = new UserRepository(this);
        ur.setActive(id, isActive);

    }

    public void isActive() {
        if(items.get(0).isActive()) {
            left.setImageResource(R.drawable.sword);
            left.setVisibility(View.VISIBLE);
        }

        if(items.get(1).isActive()) {
            right.setImageResource(R.drawable.shield);
            right.setVisibility(View.VISIBLE);
        }

        if(items.get(2).isActive()) {
            character.setImageResource(R.drawable.boy_character_armor);
            character.setVisibility(View.VISIBLE);
        }
    }
}
