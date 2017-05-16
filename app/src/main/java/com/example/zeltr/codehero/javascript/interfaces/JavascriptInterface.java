package com.example.zeltr.codehero.javascript.interfaces;

import android.content.Context;
import android.widget.Toast;

public class JavascriptInterface {

    Context mContext;

    /** Instantiate the interface and set the context */
    public JavascriptInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @android.webkit.JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}