package com.example.TrabTelaRolavel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.exemplorolavel.R;

import java.util.List;

public class ItemListAdapter extends BaseAdapter {
    List<Item> itens;
    Context ctx;
    public ItemListAdapter(List<Item> itens, Context ctx){
        this.itens = itens;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int i) {
        return itens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(ctx);
        View itemLayout = inflater.inflate(R.layout.item_valor, null);

        TextView txtValorItem = itemLayout.findViewById(R.id.txtNomeItem);
        TextView txtIdadeItem = itemLayout.findViewById(R.id.txtfcmItem);
        txtValorItem.setText(itens.get(i).getNome());
        txtIdadeItem.setText("FCM: "+ itens.get(i).getFCM());
        return itemLayout;
    }
}
