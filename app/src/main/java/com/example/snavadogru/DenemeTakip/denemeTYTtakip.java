package com.example.snavadogru.DenemeTakip;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snavadogru.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class denemeTYTtakip extends AppCompatActivity{
    GraphView tyt,tur,mat,fen,sos;
    FloatingActionButton addButton;
    FloatingActionButton deleteButton;
    ArrayList<tytDenemesi> Denemeler= new ArrayList<tytDenemesi>();

    LineGraphSeries<DataPoint> tytGraph,fenGraph,sosyalGraph,turGraph,matGraph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denemetyt);

        tyt= findViewById(R.id.tytGraph);
        tur = findViewById(R.id.TurGraph);
        mat = findViewById(R.id.Matgrapgh);
        fen = findViewById(R.id.TurGraph);
        sos = findViewById(R.id.Matgrapgh);

        addButton= findViewById(R.id.floatAdd);
        deleteButton=findViewById(R.id.floatDelete);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(denemeTYTtakip.this, denemetakipTYT_popUpAdding.class);
                startActivity(i);
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(denemeTYTtakip.this, denemetakipTYT_popUpDeleting.class);
                startActivity(i);
            }
        });
        Bundle extras = getIntent().getExtras();
        ArrayList<String> Info = new ArrayList<>();
        ArrayList<String> Netler = new ArrayList<>();
        if (extras!=null)
        {
            Info=extras.getStringArrayList("Info");
            Netler=extras.getStringArrayList("Netler");
            Denemeler.add(new tytDenemesi(Info,Netler));
        }

        turGraph = new LineGraphSeries<DataPoint>();
        tur.addSeries(turGraph);

            for (int i = 0; i <Denemeler.size() ; i++) {
                if (Denemeler.size()-1==i)
                    turGraph.appendData(new DataPoint(i+1,Denemeler.get(i).Turkce),true,500);
                else
                    turGraph.appendData(new DataPoint(i+1,Denemeler.get(i).Turkce),false,500);
            }

        turGraph.setColor(Color.GREEN);
        turGraph.setDrawDataPoints(true);
        turGraph.setDataPointsRadius(10);
        turGraph.setThickness(8);
        tur.addSeries(turGraph);
        //////////////////////////////////////////////////////////////////////
        matGraph = new LineGraphSeries<DataPoint>();
        mat.addSeries(turGraph);

        for (int i = 0; i <Denemeler.size() ; i++) {
            if (Denemeler.size()-1==i)
                matGraph.appendData(new DataPoint(i+1,Denemeler.get(i).Mat),true,500);
            else
                matGraph.appendData(new DataPoint(i+1,Denemeler.get(i).Mat),false,500);
        }

        matGraph.setColor(Color.RED);
        matGraph.setDrawDataPoints(true);
        matGraph.setDataPointsRadius(10);
        matGraph.setThickness(8);
        mat.addSeries(matGraph);
        ///////////////////////////////////////////////////////////////////////
        fenGraph = new LineGraphSeries<DataPoint>();
        fen.addSeries(turGraph);

        for (int i = 0; i <Denemeler.size() ; i++) {
            if (Denemeler.size()-1==i)
                fenGraph.appendData(new DataPoint(i+1,Denemeler.get(i).Fen),true,500);
            else
                fenGraph.appendData(new DataPoint(i+1,Denemeler.get(i).Fen),false,500);
        }

        fenGraph.setColor(Color.GRAY);
        fenGraph.setDrawDataPoints(true);
        fenGraph.setDataPointsRadius(10);
        fenGraph.setThickness(8);
        fen.addSeries(fenGraph);
        ///////////////////////////////////////////////////////////////////////
        sosyalGraph = new LineGraphSeries<DataPoint>();
        sos.addSeries(turGraph);

        for (int i = 0; i <Denemeler.size() ; i++) {
            if (Denemeler.size()-1==i)
                sosyalGraph.appendData(new DataPoint(i+1,Denemeler.get(i).Sosyal),true,500);
            else
                sosyalGraph.appendData(new DataPoint(i+1,Denemeler.get(i).Sosyal),false,500);
        }

        sosyalGraph.setColor(Color.GREEN);
        sosyalGraph.setDrawDataPoints(true);
        sosyalGraph.setDataPointsRadius(10);
        sosyalGraph.setThickness(8);
        sos.addSeries(sosyalGraph);
        ///////////////////////////////////////////////////////////////////////
        tytGraph = new LineGraphSeries<DataPoint>();
        tyt.addSeries(tytGraph);

        for (int i = 0; i <Denemeler.size() ; i++) {
            Log.d("Massage  ",Denemeler.get(i).totalNet+"---"+Denemeler.size());
            if (Denemeler.size()-1==i)
                tytGraph.appendData(new DataPoint(i+1,Denemeler.get(i).totalNet),true,500);
            else
                tytGraph.appendData(new DataPoint(i+1,Denemeler.get(i).totalNet),false,500);
        }

        tytGraph.setColor(Color.GREEN);
        tytGraph.setDrawDataPoints(true);
        tytGraph.setDataPointsRadius(10);
        tytGraph.setThickness(8);
        tyt.addSeries(tytGraph);

    }
  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }*/
}
    /*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lV = view.findViewById(R.id.lv);
        MyArrayAdapter adapter = new MyArrayAdapter(this.getContext(),0,tv1,tv2,Sorucounter);
        lV.setOnClickListener(this);
        lV.setAdapter(adapter);
       /* contact=new ArrayList<>();
        contact.add(new SoruTakipAddingItem("TÜRKÇE","ÇÖZ GAYLAN"));
        contact.add(new SoruTakipAddingItem("MATEMATİK","ÇÖZ GAYLAN"));
        contact.add(new SoruTakipAddingItem("FEN BİLİMLERİ","ÇÖZ GAYLAN"));
        contact.add(new SoruTakipAddingItem("SOSYAL BİLİMLER","ÇÖZ GAYLAN"));
    }*/
