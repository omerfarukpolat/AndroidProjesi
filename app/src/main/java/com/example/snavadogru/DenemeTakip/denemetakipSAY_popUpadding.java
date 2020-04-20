
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

    public class denemetakipSAY_popUpadding extends Activity {
        Button ekle;
        EditText name,yayin,matdogru,matyanlis,fizikdogru,fizikyanlis,kimyadogru,kimyayanlis,biodogru,bioyanlis;
        ArrayList<EditText> edits = new ArrayList<>(10);
        ArrayList<String> info = new ArrayList<>(2);
        ArrayList<String> netler = new ArrayList<>(4);
        int tytIncrement=1,sayIncrement=1,eaIncrement=1,sozIncrement=1,dilIncrement=1,nameIncrement=1;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_denemetakipsay_popup_adding);

            ekle = findViewById(R.id.onay);
            name= findViewById(R.id.takeNameEdit);
            yayin= findViewById(R.id.yayinlar);

            fizikdogru= findViewById(R.id.phyDogru);
            fizikyanlis= findViewById(R.id.phyYanlis);
            matdogru= findViewById(R.id.matDogru);
            matyanlis= findViewById(R.id.matYanlis);
            kimyadogru= findViewById(R.id.chyDogru);
            kimyayanlis= findViewById(R.id.chyYanlis);
            biodogru= findViewById(R.id.bioDogru);
            bioyanlis= findViewById(R.id.bioYanlis);


            edits.add(matdogru); edits.add(matyanlis); edits.add(fizikdogru); edits.add(fizikyanlis); edits.add(kimyadogru); edits.add(kimyayanlis); edits.add(biodogru); edits.add(bioyanlis);
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
                    if ((Integer.parseInt(edits.get(0).getText().toString())>40))
                        matdogru.setError("Lütfen 0-40 arası bir değer giriniz");
                    if ((Integer.parseInt(edits.get(2).getText().toString())>40))
                        fizikdogru.setError("Lütfen 0-40 arası bir değer giriniz");
                    if ((Integer.parseInt(edits.get(2).getText().toString())>40))
                        kimyadogru.setError("Lütfen 0-40 arası bir değer giriniz");
                    if ((Integer.parseInt(edits.get(2).getText().toString())>40))
                        biodogru.setError("Lütfen 0-40 arası bir değer giriniz");
                    netler.add((Integer.parseInt(edits.get(0).getText().toString()))-(Integer.parseInt(edits.get(1).getText().toString())*1.25)+"");
                    netler.add((Integer.parseInt(edits.get(2).getText().toString()))-(Integer.parseInt(edits.get(3).getText().toString())*1.25)+"");
                    netler.add((Integer.parseInt(edits.get(4).getText().toString()))-(Integer.parseInt(edits.get(5).getText().toString())*1.25)+"");
                    netler.add((Integer.parseInt(edits.get(6).getText().toString()))-(Integer.parseInt(edits.get(7).getText().toString())*1.25)+"");
                    Intent i = new Intent(denemetakipSAY_popUpadding.this, denemeSAYtakip.class);
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
