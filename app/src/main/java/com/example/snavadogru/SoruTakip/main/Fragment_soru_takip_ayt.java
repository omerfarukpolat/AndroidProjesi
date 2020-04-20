package com.example.snavadogru.SoruTakip.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.snavadogru.R;

import java.util.ArrayList;

public class Fragment_soru_takip_ayt extends Fragment implements AdapterView.OnItemClickListener{
    View view;
    ListView lV;
    String[] tv1={"TÜRKÇE","MATEMATİK","GEOMETRİ","FİZİK","KİMYA","BİYOLOJİ","TARİH","COĞRAFYA","FELSEFE","DİN KÜLTÜRÜ","İNGİLİZCE"};
    ArrayList<Integer> Sorucounter = new ArrayList<>(12);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sorutakip_ayt,null);
        lV = view.findViewById(R.id.lvAyt);
/////////////////////
        //    adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1, stat);
        //      lV.setAdapter(adapter);
        for (int i = 0; i <tv1.length ; i++)
            Sorucounter.add(0);

        MyArrayAdapter adapter = new MyArrayAdapter(view.getContext(),R.layout.fragment_sorutakip_adding,tv1,Sorucounter);
        Sorucounter=adapter.soruSayisi;
        lV.setAdapter(adapter);

        lV.setOnItemClickListener(this);
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
