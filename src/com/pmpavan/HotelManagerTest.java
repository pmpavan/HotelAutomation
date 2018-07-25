package com.pmpavan;

import com.google.gson.Gson;
import com.pmpavan.corridor.main.MainCorridor;
import com.pmpavan.corridor.sub.SubCorridor;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.hotel.builder.HotelBuilderImpl;
import com.pmpavan.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import static com.pmpavan.AppConstants.*;


public class HotelManagerTest {


    private HashMap<AppConstants.APPLIANCES, Integer> mainCorridorParams = new HashMap<>();
    private HashMap<AppConstants.APPLIANCES, Integer> subCorridorParams = new HashMap<>();
    private TestCaseData data;

    public HotelManagerTest() {
        super();
    }

    @Before
    public void setup() {
        mainCorridorParams.put(AppConstants.APPLIANCES.AC, NUMBER_OF_AC_IN_MAINCORRIDORS);
        mainCorridorParams.put(AppConstants.APPLIANCES.LIGHT, NUMBER_OF_LIGHT_IN_MAINCORRIDORS);

        subCorridorParams.put(AppConstants.APPLIANCES.AC, NUMBER_OF_AC_IN_SUBCORRIDORS);
        subCorridorParams.put(AppConstants.APPLIANCES.LIGHT, NUMBER_OF_LIGHT_IN_SUBCORRIDORS);

        data = readFromJson();
    }

    private TestCaseData readFromJson() {
        TestCaseData data = null;
        try {
            Gson gson = new Gson();
            data = gson.fromJson(new FileReader(System.getProperty("user.dir") + "/src/com/pmpavan/input.txt"), TestCaseData.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Test
    public void initHotelAndTestValuesFromFile() {
        int NUMBER_OF_FLOORS = data.getNumberOfFloors();
        int NUMBER_OF_MAINCORRIDORS = data.getNumberOfMaincorridors();
        int NUMBER_OF_SUBCORRIDORS = data.getNumberOfSubcorridors();
        for (TestCase testCase : data.getTestCases()) {
            HotelBuilderImpl builder = new HotelBuilderImpl();
            HotelManager manager = new HotelManager(NUMBER_OF_FLOORS,
                    NUMBER_OF_MAINCORRIDORS, mainCorridorParams,
                    NUMBER_OF_SUBCORRIDORS, subCorridorParams);

            manager.setCallBack(() -> testData(testCase, builder));

            manager.initHotel(builder, NUMBER_OF_FLOORS,
                    NUMBER_OF_MAINCORRIDORS, mainCorridorParams,
                    NUMBER_OF_SUBCORRIDORS, subCorridorParams,
                    sensor -> Assert.assertEquals(sensor.getSensorId(), AppUtils.getSensorUniqueId(sensor.getFloorNumber(), sensor.getCorridorNumber(), sensor.isMainCorridor())));
            SensorData sensorData = testCase.getSensor();
            manager.setSensorData(sensorData.getFloorNumber(), sensorData.getCorridorNumber(), sensorData.getIsMainCorridor());
        }

    }


    private void testData(TestCase testCase, HotelBuilderImpl builder) {
        List<Expected> expecteds = testCase.getExpected();
        for (Expected expected : expecteds) {
            int floorNumber = expected.getFloorNumber();
            int corridorNumber = expected.getCorridorNumber();
            boolean isMainCorridor = expected.getIsMainCorridor();
            for (ApplianceData applianceData : expected.getApplianceData()) {
                if (isMainCorridor) {
                    MainCorridor mainCorridor = builder.getMainCorridor(floorNumber, corridorNumber);
                    loopAppliances(mainCorridor.getAppliances(), applianceData);
                } else {
                    SubCorridor subCorridor = builder.getSubCorridor(floorNumber, corridorNumber);
                    loopAppliances(subCorridor.getAppliances(), applianceData);
                }
            }
        }
    }

    private void loopAppliances(List<Appliance> appliances, ApplianceData applianceData) {
        for (Appliance appliance : appliances) {
            assertApplianceObject(appliance, applianceData);
        }
    }

    private void assertApplianceObject(Appliance appliance, ApplianceData applianceData) {
        System.out.println("applicationData " + applianceData + " " + appliance);
        if (appliance.getType() == APPLIANCES.AC) {
            Assert.assertEquals(applianceData.getAc(), appliance.isSwitchedOn());
        } else if (appliance.getType() == APPLIANCES.LIGHT) {
            Assert.assertEquals(applianceData.getLight(), appliance.isSwitchedOn());
        }
    }
}