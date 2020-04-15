package com.airq.airQuality;

import com.airq.airQuality.controller.Cache;
import com.airq.airQuality.controller.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    private Cache cache;
    private Logger log = Logger.getLogger("Tests");

    @BeforeEach
    void setEach(){
        log.info("Setting up");
        cache = new Cache();
    }

    @DisplayName("First test")
    @Test
    void emptyCache(){
        log.info("Empty Cache Test");
        assertEquals(0, cache.size());
        log.info("Success");
    }

    @DisplayName("Second Test")
    @Test
    void addingCity(){
        log.info("Adding a City Test");
        City city = new City("Lisboa", 80, 80, 80, 80);
        cache.add(city);
        assertEquals(city, cache.get(cache.size()-1));
        log.info("Success");
    }

    @DisplayName("Third Test")
    @Test
    void removingCity(){
        log.info("Removing a City Test");
        City city = new City("Lisboa", 80, 80, 80, 80);
        cache.add(city);
        cache.remove(0);
        assertEquals(0, cache.size());
        log.info("Success");
    }

    @DisplayName("Fourth Test")
    @Test
    void cacheSize(){
        log.info("Fourth Test");
        City city = new City("Lisboa", 80, 80, 80, 80);
        City city1 = new City("Lisboa", 80, 80, 80, 80);
        cache.add(city);
        cache.add(city1);
        assertEquals(2, cache.size());
        log.info("Success");
    }


}
