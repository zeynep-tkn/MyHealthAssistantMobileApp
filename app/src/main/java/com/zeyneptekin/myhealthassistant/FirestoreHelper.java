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
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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


    public void updateExerciseStatus(String egzersizAdi, int egzersizVal) {
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
                            if (egzersizValue < egzersizVal) {
                                egzersizValue = egzersizVal;
                                //test amaçlı veya isteğe bağlı ayarlanma,
                                //anlık olarak hangi aşamadaysa o aşama bittikten sonra database ye o aşama değerini kaydedicek
                                //eğer yapılması gerekenden başka bir şey yapıldığında artmayacak çünkü o hareket çoktan yapıldı
                            }

                            if (egzersizValue == 10) {
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

    public void addHastalikBilgisi(String hastalikIsmi) {
        // Firestore'a veri eklemek için bir Map oluştur
        Map<String, Object> hastalikBilgisi = new HashMap<>();
        hastalikBilgisi.put("hastalik Ismi", hastalikIsmi);


        // Firestore koleksiyonunu ve belirli bir belgeyi belirle
        DocumentReference docref = db.collection("users").document("aXjqaM073S5UPEMiT2fu").
                collection("HealthInformations").document("RbEvitDDUmvkeIO9EKHx").collection("Hastalıklarım").document();
        // Belgeye veriyi ekle ve başarılı olduğunda bir onSuccessListener dinle
        docref.set(hastalikBilgisi)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Veri başarıyla eklendi
                        Toast.makeText(context, "Hastalık ismi başarıyla kaydedildi!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Veri ekleme başarısız oldu
                        Toast.makeText(context, "Hastalık ismi eklenirken hata oluştu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void addAlerjiBilgisi(String alerjiIsmi) {
        // Firestore'a veri eklemek için bir Map oluştur
        Map<String, Object> alerjiBilgisi = new HashMap<>();
        alerjiBilgisi.put("Alerji Ismi", alerjiIsmi);


        // Firestore koleksiyonunu ve belirli bir belgeyi belirle
        DocumentReference docref = db.collection("users").document("aXjqaM073S5UPEMiT2fu").
                collection("HealthInformations").document("RbEvitDDUmvkeIO9EKHx").collection("Alerjilerim").document();
        // Belgeye veriyi ekle ve başarılı olduğunda bir onSuccessListener dinle
        docref.set(alerjiBilgisi)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Veri başarıyla eklendi
                        Toast.makeText(context, "Alerji ismi başarıyla kaydedildi!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Veri ekleme başarısız oldu
                        Toast.makeText(context, "Alerji ismi eklenirken hata oluştu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void addAmeliyatBilgisi(String ameliyatIsmi, String ameliyatTarihi) {
        Map<String, Object> ameliyatBilgisi = new HashMap<>();
        ameliyatBilgisi.put("Ameliyat Ismi", ameliyatIsmi);
        ameliyatBilgisi.put("Ameliyat Tarihi", ameliyatTarihi);


        // Firestore koleksiyonunu ve belirli bir belgeyi belirle
        DocumentReference docref = db.collection("users").document("aXjqaM073S5UPEMiT2fu").
                collection("HealthInformations").document("RbEvitDDUmvkeIO9EKHx").collection("Ameliyatlarım").document();
        // Belgeye veriyi ekle ve başarılı olduğunda bir onSuccessListener dinle
        docref.set(ameliyatBilgisi)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Veri başarıyla eklendi
                        Toast.makeText(context, "Ameliyat bilgisi başarıyla kaydedildi!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Veri ekleme başarısız oldu
                        Toast.makeText(context, "Ameliyat bilgisi eklenirken hata oluştu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void SaveWaterTrackingData(int drunkedWater, int waterOfDrink, String date) {
        DocumentReference docref = db.collection("users").document("aXjqaM073S5UPEMiT2fu").
                collection("Su-Takibi").document(date);
        Map<String, Object> data = new HashMap<>();
        data.put("icilenSu", drunkedWater);
        data.put("icilmesiGerekenSu", waterOfDrink);
        docref.set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Veri ekleme işlemi başarılı!");
                        System.out.println("Veri kaydetme başarılı");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Veri ekleme işlemi başarısız!", e);
                        System.out.println("Veri kaydetme başarısız");
                    }
                });
    }

    public void GetUserWeight(final WeightFetchListener listener) {
        DocumentReference docRef = db.collection("users")
                .document("aXjqaM073S5UPEMiT2fu");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    // Firestore'dan ağırlık değerini al
                    int weight = documentSnapshot.getLong("userWeight") != null ?
                            documentSnapshot.getLong("userWeight").intValue() : 0;
                    // Geri çağrı ile ağırlık değerini döndür
                    listener.onWeightFetched(weight);
                } else {
                    // Belge bulunamadığında veya ağırlık değeri yoksa -1 döndür
                    listener.onWeightFetched(-1);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Firestore'dan veri alınırken bir hata oluştuğunda -1 döndür
                System.out.println("weight verisi çağırılamadı");
                listener.onWeightFetched(-1);
            }
        });
    }

    // Firestore'dan ağırlık değerini alındığında geri çağrı yapılacak arayüz
    public interface WeightFetchListener {
        void onWeightFetched(int weight);
    }

    // Firestore'dan değeri alındığında geri çağrı yapılacak arayüz
    public interface ProgressFetchListener {
        void onProgressFetch(int progress);
    }


    public void GetHastalıklarımTable(final StringListFetchListener listener) {
        getHastalıklarımTableFromFirestore(new StringListFetchListener() {
            @Override
            public void onStringListFetched(List<String> stringList) {
                listener.onStringListFetched(stringList);
            }
        });
    }

    private void getHastalıklarımTableFromFirestore(final StringListFetchListener listener) {
        db.collection("users").document("aXjqaM073S5UPEMiT2fu").
                collection("HealthInformations").document("RbEvitDDUmvkeIO9EKHx").collection("Hastalıklarım")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> valueList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // Her bir dökümandaki belirli bir alanın değerini al
                                String value = document.getString("hastalik Ismi");
                                if (value != null) {
                                    valueList.add(value);
                                }
                            }
                            // Dinleyiciye string listesini geri çağır
                            listener.onStringListFetched(valueList);
                        } else {
                            // Firestore'dan dökümanları alırken bir hata oluştuğunda boş bir liste döndür
                            listener.onStringListFetched(new ArrayList<String>());
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Firestore'dan dökümanları alırken bir hata oluştuğunda boş bir liste döndür
                        listener.onStringListFetched(new ArrayList<String>());
                    }
                });
    }

    public void GetAlerjilerimTable(final AlerjilerimDatabaseListener listener) {
        getAlerjilerimTableFromFirestore(new AlerjilerimDatabaseListener() {
            @Override
            public void getAlerjilerim(List<String> alerjilerimList) {
                listener.getAlerjilerim(alerjilerimList);
            }
        });
    }
        public void getRandevular ( final RandevuFetchListener listener){
            db.collection("users")
                    .document("aXjqaM073S5UPEMiT2fu")
                    .collection("HealthInformations")
                    .document("RbEvitDDUmvkeIO9EKHx")
                    .collection("randevularım")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                List<Randevu> randevuList = new ArrayList<>();
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    // Her bir dökümandaki randevu bilgilerini al
                                    String bolum = document.getString("bolum");
                                    String tarih = document.getString("tarih");
                                    String saat = document.getString("saat");
                                    String hastahane = document.getString("hastahane");
                                    String doktor = document.getString("doktor");
                                    // Diğer gerekli bilgileri de buradan alabilirsiniz
                                    Randevu randevu;
                                    randevu = new Randevu(bolum, tarih, saat, hastahane, doktor);

                                    randevuList.add(randevu);
                                }
                                // Dinleyiciye randevu listesini geri çağır
                                listener.onRandevuFetch(randevuList);
                            } else {
                                // Firestore'dan dökümanları alırken bir hata oluştuğunda boş bir liste döndür
                                listener.onRandevuFetch(new ArrayList<Randevu>());
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Firestore'dan dökümanları alırken bir hata oluştuğunda boş bir liste döndür
                            listener.onRandevuFetch(new ArrayList<Randevu>());
                        }
                    });
        }


        private void getAlerjilerimTableFromFirestore ( final AlerjilerimDatabaseListener listener){
            db.collection("users").document("aXjqaM073S5UPEMiT2fu").
                    collection("HealthInformations").document("RbEvitDDUmvkeIO9EKHx").collection("Alerjilerim")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                List<String> valueList = new ArrayList<>();
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    // Her bir dökümandaki belirli bir alanın değerini al
                                    String value = document.getString("Alerji Ismi");
                                    if (value != null) {
                                        valueList.add(value);
                                    }
                                }
                                // Dinleyiciye string listesini geri çağır
                                listener.getAlerjilerim(valueList);
                            } else {
                                // Firestore'dan dökümanları alırken bir hata oluştuğunda boş bir liste döndür
                                listener.getAlerjilerim(new ArrayList<String>());
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Firestore'dan dökümanları alırken bir hata oluştuğunda boş bir liste döndür
                            listener.getAlerjilerim(new ArrayList<String>());
                        }
                    });
        }
        public interface AlerjilerimDatabaseListener {
            void getAlerjilerim(List<String> alerjilerimList);
        }

        public interface StringListFetchListener {
            void onStringListFetched(List<String> stringList);
        }

        public interface RandevuFetchListener {
            void onRandevuFetchListener(List<String> stringList);

            void onRandevuFetch(List<Randevu> randevuList);
        }


    }
