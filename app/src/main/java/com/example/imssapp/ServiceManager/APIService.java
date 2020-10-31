package com.example.imssapp.ServiceManager;

import com.example.imssapp.Entity.RecetaMedica;
import com.example.imssapp.Entity.Respuesta;
import com.example.imssapp.Entity.User;
import com.example.imssapp.Entity.UsuarioReceta;


import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    //Produccion
    static final String BASE = "/";
    //Desarrollo
    //static final String BASE = "/apiimss/";
    @POST(BASE + "api.php/login")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<User> iniciarSesion(@Body User user);

    @POST(BASE + "api.php/recetaMedica")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<RecetaMedica> obtenerRecetaMedica(@Body UsuarioReceta user);

    @GET(BASE + "api.php/Verificar/{idUsuario}")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<Respuesta> verificarUsuarioCuentaSolicitudActiva(@Path("idUsuario") int id);

    @POST(BASE + "api.php/agendarSolicitud")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<Respuesta> agendarSolicitudNotificacion(@Body User user);

}