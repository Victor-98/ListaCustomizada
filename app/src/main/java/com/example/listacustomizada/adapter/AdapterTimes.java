package com.example.listacustomizada.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listacustomizada.R;
import com.example.listacustomizada.model.Time;

import java.util.List;

public class AdapterTimes extends RecyclerView.Adapter<AdapterTimes.MyViewHolder> {

    private List<Time> listTimes;

    public AdapterTimes(List<Time> list) {
        this.listTimes = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, location;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.textViewName);
            location = view.findViewById(R.id.textViewLocation);
            img = view.findViewById(R.id.imageViewTime);
        }

    }

    //Métodos que precisam ser implementados para este tipo de adapter
    @NonNull
    @Override
    // Cria a lista em tempo real, retornando célula a célula
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_times, parent, false);

        return new MyViewHolder(listItem);
    }

    @Override
    //Mostra os componentes de uma célula
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Time obj = listTimes.get(position);
        holder.name.setText(obj.getName());
        holder.location.setText(obj.getLocation());
        holder.img.setImageResource(obj.getImg());
    }

    @Override
    //Informa o tamanho da lista
    public int getItemCount() {
        return listTimes.size();
    }
    //Fim dos métodos que precisam ser implementados

}
