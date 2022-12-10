package com.rifara.travelling.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.rifara.travelling.MainActivity;
import com.rifara.travelling.R;
import com.rifara.travelling.Utility;

import java.util.Objects;


public class ProfileFragment extends Fragment implements View.OnClickListener {
    CardView editProfile, hubungiKami, tentangAplikasi, keluarAkun;
    TextView tvName, tvEmail;

    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editProfile = view.findViewById(R.id.cv_edit_profile);
        hubungiKami = view.findViewById(R.id.cv_hubungi_kami);
        tentangAplikasi = view.findViewById(R.id.cv_tentang_aplikasi);
        keluarAkun = view.findViewById(R.id.cv_keluar_akun);

        tvName = view.findViewById(R.id.tv_name_profile);
        tvEmail = view.findViewById(R.id.tv_email_profile);


        editProfile.setOnClickListener(this);
        hubungiKami.setOnClickListener(this);
        tentangAplikasi.setOnClickListener(this);
        keluarAkun.setOnClickListener(this);


        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(getActivity(), googleSignInOptions);

        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(getActivity());
        if (googleSignInAccount != null) {
            tvName.setText(googleSignInAccount.getDisplayName()); // Menampilkan data di profile
            tvEmail.setText(googleSignInAccount.getEmail()); // Menampilkan data di profile
        }


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cv_edit_profile) {
            Utility.showToast(getActivity(),"Edit Profile");
            startActivity(new Intent(getActivity(), EditProfileActivity.class));

        } else if (view.getId() == R.id.cv_hubungi_kami) {
            Utility.showToast(getActivity(),"Hubungi Kami");
            startActivity(new Intent(getActivity(), ContactUsActivity.class));

        } else if (view.getId() == R.id.cv_tentang_aplikasi) {
            Utility.showToast(getActivity(),"Tentang Aplikasi");
            startActivity(new Intent(getActivity(), AboutApplicationActivity.class));

        } else if (view.getId() == R.id.cv_keluar_akun) {
            Utility.showToast(getActivity(),"Keluar Akun");

            signOut();

        }
    }


    void signOut() {
//         Google
        googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                startActivity(new Intent(getActivity(), SignInActivity.class));
                requireActivity().finish();
            }
        });

        // Auth
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getActivity(), SignInActivity.class));
        requireActivity().finish();

    }
}