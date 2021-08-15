package com.example.retrofit_api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContentsAdapter extends RecyclerView.Adapter<ContentsAdapter.ViewHolder> {
    private ArrayList<other_mandi> items;
    ItemSelected activity;
    interface ItemSelected
    {
        void onItemClicked(int index);
    }
    public ContentsAdapter(Context context, ArrayList<other_mandi> list)
    {
        items=list;
        activity=(ItemSelected) context;
    }
       
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView crop_id, district, district_id, hindi_name, id, image, km, last_date, lat, lng, location, market, meters, state, url_str;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            crop_id=itemView.findViewById(R.id.cropId);
            district=itemView.findViewById(R.id.district);
            district_id=itemView.findViewById(R.id.district_id);
            hindi_name=itemView.findViewById(R.id.hindi_name);
            id=itemView.findViewById(R.id.id);
            image=itemView.findViewById(R.id.image);
            km=itemView.findViewById(R.id.km);
            last_date=itemView.findViewById(R.id.last_date);
            lat=itemView.findViewById(R.id.lat);
            lng=itemView.findViewById(R.id.lng);
            location=itemView.findViewById(R.id.location);
            market=itemView.findViewById(R.id.market);
            meters=itemView.findViewById(R.id.meters);
            state=itemView.findViewById(R.id.state);
            url_str=itemView.findViewById(R.id.url_str);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(items.indexOf((Items) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_viewmodel, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position){
        holder.itemView.setTag(items.get(position));
        holder.crop_id.setText(items.get(position).getCrop_id());
        holder.district.setText(items.get(position).getDistrict());
        holder.district_id.setText(items.get(position).getDistrict_id());
        holder.hindi_name.setText(items.get(position).getHindi_name());
        holder.id.setText(items.get(position).getId());
        holder.image.setText(items.get(position).getImage());
        holder.km.setText(items.get(position).getKm());
        holder.last_date.setText(items.get(position).getLast_date());
        holder.lat.setText(items.get(position).getLat());
        holder.lng.setText(items.get(position).getLng());
        holder.location.setText(items.get(position).getLocation());
        holder.market.setText(items.get(position).getMarket());
        holder.meters.setText(items.get(position).getMeters());
        holder.state.setText(items.get(position).getState());
        holder.url_str.setText(items.get(position).getUrl_str());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}


