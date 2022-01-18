package com.hr200012.bekir_berk_dundar_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Futbolcu {
    @SerializedName("ad")
    @Expose
    public String ad;

    @SerializedName("soyad")
    @Expose
    public String soyad;

    @SerializedName("ulke")
    @Expose
    public String ulke;

    @SerializedName("resim")
    @Expose
    public String resim;

    @SerializedName("kapak_foto")
    @Expose
    public String kapak_foto;

    @SerializedName("ozgecmis")
    @Expose
    public String ozgecmis;
}