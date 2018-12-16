package com.example.baseadapterexam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFirstAdapter extends BaseAdapter {
    private List<Weather> mData;
    private Map<String,Integer> mWeatherImageMap;

    public MyFirstAdapter(List<Weather> data) {
        this.mData = data;
        mWeatherImageMap = new HashMap<>();
        mWeatherImageMap.put("맑음",R.drawable.sunny);
        mWeatherImageMap.put("흐림",R.drawable.cloudy);
        mWeatherImageMap.put("비",R.drawable.rainy);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);

            holder.weatherImage = convertView.findViewById(R.id.image_view);
            holder.cityText = convertView.findViewById(R.id.city_text);
            holder.tempText = convertView.findViewById(R.id.temp_text);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Weather weather = mData.get(position);

        holder.weatherImage.setImageResource(mWeatherImageMap.get(weather.getWeather()));
        holder.cityText.setText(weather.getCity());
        holder.tempText.setText(weather.getTemp());



        return convertView;
    }
    static class ViewHolder{
        ImageView weatherImage;
        TextView cityText;
        TextView tempText;
    }
}
