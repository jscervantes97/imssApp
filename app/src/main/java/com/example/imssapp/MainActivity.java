package com.example.imssapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imssapp.Entity.User;

import com.example.imssapp.ServiceManager.APIService;
import com.example.imssapp.ServiceManager.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtCorreo, txtContra ;
    private TextView txtResultado ;
    private Button btnLogin ;
    private APIService mAPIService;
    public User usuarioLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo) ;
        txtContra = (EditText)findViewById(R.id.txtContra) ;
        txtResultado = (TextView) findViewById(R.id.txtResultado) ;
        btnLogin = (Button)findViewById(R.id.btnLogin) ;
        btnLogin.setOnClickListener(this);
        mAPIService = ApiUtils.getAPIService();
    }

    @Override
    public void onClick(View v) {
        String contra = "", correo = "";
        contra = this.txtContra.getText().toString();
        correo = this.txtCorreo.getText().toString();

        if (contra.isEmpty() || correo.isEmpty()) {
            Toast.makeText(this,"No puede dejar ningun campo vacio...no sea gilipollas",Toast.LENGTH_LONG).show();
        }else {
            User loger = new User();
            loger.setCorreo(correo);
            loger.setContra(contra);
            iniciarSesion(loger);
        }
    }

    public void iniciarSesion(User userLog) {
        mAPIService.iniciarSesion(userLog).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println(response.toString());
                System.out.println("on respones ??" + response.message());
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    System.out.println("post submitted to API." + response.body().toString());
                    System.out.println("Usuario ??" + response.body().getNombres());
                    setearUsuarioLogIn(response.body());

                }
                confirmarInicio();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println("Unable to submit post to API.");
                System.out.println(t.getMessage());
            }
        });
    }

    public void showResponse(String response) {
       System.out.println(response);
    }

    public void setearUsuarioLogIn(User usuarioLog){
        this.usuarioLog = usuarioLog ;
        System.out.println("usuario seteado ?" + this.usuarioLog);
    }

    public void confirmarInicio(){
        if(this.usuarioLog == null){
            Toast.makeText(this,"Usuario o contraseña no validos",Toast.LENGTH_LONG).show();
            txtResultado.setText("Usuario o contraseña no validos");
        }else {
            txtResultado.setText("");
            Toast.makeText(this,"Bienvenido",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,Inicio.class);
            intent.putExtra("usuario",usuarioLog);
            startActivity(intent);
        }
    }
}