package com.example.imssapp;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imssapp.Entity.Respuesta;
import com.example.imssapp.Entity.User;
import com.example.imssapp.ServiceManager.APIService;
import com.example.imssapp.ServiceManager.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgendarNotificacion extends AppCompatActivity implements View.OnClickListener {

    private APIService mAPIService;
    private LinearLayout layoutNoCuentaSolicitud;
    private TextView txtResultado ;
    private User usuario ;
    private Button btnSolicitar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_notificacion);
        this.usuario = (User) getIntent().getSerializableExtra("usuario");
        layoutNoCuentaSolicitud = findViewById(R.id.solicitudInactiva);
        txtResultado = findViewById(R.id.txtResultado);
        btnSolicitar = findViewById(R.id.btnSolicitar) ;
        mAPIService = ApiUtils.getAPIService();
        verSiCuenta();
        btnSolicitar.setOnClickListener(this);
    }

    public void verSiCuenta(){
        mAPIService.verificarUsuarioCuentaSolicitudActiva(usuario.getIdUsuario()).enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if(response.isSuccessful()){
                    Respuesta respuesta = response.body();
                    txtResultado.setText(respuesta.getMensaje());
                    if(!respuesta.getMensaje().equals("El usuario no tiene solicitudes")){
                        btnSolicitar.setVisibility(View.GONE);
                    }else{
                        txtResultado.setText("Por el momento no cuenta con el servicio este ¿Desea solicitar el servicio de agendar notificacion?");
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        solicitar();
    }

    public void solicitar(){
        mAPIService.agendarSolicitudNotificacion(usuario).enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if(response.isSuccessful()){
                    finish();
                    startActivity(getIntent());
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {

            }
        });

    }
}