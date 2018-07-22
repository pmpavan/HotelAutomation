package com.pmpavan.corridor.sub;

import com.pmpavan.AppConstants;
import com.pmpavan.AppUtils;
import com.pmpavan.corridor.CorridorHelper;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;

import java.util.ArrayList;
import java.util.HashMap;

public class SubCorridorBuilderImpl implements SubCorridorBuilder {


    private SubCorridor subCorridor;

    public SubCorridorBuilderImpl() {
        subCorridor = new SubCorridor();
    }

    @Override
    public SubCorridor createCorridor(int floorNumber, int subCorridorNumber, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                                      HashMap<String, Sensor> sensorMap, SensorListener listener) {

        CorridorHelper helper = new CorridorHelper();

        subCorridor.setCorridorId(subCorridorNumber);


        ArrayList<Appliance> appliances = helper.getAppliances(appliancesInSubCorridor, false);
        subCorridor.setAppliances(appliances);

        String sensorId = AppUtils.putInSensorMap(floorNumber, subCorridorNumber, false, sensorMap, listener);
        subCorridor.setSensorId(sensorId);

        return subCorridor;
    }

}
