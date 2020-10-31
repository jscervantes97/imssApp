package com.example.imssapp.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

    @SerializedName("idUsuario")
    @Expose
    private Integer idUsuario;
    @SerializedName("nombres")
    @Expose
    private String nombres;
    @SerializedName("apellidoPaterno")
    @Expose
    private String apellidoPaterno;
    @SerializedName("apellidoMaterno")
    @Expose
    private String apellidoMaterno;
    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("numeroCelular")
    @Expose
    private String numeroCelular;
    @SerializedName("contra")
    @Expose
    private String contra;
    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("nss")
    @Expose
    private String nss;

    @SerializedName("idClinica")
    @Expose
    private String idClinica;

    @SerializedName("domicilio")
    @Expose
    private String domicilio;

    public Integer getIdUsuario() {
        return idUsuario;
    }


}
