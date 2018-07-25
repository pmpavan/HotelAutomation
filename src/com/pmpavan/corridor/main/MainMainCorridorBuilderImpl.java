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

    public MainMainCorridorBuilderImpl(MainCorridor mainCorridor) {
        this.mainCorridor = mainCorridor;
    }

    @Override
    public MainCorridor createCorridor(int floorNumber, int mainCorridorNumber, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                                       HashMap<String, Sensor> sensorMap, SensorListener listener) {

        CorridorHelper helper = new CorridorHelper();
        ArrayList<Appliance> appliances = helper.getAppliances(appliancesInMainCorridor, true);
        mainCorridor.setCorridorId(mainCorridorNumber);

        mainCorridor.setAppliances(appliances);

        String sensorId = AppUtils.putInSensorMap(floorNumber, mainCorridorNumber, true, sensorMap, listener);
        mainCorridor.setSensorId(sensorId);
        return mainCorridor;
    }

    @Override
    public double getPowerConsumed() {
        ArrayList<Appliance> appliances = mainCorridor.getAppliances();
        double total = 0;
        for (Appliance appliance : appliances) {
            total += appliance.getPowerConsumed();
        }
        return total;
    }


}
