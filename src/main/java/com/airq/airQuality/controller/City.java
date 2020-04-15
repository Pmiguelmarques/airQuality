package com.airq.airQuality.controller;

public class City {

    private String name;
    private int aqi;
    private double so2;
    private double o3;
    private double no2;


    public City(String name, int aqi, double so2, double o3, double no2){
        this.name = name;
        this.aqi = aqi;
        this.so2 = so2;
        this.o3 = o3;
        this.no2 = no2;
    }

    public String getName(){
        return name;
    }

    public int getAqi(){
        return aqi;
    }

    public double getSo2(){
        return so2;
    }

    public double getO3(){
        return o3;
    }

    public double getNo2(){
        return no2;
    }

}
