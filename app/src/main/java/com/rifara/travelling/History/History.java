package com.rifara.travelling.History;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.protobuf.Value;
import com.rifara.travelling.MainActivity;
import com.rifara.travelling.R;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<Item> itemArrayList;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    private CardAdapter adapter;
    private ArrayList<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data..");
        progressDialog.show();

        recyclerView = findViewById(R.id.recycle_View);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db=FirebaseFirestore.getInstance();
        itemArrayList = new ArrayList<Item>();
        adapter=new CardAdapter(History.this,itemArrayList);
        recyclerView.setAdapter(adapter);
        EventChangeListener();
    }

    private void EventChangeListener() {
        db.collection("Booking")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();

                            Log.e("Firebase Eror", error.getMessage());
                            return;
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                itemArrayList.add(dc.getDocument().toObject(Item.class));
                            }
                            adapter.notifyDataSetChanged();
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            }

                        }
                    });

                }
    }