package com.example.snavadogru.SoruTakip;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.snavadogru.R;
import com.example.snavadogru.SoruTakip.main.Fragment_soru_takip_analiz;
import com.example.snavadogru.SoruTakip.main.Fragment_soru_takip_ayt;
import com.example.snavadogru.SoruTakip.main.Fragment_soru_takip_tyt;
import com.example.snavadogru.SoruTakip.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SoruTakip extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SectionsPagerAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takip_sorutakip);
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.vPager);
        adapter=new SectionsPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragment_soru_takip_tyt(),"TYT");
        adapter.addFragment(new Fragment_soru_takip_ayt(),"AYT");
        adapter.addFragment(new Fragment_soru_takip_analiz(),"ANALİZ");
        Log.d("Message","FRAGMENT OLUŞTURULDU");
//        adapter.addFragment(new deneme(),"Benlik ANALİZ");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}
