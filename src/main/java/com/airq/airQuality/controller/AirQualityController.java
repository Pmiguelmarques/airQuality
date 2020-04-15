package com.airq.airQuality.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AirQualityController {

    @Autowired
    private CityService cityService;



    @RequestMapping("/cities")
    public String getAllCities(Model model){
        List<City> allCities = cityService.getAllCities();
        model.addAttribute("allCities", allCities);
        return "citiesDisplay";
    }


    @RequestMapping(value = "/{name}", method = GET)
    public String getCity(@PathVariable String name, Model model) throws IOException {
        City city = cityService.getCity(name);
        model.addAttribute("cityName", city.getName());
        model.addAttribute("cityAqi", city.getAqi());
        model.addAttribute("citySO2", city.getSo2());
        model.addAttribute("cityO3", city.getO3());
        model.addAttribute("cityNO2", city.getNo2());
        return "cityPage";
    }



}





