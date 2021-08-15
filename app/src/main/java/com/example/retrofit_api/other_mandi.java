package com.example.retrofit_api;

import com.google.gson.annotations.SerializedName;

public class other_mandi {
    @SerializedName("crop_id")
    private String crop_id;
    @SerializedName("district")
    private String district;
    @SerializedName("district_id")
    private String district_id;
    @SerializedName("hindi_name")
    private String hindi_name;
    @SerializedName("id")
    private String id;
    @SerializedName("image")
    private String image;
    @SerializedName("km")
    private String km;
    @SerializedName("last_date")
    private String last_date;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("location")
    private String location;
    @SerializedName("market")
    private String market;
    @SerializedName("meters")
    private String meters;
    @SerializedName("state")
    private String state;
    @SerializedName("url_str")
    private String url_str;

    public other_mandi(String crop_id, String district, String district_id, String hindi_name, String id, String image, String km, String last_date, String lat, String lng, String location, String market, String meters, String state, String url_str) {
        this.crop_id = crop_id;
        this.district = district;
        this.district_id = district_id;
        this.hindi_name = hindi_name;
        this.id = id;
        this.image = image;
        this.km = km;
        this.last_date = last_date;
        this.lat = lat;
        this.lng = lng;
        this.location = location;
        this.market = market;
        this.meters = meters;
        this.state = state;
        this.url_str = url_str;
    }

    public String getCrop_id() {
        return crop_id;
    }

    public String getDistrict() {
        return district;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public String getHindi_name() {
        return hindi_name;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getKm() {
        return km;
    }

    public String getLast_date() {
        return last_date;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getLocation() {
        return location;
    }

    public String getMarket() {
        return market;
    }

    public String getMeters() {
        return meters;
    }

    public String getState() {
        return state;
    }

    public String getUrl_str() {
        return url_str;
    }
}

