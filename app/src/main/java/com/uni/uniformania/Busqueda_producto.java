package com.uni.uniformania;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;

public class Busqueda_producto extends AppCompatActivity {

    String MenuProducto[] = null;
    String[] producto=null;
    private ListView listViewProducto;
    ArrayAdapter<String> adapterProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_producto);
/*
        listViewProducto = (ListView)findViewById(R.id.id_listview_producto);
        listViewProducto.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l )
            {
                String cadena = adapterProducto.getItem(i);
                String[] division = cadena.split("  ---  ");
                String codigo = division[0];
               // globalClass.setCodigo_Prod(codigo);
                finish();
            }
        });

        MenuProducto=producto;
        adapterProducto=new ArrayAdapter<String>
                (
                        this ,R.layout.apariencia_list_view, MenuProducto
                );
        listViewProducto.setAdapter(adapterProducto);
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_busq_producto, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_busq_prod);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                adapterProducto.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menu_busq_prod)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}