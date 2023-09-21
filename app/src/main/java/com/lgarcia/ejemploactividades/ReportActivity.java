package com.lgarcia.ejemploactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {

    ArrayList<Parqueadero> reporte;
    ParqueaderoAdapter adapter;
    ListView listReporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        listReporte = findViewById(R.id.listReporte);

        reporte = (ArrayList<Parqueadero>) getIntent().getSerializableExtra("reporte");
        adapter = new ParqueaderoAdapter(this,reporte);
        listReporte.setAdapter(adapter);

    }
}