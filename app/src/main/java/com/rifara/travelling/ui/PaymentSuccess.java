package com.rifara.travelling.ui;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.rifara.travelling.Preferences;
import com.rifara.travelling.R;
import com.rifara.travelling.databinding.ActivityDetailPesananBinding;
import com.rifara.travelling.databinding.ActivityPaymentSuccessBinding;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PaymentSuccess extends AppCompatActivity implements View.OnClickListener {
    private ActivityPaymentSuccessBinding binding;
    int price, totalprice, pessengers;

    private Preferences preferences;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String nameBus, pessenger, from, to, pickUp, dropOff, timeStart, timeEnd, longTime, date, type, distance, seats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
        binding = ActivityPaymentSuccessBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        preferences = new Preferences(this);
        Bundle detail = getIntent().getExtras();

        nameBus = detail.getString("nameBus");
        from = detail.getString("from");
        to = detail.getString("to");
        pickUp = detail.getString("pick_up");
        dropOff = detail.getString("drop_off");
        date = detail.getString("date");
        type = detail.getString("type");
        pessenger = detail.getString("pessenger");
        price = Integer.parseInt(detail.getString("price"));


        pessengers = Integer.parseInt(pessenger);
        totalprice = price * pessengers;

        

    }

    @Override
    public void onClick(View view) {
        Map<String, Object> detail = new HashMap<>();
        detail.put("name bus", nameBus );
        detail.put("from", from);
        detail.put("to", to);
        detail.put("pessenger", pessenger);
        detail.put("pick up", pickUp);
        detail.put("date", date);
        detail.put("type", type);
        detail.put("price", String.valueOf(price));
        detail.put("total price", String.valueOf(totalprice));
        detail.put("kode seat", seats);
        db.collection("Booking")
                .add(detail)
                .addOnSuccessListener(documentReference -> {
                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    Toast.makeText(PaymentSuccess.this, "Berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
    }
    protected void onResume() {
        super.onResume();
        seats = preferences.getSharedPreferences().getString("kodeseat", null);
        if (seats != null){
            binding.tvSeat.setText(seats);
        }
    }
    protected void onStart() {
        super.onStart();
        binding.tvNameBus.setText(nameBus);
        binding.tvDariKota.setText(from);
        binding.tvKeKota.setText(to);
        binding.tvTgl.setText(date);
        binding.tvTicket.setText(type);
        binding.tvTotalPrice.setText(getPrice(totalprice));
        binding.tvPessenger.setText(pessenger);
    }

    private String getPrice(double price){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(price);
    }
}