package com.example.mavesonzini.zooadaapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by mavesonzini on 11/02/2018.
 */

class Weather {

    String weatherDescription;
    int temperature;
     Weather(JSONObject json) {
        try {
            JSONArray weatherArray = json.getJSONArray("weather");
            JSONObject weather = weatherArray.getJSONObject(0);
            weatherDescription = weather.getString("main");

            JSONObject main = json.getJSONObject("main");
            temperature = main.getInt("temp") - 273;

        } catch (Exception e) {

        }

    }

}