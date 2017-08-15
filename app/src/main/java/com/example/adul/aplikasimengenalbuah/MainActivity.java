package com.example.adul.aplikasimengenalbuah;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String nama[] = {
            "Alpukat","Apel","Ceri","Durian","Jambu Air","Manggis","Strowbery",
    };

    int gambar[] = {
            R.drawable.alpukat,R.drawable.apel,R.drawable.ceri,R.drawable.durian,
            R.drawable.jambu_air,R.drawable.manggis,R.drawable.strawberry
    };

    int suara[] = {
            R.raw.alpukat,R.raw.apel,R.raw.ceri,R.raw.durian,R.raw.jambu_air,
            R.raw.manggis,R.raw.strawberry
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        ListAdapter adapter = new ListAdapter(this, gambar, nama);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long jumlahTotalData) {
//                MemutarMusik(position);
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("nama", nama[position]);
                int img = gambar[position];
                intent.putExtra("gambar", img);
                intent.putExtra("suara", suara[position]);
                startActivity(intent);
            }
        });
    }


}
