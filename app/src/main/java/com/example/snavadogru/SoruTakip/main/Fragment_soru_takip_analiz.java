package com.example.snavadogru.SoruTakip.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.snavadogru.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class Fragment_soru_takip_analiz extends Fragment implements View.OnClickListener{
    View view;
    GraphView graph;
    GraphView graph2;
    FloatingActionButton addButton;
    FloatingActionButton deleteButton;
    ArrayList<Integer> dailyData= new ArrayList<>(7);
    ArrayList<Integer> weeklyData= new ArrayList<>(52);
    public Fragment_soru_takip_analiz(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sorutakip_analiz,container,false);
        LineGraphSeries<DataPoint> series;
        super.onCreate(savedInstanceState);

            addButton= view.findViewById(R.id.floatAdd);
            deleteButton= view.findViewById(R.id.floatDelete);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getContext(),popUpAdding.class);
                    startActivity(i);
                }
            });
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getContext(),popUpDeleting.class);
                    startActivity(i);
                }
            });
         //   ArrayList<Double> data = new ArrayList<Double>();
            graph = view.findViewById(R.id.TurGraph);
            graph2 = view.findViewById(R.id.Matgrapgh);
           /*
            series = new LineGraphSeries<>(new DataPoint[] {new DataPoint(0, -1)});*/
            //   graph.addSeries(series);
        dailyData.add(200);
        dailyData.add(150);
        dailyData.add(200);
        dailyData.add(348);
        dailyData.add(300);
        dailyData.add(125);
        dailyData.add(200);
            series = new LineGraphSeries<DataPoint>();
            series.appendData(new DataPoint(1,dailyData.get(0)),true,500);
            series.appendData(new DataPoint(2,dailyData.get(1)),true,500);
            series.appendData(new DataPoint(3,dailyData.get(2)),true,500);
            series.appendData(new DataPoint(4,dailyData.get(3)),true,500);
            series.appendData(new DataPoint(5,dailyData.get(4)),true,500);
            series.appendData(new DataPoint(6,dailyData.get(5)),true,500);
            series.appendData(new DataPoint(7,dailyData.get(6)),false,500);
            series.setColor(Color.GREEN);
            series.setDrawDataPoints(true);
            series.setDataPointsRadius(10);
            series.setThickness(8);
             graph.addSeries(series);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}