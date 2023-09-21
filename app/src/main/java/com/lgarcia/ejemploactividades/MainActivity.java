package com.lgarcia.ejemploactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtPlaca;
    Button btnIngreso, btnSalida, btnReporte;
    int id = 1;
    String placa;

    ArrayList<Parqueadero> listadoParqueadero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPlaca = findViewById(R.id.edtPlaca);
        btnIngreso = findViewById(R.id.btnIngreso);
        btnSalida = findViewById(R.id.btnSalida);
        btnReporte = findViewById(R.id.btnReporte);

        edtPlaca.setText("");

        listadoParqueadero = new ArrayList<>();

    }

    public void ingresar(View v){
        placa = edtPlaca.getText().toString().toUpperCase();
        if(listadoParqueadero.isEmpty()){
            listadoParqueadero.add(new Parqueadero(id, placa));
            id++;
            Toast.makeText(this, "Vehiculo ingresado", Toast.LENGTH_SHORT).show();
        }else{
            boolean ingresado = false;
            for (int i = 0; i<listadoParqueadero.size(); i++){
                if(listadoParqueadero.get(i).getPlaca().equals(placa)
                        && !(listadoParqueadero.get(i).verificarSalida())){
                    ingresado = true;
                }
            }
            if(!ingresado){
                listadoParqueadero.add(new Parqueadero(id, placa));
                id++;
                Toast.makeText(this, "Vehiculo ingresado", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "El vehiculo se encuentra dentro del parqueadero",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    public void salida(View v){
        int pos = -1;
        for (int i = 0; i<listadoParqueadero.size(); i++){
            if(listadoParqueadero.get(i).getPlaca().equals(placa) &&
                    listadoParqueadero.get(i).getFechaHoraSalida().equals("En curso")){
                pos = i;
            }
        }
        if (pos != -1){
            listadoParqueadero.get(pos).setFechaHoraSalida();
            Toast.makeText(this, "Salida registrada. Tiempo consumido: "+
                    listadoParqueadero.get(pos).tiempoConsumido()+" minutos",
                    Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Vehiculo no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarInforme(View v){
        Intent i = new Intent(this, ReportActivity.class);
        i.putExtra("reporte", listadoParqueadero);
        startActivity(i);
    }


}