package com.zeyneptekin.myhealthassistant;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class P2Movement1Activity extends AppCompatActivity {
    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftinmillis;
    AlertDialog.Builder builderDialog;
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate metodu çalışıyo");
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");

        int intValue = Integer.valueOf(buttonvalue);

        switch (intValue) {
            case 1:
                setContentView(R.layout.activity_sport_bir2);
                break;
            case 2:
                setContentView(R.layout.activity_sport_iki2);
                break;
            case 3:
                setContentView(R.layout.activity_sport_uc2);
                break;
            case 4:
                setContentView(R.layout.activity_sport_dort2);
                break;
            case 5:
                setContentView(R.layout.activity_sport_bes2);
                break;
            case 6:
                setContentView(R.layout.activity_sport_alti2);
                break;
            case 7:
                setContentView(R.layout.activity_sport_yedi2);
                break;
            case 8:
                setContentView(R.layout.activity_sport_sekiz2);
                break;
            case 9:
                setContentView(R.layout.activity_sport_dokuz2);
                break;
            case 10:
                setContentView(R.layout.activity_sport_on2);
                break;
        }

        //setContentView(R.layout.activity_p2_movement1);
        MTimeRunning = false;
        startBtn = findViewById(R.id.startButton);
        mtextview = findViewById(R.id.timeButton);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Butona tıklandı!"); // Log.d() kullanarak Logcat'e yazıyoruz
                if (MTimeRunning) {
                    stopTimer();
                }
                else {
                    startTimer();
                }
            }
        });
    }

    private void stopTimer() {
        System.out.println("stopTimer metodu çalışıyo");
        countDownTimer.cancel();
        MTimeRunning = false;
        startBtn.setText("START");
    }

    private void startTimer() {
        System.out.println("startTimer metodu çalışıyo");
        final CharSequence value1 = mtextview.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0, 2);
        String num3 = num1.substring(3, 5);

        final int number = Integer.valueOf(num2) * 60 + Integer.valueOf(num3);
        MTimeLeftinmillis = number * 1000;

        countDownTimer = new CountDownTimer(MTimeLeftinmillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                MTimeLeftinmillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                int newValue = Integer.valueOf(buttonvalue) + 1;

                if (newValue <= 10) {
                    Intent intent = new Intent(P2Movement1Activity.this, P2Movement1Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newValue));
                    startActivity(intent);
                }
                else {
                    // Sport success dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(P2Movement1Activity.this);
                    View successDialogView = getLayoutInflater().inflate(R.layout.sport_successdialog, null);
                    builder.setView(successDialogView);

                    // Button to dismiss the dialog
                    Button okButton = successDialogView.findViewById(R.id.buttonOk);
                    okButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Dismiss the dialog
                            alertDialog.dismiss();

                            //ok butonuna basınca programlar sayfasına geçsin
                            Intent intent = new Intent(P2Movement1Activity.this, SportsExerciseActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    });
                    // Show the dialog
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        }.start();

        startBtn.setText("Pause");
        MTimeRunning = true;
    }

    private void updateTimer() {
        int minutes = (int) (MTimeLeftinmillis / 60000);
        int seconds = (int) (MTimeLeftinmillis % 60000 / 1000);

        String timeLeftText = "";

        if (minutes < 10) {
            timeLeftText = "0";
        }
        timeLeftText += minutes + ":";

        if (seconds < 10) {
            timeLeftText += "0";
        }
        timeLeftText += seconds;

        mtextview.setText(timeLeftText);
    }

}
