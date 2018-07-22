package com.pmpavan.corridor.main;

import com.pmpavan.AppConstants;
import com.pmpavan.AppUtils;
import com.pmpavan.corridor.CorridorHelper;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainMainCorridorBuilderImpl implements MainCorridorBuilder {


    private MainCorridor mainCorridor;

    public MainMainCorridorBuilderImpl() {
        mainCorridor = new MainCorridor();
    }

    @Override
    public MainCorridor createCorridor(int floorNumber, int mainCorridorNumber, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                                       HashMap<String, Sensor> sensorMap, SensorListener listener) {

        CorridorHelper helper = new CorridorHelper();
        ArrayList<Appliance> appliances = helper.getAppliances(appliancesInMainCorridor);
        mainCorridor.setAppliances(appliances);

        String sensorId = AppUtils.putInSensorMap(floorNumber, mainCorridorNumber, true, sensorMap, listener);
        mainCorridor.setSensorId(sensorId);
        return mainCorridor;
    }


}
