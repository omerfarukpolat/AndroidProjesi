package com.example.snavadogru.DenemeTakip;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snavadogru.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class DenemeTakip extends Activity implements View.OnClickListener{
   Button tyt,say,ea,dil,soz;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denemetakip);

        tyt = findViewById(R.id.tyt);
        say = findViewById(R.id.say);
        ea = findViewById(R.id.ea);
        dil = findViewById(R.id.dil);
        soz = findViewById(R.id.soz);

        tyt.setOnClickListener(this);
        say.setOnClickListener(this);
        ea.setOnClickListener(this);
        dil.setOnClickListener(this);
        soz.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==tyt.getId())
        {
            Intent i = new Intent(DenemeTakip.this, denemeTYTtakip.class);
            startActivity(i);
        }
        else if (view.getId()==say.getId())
        {
            Intent i = new Intent(DenemeTakip.this, denemeSAYtakip.class);
            startActivity(i);
        }
        else if (view.getId()==ea.getId())
        {
            Intent i = new Intent(DenemeTakip.this, denemeEAtakip.class);
            startActivity(i);
        }
        else if (view.getId()==soz.getId())
        {
            Intent i = new Intent(DenemeTakip.this, denemeSOZtakip.class);
            startActivity(i);
        }
        else if (view.getId()==dil.getId())
        {
            Intent i = new Intent(DenemeTakip.this, denemeDiltakip.class);
            startActivity(i);
        }
    }
}
