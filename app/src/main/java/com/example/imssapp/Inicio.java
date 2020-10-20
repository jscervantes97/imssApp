package com.example.imssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imssapp.Entity.User;

public class Inicio extends AppCompatActivity {

    private User usuario ;
    private TextView txtSaludo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        this.usuario = (User) getIntent().getSerializableExtra("usuario");
        this.txtSaludo = (TextView) findViewById(R.id.txtSaludo) ;
        txtSaludo.setText("Hola " + usuario.getNombres() + " que deceas hacer?");
    }
}