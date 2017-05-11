package com.example.zeltr.codehero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Character extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
    }

    protected void equipItem(View view){
        String item = view.toString();

    }

    /*public View getItemFromDB(){

        return View;
    }*/
}
