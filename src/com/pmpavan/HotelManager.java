package com.pmpavan;

import com.pmpavan.corridor.main.MainCorridor;
import com.pmpavan.corridor.sub.SubCorridor;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.ApplianceManager;
import com.pmpavan.electricals.ac.ACManager;
import com.pmpavan.electricals.tubelight.TubeLightManager;
import com.pmpavan.hotel.builder.HotelBuilder;
import com.pmpavan.hotel.builder.HotelBuilderImpl;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelManager implements SensorListener {


    private HotelBuilder hotel;
    private HashMap<String, Sensor> sensorMap = new HashMap<>();

    public HotelManager(int numberOfFloors,
                        int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                        int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor) {
        hotel = new HotelBuilderImpl();
        hotel.initHotelState(
                numberOfFloors,
                numberOfMainCorridors,
                appliancesInMainCorridor,
                numberOfSubCorridors,
                appliancesInSubCorridor,
                sensorMap, this);
    }


    public void setSensorData(int floorNumber, int corridorNumber, boolean isMainCorridor) {
        String sensorId = AppUtils.getSensorUniqueId(floorNumber, corridorNumber, isMainCorridor);
        Sensor sensor = sensorMap.get(sensorId);
        sensor.setDetected(true);
    }

    String getCurrentHotelState() {
        return hotel != null ? hotel.toString() : "";
    }

    @Override
    public void onSensorDetected(Sensor sensor) {
        System.out.println("Sensor value changed at " + sensor.toString());
        if (sensor.isMainCorridor()) {

            //switch on the main corridor AC and Lights
            MainCorridor mainCorridor = hotel.getMainCorridor(sensor.getFloorNumber(), sensor.getCorridorNumber());
            ArrayList<Appliance> appliances = mainCorridor.getAppliances();
            for (Appliance appliance : appliances) {
                handleAppliance(appliance, true);
            }
        } else {
            //switch on current sub corridor lights and AC but off other sub corridors lights and AC
            ArrayList<SubCorridor> subCorridors = hotel.getSubCorridors(sensor.getFloorNumber());
            for (SubCorridor subCorridor : subCorridors) {
                if (subCorridor.getCorridorId() == sensor.getCorridorNumber()) {
                    ArrayList<Appliance> appliances = subCorridor.getAppliances();
                    for (Appliance appliance : appliances) {
                        handleAppliance(appliance, true);

                    }
                } else {
                    ArrayList<Appliance> appliances = subCorridor.getAppliances();
                    for (Appliance appliance : appliances) {
                        handleAppliance(appliance, false);

                    }
                }
            }

        }
    }

    private void handleAppliance(Appliance appliance, boolean isSwitchedOn) {
        ApplianceManager applianceManager = null;
        switch (appliance.getType()) {
            case AC:
                applianceManager = new ACManager();
                break;
            case LIGHT:
                applianceManager = new TubeLightManager();
                break;
        }
        if (applianceManager != null)
            if (isSwitchedOn) {
                applianceManager.switchOnAppliance(appliance);
            } else {
                applianceManager.switchOffAppliance(appliance);
            }
    }

}
