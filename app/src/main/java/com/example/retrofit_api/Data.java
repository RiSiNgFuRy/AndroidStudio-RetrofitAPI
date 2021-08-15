package com.example.retrofit_api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {
    @SerializedName("fav_mandi")
    private ArrayList<fav_mandi> fav_mandis;
    @SerializedName("other_mandi")
    private ArrayList<other_mandi> other_mandis;

    public ArrayList<other_mandi> getOther_mandis() {
        return other_mandis;
    }

    public ArrayList<fav_mandi> getFav_mandis() {
        return fav_mandis;
    }

    public void setFav_mandis(ArrayList<fav_mandi> fav_mandis) {
        this.fav_mandis = fav_mandis;
    }

    public void setOther_mandis(ArrayList<other_mandi> other_mandis) {
        this.other_mandis = other_mandis;
    }
}
