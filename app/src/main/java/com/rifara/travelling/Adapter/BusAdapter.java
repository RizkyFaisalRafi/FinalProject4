package com.rifara.travelling.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rifara.travelling.ui.DetailPesananActivity;
import com.rifara.travelling.Model.Bus;
import com.rifara.travelling.R;

import java.util.List;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ListViewHolder> {
    private final Context context;
    private final List<Bus> list;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public BusAdapter(Context context, List<Bus> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BusAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bustrav, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BusAdapter.ListViewHolder holder, int position) {
        Bus bus = list.get(position);
        holder.namaBus.setText(list.get(position).getNamaBus());
        holder.naik.setText(list.get(position).getPickUp());
        holder.turun.setText(list.get(position).getDropOff());
        holder.type.setText(list.get(position).getType());
        holder.harga.setText("Rp. " + list.get(position).getPrice());
        holder.waktu.setText(list.get(position).getTime());
        holder.start.setText(list.get(position).getTime_start());
        holder.end.setText(list.get(position).getTime_end());

//        holder.bookNow.setOnClickListener(view -> {
//            Intent intent = new Intent(context.getApplicationContext(), DetailPesananActivity.class);
//            context.startActivity(intent);
//        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(list.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView namaBus, harga, naik, turun, waktu, type, start, end;
        Button bookNow;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            namaBus = itemView.findViewById(R.id.namebus);
            harga = itemView.findViewById(R.id.price);
            naik = itemView.findViewById(R.id.dari);
            turun = itemView.findViewById(R.id.tiba);
            waktu = itemView.findViewById(R.id.time);
            type = itemView.findViewById(R.id.typeBus);
            start = itemView.findViewById(R.id.time_start);
            end = itemView.findViewById(R.id.time_end);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(Bus data);
    }
}
