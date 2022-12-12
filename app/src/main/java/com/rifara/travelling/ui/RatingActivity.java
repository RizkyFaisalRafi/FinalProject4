package com.rifara.travelling.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.rifara.travelling.R;

public class RatingActivity extends AppCompatActivity {

    Button button;
    RatingBar ratingStars;

    float myRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        button = findViewById(R.id.button);
        ratingStars = findViewById(R.id.ratingBar);


        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                
                int rating = (int) v;
                String message = null;

                myRating = ratingBar.getRating();
                
                switch (rating){
                    case 1:
                        message = "Sorry to hear that :(";
                        break;
                    case 2:
                        message = "You always accept suggestions";
                        break;
                    case 3:
                        message = "Good enough!";
                        break;
                    case 4:
                        message = "Great!, thank you";
                        break;
                    case 5:
                        message = "Awesome!, thank you";
                        break;
                }

                Toast.makeText(RatingActivity.this, message, Toast.LENGTH_SHORT).show();
                
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RatingActivity.this, "Your rating is: " + myRating , Toast.LENGTH_SHORT).show();
            }
        });


    }
}