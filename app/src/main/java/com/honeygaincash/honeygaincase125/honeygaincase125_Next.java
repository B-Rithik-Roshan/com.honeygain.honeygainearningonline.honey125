package com.honeygaincash.honeygaincase125;

import static com.honeygaincash.honeygaincase125.honeygaincase125_SplashActivity.url_passing;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class honeygaincase125_Next extends AppCompatActivity {
    Button start ;
    private CountDownTimer countDownTimer;

    public String TAG = String.valueOf(getClass());


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honeygaincase125_continue);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String savedData = sharedPreferences.getString("secondcharacter", null);
        if (savedData != null && savedData.charAt(0) == '1') {
            dialgbox1();
        } else {
            dialgbox();
        }

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentContainer, new honeygaincase125_WebViewFragment());
            fragmentTransaction.commit();
        }


        this.start = (Button) findViewById(R.id.btnContinue);

        this.start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                honeygaincase125_Next.this.startActivity(new Intent(honeygaincase125_Next.this, honeygaincase125_MainActivity.class));

            }
        });
    }


    public void onBackPressed() {
        super.onBackPressed();
    }

    private void startCountdown() {
        countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsLeft = millisUntilFinished / 1000;
                start.setText("Next (" + secondsLeft + ")");
                start.setEnabled(false); // Disable the button during countdown
            }

            @Override
            public void onFinish() {
                start.setText("Next");
                start.setEnabled(true); // Enable the button after countdown completes
            }
        };

        countDownTimer.start();
    }

    private void startCountdown1() {
        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsLeft = millisUntilFinished / 1000;
                start.setText("Next (" + secondsLeft + ")");
                start.setEnabled(false); // Disable the button during countdown
            }

            @Override
            public void onFinish() {
                start.setText("Next");
                start.setEnabled(true); // Enable the button after countdown completes
            }
        };

        countDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void dialgbox() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.honeygaincase125_dialogbox);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.anim.fade_in;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                new CountDownTimer(5000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        dialog.dismiss();
                        url_passing(honeygaincase125_Next.this);
                        startCountdown();
                    }
                }.start();
            }
        });
        dialog.show();
    }

    private void dialgbox1() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.honeygaincase125_dialogbox);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.anim.fade_in;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                new CountDownTimer(5000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        dialog.dismiss();
                        url_passing(honeygaincase125_Next.this);
                        startCountdown1();
                    }
                }.start();
            }
        });
        dialog.show();
    }

}