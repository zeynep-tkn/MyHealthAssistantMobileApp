
package com.zeyneptekin.myhealthassistant;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ProfileFragment extends Fragment {

    private Button SaglikProfilim;
    private Button Randevularim;
    private Button Ayarlar;
    private Button SSSSayfasi;
    private Button Hakkinda;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Fragment için layout dosyasını şişir
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Butonu bul ve tıklama olayını ayarla
        SaglikProfilim = view.findViewById(R.id.saglikProfilim);
        SaglikProfilim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sağlık Profilim sayfasına geçiş yap
                Intent intent = new Intent(getActivity(), saglikProfilim.class);
                startActivity(intent);
            }
        });

        // Butonu bul ve tıklama olayını ayarla
        Randevularim = view.findViewById(R.id.randevularim);
        Randevularim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Randevularım sayfasına geçiş yap
                Intent intent = new Intent(getActivity(), Randevularim.class);
                startActivity(intent);
            }
        });

        // Butonu bul ve tıklama olayını ayarla
        Ayarlar = view.findViewById(R.id.ayarlar);
        Ayarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ayarlar sayfasına geçiş yap
                Intent intent = new Intent(getActivity(), ayarlar.class);
                startActivity(intent);
            }
        });

        // Butonu bul ve tıklama olayını ayarla
        SSSSayfasi = view.findViewById(R.id.sss);
        SSSSayfasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sıkça Sorulan Sorular sayfasına geçiş yap
                Intent intent = new Intent(getActivity(), SSS.class);
                startActivity(intent);
            }
        });

        // Butonu bul ve tıklama olayını ayarla
        Hakkinda = view.findViewById(R.id.hakkinda);
        Hakkinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hakkında sayfasına geçiş yap
                Intent intent = new Intent(getActivity(), hakkinda.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
