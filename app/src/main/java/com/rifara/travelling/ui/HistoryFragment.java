package com.rifara.travelling.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.rifara.travelling.Adapter.HistoryAdapter;
import com.rifara.travelling.R;
import com.rifara.travelling.User;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<User> userArrayList;
    HistoryAdapter historyAdapter;
    FirebaseFirestore firebaseFirestore;
    Button nilai;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view_historyy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));


        firebaseFirestore = FirebaseFirestore.getInstance();
        userArrayList = new ArrayList<User>();
        historyAdapter = new HistoryAdapter(requireActivity(), userArrayList);

        recyclerView.setAdapter(historyAdapter);

        EventChangeListener();
    }

    private void EventChangeListener() {

//        nilai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getActivity(), RatingActivity.class));
//            }
//        });


        firebaseFirestore.collection("Booking")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null) {
                            Log.e("Firestore Error", error.getMessage());
                            return;
                        }

                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                userArrayList.add(dc.getDocument().toObject(User.class));
                            }

                            historyAdapter.notifyDataSetChanged();

                        }


                    }
                });

    }
}