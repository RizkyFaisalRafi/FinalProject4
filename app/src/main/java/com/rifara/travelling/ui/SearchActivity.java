package com.rifara.travelling.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.rifara.travelling.Adapter.BusAdapter;
import com.rifara.travelling.Model.Bus;
import com.rifara.travelling.R;
import com.rifara.travelling.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final List<Bus> list = new ArrayList<>();
    private BusAdapter busAdapter;
    private ActivitySearchBinding binding;
    String from,to, distance, date, imgbus ;
    int pessenger;

    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);

        //view binding
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        RecyclerView recyclerView = findViewById(R.id.rvSearch);
        busAdapter = new BusAdapter(SearchActivity.this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(busAdapter);

        //get & set
        Bundle data = getIntent().getExtras();
        binding.fromSearch.setText(data.getString("from"));
        binding.toSearch.setText(data.getString("to"));

        date = data.getString("date");
        pessenger = Integer.parseInt(data.getString("pessengers"));
        distance = data.getString("jarak") + " km";
        imgbus = data.getString("imgBus");

        binding.dateSearch.setText(date + " - " + pessenger +" pessengers" + " - " + distance);
        from = binding.fromSearch.getText().toString();
        to = binding.toSearch.getText().toString();
        getBus();

        busAdapter.setOnItemClickCallback(data1 -> showSelectedBus(data1));
        binding.back.setOnClickListener(view1 -> startActivity(new Intent(SearchActivity.this, MainActivity.class)));
    }


    @SuppressLint("NotifyDataSetChanged")
    private void getBus(){
        binding.simpleProgressBar.setVisibility(View.VISIBLE);
        if (from.equals("Probolinggo") && to.equals("Pasuruan")) {
            db.collection("Probolinggo - Pasuruan")
                    .get()
                    .addOnCompleteListener(task -> {
                        list.clear();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                //adapter
                                Bus bus = new Bus(documentSnapshot.getString("nama_bus"), documentSnapshot.getString("naik"), documentSnapshot.getString("turun"),
                                        documentSnapshot.getString("harga"), documentSnapshot.getString("type"), documentSnapshot.getString("waktu"),
                                        documentSnapshot.getString("start"), documentSnapshot.getString("end"));
                                list.add(bus);
                            }
                            busAdapter.notifyDataSetChanged();
                            binding.simpleProgressBar.setVisibility(View.GONE);
                        } else {
                            Toast.makeText(this, "Data gagal diambil", Toast.LENGTH_SHORT).show();
                            binding.simpleProgressBar.setVisibility(View.GONE);
                        }
                    }).addOnFailureListener(e -> Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show());
        }else if (from.equals("Pasuruan") && to.equals("Surabaya")) {
            db.collection("Pasuruan - Surabaya")
                    .get()
                    .addOnCompleteListener(task -> {
                        list.clear();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                                //adapter
                                Bus bus = new Bus(documentSnapshot.getString("nama_bus"), documentSnapshot.getString("naik"), documentSnapshot.getString("turun"),
                                        documentSnapshot.getString("harga"), documentSnapshot.getString("type"), documentSnapshot.getString("waktu"),
                                        documentSnapshot.getString("start"), documentSnapshot.getString("end"));
                                list.add(bus);
                            }
                            busAdapter.notifyDataSetChanged();
                            binding.simpleProgressBar.setVisibility(View.GONE);
                        } else {
                            Toast.makeText(this, "Data gagal diambil", Toast.LENGTH_SHORT).show();
                            binding.simpleProgressBar.setVisibility(View.GONE);
                        }
                    }).addOnFailureListener(e -> Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show());
        }else if (from.equals("Surabaya") && to.equals("Gresik")){
            db.collection("Surabaya - Gresik")
                    .get()
                    .addOnCompleteListener(task -> {
                        list.clear();
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                //adapter
                                Bus bus = new Bus(documentSnapshot.getString("nama_bus"), documentSnapshot.getString("naik"), documentSnapshot.getString("turun"),
                                        documentSnapshot.getString("harga"), documentSnapshot.getString("type"), documentSnapshot.getString("waktu"),
                                        documentSnapshot.getString("start"), documentSnapshot.getString("end"));
                                list.add(bus);
                            }
                            busAdapter.notifyDataSetChanged();
                            binding.simpleProgressBar.setVisibility(View.GONE);
                        }else{
                            Toast.makeText(this, "Data gagal diambil", Toast.LENGTH_SHORT).show();
                            binding.simpleProgressBar.setVisibility(View.GONE);
                        }
                    }).addOnFailureListener(e -> Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show());
        }else {
            binding.simpleProgressBar.setVisibility(View.GONE);
            binding.busNotFound.setVisibility(View.VISIBLE);
        }
    }

    private void showSelectedBus(Bus bus) {
        Intent detail = new Intent(SearchActivity.this, DetailPesananActivity.class);
        detail.putExtra("nameBus", bus.getNamaBus());
        detail.putExtra("pick_up", bus.getPickUp());
        detail.putExtra("drop_off", bus.getDropOff());
        detail.putExtra("price", bus.getPrice());
        detail.putExtra("type", bus.getType());
        detail.putExtra("long_time", bus.getTime());
        detail.putExtra("time_start", bus.getTime_start());
        detail.putExtra("time_end", bus.getTime_end());
        detail.putExtra("pessenger", String.valueOf(pessenger));
        detail.putExtra("from" , binding.fromSearch.getText().toString());
        detail.putExtra("to" , binding.toSearch.getText().toString());
        detail.putExtra("date" , date);
        detail.putExtra("distance" , distance);
        detail.putExtra("imgbus", imgbus);
        startActivity(detail);
    }

//    private String getPrice(double price){
//        Locale localeID = new Locale("in", "ID");
//        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
//        return formatRupiah.format(price);
//    }
}