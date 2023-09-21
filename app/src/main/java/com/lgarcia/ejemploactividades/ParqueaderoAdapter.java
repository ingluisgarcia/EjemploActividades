package com.lgarcia.ejemploactividades;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ParqueaderoAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<Parqueadero> listado;

    public ParqueaderoAdapter(Activity activity, ArrayList<Parqueadero> listado) {
        this.activity = activity;
        this.listado = listado;
    }

    @Override
    public int getCount() {
        return listado.size();
    }

    @Override
    public Object getItem(int i) {
        return listado.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listado.get(i).getId();
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.listado, null);
        }
        TextView txtPlaca = v.findViewById(R.id.txtPlaca);
        TextView txtHoraEntrada = v.findViewById(R.id.txtHoraEntrada);
        TextView txtHoraSalida = v.findViewById(R.id.txtHoraSalida);
        TextView txtTiempoTranscurrido = v.findViewById(R.id.txtTiempoTranscurrido);

        txtPlaca.setText(listado.get(i).getPlaca());
        txtHoraEntrada.setText(listado.get(i).getFechaHoraEntrada());
        txtHoraSalida.setText(listado.get(i).getFechaHoraSalida());
        txtTiempoTranscurrido.setText(listado.get(i).tiempoConsumido());

        return v;
    }
}
