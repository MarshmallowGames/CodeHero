package com.example.zeltr.codehero;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
    ImageView swordImg;
    ImageView shieldImg;
    ImageView armorImg;
    ImageView swordCheck;
    ImageView shieldCheck;
    ImageView armorCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        EditText exp = (EditText)findViewById(R.id.expText);
        EditText coins = (EditText)findViewById(R.id.coinsText);

        left = (ImageView)findViewById(R.id.leftHand);
        right = (ImageView)findViewById(R.id.rightHand);
        character = (ImageView)findViewById(R.id.character);
        swordImg = (ImageView) findViewById(R.id.sword);
        shieldImg = (ImageView) findViewById(R.id.shield);
        armorImg = (ImageView) findViewById(R.id.armor);
        shieldCheck = (ImageView) findViewById(R.id.shieldCheck);
        swordCheck = (ImageView) findViewById(R.id.swordCheck);
        armorCheck = (ImageView) findViewById(R.id.armorCheck);

        UserRepository ur = new UserRepository(this);
        items = ur.fetchUserItemsById(1);

        for(int i = 0; i < items.size(); i++) {
            switch(items.get(i).getUniqueId()) {
                case "sword":
                    swordImg.setImageResource(R.drawable.sword);

                    if(items.get(i).isActive()){
                        left.setImageResource(R.drawable.sword);

                        ImageView swordCheck = (ImageView) findViewById(R.id.swordCheck);
                        swordCheck.setImageResource(R.drawable.checkmark);
                    }
                    break;
                case "shield":
                    shieldImg.setImageResource(R.drawable.shield);

                    if(items.get(i).isActive()){
                        right.setImageResource(R.drawable.shield);

                        shieldCheck.setImageResource(R.drawable.checkmark);
                    }
                    break;
                case "armor":
                    armorImg.setImageResource(R.drawable.armor);

                    if(items.get(i).isActive()){
                        character.setImageResource(R.drawable.boy_character_armor);

                        armorCheck.setImageResource(R.drawable.checkmark);
                    } else {
                        character.setImageResource(R.drawable.boy_character);
                    }
                    break;
            }
        }

        UserEntity user = ur.fetchUserById(1);

        String expInput = "Exp: " + user.getExp();
        exp.setText(expInput, TextView.BufferType.EDITABLE);

        String sm = "Coins: " + user.getCoins();
        coins.setText(sm, TextView.BufferType.EDITABLE);
    }

    public void equipItem(View v){
        switch(v.getId()){
            case R.id.sword:
                left.setImageResource(R.drawable.sword);
                swordCheck.setImageResource(R.drawable.checkmark);

                setActive(0, true);
                break;
            case R.id.shield:
                right.setImageResource(R.drawable.shield);
                shieldCheck.setImageResource(R.drawable.checkmark);

                setActive(1, true);
                break;
            case R.id.armor:
                character.setImageResource(R.drawable.boy_character_armor);
                armorCheck.setImageResource(R.drawable.checkmark);

                setActive(2, true);
                break;
        }
    }

    public void unequipItem(View v){
        switch(v.getId()){
            case R.id.leftHand:
                left.setImageDrawable(null);
                swordCheck.setImageDrawable(null);

                setActive(0, false);
                break;
            case R.id.rightHand:
                right.setImageDrawable(null);
                shieldCheck.setImageDrawable(null);

                setActive(1, false);
                break;
            case R.id.character:
                character.setImageResource(R.drawable.boy_character);
                armorCheck.setImageDrawable(null);

                setActive(2, false);
                break;
        }
    }

    public void setActive(int index, boolean isActive) {
        int id = items.get(index).getId();

        UserRepository ur = new UserRepository(this);
        ur.setActive(id, isActive);
    }

}
