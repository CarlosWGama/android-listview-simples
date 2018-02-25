package br.com.carloswgama.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> listaItens = new ArrayList<String>();
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.minha_listview);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listaItens.remove(position);
                atualizarLista();
            }
        });
    }

    public void botao(View v) {
        EditText campoTexto = findViewById(R.id.et_texto);
        listaItens.add(campoTexto.getText().toString());
        campoTexto.setText("");
        atualizarLista();
    }

    private void atualizarLista() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listaItens);
        lista.setAdapter(adapter);
    }
}
