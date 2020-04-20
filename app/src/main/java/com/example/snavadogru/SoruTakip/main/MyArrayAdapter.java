package com.example.snavadogru.SoruTakip.main;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.snavadogru.R;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<String>{
    private String tv1="TV1";
    Context c;
    int index;
    Button bPlus;
    Button bMinus;
    String[] tvarray;
    EditText eCounter;
    ArrayList<Integer> soruSayisi= new ArrayList<>();
    public MyArrayAdapter(@NonNull Context context,int resource,String[] tv1,ArrayList<Integer> count) {
        super(context, resource); c=context; tvarray=tv1; soruSayisi=count;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater linflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //LayoutInflater.from(c);
        index=position;
        View row = linflater.inflate(R.layout.fragment_sorutakip_adding,null);
        TextView tv1=row.findViewById(R.id.textViewL1tv1);
        eCounter=row.findViewById(R.id.editTextL2et1);
        eCounter.setText(soruSayisi.get(position)+"");

        bPlus = row.findViewById(R.id.bPlus);
        bMinus = row.findViewById(R.id.bMinus);
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soruSayisi.set(position,soruSayisi.get(position)+10);
                eCounter.setText(soruSayisi.get(position)+10+"");
            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soruSayisi.get(position) < 10)
                    Toast.makeText(view.getContext(), "Lütfen 0'dan büyük soru sayısı giriniz", Toast.LENGTH_SHORT).show();
                else {
                    soruSayisi.set(position, soruSayisi.get(position) - 10);
                 //   eCounter.setText(soruSayisi.get(position)+"");
                }
            }
        });
        if (eCounter.getText().length()>0)
            soruSayisi.set(position,Integer.parseInt(eCounter.getText().toString()));
        tv1.setText(tvarray[position]);
        return row;
    }
    @Override
    public int getCount() {
        if (tvarray.length<=0)
            return 1;
        return tvarray.length;
    }

}
