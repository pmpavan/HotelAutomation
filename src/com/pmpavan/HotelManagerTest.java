package com.pmpavan;

import com.pmpavan.hotel.builder.HotelBuilder;
import com.pmpavan.hotel.builder.HotelBuilderImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static com.pmpavan.AppConstants.*;


public class HotelManagerTest {

    int NUMBER_OF_FLOORS = 2;
    int NUMBER_OF_MAINCORRIDORS = 1;
    int NUMBER_OF_SUBCORRIDORS = 2;
    private HotelBuilderImpl builder;
    private HotelManager manager;
    private HashMap<AppConstants.APPLIANCES, Integer> mainCorridorParams = new HashMap<>();
    private HashMap<AppConstants.APPLIANCES, Integer> subCorridorParams = new HashMap<>();

    public HotelManagerTest() {
        super();
    }

    @Before
    public void setup() {
        mainCorridorParams.put(AppConstants.APPLIANCES.AC, NUMBER_OF_AC_IN_MAINCORRIDORS);
        mainCorridorParams.put(AppConstants.APPLIANCES.LIGHT, NUMBER_OF_LIGHT_IN_MAINCORRIDORS);

        subCorridorParams.put(AppConstants.APPLIANCES.AC, NUMBER_OF_AC_IN_SUBCORRIDORS);
        subCorridorParams.put(AppConstants.APPLIANCES.LIGHT, NUMBER_OF_LIGHT_IN_SUBCORRIDORS);

        builder = new HotelBuilderImpl();
        manager = new HotelManager(NUMBER_OF_FLOORS,
                NUMBER_OF_MAINCORRIDORS, mainCorridorParams,
                NUMBER_OF_SUBCORRIDORS, subCorridorParams);
    }

    @Test
    public void initHotel() {

        manager.initHotel(builder, NUMBER_OF_FLOORS,
                NUMBER_OF_MAINCORRIDORS, mainCorridorParams,
                NUMBER_OF_SUBCORRIDORS, subCorridorParams,
                sensor -> {
                    Assert.assertEquals(sensor.getSensorId(), AppUtils.getSensorUniqueId(1, 0, false));
                });

        manager.setSensorData(1, 0, false);

    }

}