package com.example.imssapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imssapp.Entity.RecetaItemMedicamento;

import java.util.List;

import lombok.Data;

@Data
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MedicamentoViewHolder>{

    private List<RecetaItemMedicamento> medicamentos ;
    private Context context ;

    RVAdapter(List<RecetaItemMedicamento> medicamentos, Context context){
        this.medicamentos = medicamentos ;
        this.context = context ;
    }

    @NonNull
    @Override
    public MedicamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_receta_item, parent, false);
        return  new MedicamentoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicamentoViewHolder holder, int position) {
        holder.descripcion.setText(medicamentos.get(position).getNombreMedicamento() + " " + medicamentos.get(position).getCantidad() );
        if(medicamentos.get(position).getDisponible().equals("Disponible")){
            holder.imagenResult.setImageResource(R.drawable.palomita);
        }else {
            holder.imagenResult.setImageResource(R.drawable.cruz);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MedicamentoViewHolder extends RecyclerView.ViewHolder {
        TextView descripcion;
        ImageView imagenResult;

        MedicamentoViewHolder(View itemView) {
            super(itemView);
            descripcion = (TextView)itemView.findViewById(R.id.txtMedicamento);
            imagenResult = (ImageView) itemView.findViewById(R.id.imgDisponible);
        }
    }

}