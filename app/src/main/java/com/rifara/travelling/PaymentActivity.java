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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        com.rifara.travelling.databinding.ActivityPaymentBinding binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        preferences = new Preferences(this);

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
        startActivity(intent);
    }
}