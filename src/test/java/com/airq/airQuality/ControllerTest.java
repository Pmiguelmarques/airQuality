package com.airq.airQuality;


import com.airq.airQuality.controller.AirQualityController;
import com.airq.airQuality.controller.City;
import com.airq.airQuality.controller.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest
public class ControllerTest {

    private Logger log = Logger.getLogger("Test log");

    @Mock
    CityService mockService;
    City mockCity;

    @InjectMocks
    AirQualityController controller = new AirQualityController();
    /*

    @BeforeEach
    void setUp() throws IOException {
        when(mockService.getCity("Lisboa")).thenReturn(mockCity);
        when(mockCity.getName()).thenReturn("Lisboa");
    }

    @Test
    public void testName() throws IOException {
        log.info("Boas");
        /*City mock = mockService.getCity("Lisboa");
        assertEquals("Lisboa", mock.getName());
        System.out.println("Boas");*/
    //}
}
