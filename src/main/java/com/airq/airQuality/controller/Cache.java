package com.airq.airQuality.controller;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private List<City> info = new ArrayList<>();

    public void add(City city){
        info.add(city);
    }

    public City get(int i){
        return info.get(i);
    }

    public int size(){
        return info.size();
    }

    public List<City> returnInfo(){
        return info;
    }

    public void remove(int i){
        info.remove(i);
    }
}
