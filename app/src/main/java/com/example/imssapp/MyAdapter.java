package com.example.imssapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.imssapp.Entity.RecetaItemMedicamento;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<RecetaItemMedicamento> medicamentos;

    public MyAdapter(Context context, int layout, List<RecetaItemMedicamento> medicamentos){
        this.context = context;
        this.layout = layout;
        this.medicamentos = medicamentos;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v= layoutInflater.inflate(R.layout.list_item, null);
        // Valor actual según la posición

        RecetaItemMedicamento actual  = medicamentos.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(actual.getNombreMedicamento() + " " + actual.getCantidad() + " " + actual.getDisponible());
        //Devolvemos la vista inflada
        return v;
    }
}
