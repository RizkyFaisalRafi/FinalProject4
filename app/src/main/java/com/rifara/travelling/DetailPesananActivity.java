package com.rifara.travelling;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rifara.travelling.databinding.ActivityDetailPesananBinding;
import com.rifara.travelling.databinding.ActivitySearchBinding;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.prefs.Preferences;

public class DetailPesananActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityDetailPesananBinding binding;
    int price, totalprice, pessengers;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String nameBus, pessenger, from, to, pickUp, dropOff, timeStart, timeEnd, longTime, date, type, distance, seats, imgbus;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailPesananBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

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
//        Toast.makeText(this, ""+imgbus, Toast.LENGTH_SHORT).show();


        pessengers = Integer.parseInt(pessenger);
        totalprice = price * pessengers;

        binding.bookNow.setOnClickListener(this);
        binding.btChooseSeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailPesananActivity.this, SeatActivity.class);
                intent.putExtra("total_pessenger", pessenger);
                startActivity(intent);
            }
        });
        binding.imgBack.setOnClickListener(view1 -> {
            startActivity(new Intent(DetailPesananActivity.this, SearchActivity.class));
        });
        getImageBus();
  }

    @Override
    protected void onResume() {
        super.onResume();
//        seats = getIntent().getStringExtra("kode_seat");  //gagal get kode seat
//        seats = getIntent().getStringExtra("total_seat");
//        binding.tvSeat.setText(seats);
//        Toast.makeText(this, "ini seat detail" +seats, Toast.LENGTH_SHORT).show();
    }

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

//        seats = getIntent().getStringExtra("total_seat"); //gagal get data seat
//        binding.tvSeat.setText(seats);
//        Toast.makeText(this, "ini seat detail" +seats, Toast.LENGTH_SHORT).show();

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

// Add a new document with a generated ID
        db.collection("Booking")
                .add(detail)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText(DetailPesananActivity.this, "Berhasil ditambahkan", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    private void getImageBus(){
        Glide.with(DetailPesananActivity.this)
                .load(imgbus)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                        return false;
                    }
                })
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