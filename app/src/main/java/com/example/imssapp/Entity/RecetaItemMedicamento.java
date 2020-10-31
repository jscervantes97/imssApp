package com.example.imssapp.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

@Data
public class RecetaItemMedicamento implements Serializable {
    @SerializedName("nombreMedicamento")
    @Expose
    private String nombreMedicamento;
    @SerializedName("cantidad")
    @Expose
    private String cantidad;
    @SerializedName("disponible")
    @Expose
    private String disponible;
}
