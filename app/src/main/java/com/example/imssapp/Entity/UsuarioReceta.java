package com.example.imssapp.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class UsuarioReceta {
    @SerializedName("idUsuario")
    @Expose
    private Integer idUsuario;

    @SerializedName("idReceta")
    @Expose
    private Integer idReceta;
}
