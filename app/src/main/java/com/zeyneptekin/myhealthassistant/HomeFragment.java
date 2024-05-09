package com.zeyneptekin.myhealthassistant;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnDateSelectedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private CardView MotivationCard;
    private CardView SportsCard;
    private CardView EducationCard;
    private CardView FoodCard;
    private CustomCalendar customCalendar;
    ImageView PlusButton;
    ImageView MinusButton;
    private TextView AmountText;
    private int kalanBardak;
    FirestoreHelper db = new FirestoreHelper(getActivity());
    double kullaniciKilo;
    ArrayList<BarEntry> barArrayList;

    BarChart barChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        AmountText = view.findViewById(R.id.amountTextView);
        MinusButton=view.findViewById(R.id.minusButton);
        PlusButton=view.findViewById(R.id.plusButton);

        customCalendar = view.findViewById(R.id.custom_calendar);
        MotivationCard = view.findViewById(R.id.motivationCard);
        SportsCard = view.findViewById(R.id.sportsCard);
        EducationCard = view.findViewById(R.id.educationCard);
        FoodCard = view.findViewById(R.id.foodCard);
        barChart= view.findViewById(R.id.barchart);


        //takvim kodları
        HashMap<Object, Property> descHashMap = new HashMap<>();

        Property defaultProperty =new Property();
        defaultProperty.layoutResource=R.layout.default_view;
        defaultProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("default",defaultProperty);

        Property currentProperty=new Property();
        currentProperty.layoutResource=R.layout.current_view;
        currentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("current",currentProperty);

        Property presentProperty =new Property();
        presentProperty.layoutResource=R.layout.present_view;
        presentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("present",presentProperty);

        Property absentProperty =new Property();
        absentProperty.layoutResource=R.layout.absent_view;
        absentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("absent",absentProperty);

        customCalendar.setMapDescToProp(descHashMap);
        HashMap<Integer,Object> dateHashMap =new HashMap<>();
        Calendar calendar=Calendar.getInstance();

        dateHashMap.put(calendar.get(Calendar.DAY_OF_MONTH),"current");
        dateHashMap.put(1,"present");
        dateHashMap.put(2,"absent");
        dateHashMap.put(3,"present");
        dateHashMap.put(6,"absent");
        dateHashMap.put(20,"present");
        dateHashMap.put(30,"absent");

        customCalendar.setDate(calendar,dateHashMap);
        customCalendar.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(View view, Calendar selectedDate, Object desc) {
                String sDate=selectedDate.get(Calendar.DAY_OF_MONTH)
                        +"/"+(selectedDate.get(Calendar.MONTH)+1)
                        +"/"+selectedDate.get(Calendar.YEAR);

                Toast.makeText(getContext(), sDate, Toast.LENGTH_SHORT).show();

            }
        });


        //kalori takip grafiği
        getData();
        BarDataSet barDataSet=new BarDataSet(barArrayList,"Kalori Değerleri");
        BarData barData =new BarData(barDataSet);
        barChart.setData(barData);
        //color bar data set
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //text color
        barDataSet.setValueTextColor(Color.BLACK);
        //setting text size
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);





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


        //su takip +firebase
        kullaniciKilo = 70;
        db.GetUserWeight(new FirestoreHelper.WeightFetchListener() {
            @Override
            public void onWeightFetched(int weight) {
                if (weight != -1) {
                    // Firestore'dan başarıyla ağırlık değeri alındı
                    kullaniciKilo = weight;
                    // İşlemleri burada gerçekleştir
                }
            }
        });
        double katSayi = 0.033; //kilogram
        double suKilogram = katSayi * kullaniciKilo; //su miktarı kilogram
        double toplamBardak = suKilogram / 0.2; // İçilen suyun bardak sayısına çevrilmesi
        kalanBardak = (int) toplamBardak;
        System.out.println("toplam bardak sayısı:"+toplamBardak);

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; // Ocak 0'dan başlar, bu yüzden 1 ekliyoruz
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String currentDate = day + "-" + month + "-" + year;
        System.out.println("Bugünün tarihi: " + currentDate);

        PlusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Mevcut değeri al
                System.out.println("Plus butonuna tıklandı");
                String currentValueString = AmountText.getText().toString();
                // String'i integer'a dönüştür
                try {
                    int currentValue = Integer.parseInt(currentValueString);
                    // Eğer mevcut değer küçükse, değeri bir artır
                    if (currentValue < toplamBardak) {
                        int newValue = currentValue + 1;
                        kalanBardak--;
                        AmountText.setText(String.valueOf(newValue));
                        System.out.println(newValue);
                        db.SaveWaterTrackingData(newValue,(int)toplamBardak,currentDate);
                        // Eğer yeni değer 8 ise "Başarılı" mesajını göster
                        if (newValue >= toplamBardak) {
                            Toast.makeText(getActivity(), "Tebrikler! Hedefe ulaştınız", Toast.LENGTH_LONG).show();
                        }
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("Metni bir tamsayıya dönüştürme hatası oluştu");
                }

            }
        });


        MinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mevcut tarihi al

                System.out.println("Minus butonuna tıklandı");
                // Mevcut değeri al
                String currentValueString = AmountText.getText().toString();
                try {
                    int currentValue = Integer.parseInt(currentValueString);
                // Eğer mevcut değer 0'dan büyükse, değeri bir azalt
                if (currentValue > 0) {
                    int newValue = currentValue - 1;
                    kalanBardak++;
                    AmountText.setText(String.valueOf(newValue));
                    System.out.println(newValue);
                    // Yeni değeri TextView'e yaz
                    db.SaveWaterTrackingData(newValue,kalanBardak,currentDate);
                    AmountText.setText(String.valueOf(newValue));
                }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("Metni bir tamsayıya dönüştürme hatası oluştu");
                }
            }
        });

        return view;
    }


    //kalori takip fonksiyonu
    private void getData(){
        barArrayList=new ArrayList<>();
        barArrayList.add(new BarEntry(0,10)); // Pazartesi
        barArrayList.add(new BarEntry(1,20)); // Salı
        barArrayList.add(new BarEntry(2,15)); // Çarşamba
        barArrayList.add(new BarEntry(3,25)); // Perşembe
        barArrayList.add(new BarEntry(4,18)); // Cuma

        // Günleri temsil eden bir dizi oluşturun
        String[] days = {"Pzt", "Sal", "Çar", "Per", "Cum"};

        // Her bir çubuk için bir BarEntry oluştururken bu günleri kullanarak BarEntry listesini doldurun
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for (int i = 0; i < barArrayList.size(); i++) {
            barEntries.add(new BarEntry(i, barArrayList.get(i).getY()));
        }

        // BarDataSet oluşturun
        BarDataSet barDataSet=new BarDataSet(barEntries,"Kalori Takibi");
        BarData barData =new BarData(barDataSet);

        // Grafiği güncelleyin
        barChart.setData(barData);
        barChart.invalidate();

        //color bar data set
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //text color
        barDataSet.setValueTextColor(Color.BLACK);
        //setting text size
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);
    }


}
