package com.example.snavadogru.DenemeTakip;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snavadogru.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Button delete;
    Context context;
    ArrayList<String> Name = new ArrayList<>();
    ArrayList<String> YayinAdi = new ArrayList<>();
    ArrayList<Double> TotalNet = new ArrayList<>();
    public RecyclerViewAdapter(Context c, ArrayList<String> name ,ArrayList<String> yayinAdi,ArrayList<Double> totalNet){
        context=c; Name=name; YayinAdi=yayinAdi; TotalNet=totalNet;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_denemetakip_deleting,parent,false);
/*        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(Name.get(position));
        holder.yayinName.setText(YayinAdi.get(position));
        holder.netler.setText(TotalNet.get(position)+"");
    }

    @Override
    public int getItemCount() {
        return Name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,yayinName,netler;
        Button delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            delete=itemView.findViewById(R.id.delete);
            name=itemView.findViewById(R.id.denemName);
            yayinName=itemView.findViewById(R.id.yayinName);
            netler=itemView.findViewById(R.id.netSayisi);
        }
    }
}
