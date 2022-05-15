package com.uni.uniformania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button inicio_sesion, btn_mostrar_cont;
    CheckBox estado;
    EditText varusuario,varpass;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        varusuario =(EditText) findViewById(R.id.usuario);
        varpass=(EditText) findViewById(R.id.pass);
        estado = (CheckBox)findViewById(R.id.check_bx_guadarDatos) ;
        CargarPreferencias();

        inicio_sesion = (Button) findViewById(R.id.btningresar);
        inicio_sesion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), Main_drawer.class);
                startActivityForResult(intent, 0);
                GuardarPreferencias();
                Toast.makeText(getApplicationContext(), "Se han guardado sus datos de usuario", Toast.LENGTH_LONG).show();
            }
        });

        btn_mostrar_cont = (Button)findViewById(R.id.btn_mostrar_password);
        btn_mostrar_cont.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event)
            {
                switch ( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        varpass.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case MotionEvent.ACTION_UP:
                        varpass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;
                }
                return true;
            }
        });
    }

    public void CargarPreferencias()
    {
        SharedPreferences mispreferencias = getSharedPreferences ("PreferenciasUsuario", Context.MODE_PRIVATE);
        estado.setChecked(mispreferencias.getBoolean("checked", false));
        varusuario.setText(mispreferencias.getString("usuario",""));
        varpass.setText(mispreferencias.getString("contraseña",""));
    }
    public void GuardarPreferencias()
    {
        SharedPreferences mispreferencias = getSharedPreferences ("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        boolean valor= estado.isChecked();
        editor.putBoolean("checked", valor);
        String usuario = varusuario.getText().toString();
        editor.putString("usuario", usuario);
        String contraseña = varpass.getText().toString();
        editor.putString("contraseña", contraseña);
        editor.commit();
    }
}