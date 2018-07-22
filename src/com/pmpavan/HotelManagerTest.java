package com.pmpavan;

import com.pmpavan.hotel.builder.HotelBuilder;
import com.pmpavan.hotel.builder.HotelBuilderImpl;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static com.pmpavan.AppConstants.*;


public class HotelManagerTest {

    public HotelManagerTest() {
        super();
    }

    @Test
    public void initHotel() {
        int NUMBER_OF_FLOORS = 2;
        int NUMBER_OF_MAINCORRIDORS = 1;
        int NUMBER_OF_SUBCORRIDORS = 2;

        HashMap<AppConstants.APPLIANCES, Integer> mainCorridorParams = new HashMap<>();
        mainCorridorParams.put(AppConstants.APPLIANCES.AC, NUMBER_OF_AC_IN_MAINCORRIDORS);
        mainCorridorParams.put(AppConstants.APPLIANCES.LIGHT, NUMBER_OF_LIGHT_IN_MAINCORRIDORS);
        HashMap<AppConstants.APPLIANCES, Integer> subCorridorParams = new HashMap<>();
        subCorridorParams.put(AppConstants.APPLIANCES.AC, NUMBER_OF_AC_IN_SUBCORRIDORS);
        subCorridorParams.put(AppConstants.APPLIANCES.LIGHT, NUMBER_OF_LIGHT_IN_SUBCORRIDORS);

        HotelBuilder builder = new HotelBuilderImpl();
        HotelManager manager = new HotelManager(NUMBER_OF_FLOORS,
                NUMBER_OF_MAINCORRIDORS, mainCorridorParams,
                NUMBER_OF_SUBCORRIDORS, subCorridorParams);

        manager.initHotel(builder, NUMBER_OF_FLOORS,
                NUMBER_OF_MAINCORRIDORS, mainCorridorParams,
                NUMBER_OF_SUBCORRIDORS, subCorridorParams,
                sensor -> {
                    Assert.assertEquals(sensor.getSensorId(), AppUtils.getSensorUniqueId(1, 0, false));
                });

        manager.setSensorData(1, 0, false);

    }

}