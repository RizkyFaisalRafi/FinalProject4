package com.rifara.travelling;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rifara.travelling.databinding.ActivitySeatBinding;

public class SeatActivity extends AppCompatActivity implements View.OnClickListener {

    ActivitySeatBinding binding;
    int total_pessenger;

    int seat, seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8, seat9, seat10, seat11, seat12, seat13, seat14, seat15, seat16, seat17,
            seat18, seat19, seat20, seat21, seat22, seat23, seat24, seat25, seat26, seat27, seat28, seat29, seat30, seat31;

    String kode_seat= "", kdseat1="", kdseat2="", kdseat3="", kdseat4="", kdseat5="", kdseat6="", kdseat7="", kdseat8="", kdseat9="", kdseat10="", kdseat11="", kdseat12="", kdseat13="", kdseat14="", kdseat15="", kdseat16="", kdseat17="",
            kdseat18="", kdseat19="", kdseat20="", kdseat21="", kdseat22="", kdseat23="", kdseat24="", kdseat25="", kdseat26="", kdseat27="", kdseat28="", kdseat29="", kdseat30="", kdseat31="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        total_pessenger = Integer.parseInt(getIntent().getStringExtra("total_pessenger"));
        Toast.makeText(this, ""+total_pessenger, Toast.LENGTH_SHORT).show();

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

//        int total = (seat1 + seat2 + seat3 + seat4 + seat5 + seat6 + seat7 + seat8 + seat9 + seat10 + seat11 + seat12 + seat13 + seat14 + seat15 + seat16 + seat17
//                + seat18 + seat19 + seat20 + seat21 + seat22 + seat23 + seat24 + seat25 + seat26 + seat27 + seat28 + seat29 + seat30 + seat31);
//        binding.totalseat.setText(String.valueOf(total));

//        if(total == Integer.parseInt(total_pessenger)) {
//            Toast.makeText(this, ""+total, Toast.LENGTH_SHORT).show();
//        }

//        for (seat = 0 ; seat <= total_pessenger; seat++) {
//
//        }
        binding.btnBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeatActivity.this, DetailPesananActivity.class);
                intent.putExtra("kode_seat", binding.totalseat.getText().toString());
                startActivity(intent);
            }
        });
        binding.imgBack.setOnClickListener(view1 -> {
            startActivity(new Intent(SeatActivity.this, DetailPesananActivity.class));
        });
    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.view_1:
                    binding.view1.setBackgroundResource(R.drawable.bg_seat_on);
                    seat1 = 1;
                    kdseat1 = "1A";
                    break;
                case R.id.view_2:
                    binding.view2.setBackgroundResource(R.drawable.bg_seat_on);
                    seat2 = 1;
                    kdseat2 = "1B";
                    break;
                case R.id.view3:
                    binding.view3.setBackgroundResource(R.drawable.bg_seat_on);
                    seat3 = 1;
                    kdseat3 = "2A";
                    break;
                case R.id.view4:
                    binding.view4.setBackgroundResource(R.drawable.bg_seat_on);
                    seat4 = 1;
                    kdseat4 = "2B";
                    break;
                case R.id.view5:
                    binding.view5.setBackgroundResource(R.drawable.bg_seat_on);
                    seat5 = 1;
                    kdseat5 = "3A";
                    break;
                case R.id.view6:
                    binding.view6.setBackgroundResource(R.drawable.bg_seat_on);
                    seat6 = 1;
                    kdseat6 = "3B";
                    break;
                case R.id.view7:
                    binding.view7.setBackgroundResource(R.drawable.bg_seat_on);
                    seat7 = 1;
                    kdseat7 = "4A";
                    break;
                case R.id.view8:
                    binding.view8.setBackgroundResource(R.drawable.bg_seat_on);
                    seat8 = 1;
                    kdseat8 = "4B";
                    break;
                case R.id.view9:
                    binding.view9.setBackgroundResource(R.drawable.bg_seat_on);
                    seat9 = 1;
                    kdseat9 = "5A";
                    break;
                case R.id.view10:
                    binding.view10.setBackgroundResource(R.drawable.bg_seat_on);
                    seat10 = 1;
                    kdseat10 = "5B";
                    break;
                case R.id.view11:
                    binding.view11.setBackgroundResource(R.drawable.bg_seat_on);
                    seat11 = 1;
                    kdseat11 = "6A";
                    break;
                case R.id.view12:
                    binding.view12.setBackgroundResource(R.drawable.bg_seat_on);
                    seat12 = 1;
                    kdseat12 = "6B";
                    break;
                case R.id.view13:
                    binding.view13.setBackgroundResource(R.drawable.bg_seat_on);
                    seat13 = 1;
                    kdseat13 = "7A";
                    break;
                case R.id.view14:
                    binding.view14.setBackgroundResource(R.drawable.bg_seat_on);
                    seat14 = 1;
                    kdseat14 = "7B";
                    break;
                case R.id.view15:
                    binding.view15.setBackgroundResource(R.drawable.bg_seat_on);
                    seat15 = 1;
                    kdseat15 = "8B";
                    break;
                case R.id.view16:
                    binding.view16.setBackgroundResource(R.drawable.bg_seat_on);
                    seat16 = 1;
                    kdseat16 = "1C";
                    break;
                case R.id.view17:
                    binding.view17.setBackgroundResource(R.drawable.bg_seat_on);
                    seat17 = 1;
                    kdseat17 = "1D";
                    break;
                case R.id.view18:
                    binding.view18.setBackgroundResource(R.drawable.bg_seat_on);
                    seat18 = 1;
                    kdseat18 = "2C";
                    break;
                case R.id.view19:
                    binding.view19.setBackgroundResource(R.drawable.bg_seat_on);
                    seat19 = 1;
                    kdseat19 = "2D";
                    break;
                case R.id.view20:
                    binding.view20.setBackgroundResource(R.drawable.bg_seat_on);
                    seat20 = 1;
                    kdseat20 = "3C";
                    break;
                case R.id.view21:
                    binding.view21.setBackgroundResource(R.drawable.bg_seat_on);
                    seat21 = 1;
                   kdseat21 = "3D";
                    break;
                case R.id.view22:
                    binding.view22.setBackgroundResource(R.drawable.bg_seat_on);
                    seat22 = 1;
                    kdseat22 = "4C";
                    break;
                case R.id.view23:
                    binding.view23.setBackgroundResource(R.drawable.bg_seat_on);
                    seat23 = 1;
                    kdseat23 = "4D";
                    break;
                case R.id.view24:
                    binding.view24.setBackgroundResource(R.drawable.bg_seat_on);
                    seat24 = 1;
                    kdseat24 = "5C";
                    break;
                case R.id.view25:
                    binding.view25.setBackgroundResource(R.drawable.bg_seat_on);
                    seat25 = 1;
                    kdseat25 = "5D";
                    break;
                case R.id.view26:
                    binding.view26.setBackgroundResource(R.drawable.bg_seat_on);
                    seat26 = 1;
                    kdseat26 = "6A";
                    break;
                case R.id.view27:
                    binding.view27.setBackgroundResource(R.drawable.bg_seat_on);
                    seat27 = 1;
                    kdseat27 = "6D";
                    break;
                case R.id.view28:
                    binding.view28.setBackgroundResource(R.drawable.bg_seat_on);
                    seat28 = 1;
                    kdseat28 = "7A";
                    break;
                case R.id.view29:
                    binding.view29.setBackgroundResource(R.drawable.bg_seat_on);
                    seat29 = 1;
                    kdseat29 = "7D";
                    break;
                case R.id.view30:
                    binding.view30.setBackgroundResource(R.drawable.bg_seat_on);
                    seat30 = 1;
                    kdseat30 = "8C";
                    break;
                case R.id.view31:
                    binding.view31.setBackgroundResource(R.drawable.bg_seat_on);
                    seat31 = 1;
                    kdseat31 = "8D";
                    break;
            }
            seat = seat1 + seat2 + seat3 + seat4 + seat5 + seat6 + seat7 + seat8 + seat9 + seat10 + seat11 + seat12 + seat13 + seat14 + seat15 + seat16 + seat17
                    + seat18 + seat19 + seat20 + seat21 + seat22 + seat23 + seat24 + seat25 + seat26 + seat27 + seat28 + seat29 + seat30 + seat31;

            kode_seat = kdseat1 + kdseat2+ kdseat3+ kdseat4+ kdseat5 + kdseat6 + kdseat7 + kdseat8 + kdseat9 + kdseat10 + kdseat11 + kdseat12 +
                    kdseat13 + kdseat14 + kdseat15 + kdseat16 + kdseat17 + kdseat18 + kdseat19 + kdseat20 + kdseat21 + kdseat22 + kdseat23 + kdseat24 +
                    kdseat25 + kdseat26 + kdseat27 + kdseat28 + kdseat29 + kdseat30 + kdseat31 ;

            binding.totalseat.setText(kode_seat);
        }
}