package com.example.snavadogru.DatabaseClasses;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
public class Students {
    private String Name="";
    private int ID=0;
    public Students(){}
    public Students(String n,int i)
    {Name=n; ID=i;}

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }
}
