package com.example.imssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.imssapp.Entity.User;

public class info extends AppCompatActivity {

    private User usuario ;
    private TextView txtNss,txtNombre,txtApellidos,txtNumeroCelular,txtDomicilio,txtCorreo,txtClinica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        this.usuario = (User) getIntent().getSerializableExtra("usuario");
        txtNss = (TextView)findViewById(R.id.txtNss);
        txtNombre = (TextView)findViewById(R.id.txtNombre);
        txtApellidos = (TextView)findViewById(R.id.txtApellidos);
        txtCorreo = (TextView)findViewById(R.id.txtCorreo);
        txtClinica = (TextView)findViewById(R.id.txtClinica);
        txtNumeroCelular = (TextView)findViewById(R.id.txtNumeroCelular);
        txtDomicilio = (TextView)findViewById(R.id.txtDomicilio);

        txtNss.setText("Numero de seguro social: " + usuario.getNss());
        txtNombre.setText("Nombre: " + usuario.getNombres());
        txtDomicilio.setText("Domicilio: " + usuario.getDomicilio());
        txtNumeroCelular.setText("Numero celular: " + usuario.getNumeroCelular());
        txtApellidos.setText("Apellidos: " + usuario.getApellidoPaterno() + " " + usuario.getApellidoMaterno());
        txtClinica.setText("Clave clinica: " + usuario.getIdClinica());
        txtCorreo.setText("Correo : " + usuario.getCorreo());
    }
}