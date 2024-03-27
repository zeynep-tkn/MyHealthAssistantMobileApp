package com.zeyneptekin.myhealthassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.Random;

public class MotivationActivity extends AppCompatActivity {


    private final String[] motivationMessages = {
            "Her gün biraz daha iyileşiyorsun!",
            "Başarı, her gün bir adım atmaktır.",
            "Hiçbir şey seni durduramaz!",
            "Bugün için motivasyonunu artır!",
            "İnanıyorum, yapabilirsin!",
            "Hayal ettiğin her şeyin üzerine çık!",
            "Kendine güvenin, başarının anahtarıdır!",
            "Senin gücün sınırsızdır!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);

        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

        MaterialButton button1 = createButton("Button 1");
        MaterialButton button2 = createButton("Button 2");
        MaterialButton button3 = createButton("Button 3");
        MaterialButton button4 = createButton("Button 4");
        MaterialButton button5 = createButton("Button 5");
        MaterialButton button6 = createButton("Button 6");
        TextView textView = createTextView("HER GÜN BİR ADIM DAHA YAKINSINIZ!");
        TextView motivationTextView = createTextView(getRandomMotivationMessage());

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );

        constraintLayout.addView(button1, layoutParams);
        constraintLayout.addView(button2, layoutParams);
        constraintLayout.addView(button3, layoutParams);
        constraintLayout.addView(button4, layoutParams);
        constraintLayout.addView(button5, layoutParams);
        constraintLayout.addView(button6, layoutParams);
        constraintLayout.addView(textView, layoutParams);
        constraintLayout.addView(motivationTextView, layoutParams);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(button1.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        constraintSet.connect(button2.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        constraintSet.connect(button3.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 0);
        constraintSet.connect(button4.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);
        constraintSet.connect(button5.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);
        constraintSet.connect(button6.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 0);
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        constraintSet.connect(button1.getId(), ConstraintSet.BOTTOM, textView.getId(), ConstraintSet.BOTTOM, 16);
        constraintSet.connect(motivationTextView.getId(), ConstraintSet.TOP, button6.getId(), ConstraintSet.BOTTOM, 16);

        constraintSet.applyTo(constraintLayout);
    }

    private MaterialButton createButton(String text) {
        MaterialButton button = new MaterialButton(this);
        button.setText(text);
        button.setId(View.generateViewId());
        return button;
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setId(View.generateViewId());
        return textView;
    }

    private String getRandomMotivationMessage() {
        Random random = new Random();
        int index = random.nextInt(motivationMessages.length);
        return motivationMessages[index];
    }



}