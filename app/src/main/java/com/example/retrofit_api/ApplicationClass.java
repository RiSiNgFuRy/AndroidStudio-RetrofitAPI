package com.example.retrofit_api;

import android.app.Application;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<other_mandi> items;
    @Override
    public void onCreate() {
        super.onCreate();
        items = new ArrayList<other_mandi>();
        try {
            database_store db=new database_store(this);
            db.open();
            if(!db.isEmpty()) {
                for(int j=0;j<db.uniqueIDs().size();j++){
                    int i = db.uniqueIDs().get(j);
                    items.add(new other_mandi(db.getKeyCropId(i), db.getKeyDistrict(i), db.getKeyDistrictId(i), db.getKeyHindiName(i), db.getKeyId(i), db.getKeyImage(i), db.getKeyKm(i), db.getKeyLastDate(i), db.getKeyLat(i), db.getKeyLng(i), db.getKeyLocation(i), db.getKeyMarket(i), db.getKeyMeters(i), db.getKeyState(i), db.getKeyUrlStr(i)));
                }
            }
            db.close();
        } catch (SQLException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
