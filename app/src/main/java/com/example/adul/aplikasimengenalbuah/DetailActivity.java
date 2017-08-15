package com.example.adul.aplikasimengenalbuah;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fab.setVisibility(View.GONE);

        Intent a = getIntent();
        String nama = a.getStringExtra("nama");
        int gambar = a.getIntExtra("gambar", 0);
        final int suara = a.getIntExtra("suara", 0);

        TextView textView = (TextView) findViewById(R.id.detailjudul);
        ImageView imageView = (ImageView) findViewById(R.id.detailgambar);
        textView.setText(nama);
        imageView.setImageResource(gambar);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MemutarMusik(suara);
            }
        });
    }

    private void MemutarMusik(int posisi) {
        final Uri uri = Uri.parse("android.resource://"+getPackageName()
                +"/"+posisi);
        MediaPlayer musik = new MediaPlayer();

        musik.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            musik.setDataSource(getApplicationContext(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            musik.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        musik.start();
    }
}
