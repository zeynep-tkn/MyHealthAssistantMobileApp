
package com.zeyneptekin.myhealthassistant;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ProfileFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Button SaglikProfilim;
    private Button Randevularim;


    public ProfileFragment() {
        // Gerekli boş yapıcı metod
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

        return view;
    }
}
