package com.airq.airQuality.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private Cache cities = new Cache();
    private JsonReader reader = new JsonReader();


    public List<City> getAllCities(){
        int nullCity = -1;
        for(int i = 0; i < cities.size(); i++)
            if(cities.get(i).getName().equals("nullCity"))
                nullCity = i;
        Cache nC = cities;
        if(nullCity != -1)
            nC.remove(nullCity);
        return cities.returnInfo();
    }

    public City getCity(String name) throws IOException {
        for(int i = 0; i < cities.size(); i++){
            if(cities.get(i).getName().equals(name))
                return cities.get(i);
        }
        City newCity = findCity(name);
        cities.add(newCity);
        return newCity;
    }

    public City findCity(String name) throws IOException {
        String url = "https://api.waqi.info/feed/"+name+"/?token=eade7c646c2e7afd8002d159cc2559732774620c";
        JSONObject json = reader.readJsonFromUrl(url);
        if(json.get("data").equals("Unknown station"))
            return new NullCity("nullCity", 0, 0, 0, 0);
        JSONObject data = json.getJSONObject("data");
        int aqi = (int) data.get("aqi");
        JSONObject iaqi = data.getJSONObject("iaqi");
        double so2 = (double) iaqi.getJSONObject("so2").get("v");
        double o3 = (double) iaqi.getJSONObject("o3").get("v");
        double no2 = (double) iaqi.getJSONObject("no2").get("v");
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        return new City(name, aqi, so2, o3, no2);

    }
}
