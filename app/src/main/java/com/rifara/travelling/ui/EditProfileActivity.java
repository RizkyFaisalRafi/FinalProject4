package com.rifara.travelling.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.rifara.travelling.R;

public class EditProfileActivity extends AppCompatActivity {

    EditText nameEt, emailEt, passEt, phoneNumberEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        nameEt = findViewById(R.id.et_name);
        emailEt = findViewById(R.id.et_emailuser);
        passEt = findViewById(R.id.et_password);
        phoneNumberEt = findViewById(R.id.et_phone_number); //

//        showAllUserData();
    }

    private void showAllUserData() {
//        Intent intent = getIntent();
//        String _NAME = intent.getStringExtra("name");
//        String _EMAIL = intent.getStringExtra("email");
//        String _PASS = intent.getStringExtra("password");
//        String _PHONE = intent.getStringExtra("phone");
//
//        nameEt.setText(_NAME);
//        nameEt.getEditableText().toString().trim();
//
//
//        emailEt.setText(_EMAIL);
//        passEt.setText(_PASS);
//        phoneNumberEt.setText(_PHONE);

    }
}