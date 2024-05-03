package com.zeyneptekin.myhealthassistant;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

import android.util.Log;
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

    public void addIlacBilgisi(String ilacIsmi, String dozaj, String almaSikligi) {
        // Firestore'a veri eklemek için bir Map oluştur
        Map<String, Object> ilacBilgisi = new HashMap<>();
        ilacBilgisi.put("ilacIsmi", ilacIsmi);
        ilacBilgisi.put("dozaj", dozaj);
        ilacBilgisi.put("almaSikligi", almaSikligi);

        // Firestore koleksiyonunu ve belirli bir belgeyi belirle
        DocumentReference docref = db.collection("users").document("aXjqaM073S5UPEMiT2fu").
                collection("HealthInformations").document("RbEvitDDUmvkeIO9EKHx").collection("ilaç Bilgilerim").document();
        // Belgeye veriyi ekle ve başarılı olduğunda bir onSuccessListener dinle
        docref.set(ilacBilgisi)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Veri başarıyla eklendi
                        Toast.makeText(context, "İlaç bilgileri başarıyla kaydedildi!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Veri ekleme başarısız oldu
                        Toast.makeText(context, "İlaç bilgileri eklenirken hata oluştu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void updateExerciseStatus(String egzersizAdi) {
        // Firestore koleksiyonunu ve belirli bir belgeyi belirle
        DocumentReference docRef = db.collection("users").document("aXjqaM073S5UPEMiT2fu")
                .collection("egzersiz").document("1SihdqPNvOZLfZfdRNaF");

        // Belgeyi al ve güncelleme işlemlerini yap
        docRef.update(egzersizAdi, 1)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Başarıyla güncellendiğinde yapılacak işlemler
                        Log.d(TAG, "Egzersiz durumu başarıyla güncellendi");
                        System.out.println("Güncelleme başarılı");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Güncelleme sırasında hata oluştuğunda yapılacak işlemler
                        Log.w(TAG, "Egzersiz durumu güncellenirken hata oluştu", e);
                        System.out.println("Güncellenirken hata oldu");
                    }
                });
    }


}
