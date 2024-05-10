package com.zeyneptekin.myhealthassistant;

import java.io.Serializable;
public class Randevu {
    private String bolum;
    private String tarih;
    private String saat;
    private String hastahane;
    private String doktor;

    // Parametrelerle çalışan bir yapıcı metot tanımla
    public Randevu(String bolum, String tarih, String saat, String hastahane, String doktor) {
        this.bolum = bolum;
        this.tarih = tarih;
        this.saat = saat;
        this.hastahane = hastahane;
        this.doktor = doktor;
    }

    // Getter ve setter metotları
    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getHastahane() {
        return hastahane;
    }

    public void setHastahane(String hastahane) {
        this.hastahane = hastahane;
    }

    public String getDoktor() {
        return doktor;
    }

    public void setDoktor(String doktor) {
        this.doktor = doktor;
    }

    // Veri doğrulama metodu
    public boolean isValid() {
        // Basit bir doğrulama örneği: Tarih ve saat bilgisi olmalı
        return tarih != null && !tarih.isEmpty() && saat != null && !saat.isEmpty();
    }

    // toString metodu
    @Override
    public String toString() {
        return "Randevu{" +
                "bolum='" + bolum + '\'' +
                ", tarih='" + tarih + '\'' +
                ", saat='" + saat + '\'' +
                ", hastahane='" + hastahane + '\'' +
                ", doktor='" + doktor + '\'' +
                '}';
    }
}
