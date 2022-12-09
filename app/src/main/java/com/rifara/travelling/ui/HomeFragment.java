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
import com.rifara.travelling.NotificationActivity;
import com.rifara.travelling.R;
import com.rifara.travelling.databinding.FragmentHomeBinding;

import java.text.DateFormat;
import java.util.Calendar;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FragmentHomeBinding binding;
    FirebaseFirestore db;
    private int penumpang = 0;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener setListener;
    String linkBus = "";
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
        binding.notif.setOnClickListener(this);

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
                datePickerDialog = new DatePickerDialog(getActivity(), setListener, year,month,day);
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String pickerDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
                binding.date.setText(pickerDateString);

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
                    Toast.makeText(getActivity(), "lengkapi dulu", Toast.LENGTH_SHORT).show();
                }else if(binding.date == null){
                    Toast.makeText(getActivity(), "Plese select your date", Toast.LENGTH_SHORT).show();
                }else if(binding.pessengers == null){
                    Toast.makeText(getActivity(), "Plese select your pessengers", Toast.LENGTH_SHORT).show();
                }else{
                    checkPriceAndBus();
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    intent.putExtra("from", binding.from.getSelectedItem().toString());
                    intent.putExtra("to", binding.to.getSelectedItem().toString());
                    intent.putExtra("pessengers", binding.pessengers.getText().toString());
                    intent.putExtra("date", binding.date.getText().toString());
                    intent.putExtra("jarak", String.valueOf(jarak));
                    intent.putExtra("imgBus", String.valueOf(linkBus));
                    startActivity(intent);
                }
                break;
            case R.id.notif:
                startActivity(new Intent(getActivity(), NotificationActivity.class));
        }
    }

    private void checkPriceAndBus() {

        if (binding.from.getSelectedItem().toString().equals("Probolinggo") && binding.to.getSelectedItem().toString().equals("Pasuruan")
                || binding.from.getSelectedItem().toString().equals("Pasuruan") && binding.to.getSelectedItem().toString().equals("Probolinggo")) {
            Toast.makeText(getActivity(), "sukses", Toast.LENGTH_SHORT).show();
            jarak = 87.8;
            linkBus = "https://4.bp.blogspot.com/-WbGOH6vIl-M/V5letupc-BI/AAAAAAAABDM/r0jqkLXxYfM7bFNuKQS0jV52s-BL2YqGACLcB/s1600/akas%2BI.JPG";
        }else if (binding.from.getSelectedItem().toString().equals("Probolinggo") && binding.to.getSelectedItem().toString().equals("Surabaya")
                || binding.from.getSelectedItem().toString().equals("Surabaya") && binding.to.getSelectedItem().toString().equals("Probolinggo")) {
            jarak = 149;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Probolinggo") && binding.to.getSelectedItem().toString().equals("Malang")
                || binding.from.getSelectedItem().toString().equals("Malang") && binding.to.getSelectedItem().toString().equals("Probolinggo")) {
            jarak = 124;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Probolinggo") && binding.to.getSelectedItem().toString().equals("Gresik")
                || binding.from.getSelectedItem().toString().equals("Gresik") && binding.to.getSelectedItem().toString().equals("Probolinggo")) {
            jarak = 160;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Pasuruan") && binding.to.getSelectedItem().toString().equals("Surabaya")
                || binding.from.getSelectedItem().toString().equals("Surabaya") && binding.to.getSelectedItem().toString().equals("Pasuruan")) {
            jarak = 66.90;
            linkBus = "https://jadwalbis.com/images/bus_logo/61547445_688326811623726_5558866464863158272_n.jpg";
        }else if (binding.from.getSelectedItem().toString().equals("Malang") && binding.to.getSelectedItem().toString().equals("Surabaya")
                || binding.from.getSelectedItem().toString().equals("Surabaya") && binding.to.getSelectedItem().toString().equals("Malang")) {
            jarak = 125;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Gresik") && binding.to.getSelectedItem().toString().equals("Surabaya")
                || binding.from.getSelectedItem().toString().equals("Surabaya") && binding.to.getSelectedItem().toString().equals("Gresik")) {
            jarak = 18;
            linkBus = "https://ik.imagekit.io/tvlk/image/imageResource/2018/12/05/1544004740153-50b7565a2aeb2f73e30f979ac9b93644.jpeg?tr=q-75";
        }else if (binding.from.getSelectedItem().toString().equals("Malang") && binding.to.getSelectedItem().toString().equals("Pasuruan")
                || binding.from.getSelectedItem().toString().equals("Pasuruan") && binding.to.getSelectedItem().toString().equals("Malang")) {
            jarak = 55;
            linkBus = "";
        }else if (binding.from.getSelectedItem().toString().equals("Gresik") && binding.to.getSelectedItem().toString().equals("Pasuruan")
                || binding.from.getSelectedItem().toString().equals("Pasuruan") && binding.to.getSelectedItem().toString().equals("Gresik")) {
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