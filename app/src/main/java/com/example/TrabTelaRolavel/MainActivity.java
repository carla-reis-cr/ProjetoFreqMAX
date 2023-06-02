package com.example.TrabTelaRolavel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exemplorolavel.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtNome;
    EditText txtIdade;
    ListView listItens;
    ItemListAdapter adapter;
    List<Item> itens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = findViewById(R.id.txtNome);
        txtIdade = findViewById(R.id.txtIdade);
        listItens = findViewById(R.id.listItens);

        adapter = new ItemListAdapter(itens, getBaseContext());
        listItens.setAdapter(adapter);
    }


    public void addItem(View v) {
        String nome = txtNome.getText().toString();
        String idadeText = txtIdade.getText().toString();

        if (nome.isEmpty() || idadeText.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        int auxIdade;

        try {
            auxIdade = 200 - Integer.parseInt(idadeText);
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Por favor, insira uma idade válida.", Toast.LENGTH_SHORT).show();
            return;
        }

        Item it = new Item();
        it.setNome(nome);
        it.setFCM(String.valueOf(auxIdade));

        txtNome.setText("");
        txtIdade.setText("");

        itens.add(it);
        adapter.notifyDataSetChanged();
    }
}