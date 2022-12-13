package com.rifara.travelling.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rifara.travelling.R;
import com.rifara.travelling.Model.User;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> userArrayList;

    public HistoryAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, int position) {

        User user = userArrayList.get(position);

        holder.nameBus.setText(user.getNameBus());
        holder.date.setText(user.getDate());
        holder.from.setText(user.getFrom());
        holder.to.setText(user.getTo());
        holder.passenger.setText(user.getPessenger());
        holder.totalPrice.setText(user.getTotalPrice());

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameBus, date, from, to, passenger, totalPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameBus = itemView.findViewById(R.id.tv_name_bus);
            date = itemView.findViewById(R.id.tv_tanggal);
            from = itemView.findViewById(R.id.tv_dari_kota);
            to = itemView.findViewById(R.id.tv_ke_kota);
            passenger = itemView.findViewById(R.id.tv_jumlah_penumpang);
            totalPrice = itemView.findViewById(R.id.tv_harga);
        }
    }
}
