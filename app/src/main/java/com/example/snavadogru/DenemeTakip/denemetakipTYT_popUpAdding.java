package com.example.snavadogru.DenemeTakip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.snavadogru.R;

import java.util.ArrayList;

public class denemetakipTYT_popUpAdding extends Activity {
    Button ekle;
    EditText name,yayin,turkcedogru,turkceyanlis,matdogru,matyanlis,fendogru,fenyanlis,sosyaldogru,sosyalyanlis;
    ArrayList<EditText> edits = new ArrayList<>(10);
    ArrayList<String> info = new ArrayList<>(2);
    ArrayList<String> netler = new ArrayList<>(4);
    int tytIncrement=1,sayIncrement=1,eaIncrement=1,sozIncrement=1,dilIncrement=1,nameIncrement=1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denemetakiptyt_popupadding);

        ekle = findViewById(R.id.onay);
        name= findViewById(R.id.takeNameEdit);
        yayin= findViewById(R.id.yayinlar);

        turkcedogru= findViewById(R.id.turkceDogru);
        turkceyanlis= findViewById(R.id.turkceYanlis);
        matdogru= findViewById(R.id.matDogru);
        matyanlis= findViewById(R.id.matYanlis);
        fendogru= findViewById(R.id.fenDogru);
        fenyanlis= findViewById(R.id.fenYanlis);
        sosyaldogru= findViewById(R.id.sosyalDogru);
        sosyalyanlis= findViewById(R.id.sosyalYanlis);


        edits.add(turkcedogru); edits.add(turkceyanlis); edits.add(matdogru); edits.add(matyanlis); edits.add(fendogru); edits.add(fenyanlis); edits.add(sosyaldogru); edits.add(sosyalyanlis);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().length()==0)
                    info.add(name.getText().toString()+nameIncrement);
                else
                    info.add(name.getText().toString());
                if (yayin.getText().toString().length()==0)
                    info.add(yayin.getText().toString()+" ");
                else
                    info.add(yayin.getText().toString());

                for (int i = 0; i <edits.size() ; i++) {
                    if (edits.get(i).getText().toString().length()==0)
                        edits.get(i).setText("0");
                }
                    netler.add((Integer.parseInt(edits.get(0).getText().toString()))-(Integer.parseInt(edits.get(1).getText().toString())*1.25)+"");
                    netler.add((Integer.parseInt(edits.get(2).getText().toString()))-(Integer.parseInt(edits.get(3).getText().toString())*1.25)+"");
                    netler.add((Integer.parseInt(edits.get(4).getText().toString()))-(Integer.parseInt(edits.get(5).getText().toString())*1.25)+"");
                    netler.add((Integer.parseInt(edits.get(6).getText().toString()))-(Integer.parseInt(edits.get(7).getText().toString())*1.25)+"");
                    Intent i = new Intent(denemetakipTYT_popUpAdding.this, denemeTYTtakip.class);
                    i.putStringArrayListExtra("Info",info);
                    i.putStringArrayListExtra("Netler",netler);
                    startActivity(i);
            }
        });


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
