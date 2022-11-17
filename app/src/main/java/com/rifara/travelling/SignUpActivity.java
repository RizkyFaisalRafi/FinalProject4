package com.rifara.travelling;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

        createAccountInFirebase(name, email, password);

    }

    private void createAccountInFirebase(String name, String email, String password) {

        changeInProgress(true);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, task -> {
            changeInProgress(false);
            if (task.isSuccessful()) {
                // Apabila Berhasil
                Toast.makeText(SignUpActivity.this, "Sukses, Cek email untuk verifikasi", Toast.LENGTH_SHORT).show();
                Objects.requireNonNull(firebaseAuth.getCurrentUser()).sendEmailVerification();
                firebaseAuth.signOut();
                finish();

            } else {
                // Apabila Gagal
                Toast.makeText(SignUpActivity.this, Objects.requireNonNull(task.getException()).getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    void changeInProgress(boolean inProgress) {
        if (inProgress) {
            progressBar.setVisibility(View.VISIBLE);
            createAccountBtn.setVisibility(View.GONE);
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