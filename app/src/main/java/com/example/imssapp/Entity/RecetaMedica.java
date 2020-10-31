package com.example.imssapp.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

@Data
public class RecetaMedica {

    @SerializedName("idReceta")
    @Expose
    private Integer idReceta;
    @SerializedName("idUsuario")
    @Expose
    private Integer idUsuario;
    @SerializedName("fechaExpedicion")
    @Expose
    private String fechaExpedicion;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("medicamentos")
    @Expose
    private List<RecetaItemMedicamento> medicamentos = null;
}
