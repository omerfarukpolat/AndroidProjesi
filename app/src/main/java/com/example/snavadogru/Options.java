package com.example.snavadogru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.snavadogru.Camera.SORULAR;
import com.example.snavadogru.DenemeTakip.DenemeTakip;
import com.example.snavadogru.KonuTakip.Konu_takip;
import com.example.snavadogru.SoruTakip.SoruTakip;

public class Options extends AppCompatActivity implements View.OnClickListener {
Button Bsss,bRehberlik,bSorular,bPuan,bKendiniDene,bKonutakip,bSorutakip,bDenemetakip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Bsss = findViewById(R.id.Bsss);
        bRehberlik = findViewById(R.id.BRehber);
        bKonutakip = findViewById(R.id.BKonuTakip);
        bSorular = findViewById(R.id.BCS);
        bPuan = findViewById(R.id.BPuan);
        bKendiniDene = findViewById(R.id.BKendi_kendine);
        bSorutakip=findViewById(R.id.BSoruTakip);
        bDenemetakip=findViewById(R.id.BDeneme_Takip);

        bKendiniDene.setOnClickListener(this);
        bPuan.setOnClickListener(this);
        bSorular.setOnClickListener(this);
        bKonutakip.setOnClickListener(this);
        bRehberlik.setOnClickListener(this);
        Bsss.setOnClickListener(this);
        bSorutakip.setOnClickListener(this);
        bDenemetakip.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case(R.id.Bsss):
                Intent ISSS= new Intent(Options.this,SSS.class);
                startActivity(ISSS);
                break;
            case (R.id.BCS) :
                Intent ISorular = new Intent(Options.this, SORULAR.class);
                startActivity(ISorular);
                break;
            case (R.id.BRehber) :
                Intent IRehberlik = new Intent(Options.this,REHBERLİK.class);
                startActivity(IRehberlik);
                break;
            case (R.id.BPuan) :
                Intent IPuan = new Intent(Options.this,PUAN.class);
                startActivity(IPuan);
                break;
            case (R.id.BKonuTakip) :
                Intent IKonuTakip = new Intent(Options.this, Konu_takip.class);
                startActivity(IKonuTakip);
                break;
            case (R.id.BKendi_kendine) :
                Intent IKendiniDene = new Intent(Options.this,KENDİNİDENE.class);
                startActivity(IKendiniDene);
                break;
            case (R.id.BSoruTakip) :
                Intent ISoruTakip = new Intent(Options.this, SoruTakip.class);
                startActivity(ISoruTakip);
                break;
            case (R.id.BDeneme_Takip) :
                Intent IDenemeTakip = new Intent(Options.this, DenemeTakip.class);
                startActivity(IDenemeTakip);
                break;

        }
    }
}
