package com.kelompok16.tugasppbkelompok16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AbsenAdapter extends RecyclerView.Adapter<AbsenAdapter.MyViewHolder>{

    private ArrayList<Absen> absenList;

    public AbsenAdapter(ArrayList<Absen> absenList){
        this.absenList = absenList;
    }


    //Fungsi untuk memilih layout mana yang akan digunakan sebagai RecyclerView
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.absen_list, parent, false);
        return new MyViewHolder(itemView);
    }


    //Fungsi untuk set Data pada RecyclerView
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Absen absen = absenList.get(position);
        holder.txtNIM.setText(absen.getNim());
        holder.txtNama.setText(absen.getNama());
        holder.txtTanggal.setText(absen.getTanggal());
        holder.txtStatus.setText(absen.getStatus());
    }


    //Fungsi untuk mengetahui jumlah Data pada RecyclerView
    @Override
    public int getItemCount() {
        return absenList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNIM, txtNama, txtTanggal, txtStatus;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNIM = (TextView) itemView.findViewById(R.id.txtANIM);
            txtNama = (TextView) itemView.findViewById(R.id.txtANama);
            txtTanggal = (TextView) itemView.findViewById(R.id.txtATanggal);
            txtStatus = (TextView) itemView.findViewById(R.id.txtAStatus);
        }
    }

}
