package com.zeyneptekin.myhealthassistant;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
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
    public void addRandevuBilgisi(String bolum, String tarih, String saat, String doktor, String hastahane) {
        Map<String, Object> randevuBilgisi = new HashMap<>();
        randevuBilgisi.put("bolum", bolum);
        randevuBilgisi.put("tarih", tarih);
        randevuBilgisi.put("saat", saat);
        randevuBilgisi.put("doktor", doktor);
        randevuBilgisi.put("hastahane", hastahane);

        // Firestore koleksiyonunu ve belirli bir belgeyi belirle
        DocumentReference docref = db.collection("users").document("aXjqaM073S5UPEMiT2fu").
                collection("HealthInformations").document("RbEvitDDUmvkeIO9EKHx").collection("randevularım").document();
        // Belgeye veriyi ekle ve başarılı olduğunda bir onSuccessListener dinle
        docref.set(randevuBilgisi)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Veri başarıyla eklendi
                        Toast.makeText(context, "Randevu bilgileri başarıyla kaydedildi!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Veri ekleme başarısız oldu
                        Toast.makeText(context, "Randevu bilgileri eklenirken hata oluştu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public void updateExerciseStatus(String egzersizAdi,int egzersizVal) {
        // Firestore koleksiyonunu ve belirli bir belgeyi belirle
        DocumentReference docRef = db.collection("users")
                .document("aXjqaM073S5UPEMiT2fu")
                .collection("egzersiz")
                .document("1SihdqPNvOZLfZfdRNaF");

        // Belgeyi al ve güncelleme işlemlerini yap
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        // Doküman başarıyla alındığında yapılacak işlemler
                        if (documentSnapshot.exists()) {
                            // Egzersizler map'ini al
                            int egzersizValue = documentSnapshot.getLong(egzersizAdi) != null ?
                                    documentSnapshot.getLong(egzersizAdi).intValue() : 0;
                            //egzersizValue++; // Egzersiz değerini arttır
                            if(egzersizValue < egzersizVal) {
                                egzersizValue = egzersizVal;
                                //test amaçlı veya isteğe bağlı ayarlanma,
                                //anlık olarak hangi aşamadaysa o aşama bittikten sonra database ye o aşama değerini kaydedicek
                                //eğer yapılması gerekenden başka bir şey yapıldığında artmayacak çünkü o hareket çoktan yapıldı
                            }

                            if(egzersizValue == 10){
                                egzersizValue = 0;
                            }

                            final int egzersizValueForLog = egzersizValue;
                            docRef.update(egzersizAdi, egzersizValue)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            // Güncelleme başarılı olduğunda yapılacak işlemler
                                            System.out.println("Egzersiz değeri başarıyla arttırıldı. Yeni değer: " + egzersizValueForLog);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Güncelleme başarısız olduğunda yapılacak işlemler
                                            System.out.println("Egzersiz değeri arttırılırken bir hata oluştu: " + e.getMessage());
                                        }
                                    });
                        } else {
                            // Belirtilen belge bulunamadığında yapılacak işlemler
                            System.out.println("Belirtilen belge bulunamadı. Yeni bir özellik oluşturulacak.");
                            Map<String, Object> newData = new HashMap<>();
                            newData.put(egzersizAdi, 1); // Yeni egzersiz adı ile 1 değeriyle yeni bir özellik oluşturulacak
                            docRef.set(newData)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            System.out.println("Yeni egzersiz özelliği başarıyla oluşturuldu ve değeri 1 olarak ayarlandı.");
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            System.out.println("Yeni egzersiz özelliği oluşturulurken bir hata oluştu: " + e.getMessage());
                                        }
                                    });
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Doküman alınırken hata oluştuğunda yapılacak işlemler
                        Log.w(TAG, "Doküman alınırken hata oluştu", e);
                        System.out.println("Doküman alınırken hata oldu");
                    }
                });
    }
    //----
    public void showProgressForSportPage(String egzersizAdi, final ProgressFetchListener listener) {
        // Firestore koleksiyonunu ve belirli bir belgeyi belirle
        DocumentReference docRef = db.collection("users")
                .document("aXjqaM073S5UPEMiT2fu")
                .collection("egzersiz")
                .document("1SihdqPNvOZLfZfdRNaF");

        // Belgeyi al ve güncelleme işlemlerini yap
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        // Doküman başarıyla alındığında yapılacak işlemler
                        int egzersizValue = 0;
                        if (documentSnapshot.exists()) {
                            // Egzersizler map'ini al
                            egzersizValue = documentSnapshot.getLong(egzersizAdi) != null ?
                                    documentSnapshot.getLong(egzersizAdi).intValue() : 0;
                        } else {
                            // Belirtilen belge bulunamadığında yapılacak işlemler
                            System.out.println("Belirtilen belge bulunamadı. Yeni bir özellik oluşturulacak.");
                            Map<String, Object> newData = new HashMap<>();
                            newData.put(egzersizAdi, 0); // Yeni egzersiz adı ile 1 değeriyle yeni bir özellik oluşturulacak
                            docRef.set(newData)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            System.out.println("Yeni egzersiz özelliği başarıyla oluşturuldu ve değeri 1 olarak ayarlandı.");
                                            listener.onProgressFetch(0); // Değeri geri dön
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            System.out.println("Yeni egzersiz özelliği oluşturulurken bir hata oluştu: " + e.getMessage());
                                            listener.onProgressFetch(-1); // Hata durumunu geri dön
                                        }
                                    });
                        }
                        // Egzersiz değerini döndür
                        listener.onProgressFetch(egzersizValue);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Doküman alınırken hata oluştuğunda yapılacak işlemler
                        System.out.println("Doküman alınırken hata oldu: " + e.getMessage());
                        listener.onProgressFetch(-1); // Hata durumunu geri dön
                    }
                });
    }

    // Firestore'dan değeri alındığında geri çağrı yapılacak arayüz
    public interface ProgressFetchListener {
        void onProgressFetch(int progress);
    }




}



