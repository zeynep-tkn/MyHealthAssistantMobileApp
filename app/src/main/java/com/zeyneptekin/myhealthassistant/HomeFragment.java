package com.zeyneptekin.myhealthassistant;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private CardView MotivationCard;
    private CardView SportsCard;
    private CardView EducationCard;
    private CardView FoodCard;
    private CalendarView calendarView;

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

        // Takvim bileşenini bul
        calendarView = view.findViewById(R.id.calendarView);

        // Mevcut tarihi al
        Calendar calendar = Calendar.getInstance();

        // Mevcut tarihin gününü al
        int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Mevcut tarihi takvimin ilk gününe ayarla (Pazar)
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

        // Mevcut tarihe 6 gün ekleyerek haftanın son gününü al
        calendar.add(Calendar.DAY_OF_MONTH, 6);

        // Haftanın son gününü al
        long lastDayOfWeek = calendar.getTimeInMillis();

        // Takvim bileşenine son günü ayarla
        calendarView.setMaxDate(lastDayOfWeek);

        // Diğer bileşenlerin tanımlamaları ve tıklama işlevselliği burada devam eder

        MotivationCard = view.findViewById(R.id.motivationCard);
        SportsCard = view.findViewById(R.id.sportsCard);
        EducationCard = view.findViewById(R.id.educationCard);
        FoodCard = view.findViewById(R.id.foodCard);

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

        return view;
    }





}
