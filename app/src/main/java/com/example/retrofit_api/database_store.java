package com.example.retrofit_api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class database_store {
    public static final String KEY_ROWID="row_id";
    public static final String KEY_CROP_ID="crop_id";
    public static final String KEY_DISTRICT="district";
    public static final String KEY_DISTRICT_ID="district_id";
    public static final String KEY_HINDI_NAME="hindi_name";
    public static final String KEY_ID="_id";
    public static final String KEY_IMAGE="_image";
    public static final String KEY_KM="_km";
    public static final String KEY_LAST_DATE="last_date";
    public static final String KEY_LAT="_lat";
    public static final String KEY_LNG="_lng";
    public static final String KEY_LOCATION="location";
    public static final String KEY_MARKET="market";
    public static final String KEY_METERS="meters";
    public static final String KEY_STATE="state";
    public static final String KEY_URL_STR="url_str";


    private final String DATABASE_NAME="database_store";
    private final String DATABASE_TABLE="DataEntryOfCrops";
    private final int DATABASE_VERSION=1;

    private DBHelper ourHelper;
    private Context ourContext;
    private SQLiteDatabase ourDatabase;

    public database_store(Context context){
        ourContext = context;
    }

    public class DBHelper extends SQLiteOpenHelper
    {
        public DBHelper(Context context)
        {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            String sqlcode="CREATE TABLE "+DATABASE_TABLE+" ("+
                    KEY_ROWID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    KEY_CROP_ID+" TEXT NOT NULL, "+
                    KEY_DISTRICT+" TEXT NOT NULL, "+
                    KEY_DISTRICT_ID+" TEXT NOT NULL, "+
                    KEY_HINDI_NAME+" TEXT NOT NULL, "+
                    KEY_ID+" TEXT NOT NULL, "+
                    KEY_KM+" TEXT NOT NULL, "+
                    KEY_LAST_DATE+" TEXT NOT NULL, "+
                    KEY_LAT+" TEXT NOT NULL, "+
                    KEY_LNG+" TEXT NOT NULL, "+
                    KEY_LOCATION+" TEXT NOT NULL, "+
                    KEY_MARKET+" TEXT NOT NULL, "+
                    KEY_METERS+" TEXT NOT NULL, "+
                    KEY_STATE+" TEXT NOT NULL, "+
                    KEY_URL_STR+" TEXT NOT NULL, "+
                    KEY_IMAGE+" VARCHAR(1000) );";
            db.execSQL(sqlcode);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
            onCreate(db);
        }
    }
    public com.example.retrofit_api.database_store open() throws SQLException
    {
        ourHelper=new DBHelper(ourContext);
        ourDatabase=ourHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        ourHelper.close();
    }

    public long createEntry(String crop_id, String district, String district_id, String hindi_name, String id, String image, String km, String last_date, String lat, String lng, String location, String market, String meters, String state, String url_str)
    {
        ContentValues cv=new ContentValues();
        cv.put(KEY_CROP_ID,crop_id);
        cv.put(KEY_DISTRICT,district);
        cv.put(KEY_DISTRICT_ID,district_id);
        cv.put(KEY_HINDI_NAME,hindi_name);
        cv.put(KEY_ID,id);
        cv.put(KEY_IMAGE,image);
        cv.put(KEY_KM,km);
        cv.put(KEY_LAST_DATE,last_date);
        cv.put(KEY_LAT,lat);
        cv.put(KEY_LNG,lng);
        cv.put(KEY_LOCATION,location);
        cv.put(KEY_MARKET,market);
        cv.put(KEY_METERS,meters);
        cv.put(KEY_STATE,state);
        cv.put(KEY_URL_STR,url_str);
        return ourDatabase.insert(DATABASE_TABLE,null,cv);
    }


    public String getKeyCropId(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_CROP_ID,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int CropId=c.getColumnIndex(KEY_CROP_ID);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(CropId);
                break;
            }
        }
        c.close();
        return result;
    }
    public String getKeyDistrict(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_DISTRICT,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int District=c.getColumnIndex(KEY_DISTRICT);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(District);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyDistrictId(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_DISTRICT_ID,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int DistrictId=c.getColumnIndex(KEY_DISTRICT_ID);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(DistrictId);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyHindiName(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_HINDI_NAME,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int HindiName=c.getColumnIndex(KEY_HINDI_NAME);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(HindiName);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyId(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_ID,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int CId=c.getColumnIndex(KEY_ID);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(CId);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyImage(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_IMAGE,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int Image=c.getColumnIndex(KEY_IMAGE);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(Image);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyKm(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_KM,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int Km=c.getColumnIndex(KEY_KM);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(Km);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyLastDate(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_LAST_DATE,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int LastDate=c.getColumnIndex(KEY_LAST_DATE);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(LastDate);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyLat(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_LAT,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int Lat=c.getColumnIndex(KEY_LAT);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(Lat);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyLng(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_LNG,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int Lng=c.getColumnIndex(KEY_LNG);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(Lng);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyLocation(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_LOCATION,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int Location=c.getColumnIndex(KEY_LOCATION);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(Location);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyMarket(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_MARKET,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int Market=c.getColumnIndex(KEY_MARKET);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(Market);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyMeters(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_METERS,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int Meters=c.getColumnIndex(KEY_METERS);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(Meters);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyState(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_STATE,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int State=c.getColumnIndex(KEY_STATE);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(State);
                break;
            }
        }
        c.close();
        return result;
    }

    public String getKeyUrlStr(Integer Id) {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_URL_STR,KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int UrlStr=c.getColumnIndex(KEY_URL_STR);
        int pid=c.getColumnIndex(KEY_ROWID);
        String result="";
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            if(c.getString(pid).equals(Id.toString())){
                result+= c.getString(UrlStr);
                break;
            }
        }
        c.close();
        return result;
    }

    public ArrayList<Integer> uniqueIDs() {
        Cursor c = ourDatabase.query(DATABASE_TABLE, new String[]{KEY_ROWID}, null, null, null, null,KEY_ROWID);
        int pid=c.getColumnIndex(KEY_ROWID);
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            result.add(Integer.parseInt(c.getString(pid)));
        }
        c.close();
        return result;
    }

    public long deleteEntry(Integer ID)
    {
        return ourDatabase.delete(DATABASE_TABLE,KEY_ID+"=?",new String[]{ID.toString()});
    }

    public boolean isEmpty()
    {
        boolean e=true;
        Cursor c=ourDatabase.rawQuery("SELECT COUNT(*) FROM "+DATABASE_TABLE,null);
        if(c!=null && c.moveToFirst())
            e=(c.getInt(0))==0;
        c.close();
        return e;
    }
}
