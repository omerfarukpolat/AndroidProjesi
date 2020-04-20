package com.example.snavadogru.SoruTakip.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snavadogru.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_soru_takip_tyt extends Fragment implements AdapterView.OnItemClickListener{
    View view;
    ListView lV;
    String[] tv1={"TÜRKÇE","MATEMATİK","FİZİK","KİMYA","BİYOLOJİ","TARİH","COĞRAFYA","FELSEFE"};
    static ArrayList<Integer> SoruSayisi = new ArrayList<>(8);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sorutakip_tyt,null);
        lV = view.findViewById(R.id.lvTyt);
        for (int i = 0; i <tv1.length ; i++)
            SoruSayisi.add(0);

        MyArrayAdapter adapter = new MyArrayAdapter(view.getContext(),R.layout.fragment_sorutakip_adding,tv1,SoruSayisi);
        SoruSayisi=adapter.soruSayisi;
        lV.setAdapter(adapter);
        lV.setOnItemClickListener(this);
        Log.d("mesage","geldi3");
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0)
                {
                    Toast.makeText(view.getContext(),"EKLENDİ",Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}