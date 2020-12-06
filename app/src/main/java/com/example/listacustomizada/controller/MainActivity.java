package com.example.listacustomizada.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.listacustomizada.InfoActivity;
import com.example.listacustomizada.R;
import com.example.listacustomizada.adapter.AdapterTimes;
import com.example.listacustomizada.model.Time;
import com.example.listacustomizada.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTimes;
    private List<Time> listTimes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTimes = findViewById(R.id.recyclerViewTimes);

        // Configurar o adapter
        this.createTime();
        AdapterTimes adapter = new AdapterTimes(listTimes);

        //Configurar RecyclerView utilizando um layout linear
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerViewTimes.setLayoutManager(layoutManager);
        //Otimizar o RecyclerView
        recyclerViewTimes.setHasFixedSize(true);

        //Insere um divisor entre as células
        recyclerViewTimes.addItemDecoration(
                new DividerItemDecoration(this, LinearLayout.VERTICAL));

        //Liga o adapter ao recycler
        recyclerViewTimes.setAdapter(adapter);

        //evento de clique
        recyclerViewTimes.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewTimes,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Time obj = listTimes.get(position);

                                Intent it = new Intent(MainActivity.this, InfoActivity.class);
                                Bundle params = new Bundle();
                                params.putSerializable("time", obj);
                                it.putExtras(params);
                                startActivity(it);

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Clique longo",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }

    public void createTime() {
        Time obj = new Time(R.drawable.cap, "Athletico", "Curitiba, PR", "Campeão da Sul Americana 2018\nVice Campeão da Recopa 2019\nCampeão da Copa do Brasil 2019");
        listTimes.add(obj);

        obj = new Time(R.drawable.cfc, "Coritiba", "Curitiba, PR", "Campeonato Paranaense 2013 e 2017");
        listTimes.add(obj);

        obj = new Time(R.drawable.fla, "Flamengo", "Rio de Janeiro, RJ", "Campeão da Supercopa do Brasil 2020\nCampeão Campeonato Brasileiro 2019\nCampeão Libertadores 2019");
        listTimes.add(obj);

        obj = new Time(R.drawable.pal, "Palmeiras", "São Paulo, SP", "Campeonato Brasileiro 2018\nCampeonato Paulista 2020");
        listTimes.add(obj);
    }
}