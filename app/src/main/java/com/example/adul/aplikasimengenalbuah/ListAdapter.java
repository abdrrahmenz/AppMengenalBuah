package com.example.adul.aplikasimengenalbuah;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by adul on 20/11/16.
 */

public class ListAdapter extends ArrayAdapter {

    private final Activity activ;
    private final int gambar[];
    private final String nama[];

    public ListAdapter(Activity activity, int[] gambar, String[] nama) {
        super(activity, R.layout.list_item, nama);
        this.activ = activity;
        this.gambar = gambar;
        this.nama = nama;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = activ.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_item,null);
        TextView textView = (TextView) view.findViewById(R.id.txtJudul);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        textView.setText(nama[position]);
        imageView.setImageResource(gambar[position]);

        return view;
    }
}
