package com.rifara.travelling.History;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rifara.travelling.R;

import java.util.ArrayList;
import java.util.Locale;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ItemHolder>{

    private Context context2;
    private ArrayList<Item> items;

    public CardAdapter(Context context2, ArrayList<Item> items) {
        this.context2 = context2;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context2).inflate(R.layout.history_list,parent,false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ItemHolder holder, int position) {

        Item item = items.get(position);
        holder.nama_bus.setText(item.getNama_bus());
        holder.pessenger.setText(item.getPessenger());
        holder.drop_off.setText(item.getDrop_off());
        holder.pick_up.setText(item.getPick_up());
        holder.date.setText(item.getDate());
        holder.from.setText(item.getPessenger());
        holder.kode_seat.setText(item.getPessenger());
        holder.long_time.setText(item.getPessenger());
        holder.to.setText(item.getPessenger());
        holder.type.setText(item.getPessenger());
        holder.distance.setText(item.getDistance());
        holder.time_end.setText(item.getTime_end());
        holder.time_start.setText(item.getTime_start());
        holder.total_price.setText(item.getTotal_price());
        holder.price.setText(item.getPrice());


    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        private TextView nama_bus,drop_off,pick_up,date,from,kode_seat,long_time, to,type,pessenger,distance,price,time_end,time_start,total_price;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            nama_bus = itemView.findViewById(R.id.tvnama_bus);
            pessenger = itemView.findViewById(R.id.tvpessanger);
            drop_off = itemView.findViewById(R.id.tvdrop_off);
            pick_up = itemView.findViewById(R.id.tvpick_up);
            date = itemView.findViewById(R.id.tvdate);
            from = itemView.findViewById(R.id.tvfrom);
            kode_seat = itemView.findViewById(R.id.tvset);
            long_time = itemView.findViewById(R.id.tvlong_time);
            to = itemView.findViewById(R.id.tvto);
            type = itemView.findViewById(R.id.tvtype);
            price = itemView.findViewById(R.id.tvprice);
            total_price = itemView.findViewById(R.id.tvtotal_price);
            time_start = itemView.findViewById(R.id.tvtime_start);
            time_end = itemView.findViewById(R.id.tvtime_start);
            distance = itemView.findViewById(R.id.tvdistance);




        }

    }
}
