package com.dmappdev.mydiceapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnRoll = findViewById(R.id.btnRollTheDice);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MyDiceApp", "btrRoll is tapped now");

                ImageView imgDice1 = findViewById(R.id.imgDice1);
                ImageView imgDice2 = findViewById(R.id.imgDice2);

                int[] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};


                Random rndObject = new Random();
                int myRandomNumber1 = rndObject.nextInt(6);// 0...5

                Log.i("MyDiceApp", "Random n : " + myRandomNumber1);

                imgDice1.setImageResource(diceImages[myRandomNumber1]);

                myRandomNumber1 = rndObject.nextInt(6);// 0...5
                imgDice2.setImageResource(diceImages[myRandomNumber1]);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(imgDice1);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(imgDice2);
                mp.start();


            }
        });


    }
}