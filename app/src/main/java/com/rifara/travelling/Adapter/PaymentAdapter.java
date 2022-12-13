package com.rifara.travelling.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rifara.travelling.Model.Payment;
import com.rifara.travelling.R;

import java.util.List;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ListViewHolder> {

    private final Context context;
    private final List<Payment> list;
    private PaymentAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(PaymentAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public PaymentAdapter(Context context, List<Payment> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PaymentAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_payment, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentAdapter.ListViewHolder holder, int position) {
        holder.method.setText(list.get(position).getMethod());
        Glide.with(context).load(list.get(position).getIcon()).error(R.drawable.ic_launcher_background).centerCrop().into(holder.icon);

        holder.itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(list.get(holder.getAdapterPosition())));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView method;
        ImageView icon;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            method = itemView.findViewById(R.id.method);
            icon = itemView.findViewById(R.id.icon_payment);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Payment data);
    }
}
