package com.example.zeltr.codehero.utils;


import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.zeltr.codehero.R;

public class ActivityUtils {

    public static PopupWindow popup;

    public static void initiatePopupWindow(Context context, String text) {
        try {
            Activity activity = (Activity) context;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup_window, (ViewGroup) activity.findViewById(R.id.popup_element));

            TextView content = (TextView) layout.findViewById(R.id.content);
            content.setText(text);

            popup = new PopupWindow(layout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

            layout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popup.dismiss();
                    return true;
                }
            });

            popup.showAtLocation(layout, Gravity.CENTER, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
