package com.zeyneptekin.myhealthassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private CardView MotivationCard;
    private CardView SportsCard;
    private CardView EducationCard;
    private CardView FoodCard;
    private CalendarView calendarView;
    ImageButton PlusButton;
    ImageButton MinusButton;
    private TextView AmountText;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        AmountText = view.findViewById(R.id.amountTextView);
        // Takvim bileşenini bul
        calendarView = view.findViewById(R.id.calendarView);



        // Diğer bileşenlerin tanımlamaları ve tıklama işlevselliği burada devam eder

        MotivationCard = view.findViewById(R.id.motivationCard);
        SportsCard = view.findViewById(R.id.sportsCard);
        EducationCard = view.findViewById(R.id.educationCard);
        FoodCard = view.findViewById(R.id.foodCard);

        MinusButton=view.findViewById(R.id.minusButton);
        PlusButton=view.findViewById(R.id.plusButton);



        MotivationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MotivationActivity.class);
                startActivity(intent);
            }
        });

        SportsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SportsExerciseActivity.class);
                startActivity(intent);
            }
        });

        EducationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EducationActivity.class);
                startActivity(intent);
            }
        });

        FoodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FoodActivity.class);
                startActivity(intent);
            }
        });
        PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mevcut değeri al
                System.out.println("Plus butonuna tıklandı");
                String currentValueString = AmountText.getText().toString();
                // String'i integer'a dönüştür
                int currentValue = Integer.parseInt(currentValueString);
                // Eğer mevcut değer 8'den küçükse, değeri bir artır
                System.out.println("Değer 1 arttırıldı");
                if (currentValue < 8) {
                    int newValue = currentValue + 1;
                    // Yeni değeri TextView'e yaz
                    AmountText.setText(newValue + "/8 bardak");
                    System.out.println(newValue+ "/8 bardak");
                    // Eğer yeni değer 8 ise "Başarılı" mesajını göster
                    if (newValue == 8) {
                        Toast.makeText(getActivity(), "Başarılı", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        MinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Minus butonuna tıklandı");
                // Mevcut değeri al
                String currentValueString = AmountText.getText().toString();
                // String'i integer'a dönüştür
                int currentValue = Integer.parseInt(currentValueString);
                // Eğer mevcut değer 0'dan büyükse, değeri bir azalt
                if (currentValue > 0) {
                    int newValue = currentValue - 1;
                    // Yeni değeri TextView'e yaz
                    AmountText.setText(newValue + "/8 bardak");

                }
            }
        });


        return view;
    }





}
