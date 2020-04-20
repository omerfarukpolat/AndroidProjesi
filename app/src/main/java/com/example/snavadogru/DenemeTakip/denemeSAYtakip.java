package com.example.snavadogru.DenemeTakip;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.snavadogru.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class denemeSAYtakip extends AppCompatActivity {
    LineChart matChart,fizChart,chyChart,bioChart,totalChart;
    FloatingActionButton addButton;
    FloatingActionButton deleteButton;
    ArrayList<sayDenemesi> Denemeler= new ArrayList<sayDenemesi>();
    ArrayList<Entry> yMatVlaues,yPhyVlaues,yChyVlaues,yBioVlaues,yTotalVlaues;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denemesay);

        addButton= findViewById(R.id.floatAdd);
        deleteButton=findViewById(R.id.floatDelete);
        Description description = new Description();
        description.setText("Sınava Doğru");
        description.setTextColor(Color.BLACK);
        description.setTextSize(5);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(denemeSAYtakip.this, denemetakipSAY_popUpadding.class);
                startActivity(i);
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(denemeSAYtakip.this, denemetakipSAY_popUpdeleting.class);
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
            Denemeler.add(new sayDenemesi(Info,Netler));
        }
            matChart =findViewById(R.id.matLineChart);
            fizChart =findViewById(R.id.phyLineChart);
            chyChart =findViewById(R.id.chyLineChart);
            bioChart =findViewById(R.id.bioLineChart);
            totalChart=findViewById(R.id.totalSayChart);
            matChart.setDescription(description);
            fizChart.setDescription(description);
            chyChart.setDescription(description);
            bioChart.setDescription(description);
            totalChart.setDescription(description);
     

        XAxis xAxis = matChart.getXAxis();
        YAxis yAxisLeft =matChart.getAxisLeft();
        yAxisLeft.setAxisMinimum(0f);
        xAxis.setValueFormatter(new MyAxisValueFormatter());


        yMatVlaues = new ArrayList<>();
        yPhyVlaues = new ArrayList<>();
        yChyVlaues = new ArrayList<>();
        yBioVlaues = new ArrayList<>();
        yTotalVlaues = new ArrayList<>();
///////////////////////////////////////////////////////////////////
        yMatVlaues.add(new Entry(1,2f));
        yMatVlaues.add(new Entry(2,3f));
        yMatVlaues.add(new Entry(3,8f));
        yMatVlaues.add(new Entry(4,12f));

        for (int i = 0; i <Denemeler.size() ; i++) {
            //   yMatVlaues.add(new Entry(i+1,Float.parseFloat(Denemeler.get(i).Mat+"")));
            yPhyVlaues.add(new Entry(i+1,Float.parseFloat(Denemeler.get(i).Fizik+"")));
            yChyVlaues.add(new Entry(i+1,Float.parseFloat(Denemeler.get(i).Kimya+"")));
            yBioVlaues.add(new Entry(i+1,Float.parseFloat(Denemeler.get(i).Bio+"")));
            yTotalVlaues.add(new Entry(i+1,Float.parseFloat(Denemeler.get(i).totalNet+"")));
        }
        ///////////////////////////////////////////////////////////
        LineDataSet matset = new LineDataSet(yMatVlaues,"Net Grafiği");
        LineDataSet fizset = new LineDataSet(yMatVlaues,"Net Grafiği");
        LineDataSet chyset = new LineDataSet(yMatVlaues,"Net Grafiği");
        LineDataSet bioset = new LineDataSet(yMatVlaues,"Net Grafiği");
        LineDataSet totalset = new LineDataSet(yMatVlaues,"Net Grafiği");

        ArrayList<ILineDataSet> matDataSets = new ArrayList<>();
        ArrayList<ILineDataSet> fizDataSets = new ArrayList<>();
        ArrayList<ILineDataSet> chyDataSets = new ArrayList<>();
        ArrayList<ILineDataSet> bioDataSets = new ArrayList<>();
        ArrayList<ILineDataSet> totalDataSets = new ArrayList<>();

        matset.setLineWidth(4);
        matset.setDrawCircles(true);
        matset.setDrawCircleHole(true);
        matset.setCircleColor(Color.GRAY);
        matDataSets.add(matset);

        fizset.setLineWidth(4);
        fizset.setDrawCircles(true);
        fizset.setDrawCircleHole(true);
        fizset.setCircleColor(Color.GRAY);
        fizDataSets.add(fizset);

        chyset.setLineWidth(4);
        chyset.setDrawCircles(true);
        chyset.setDrawCircleHole(true);
        chyset.setCircleColor(Color.GRAY);
        chyDataSets.add(chyset);

        bioset.setLineWidth(4);
        bioset.setDrawCircles(true);
        bioset.setDrawCircleHole(true);
        bioset.setCircleColor(Color.GRAY);
        bioDataSets.add(bioset);

        totalset.setLineWidth(4);
        totalset.setDrawCircles(true);
        totalset.setDrawCircleHole(true);
        totalset.setCircleColor(Color.GRAY);
        totalDataSets.add(totalset);

        LineData matData =new LineData(matDataSets);
        LineData fizData =new LineData(matDataSets);
        LineData chyData =new LineData(matDataSets);
        LineData bioData =new LineData(matDataSets);
        LineData totalData =new LineData(matDataSets);

        matChart.setDragEnabled(true);
        matChart.setScaleEnabled(false);

        matChart.setData(matData);
    /*    fizChart.setData(fizData);*/
        if (Denemeler.size()>0){
            matChart.setData(matData);
            fizChart.setData(fizData);
            chyChart.setData(chyData);
            bioChart.setData(bioData);
            totalChart.setData(totalData);
        }
        else
        {
       //    matChart.setNoDataTextColor(Color.BLACK);
       //     matChart.setNoDataText("Kayıtlı Deneme Yok");
            fizChart.setNoDataTextColor(Color.BLACK);
            fizChart.setNoDataText("Kayıtlı Deneme Yok");
            chyChart.setNoDataTextColor(Color.BLACK);
            chyChart.setNoDataText("Kayıtlı Deneme Yok");
            bioChart.setNoDataTextColor(Color.BLACK);
            bioChart.setNoDataText("Kayıtlı Deneme Yok");
            totalChart.setNoDataTextColor(Color.BLACK);
            totalChart.setNoDataText("Kayıtlı Deneme Yok");
        }
        matChart.invalidate();


      /*  set.setFillAlpha(100);
        set.setColor(Color.RED);
        set.setLineWidth(3f);*/
      /*  set.setValueTextSize(10f);
        set.setValueTextColor(Color.GREEN);*/

    }
    class MyAxisValueFormatter implements IAxisValueFormatter{
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return "Deneme "+(int) value;
        }
    }
}

