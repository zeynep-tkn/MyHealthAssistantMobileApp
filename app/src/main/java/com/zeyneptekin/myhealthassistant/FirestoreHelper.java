package com.zeyneptekin.myhealthassistant;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;
import android.widget.Toast;

public class FirestoreHelper {
    private static final String TAG = "FirestoreHelper";
    private FirebaseFirestore db;
    private Context context;
    public FirestoreHelper(Context context) {
        // Firestore bağlantısını başlat
        db = FirebaseFirestore.getInstance();
        this.context = context;
    }

    public void addIlacAlerjisi(String ilacIsmi) {
        // Firestore'a veri eklemek için bir Map oluştur
        Map<String, Object> ilacAlerjisi = new HashMap<>();
        ilacAlerjisi.put("ilacIsmi", ilacIsmi);

        // Firestore koleksiyonunu ve belirli bir belgeyi belirle
        DocumentReference docref = db.collection("users").document("aXjqaM073S5UPEMiT2fu").
                collection("HealthInformations").document("RbEvitDDUmvkeIO9EKHx").collection("ilaç alerjilerim").document();
        // Belgeye veriyi ekle ve başarılı olduğunda bir onSuccessListener dinle
        docref.set(ilacAlerjisi)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Veri başarıyla eklendi
                        Toast.makeText(context, "Veri başarıyla kaydedildi!", Toast.LENGTH_SHORT).show();


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Veri ekleme başarısız oldu
                        Toast.makeText(context, "Veri eklenirken hata oluştu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
