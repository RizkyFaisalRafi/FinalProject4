package com.rifara.travelling;

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
import com.rifara.travelling.Adapter.PaymentAdapter;
import com.rifara.travelling.Model.Payment;
import com.rifara.travelling.databinding.ActivityPaymentBinding;
import com.rifara.travelling.ui.DetailPesananActivity;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final List<Payment> list = new ArrayList<>();
    private PaymentAdapter paymentAdapter;
    private Preferences preferences;
    String price, nameBus, pessenger, from, to, pickUp, dropOff, timeStart, timeEnd, longTime, date, type, distance, seats, imgbus, iconPayment, methodPayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        com.rifara.travelling.databinding.ActivityPaymentBinding binding = ActivityPaymentBinding.inflate(getLayoutInflater());
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
        imgbus = detail.getString("imgbus");
        price = detail.getString("price");

        RecyclerView recyclerView = findViewById(R.id.recycler_view_payment);
        paymentAdapter = new PaymentAdapter(PaymentActivity.this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(paymentAdapter);

        getMethodPayment();

        paymentAdapter.setOnItemClickCallback(this::showSelectedPayment);

    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        startActivity(new Intent(PaymentActivity.this, DetailPesananActivity.class));
//    }

    private void getMethodPayment() {
        db.collection("Payment").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                    Payment payment = new Payment(documentSnapshot.getString("img"), documentSnapshot.getString("method"));
                    list.add(payment);
                }
                paymentAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Server Error", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(e -> Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show());
    }

    private void showSelectedPayment(Payment payment) {
        Intent intent = new Intent(PaymentActivity.this, DetailPesananActivity.class);
        preferences.getEditor().putString("methodPayment", payment.getMethod()).apply();
        preferences.getEditor().putString("iconPayment", payment.getIcon()).apply();
        intent.putExtra("pessenger", pessenger);
        intent.putExtra("nameBus", nameBus);
        intent.putExtra("from", from);
        intent.putExtra("to", to);
        intent.putExtra("drop_off", dropOff);
        intent.putExtra("pick_up",pickUp);
        intent.putExtra("time_start", timeStart);
        intent.putExtra("time_end", timeEnd);
        intent.putExtra("long_time", longTime);
        intent.putExtra("type", type);
        intent.putExtra("price", price);
        intent.putExtra("date", date);
        intent.putExtra("imgbus", imgbus);
        startActivity(intent);
    }
}