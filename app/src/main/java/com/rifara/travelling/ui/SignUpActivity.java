package com.rifara.travelling.ui;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rifara.travelling.R;
import com.rifara.travelling.Utility;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEt, emailEt, passEt, confirmPassEt;
    LinearLayout createAccountBtn;
    ProgressBar progressBar;
    TextView loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEt = findViewById(R.id.et_name);
        emailEt = findViewById(R.id.et_emailuser);
        passEt = findViewById(R.id.et_password);
        confirmPassEt = findViewById(R.id.et_confirm_password);
        createAccountBtn = findViewById(R.id.linear_button_signup);
        loginBtn = findViewById(R.id.tv_sign_in);
        progressBar = findViewById(R.id.loading);

        createAccountBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.linear_button_signup) {
            createAccount();
        } else if (view.getId() == R.id.tv_sign_in) {
            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
        }
    }

    private void createAccount() {
        String name = nameEt.getText().toString();
        String email = emailEt.getText().toString();
        String password = passEt.getText().toString();
        String confirmPassword = confirmPassEt.getText().toString();

        boolean isValidated = validateData(name, email, password, confirmPassword);
        if (!isValidated) {
            return;
        }

        createAccountInFirebaseAuth(email, password); // Authentication
        createAccountRealtimeDatabase(name, email, password); // Realtime Database

    }

    private void createAccountRealtimeDatabase(String name, String email, String password) {

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReferenceFromUrl("https://travelling-1b36f-default-rtdb.firebaseio.com/");

        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(name)) {
                    Utility.showToast(SignUpActivity.this, "Email Sudah Terdaftar!");
                } else {
                    // databaseReference.setValue(User.class);
                    databaseReference.child("users").child(name).child("name").setValue(name);
                    databaseReference.child("users").child(name).child("email").setValue(email);
                    databaseReference.child("users").child(name).child("password").setValue(password);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Utility.showToast(SignUpActivity.this, "Gagal");
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    private void createAccountInFirebaseAuth(String email, String password) {

        changeInProgress(true);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, task -> {
            changeInProgress(false);
            if (task.isSuccessful()) {
                // Apabila Berhasil
                Utility.showToast(SignUpActivity.this, "Sukses, Cek email untuk verifikasi");
                Objects.requireNonNull(firebaseAuth.getCurrentUser()).sendEmailVerification();
                firebaseAuth.signOut();
                finish();

            } else {
                // Apabila Gagal
                Utility.showToast(SignUpActivity.this, Objects.requireNonNull(task.getException()).getLocalizedMessage());
            }
        });

    }

    void changeInProgress(boolean inProgress) {
        if (inProgress) {
            progressBar.setVisibility(View.VISIBLE);
            createAccountBtn.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            createAccountBtn.setVisibility(View.VISIBLE);
        }
    }

    boolean validateData(String name, String email, String password, String confrimPassword) {

        if (name.isEmpty()) {
            nameEt.setError("Nama tidak boleh kosong");
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEt.setError("Email Salah");
            return false;
        }
        if (password.length() <= 6) {
            passEt.setError("Password harus lebih dari 6 karakter");
            return false;
        }
        if (!password.equals(confrimPassword)) {
            confirmPassEt.setError("Password tidak sama");
            return false;
        }
        return true;

    }
}