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

public class PaymentSuccess extends AppCompatActivity {
    private ActivityPaymentSuccessBinding binding;
    int price, totalprice, pessengers;

    String nameBus, pessenger, from, to, date, type, seats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentSuccessBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Bundle detail = getIntent().getExtras();

        nameBus = detail.getString("namebus");
        from = detail.getString("from");
        to = detail.getString("to");
        date = detail.getString("date");
        type = detail.getString("ticket");
        pessenger = detail.getString("pessenger");
        seats =detail.getString("seat");
        price= Integer.parseInt(detail.getString("totalPrice"));

        

    }


    protected void onResume() {
        super.onResume();
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