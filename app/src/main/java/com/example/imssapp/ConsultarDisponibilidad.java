package com.example.imssapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.imssapp.Entity.RecetaItemMedicamento;
import com.example.imssapp.Entity.RecetaMedica;
import com.example.imssapp.Entity.User;
import com.example.imssapp.Entity.UsuarioReceta;
import com.example.imssapp.ServiceManager.APIService;
import com.example.imssapp.ServiceManager.ApiUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsultarDisponibilidad extends AppCompatActivity implements View.OnClickListener {

    private APIService mAPIService;
    private List<RecetaItemMedicamento> medicamentos ;
    private RecyclerView rv ;
    private ListView lista ;
    private TextView txtFecha,txtNoEncontrado ;
    private LinearLayout layoutLista ;
    private EditText txtFolioReceta ;
    private User usuario ;
    private Button btnVer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_disponibilidad);
        this.usuario = (User) getIntent().getSerializableExtra("usuario");
        mAPIService = ApiUtils.getAPIService();
        lista = (ListView) findViewById(R.id.listaReceta);
        txtFecha = (TextView) findViewById(R.id.txtFechaExpedicion);
        txtFolioReceta = (EditText) findViewById(R.id.txtFolioReceta) ;
        txtNoEncontrado = (TextView) findViewById(R.id.txtNoEncontrado);
        layoutLista = (LinearLayout) findViewById(R.id.contenedorLista);
        btnVer = findViewById(R.id.btnVerD);
        btnVer.setOnClickListener(this);


    }

    public void cargarDatosConsulta(){
        if(txtFolioReceta.getText().toString().isEmpty()){
            txtNoEncontrado.setText("El folio es obligatorio");
        }
        UsuarioReceta usuarioReceta = new UsuarioReceta();
        usuarioReceta.setIdReceta(Integer.parseInt(txtFolioReceta.getText().toString()));
        usuarioReceta.setIdUsuario(usuario.getIdUsuario());

        mAPIService.obtenerRecetaMedica(usuarioReceta).enqueue(new Callback<RecetaMedica>() {
            @Override
            public void onResponse(Call<RecetaMedica> call, Response<RecetaMedica> response) {
                if(response.isSuccessful()){
                    medicamentos = response.body().getMedicamentos() ;
                    txtFecha.setText("Fecha de expedicion: " + response.body().getFechaExpedicion());
                    setearAdaptador(medicamentos);
                    layoutLista.setVisibility(View.VISIBLE);
                    txtNoEncontrado.setText("");
                }else {
                    layoutLista.setVisibility(View.GONE);
                    txtNoEncontrado.setText("Folio de receta no valido para el usuario actual...");
                }

            }

            @Override
            public void onFailure(Call<RecetaMedica> call, Throwable t) {
                System.out.println("error en: " + t.getMessage());
            }
        });
    }

    public void setearAdaptador(List<RecetaItemMedicamento> listaM){
        ArrayList<String> listaDescriptiva = new ArrayList<>();
        for(RecetaItemMedicamento item : listaM){
            listaDescriptiva.add(item.getNombreMedicamento() + " " + item.getCantidad() + " " + item.getDisponible());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaDescriptiva);
        //MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, listaM);
        lista.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        cargarDatosConsulta();
    }
}