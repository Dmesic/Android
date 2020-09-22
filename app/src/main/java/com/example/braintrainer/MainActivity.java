package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button playAgainButton;
    TextView timerTextView;
    TextView sumTextView;
    TextView scoreTextView;
    TextView correctTextView;
    int rand1;
    int rand2;
    int randSum1;
    int randSum2;
    int randSum3;
    int sum;
    int score;
    int tries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton = findViewById(R.id.goButton);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        playAgainButton = findViewById(R.id.playAgainButton);
        timerTextView = findViewById(R.id.timerTextView);
        sumTextView = findViewById(R.id.sumTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        correctTextView = findViewById(R.id.correctTextView);
    }

    public void go(View view) {
        play();
    }

    public void playAgain(View view) {
        scoreTextView.setText("");
        tries=0;
        score=0;
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        play();
    }

    public void check1(View view) {

        if (Integer.parseInt(button1.getTag().toString()) == sum) {
            correctTextView.setText("Correct!");
            score += 1;
            tries += 1;
        } else {
            correctTextView.setText("False!");
            tries += 1;
        }

        scoreTextView.setText(button1.getTag().toString());

        play2();
    }

    public void check2(View view) {

        if (Integer.parseInt(button2.getTag().toString()) == sum) {
            correctTextView.setText("Correct!");
            score += 1;
            tries += 1;
        } else {
            correctTextView.setText("False!");
            tries += 1;
        }
        scoreTextView.setText(button2.getTag().toString());

        play2();
    }

    public void check3(View view) {


        if (Integer.parseInt(button3.getTag().toString()) == sum) {
            correctTextView.setText("Correct!");
            score += 1;
            tries += 1;
        } else {
            correctTextView.setText("False!");
            tries += 1;
        }
        scoreTextView.setText(button3.getTag().toString());

        play2();
    }

    public void check4(View view) {

        if (Integer.parseInt(button4.getTag().toString()) == sum) {
            correctTextView.setText("Correct!");
            score += 1;
            tries += 1;
        } else {
            correctTextView.setText("False!");
            tries += 1;
        }
        scoreTextView.setText(button4.getTag().toString());

        play2();
    }

    public void play() {
        goButton.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        correctTextView.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        correctTextView.setText("");

        Random random = new Random();
        rand1 = random.nextInt(30);
        rand2 = random.nextInt(30);
        randSum1 = random.nextInt(60);
        randSum2 = random.nextInt(60);
        randSum3 = random.nextInt(60);
        sum = rand1 + rand2;

        sumTextView.setText(rand1 + "+" + rand2);

        button1.setText(sum + "");
        button1.setTag(sum);
        button2.setText(randSum1 + "");
        button2.setTag(randSum1);
        button3.setText(randSum2 + "");
        button3.setTag(randSum2);
        button4.setText(randSum3 + "");
        button4.setTag(randSum3);


        new CountDownTimer(31000, 1000) {
            @Override
            public void onTick(long l) {

                timerTextView.setText(l / 1000 + "s");
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                correctTextView.setText("Done!");
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
            }
        }.start();
    }

    public void play2() {
        Random random = new Random();

        rand1 = random.nextInt(30);
        rand2 = random.nextInt(30);
        randSum1 = random.nextInt(60);
        randSum2 = random.nextInt(60);
        randSum3 = random.nextInt(60);
        sum = rand1 + rand2;

        List<Integer> randomList = new ArrayList<>();
        randomList.add(sum);
        randomList.add(randSum1);
        randomList.add(randSum2);
        randomList.add(randSum3);

        Collections.shuffle(randomList);

        sumTextView.setText(rand1 + "+" + rand2);
        scoreTextView.setText(score + "/" + tries);

        button1.setText(randomList.get(0) + "");
        button1.setTag(randomList.get(0));
        button2.setText(randomList.get(1) + "");
        button2.setTag(randomList.get(1));
        button3.setText(randomList.get(2) + "");
        button3.setTag(randomList.get(2));
        button4.setText(randomList.get(3) + "");
        button4.setTag(randomList.get(3));

    }
}