package com.example.snavadogru.DenemeTakip;

import java.util.ArrayList;

public class tytDenemesi {
    Double Turkce,Mat,Fen,Sosyal,totalNet;
    String Name,Yayin;
    public tytDenemesi(ArrayList<String> Info, ArrayList<String> Netler){
            Name=Info.get(0); Yayin=Info.get(1);
            Turkce=Double.parseDouble(Netler.get(0));
            Mat=Double.parseDouble(Netler.get(1));
            Fen=Double.parseDouble(Netler.get(2));
            Sosyal=Double.parseDouble(Netler.get(3));
            totalNet=Turkce+Mat+Fen+Sosyal;
    }
}
