package com.example.listacustomizada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listacustomizada.model.Time;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent it = getIntent();
        // Certifica que intent pode ser recebido.
        if (it == null)
            return;

        Bundle params = it.getExtras();
        // Certifica que os parâmetros foram enviados corretamente.
        if (params == null)
            return;

        Time time =  (Time) params.getSerializable("time");

        // Carrega os elementos de UI nas variáveis :
        TextView textViewNomeTime = findViewById(R.id.textViewNomeTime);
        ImageView imageViewLogo = findViewById(R.id.imageViewInfoTime);
        TextView textViewInfoLocation = findViewById(R.id.textViewInfoLocation);
        TextView textViewInfoTitulos = findViewById(R.id.textViewInfoTitulos);

        textViewNomeTime.setText(time.getName());
        System.out.println("Image : " + time.getImg());

        //imageViewLogo.setImageResource( R.drawable.cap );
        imageViewLogo.setImageResource( time.getImg());


        textViewInfoLocation.setText(time.getLocation());
        textViewInfoTitulos.setText(time.getTitulos());

    }
}