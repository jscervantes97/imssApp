package com.example.imssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imssapp.Entity.User;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    private User usuario ;
    private TextView txtSaludo ;
    private Button btnConsultaDisponibles, btnAgendarNotificacion, btnConsultarInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        this.usuario = (User) getIntent().getSerializableExtra("usuario");
        this.txtSaludo = (TextView) findViewById(R.id.txtSaludo) ;
        txtSaludo.setText("Hola " + usuario.getNombres() + " que deceas hacer?");
        this.btnAgendarNotificacion = (Button) findViewById(R.id.btnAgendarNotificacion);
        this.btnConsultaDisponibles = (Button) findViewById(R.id.btnDisponibilidad) ;
        this.btnConsultarInformacion = (Button) findViewById(R.id.btnVerMiInformacion);
        this.btnConsultarInformacion.setOnClickListener(this);
        this.btnConsultaDisponibles.setOnClickListener(this);
        this.btnAgendarNotificacion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnVerMiInformacion){
            Intent intent = new Intent(this,info.class);
            intent.putExtra("usuario",this.usuario);
            startActivity(intent);
        }
        if(v.getId() == R.id.btnDisponibilidad){
            Intent intent = new Intent(this,ConsultarDisponibilidad.class);
            intent.putExtra("usuario",this.usuario);
            startActivity(intent);
        }
        if(v.getId() == R.id.btnAgendarNotificacion){
            Intent intent = new Intent(this,AgendarNotificacion.class);
            intent.putExtra("usuario",this.usuario);
            startActivity(intent);
        }
    }
}