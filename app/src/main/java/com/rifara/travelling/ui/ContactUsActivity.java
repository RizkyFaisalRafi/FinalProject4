package com.rifara.travelling.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.rifara.travelling.R;
import com.rifara.travelling.databinding.ActivityContactUsBinding;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityContactUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        binding = ActivityContactUsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.akun1.setOnClickListener(this);
        binding.akun2.setOnClickListener(this);
        binding.akun3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.akun1) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/rizky_faisal_rafi")));
        } else if (view.getId() == R.id.akun2) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/lindahasanah_")));
        } else if (view.getId() == R.id.akun3) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/wahyurt_")));
        }
    }
}