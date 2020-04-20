package com.example.snavadogru.DenemeTakip;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class XasisVlaueFormatter implements IAxisValueFormatter {
    ArrayList<String> values = new ArrayList<>();
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return values.get((int)value);
    }
    public  XasisVlaueFormatter(ArrayList<String> val)
    {
        this.values=val;
    }
}
