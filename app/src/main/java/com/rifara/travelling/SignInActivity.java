package com.rifara.travelling;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {

    EditText emailEt, passEt;
    LinearLayout signInBtn;
    ProgressBar progressBar;
    TextView tvCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        emailEt = findViewById(R.id.et_email_sign_in);
        passEt = findViewById(R.id.et_Password_sign_up);
        signInBtn = findViewById(R.id.linear_button_signin);
        progressBar = findViewById(R.id.loading);
        tvCreateAccount = findViewById(R.id.tv_create_account);

        signInBtn.setOnClickListener((v) -> loginUser());

        tvCreateAccount.setOnClickListener((v) -> startActivity(new Intent(SignInActivity.this, SignUpActivity.class)));


    }

    private void loginUser() {
        String email = emailEt.getText().toString();
        String password = passEt.getText().toString();

        boolean isValidated = validateData(email, password);
        if (!isValidated) {
            return;
        }

        signInAccountInfirebase(email, password);
    }

    void signInAccountInfirebase(String email, String password) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                changeInProgress(false);
                if (task.isSuccessful()) {
                    // Sign In Succes
                    if (firebaseAuth.getCurrentUser().isEmailVerified()) {
                        // Go To MainActivity
                        startActivity(new Intent(SignInActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Utility.showToast(SignInActivity.this, "Harap Verifikasi Email Terlebih Dahulu!");
                    }

                } else {
                    // Sign In Failed
                    Utility.showToast(SignInActivity.this, task.getException().getLocalizedMessage());

                }
            }
        });



    }


    void changeInProgress(boolean inProgress) {
        if (inProgress) {
            progressBar.setVisibility(View.VISIBLE);
            signInBtn.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            signInBtn.setVisibility(View.VISIBLE);
        }
    }

    boolean validateData(String email, String password) {

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEt.setError("Email Salah");
            return false;
        }
        if (password.length() <= 6) {
            passEt.setError("Password harus lebih dari 6 karakter");
            return false;
        }

        return true;

    }


}