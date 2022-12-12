package com.rifara.travelling;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rifara.travelling.databinding.ActivitySeatBinding;
import com.rifara.travelling.ui.DetailPesananActivity;

public class SeatActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivitySeatBinding binding;
    int total_pessenger;
    private Preferences preferences;
    int totalClick2 = 0;

    int seat, seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9, seat10, seat11, seat12, seat13, seat14, seat15, seat16, seat17,
            seat18, seat19, seat20, seat21, seat22, seat23, seat24, seat25, seat26, seat27, seat28, seat29, seat30, seat31;

    String kode_seat = "", kdseat1 = "", kdseat2 = "", kdseat3 = "", kdseat4 = "", kdseat5 = "", kdseat6 = "", kdseat7 = "", kdseat8 = "", kdseat9 = "", kdseat10 = "", kdseat11 = "", kdseat12 = "", kdseat13 = "", kdseat14 = "", kdseat15 = "", kdseat16 = "", kdseat17 = "",
            kdseat18 = "", kdseat19 = "", kdseat20 = "", kdseat21 = "", kdseat22 = "", kdseat23 = "", kdseat24 = "", kdseat25 = "", kdseat26 = "", kdseat27 = "", kdseat28 = "", kdseat29 = "", kdseat30 = "", kdseat31 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = new Preferences(this);
        total_pessenger = Integer.parseInt(getIntent().getStringExtra("total_pessenger"));
        Toast.makeText(this, "" + total_pessenger, Toast.LENGTH_SHORT).show();

        binding.view1.setOnClickListener(this);
        binding.view2.setOnClickListener(this);
        binding.view3.setOnClickListener(this);
        binding.view4.setOnClickListener(this);
        binding.view5.setOnClickListener(this);
        binding.view6.setOnClickListener(this);
        binding.view7.setOnClickListener(this);
        binding.view8.setOnClickListener(this);
        binding.view9.setOnClickListener(this);
        binding.view10.setOnClickListener(this);
        binding.view11.setOnClickListener(this);
        binding.view12.setOnClickListener(this);
        binding.view13.setOnClickListener(this);
        binding.view14.setOnClickListener(this);
        binding.view15.setOnClickListener(this);
        binding.view16.setOnClickListener(this);
        binding.view17.setOnClickListener(this);
        binding.view18.setOnClickListener(this);
        binding.view19.setOnClickListener(this);
        binding.view20.setOnClickListener(this);
        binding.view21.setOnClickListener(this);
        binding.view22.setOnClickListener(this);
        binding.view23.setOnClickListener(this);
        binding.view24.setOnClickListener(this);
        binding.view25.setOnClickListener(this);
        binding.view26.setOnClickListener(this);
        binding.view27.setOnClickListener(this);
        binding.view28.setOnClickListener(this);
        binding.view29.setOnClickListener(this);
        binding.view30.setOnClickListener(this);
        binding.view31.setOnClickListener(this);

        binding.btnBookNow.setOnClickListener(view -> {
            Intent intent = new Intent(SeatActivity.this, DetailPesananActivity.class);
            if (seat == total_pessenger) {
                preferences.getEditor().putString("kodeseat", binding.totalseat.getText().toString()).apply();
                startActivity(intent);
            } else {
                Toast.makeText(this, "Please choose " + total_pessenger + " seats", Toast.LENGTH_SHORT).show();
            }
        });
        binding.imgBack.setOnClickListener(view1 -> startActivity(new Intent(SeatActivity.this, DetailPesananActivity.class)));
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_1:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view1.setBackgroundResource(R.drawable.bg_seat_off);
                    seat1 = 0;
                    kdseat1 = "";
                } else {
                    binding.view1.setBackgroundResource(R.drawable.bg_seat_on);
                    seat1 = 1;
                    kdseat1 = "1A";
                }
                break;
            case R.id.view_2:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view2.setBackgroundResource(R.drawable.bg_seat_off);
                    seat2 = 0;
                    kdseat2 = "";
                } else {
                    binding.view2.setBackgroundResource(R.drawable.bg_seat_on);
                    seat2 = 1;
                    kdseat2 = "1B";
                }
                break;
            case R.id.view3:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view3.setBackgroundResource(R.drawable.bg_seat_off);
                    seat3 = 0;
                    kdseat3 = "";
                } else {
                    binding.view3.setBackgroundResource(R.drawable.bg_seat_on);
                    seat3 = 1;
                    kdseat3 = "2A";
                }
                break;
            case R.id.view4:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view4.setBackgroundResource(R.drawable.bg_seat_off);
                    seat4 = 0;
                    kdseat4 = "";
                } else {
                    binding.view4.setBackgroundResource(R.drawable.bg_seat_on);
                    seat4 = 1;
                    kdseat4 = "2B";
                }
                break;
            case R.id.view5:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view5.setBackgroundResource(R.drawable.bg_seat_off);
                    seat5 = 0;
                    kdseat5 = "";
                } else {
                    binding.view5.setBackgroundResource(R.drawable.bg_seat_on);
                    seat5 = 1;
                    kdseat5 = "3A";
                }
                break;
            case R.id.view6:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view6.setBackgroundResource(R.drawable.bg_seat_off);
                    seat6 = 0;
                    kdseat6 = "";
                } else {
                    binding.view6.setBackgroundResource(R.drawable.bg_seat_on);
                    seat6 = 1;
                    kdseat6 = "3B";
                }
                break;
            case R.id.view7:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view7.setBackgroundResource(R.drawable.bg_seat_off);
                    seat7 = 0;
                    kdseat7 = "";
                } else {
                    binding.view7.setBackgroundResource(R.drawable.bg_seat_on);
                    seat7 = 1;
                    kdseat7 = "4A";
                }
                break;
            case R.id.view8:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view8.setBackgroundResource(R.drawable.bg_seat_off);
                    seat8 = 0;
                    kdseat8 = "";
                } else {
                    binding.view8.setBackgroundResource(R.drawable.bg_seat_on);
                    seat8 = 1;
                    kdseat8 = "4B";
                }
                break;
            case R.id.view9:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view9.setBackgroundResource(R.drawable.bg_seat_off);
                    seat9 = 0;
                    kdseat9 = "";
                } else {
                    binding.view9.setBackgroundResource(R.drawable.bg_seat_on);
                    seat9 = 1;
                    kdseat9 = "5A";
                }
                break;
            case R.id.view10:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view10.setBackgroundResource(R.drawable.bg_seat_off);
                    seat10 = 0;
                    kdseat10 = "";
                } else {
                    binding.view10.setBackgroundResource(R.drawable.bg_seat_on);
                    seat10 = 1;
                    kdseat10 = "5B";
                }
                break;
            case R.id.view11:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view11.setBackgroundResource(R.drawable.bg_seat_off);
                    seat11 = 0;
                    kdseat11 = "";
                } else {
                    binding.view11.setBackgroundResource(R.drawable.bg_seat_on);
                    seat11 = 1;
                    kdseat11 = "6A";
                }
                break;
            case R.id.view12:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view12.setBackgroundResource(R.drawable.bg_seat_off);
                    seat12 = 0;
                    kdseat12 = "";
                } else {
                    binding.view12.setBackgroundResource(R.drawable.bg_seat_on);
                    seat12 = 1;
                    kdseat12 = "6B";
                }
                break;
            case R.id.view13:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view13.setBackgroundResource(R.drawable.bg_seat_off);
                    seat13 = 0;
                    kdseat13 = "";
                } else {
                    binding.view13.setBackgroundResource(R.drawable.bg_seat_on);
                    seat13 = 1;
                    kdseat13 = "7A";
                }
                break;
            case R.id.view14:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view14.setBackgroundResource(R.drawable.bg_seat_off);
                    seat14 = 0;
                    kdseat14 = "";
                } else {
                    binding.view14.setBackgroundResource(R.drawable.bg_seat_on);
                    seat14 = 1;
                    kdseat14 = "7B";
                }
                break;
            case R.id.view15:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view15.setBackgroundResource(R.drawable.bg_seat_off);
                    seat15 = 0;
                    kdseat15 = "";
                } else {
                    binding.view15.setBackgroundResource(R.drawable.bg_seat_on);
                    seat15 = 1;
                    kdseat15 = "8B";
                }
                break;
            case R.id.view16:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view16.setBackgroundResource(R.drawable.bg_seat_off);
                    seat16 = 0;
                    kdseat16 = "";
                } else {
                    binding.view16.setBackgroundResource(R.drawable.bg_seat_on);
                    seat16 = 1;
                    kdseat16 = "1C";
                }
                break;
            case R.id.view17:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view17.setBackgroundResource(R.drawable.bg_seat_off);
                    seat17 = 0;
                    kdseat17 = "";
                } else {
                    binding.view17.setBackgroundResource(R.drawable.bg_seat_on);
                    seat17 = 1;
                    kdseat17 = "1D";
                }
                break;
            case R.id.view18:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view18.setBackgroundResource(R.drawable.bg_seat_off);
                    seat18 = 0;
                    kdseat18 = "";
                } else {
                    binding.view18.setBackgroundResource(R.drawable.bg_seat_on);
                    seat18 = 1;
                    kdseat18 = "2C";
                }
                break;
            case R.id.view19:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view19.setBackgroundResource(R.drawable.bg_seat_off);
                    seat19 = 0;
                    kdseat19 = "";
                } else {
                    binding.view19.setBackgroundResource(R.drawable.bg_seat_on);
                    seat19 = 1;
                    kdseat19 = "2D";
                }
                break;
            case R.id.view20:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view20.setBackgroundResource(R.drawable.bg_seat_off);
                    seat20 = 0;
                    kdseat20 = "";
                } else {
                    binding.view20.setBackgroundResource(R.drawable.bg_seat_on);
                    seat20 = 1;
                    kdseat20 = "3C";
                }
                break;
            case R.id.view21:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view21.setBackgroundResource(R.drawable.bg_seat_off);
                    seat21 = 0;
                    kdseat21 = "";
                } else {
                    binding.view21.setBackgroundResource(R.drawable.bg_seat_on);
                    seat21 = 1;
                    kdseat21 = "3D";
                }
                break;
            case R.id.view22:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view22.setBackgroundResource(R.drawable.bg_seat_off);
                    seat22 = 0;
                    kdseat22 = "";
                } else {
                    binding.view22.setBackgroundResource(R.drawable.bg_seat_on);
                    seat22 = 1;
                    kdseat22 = "4C";
                }
                break;
            case R.id.view23:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view23.setBackgroundResource(R.drawable.bg_seat_off);
                    seat23 = 0;
                    kdseat23 = "";
                } else {
                    binding.view23.setBackgroundResource(R.drawable.bg_seat_on);
                    seat23 = 1;
                    kdseat23 = "4D";
                }
                break;
            case R.id.view24:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view24.setBackgroundResource(R.drawable.bg_seat_off);
                    seat24 = 0;
                    kdseat24 = "";
                } else {
                    binding.view24.setBackgroundResource(R.drawable.bg_seat_on);
                    seat24 = 1;
                    kdseat24 = "5C";
                }
                break;
            case R.id.view25:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view25.setBackgroundResource(R.drawable.bg_seat_off);
                    seat25 = 0;
                    kdseat25 = "";
                } else {
                    binding.view25.setBackgroundResource(R.drawable.bg_seat_on);
                    seat25 = 1;
                    kdseat25 = "5D";
                }
                break;
            case R.id.view26:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view26.setBackgroundResource(R.drawable.bg_seat_off);
                    seat26 = 0;
                    kdseat26 = "";
                } else {
                    binding.view26.setBackgroundResource(R.drawable.bg_seat_on);
                    seat26 = 1;
                    kdseat26 = "6A";
                }
                break;
            case R.id.view27:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view27.setBackgroundResource(R.drawable.bg_seat_off);
                    seat27 = 0;
                    kdseat27 = "";
                } else {
                    binding.view27.setBackgroundResource(R.drawable.bg_seat_on);
                    seat27 = 1;
                    kdseat27 = "6D";
                }
                break;
            case R.id.view28:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view28.setBackgroundResource(R.drawable.bg_seat_off);
                    seat28 = 0;
                    kdseat28 = "";
                } else {
                    binding.view28.setBackgroundResource(R.drawable.bg_seat_on);
                    seat28 = 1;
                    kdseat28 = "7C";
                }
                break;
            case R.id.view29:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view29.setBackgroundResource(R.drawable.bg_seat_off);
                    seat29 = 0;
                    kdseat29 = "";
                } else {
                    binding.view29.setBackgroundResource(R.drawable.bg_seat_on);
                    seat29 = 1;
                    kdseat29 = "7D";
                }
                break;
            case R.id.view30:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view30.setBackgroundResource(R.drawable.bg_seat_off);
                    seat30 = 0;
                    kdseat30 = "";
                } else {
                    binding.view30.setBackgroundResource(R.drawable.bg_seat_on);
                    seat30 = 1;
                    kdseat30 = "8C";
                }
                break;
            case R.id.view31:
                totalClick2 += 1;
                if (totalClick2 % 2 == 0) {
                    binding.view31.setBackgroundResource(R.drawable.bg_seat_off);
                    seat2 = 0;
                    kdseat31 = "";
                } else {
                    binding.view31.setBackgroundResource(R.drawable.bg_seat_on);
                    seat31 = 1;
                    kdseat31 = "8D";
                }
                break;
        }
        seat = seat1 + seat2 + seat3 + seat4 + seat5 + seat6 + seat7 + seat8 + seat9 + seat10 + seat11 + seat12 + seat13 + seat14 + seat15 + seat16 + seat17
                + seat18 + seat19 + seat20 + seat21 + seat22 + seat23 + seat24 + seat25 + seat26 + seat27 + seat28 + seat29 + seat30 + seat31;

        kode_seat = kdseat1 + kdseat2 + kdseat3 + kdseat4 + kdseat5 + kdseat6 + kdseat7 + kdseat8 + kdseat9 + kdseat10 + kdseat11 + kdseat12 +
                kdseat13 + kdseat14 + kdseat15 + kdseat16 + kdseat17 + kdseat18 + kdseat19 + kdseat20 + kdseat21 + kdseat22 + kdseat23 + kdseat24 +
                kdseat25 + kdseat26 + kdseat27 + kdseat28 + kdseat29 + kdseat30 + kdseat31;

        binding.totalseat.setText(kode_seat);
    }

}