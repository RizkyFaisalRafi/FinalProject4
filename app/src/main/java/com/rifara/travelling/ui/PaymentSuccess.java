package com.rifara.travelling.ui;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.rifara.travelling.MainActivity;
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
    int totalprice;
    float myRating = 0;

    String nameBus, pessenger, from, to, date, type, seats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentSuccessBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                int rating = (int) v;
                String message = null;

                myRating = ratingBar.getRating();

                switch (rating){
                    case 1:
                        message = "Sorry to hear that :(";
                        break;
                    case 2:
                        message = "You always accept suggestions";
                        break;
                    case 3:
                        message = "Good enough!";
                        break;
                    case 4:
                        message = "Great!, thank you";
                        break;
                    case 5:
                        message = "Awesome!, thank you";
                        break;
                }

                Toast.makeText(PaymentSuccess.this, message, Toast.LENGTH_SHORT).show();
            }
        });


        binding.buttonHome.setOnClickListener(view1 -> {
            startActivity(new Intent(PaymentSuccess.this , MainActivity.class));
        });

        Bundle detail = getIntent().getExtras();
        nameBus = detail.getString("namabus");
        from = detail.getString("from");
        to = detail.getString("to");
        date = detail.getString("tgl");
        type = detail.getString("ticket");
        pessenger = detail.getString("pessenger");
        seats =detail.getString("seat");
        totalprice = Integer.parseInt(detail.getString("totalPrice"));

        binding.tvNameBus.setText(nameBus);
        binding.tvDariKota.setText(from);
        binding.tvKeKota.setText(to);
        binding.tvTgl.setText(date);
        binding.tvTicket.setText(type);
        binding.tvSeat.setText(seats);
        binding.tvTotalPrice.setText(getPrice(totalprice));
        binding.tvPessenger.setText(pessenger);

    }

    private String getPrice(double price){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(price);
    }
}