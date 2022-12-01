package com.rifara.travelling;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rifara.travelling.databinding.ActivityDetailPesananBinding;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DetailPesananActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityDetailPesananBinding binding;
    int price, totalprice, pessengers;

    private Preferences preferences;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String nameBus, pessenger, from, to, pickUp, dropOff, timeStart, timeEnd, longTime, date, type, distance, seats, imgbus;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailPesananBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        preferences = new Preferences(this);
        Bundle detail = getIntent().getExtras();
        nameBus = detail.getString("nameBus");
        from = detail.getString("from");
        to = detail.getString("to");
        pickUp = detail.getString("pick_up");
        dropOff = detail.getString("drop_off");
        timeStart = detail.getString("time_start");
        timeEnd = detail.getString("time_end");
        longTime = detail.getString("long_time");
        date = detail.getString("date");
        type = detail.getString("type");
        imgbus = detail.getString("imgbus");
        distance = detail.getString("distance");
        pessenger = detail.getString("pessenger");
        price = Integer.parseInt(detail.getString("price"));


        pessengers = Integer.parseInt(pessenger);
        totalprice = price * pessengers;

        binding.bookNow.setOnClickListener(this);
        binding.btChooseSeat.setOnClickListener(view12 -> {
            Intent intent = new Intent(DetailPesananActivity.this, SeatActivity.class);
            intent.putExtra("total_pessenger", pessenger);
            startActivity(intent);
        });
        binding.imgBack.setOnClickListener(view1 -> startActivity(new Intent(DetailPesananActivity.this, SearchActivity.class)));
        getImageBus();
  }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        super.onStart();
        binding.nameBusDetail.setText(nameBus);
        binding.fromDetail.setText(from);
        binding.toDetail.setText(to);
        binding.pickUpDetail.setText(pickUp);
        binding.dropOffDetail.setText(dropOff);
        binding.timeStartDetail.setText(timeStart);
        binding.timeEndDetail.setText(timeEnd);
        binding.longTimeDetail.setText(longTime);
        binding.dateDetail.setText(date);
        binding.tvClass.setText(type);
        binding.totalPrice.setText(getPrice(totalprice));
        binding.pessengersDetail.setText(pessenger + " Pessengers");

        seats = preferences.getSharedPreferences().getString("kodeseat", "0");

        binding.tvSeat.setText(seats);
        preferences.getEditor().clear().apply();
    }

    @Override
    public void onClick(View view) {
        Map<String, Object> detail = new HashMap<>();
        detail.put("name bus", nameBus );
        detail.put("from", from);
        detail.put("to", to);
        detail.put("pessenger", pessenger);
        detail.put("pick up", pickUp);
        detail.put("drop off", dropOff);
        detail.put("time start", timeStart);
        detail.put("time end", timeEnd);
        detail.put("long time", longTime);
        detail.put("date", date);
        detail.put("type", type);
        detail.put("distance", distance);
        detail.put("price", String.valueOf(price));
        detail.put("total price", String.valueOf(totalprice));
        detail.put("kode seat", seats);

// Add a new document with a generated ID
        db.collection("Booking")
                .add(detail)
                .addOnSuccessListener(documentReference -> {
                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    Toast.makeText(DetailPesananActivity.this, "Berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                })
                .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
    }

    private void getImageBus(){
        Glide.with(DetailPesananActivity.this)
                .load(imgbus)
                .error(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(binding.imgBus);
    }

    private String getPrice(double price){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(price);
    }
}