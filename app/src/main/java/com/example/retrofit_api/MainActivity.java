

package com.example.retrofit_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ContentsAdapter.ItemSelected {

    private RecyclerView recyclerView;
    Button parsing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int test=0;
        recyclerView = findViewById(R.id.listView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        ContentsAdapter contentsAdapter = new ContentsAdapter(MainActivity.this, ApplicationClass.items);
        recyclerView.setAdapter(contentsAdapter);

        parsing = findViewById(R.id.parsing);
        parsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://thekrishi.com/test/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JsonPlaceHolder placeHolder = retrofit.create(JsonPlaceHolder.class);
                Call<Items> call = placeHolder.getPost();
                call.enqueue(new Callback<Items>() {
                    @Override
                    public void onResponse(Call<Items> call, Response<Items> response) {
                        database_store db = new database_store(MainActivity.this);
                        ArrayList<other_mandi> items = new ArrayList(response.body().getData().getOther_mandis());
                        Toast.makeText(MainActivity.this, "Updating Content", Toast.LENGTH_SHORT).show();
                        try {
                            db.open();
                            int i=0;
                            while(!db.isEmpty()){
                                db.deleteEntry(i);
                                i++;
                            }
                            if(i==0) {
                                ContentsAdapter contentsAdapter = new ContentsAdapter(MainActivity.this, ApplicationClass.items);
                                recyclerView.setAdapter(contentsAdapter);
                                i=1;
                            }
                            for(int j=0;j<items.size();j++) {
                                db.createEntry(items.get(j).getCrop_id(), items.get(j).getDistrict(), items.get(j).getDistrict_id(), items.get(j).getHindi_name(), items.get(j).getId(), items.get(j).getImage(), items.get(j).getKm(), items.get(j).getLast_date(), items.get(j).getLat(), items.get(j).getLng(), items.get(j).getLocation(), items.get(j).getMarket(), items.get(j).getMeters(), items.get(j).getState(), items.get(j).getUrl_str());
                                ApplicationClass.items.add(new other_mandi(items.get(j).getCrop_id(),items.get(j).getDistrict(),items.get(j).getDistrict_id(),items.get(j).getHindi_name(),items.get(j).getId(),items.get(j).getImage(),items.get(j).getKm(),items.get(j).getLast_date(),items.get(j).getLat(),items.get(j).getLng(),items.get(j).getLocation(),items.get(j).getMarket(),items.get(j).getMeters(),items.get(j).getState(),items.get(j).getUrl_str()));
                            }
                            db.close();
                            } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                     }

                    @Override
                    public void onFailure(Call<Items> call, Throwable t) {
                        Log.d("Error", t.getMessage());
                    }

                });
            }
        });
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}