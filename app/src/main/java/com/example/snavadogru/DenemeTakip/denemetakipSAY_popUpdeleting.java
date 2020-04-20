package com.example.snavadogru.DenemeTakip;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snavadogru.R;
import com.example.snavadogru.SoruTakip.main.MyArrayAdapter;

import java.util.ArrayList;

public class denemetakipSAY_popUpdeleting extends Activity {
    RecyclerView rV;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> yayinName = new ArrayList<>();
    ArrayList<Double> netler = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denemetakipsay_popup_deleting);
        rV = findViewById(R.id.recyclerView);
        name.add("Deneme 1");
        name.add("Deneme 2");
        yayinName.add("3 4 5");
        yayinName.add("Fen Bilimleri");
        netler.add((double)70);
        netler.add((double)60);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,name,yayinName,netler);
        rV.setAdapter(myAdapter);
        rV.setLayoutManager(new LinearLayoutManager(this));
    }
}
