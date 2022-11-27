package com.rifara.travelling.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.firestore.FirebaseFirestore;
import com.rifara.travelling.R;
import com.rifara.travelling.databinding.FragmentHomeBinding;

import java.util.Calendar;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FragmentHomeBinding binding;
    FirebaseFirestore db;
    private int penumpang = 0;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener setListener;
    RadioButton rb;
    String nameBus, linkBus = "";
    int price,longTime;
    double jarak;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        binding.btSearchBus.setOnClickListener(this);

// Spinner from
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Kota, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.from.setAdapter(adapter);
//Spinner To
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.Tujuan, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.to.setAdapter(adapter1);

//count penumpang
        binding.plus.setOnClickListener(this);
        binding.minus.setOnClickListener(this);

// select Date
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        binding.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePickerDialog = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month+1;
                String Month = String.valueOf(month);
                String date = dayOfMonth+"/"+Month+"/"+year;
                binding.date.setText(date);

            }
        };

    }



    @Override
    public void onClick(View view) { //penumpang
        switch (view.getId()){
            case R.id.plus:
                penumpang ++;
                binding.pessengers.setText(String.valueOf(penumpang));
                break;
            case R.id.minus:
                penumpang --;
                binding.pessengers.setText(String.valueOf(penumpang));
                break;
            case R.id.btSearchBus:
                if(binding.from.getSelectedItem().toString().equals(binding.to.getSelectedItem().toString())){
                    Toast.makeText(getActivity(), "Cannot same place", Toast.LENGTH_SHORT).show();
                }else if(binding.date == null){
                    Toast.makeText(getActivity(), "Plese select your date", Toast.LENGTH_SHORT).show();
                }
                checkPriceAndBus();
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("from", binding.from.getSelectedItem().toString());
                intent.putExtra("to", binding.to.getSelectedItem().toString());
                intent.putExtra("pessengers", binding.pessengers.getText().toString());
                intent.putExtra("date", binding.date.getText().toString());
                intent.putExtra("jarak", String.valueOf(jarak));
//                intent.putExtra("price", price);
//                intent.putExtra("nameBus", nameBus);
//                intent.putExtra("longTime", longTime);
//                intent.putExtra("imgBus", linkBus);
                startActivity(intent);
                Toast.makeText(getActivity(), "berhasil"+binding.date.getText().toString() +binding.pessengers.getText().toString() +jarak, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void checkPriceAndBus() {
//       String from = binding.from.getSelectedItem().toString(); //Gagal
//        String to = binding.from.getSelectedItem().toString();

//        if(from.equals("Probolinggo") && to.equals("Pasuruan")){
//            Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
//        }

        if (binding.from.getSelectedItem().toString().equals("Probolinggo") && binding.to.getSelectedItem().toString().equals("Pasuruan")
                || binding.from.getSelectedItem().toString().equals("Pasuruan") && binding.to.getSelectedItem().toString().equals("Probolinggo")) {
            Toast.makeText(getActivity(), "sukses", Toast.LENGTH_SHORT).show();
            price = 25000;
            longTime = 2;
            nameBus = "AKAS";
            jarak = 87.8;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Probolinggo") && binding.to.getSelectedItem().toString().equals("Surabaya")
                || binding.from.getSelectedItem().toString().equals("Surabaya") && binding.to.getSelectedItem().toString().equals("Probolinggo")) {
            price = 50000;
            longTime = 4;
            nameBus = "AKAS";
            jarak = 149;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Probolinggo") && binding.to.getSelectedItem().toString().equals("Malang")
                || binding.from.getSelectedItem().toString().equals("Malang") && binding.to.getSelectedItem().toString().equals("Probolinggo")) {
            price = 40000;
            longTime = 3;
            nameBus = "AKAS";
            jarak = 124;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Probolinggo") && binding.to.getSelectedItem().toString().equals("Gresik")
                || binding.from.getSelectedItem().toString().equals("Gresik") && binding.to.getSelectedItem().toString().equals("Probolinggo")) {
            price = 70000;
            longTime = 6;
            nameBus = "AKAS";
            jarak = 160;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Pasuruan") && binding.to.getSelectedItem().toString().equals("Surabaya")
                || binding.from.getSelectedItem().toString().equals("Surabaya") && binding.to.getSelectedItem().toString().equals("Pasuruan")) {
            price = 20000;
            longTime = 1;
            nameBus = "AKAS";
            jarak = 66.90;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Malang") && binding.to.getSelectedItem().toString().equals("Surabaya")
                || binding.from.getSelectedItem().toString().equals("Surabaya") && binding.to.getSelectedItem().toString().equals("Malang")) {
            price = 40000;
            longTime = 2;
            nameBus = "AKAS";
            jarak = 125;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Gresik") && binding.to.getSelectedItem().toString().equals("Surabaya")
                || binding.from.getSelectedItem().toString().equals("Surabaya") && binding.to.getSelectedItem().toString().equals("Gresik")) {
            price = 15000;
            longTime = 1;
            nameBus = "AKAS";
            jarak = 18;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Malang") && binding.to.getSelectedItem().toString().equals("Pasuruan")
                || binding.from.getSelectedItem().toString().equals("Pasuruan") && binding.to.getSelectedItem().toString().equals("Malang")) {
            price = 30000;
            longTime = 1;
            nameBus = "AKAS";
            jarak = 55;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Gresik") && binding.to.getSelectedItem().toString().equals("Pasuruan")
                || binding.from.getSelectedItem().toString().equals("Pasuruan") && binding.to.getSelectedItem().toString().equals("Gresik")) {
            price = 50000;
            longTime = 3;
            nameBus = "AKAS";
            jarak = 78;
            linkBus = "";
        }

    }


//
//    public void checkButton(View view) {
//        int radioId = binding.rgClass.getCheckedRadioButtonId();
//        rb = (RadioButton) view.findViewById(radioId);
//        String classBus = rb.getText().toString();
//        Toast.makeText(getActivity(), "ini" +classBus, Toast.LENGTH_SHORT).show();
//    }
}