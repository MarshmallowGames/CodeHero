package com.example.zeltr.codehero;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Character extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
    }

    protected void equipItem(View view){
        String item = view.toString();
        View leftHand = findViewById(R.id.leftHand);
        View rightHand = findViewById(R.id.rightHand);
    }

    /*public View getItemFromDB(){

        return View;
    }*/
}
