package com.example.snavadogru.DenemeTakip;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.example.snavadogru.R;

public class denemetakipTYT_popUpDeleting extends Activity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denemetakiptyt_popupdeleting);
        int width,height;
        DisplayMetrics ds = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(ds);
        width= ds.widthPixels; height=ds.heightPixels;
        getWindow().setLayout((int)(width*(0.8)),(int)(height*0.5));

        WindowManager.LayoutParams params =getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x=0;
        params.y =-20;
        getWindow().setAttributes(params);
    }
}
