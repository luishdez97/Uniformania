package com.uni.uniformania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Consulta_Inventario extends AppCompatActivity {

    Button busqueda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_inventario);

        busqueda = (Button) findViewById(R.id.btn_busq_producto);
        busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent (view.getContext(), Busqueda_producto.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}