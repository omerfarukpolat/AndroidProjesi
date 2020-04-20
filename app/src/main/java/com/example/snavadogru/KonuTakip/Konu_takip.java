package com.example.snavadogru.KonuTakip;

import android.os.Bundle;

import com.example.snavadogru.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class Konu_takip extends AppCompatActivity implements View.OnClickListener {

    Button Turkce,Matematik,Fen,Sosyal,Sayisal,Sozel,Esitagirlik,Yabancidil,gelisim1,gelisim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takip_konu);
        Turkce = findViewById(R.id.Turkce);
        Matematik = findViewById(R.id.Mat);
        Fen = findViewById(R.id.Fen);
        Sosyal = findViewById(R.id.Sosyal);
        Sayisal = findViewById(R.id.Sayisal);
        Sozel = findViewById(R.id.Sozel);
        Esitagirlik = findViewById(R.id.EsitAgirlik);
        Yabancidil = findViewById(R.id.YabanciDil);
        gelisim1 = findViewById(R.id.Gelisime1);
        gelisim2 = findViewById(R.id.Gelisime2);

        Turkce.setOnClickListener(this);
        Matematik.setOnClickListener(this);
        Fen.setOnClickListener(this);
        Sosyal.setOnClickListener(this);
        Sayisal.setOnClickListener(this);
        Sozel.setOnClickListener(this);
        Esitagirlik.setOnClickListener(this);
        Yabancidil.setOnClickListener(this);
        gelisim1.setOnClickListener(this);
        gelisim2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.Turkce) {
        }
        if (view.getId()==R.id.Mat) {
        }
        if (view.getId()==R.id.Sosyal) {
        }
        if (view.getId()==R.id.Fen) {
        }
        if (view.getId()==R.id.Sayisal) {
        }
        if (view.getId()==R.id.Sozel) {
        }
        if (view.getId()==R.id.YabanciDil) {
        }
        if (view.getId()==R.id.EsitAgirlik) {
        }
        if (view.getId()==R.id.Gelisime1) {
        }
        if (view.getId()==R.id.Gelisime2) {
        }
    }
}