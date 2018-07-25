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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HotelManager implements SensorListener {


    private HotelBuilder hotel;
    private HashMap<String, Sensor> sensorMap = new HashMap<>();

    private double maximumPowerAllowedToBeConsumed = 0;

    public HotelManager(int numberOfFloors,
                        int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                        int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor) {
        hotel = new HotelBuilderImpl();
        initHotel(hotel,
                numberOfFloors,
                numberOfMainCorridors,
                appliancesInMainCorridor,
                numberOfSubCorridors,
                appliancesInSubCorridor,
                this);
        maximumPowerAllowedToBeConsumed = getMaxPowerConsumed(numberOfFloors, numberOfMainCorridors, numberOfSubCorridors);
    }

    public void initHotel(HotelBuilder hotel, int numberOfFloors,
                          int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                          int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                          SensorListener listener) {
        hotel.initHotelState(numberOfFloors,
                numberOfMainCorridors,
                appliancesInMainCorridor,
                numberOfSubCorridors,
                appliancesInSubCorridor,
                sensorMap, listener);
    }


    public void setSensorData(int floorNumber, int corridorNumber, boolean isMainCorridor) {
        String sensorId = AppUtils.getSensorUniqueId(floorNumber, corridorNumber, isMainCorridor);
        Sensor sensor = sensorMap.get(sensorId);
        sensor.setDetected(true);
    }

    String getCurrentHotelState() {
        return hotel != null ? hotel.toString() : "";
    }

    /**
     * Callback function where all the sensor changes are reflected
     *
     * @param sensor the sensor object which detected a value
     */
    @Override
    public void onSensorDetected(Sensor sensor) {
        System.out.println("Sensor value changed at " + sensor.toString());
        if (sensor.isMainCorridor()) {
            //switch on the main corridor AC and Lights
            MainCorridor mainCorridor = hotel.getMainCorridor(sensor.getFloorNumber(), sensor.getCorridorNumber());
            ArrayList<Appliance> appliances = mainCorridor.getAppliances();
            for (Appliance appliance : appliances) {
                handleAppliance(sensor.isMainCorridor(), sensor.isDetected(), appliance, sensor.isDetected(), false);
            }
        } else {
            //switch on current sub corridor lights and AC but off other sub corridors lights and AC
            ArrayList<SubCorridor> subCorridors = hotel.getSubCorridors(sensor.getFloorNumber());
            for (SubCorridor subCorridor : subCorridors) {
                if (subCorridor.getCorridorId() == sensor.getCorridorNumber()) {
                    ArrayList<Appliance> appliances = subCorridor.getAppliances();
                    for (Appliance appliance : appliances) {
                        handleAppliance(sensor.isMainCorridor(), sensor.isDetected(), appliance, sensor.isDetected(), false);

                    }
                } else {
                    resetSubCorridor(subCorridor, sensor);
                }
            }
        }
        //Check if the power consumption is well within limit
        double powerConsumed = getTotalPowerConsumed();
        if (powerConsumed > maximumPowerAllowedToBeConsumed) {
            hotel.getFloors()
                    .stream()
                    .flatMap(floor -> floor.getSubCorridors().stream())
                    .flatMap(subCorridor -> subCorridor.getAppliances().stream())
                    .forEach(appliance -> handleAppliance(sensor.isMainCorridor(), sensor.isDetected(), appliance, sensor.isDetected(), true));
        }
    }

    private void resetSubCorridor(SubCorridor subCorridor, Sensor sensor) {
        ArrayList<Appliance> appliances = subCorridor.getAppliances();
        for (Appliance appliance : appliances) {
            handleAppliance(sensor.isMainCorridor(), sensor.isDetected(), appliance, false, false);
        }
    }

    private void handleAppliance(boolean isMainCorridor, boolean isDetected, Appliance appliance, boolean isSwitchedOn, boolean isEmergencyCriteria) {
        ApplianceManager applianceManager = null;
        switch (appliance.getType()) {
            case AC:
                applianceManager = new ACManager();
                break;
            case LIGHT:
                applianceManager = new TubeLightManager();
                break;
        }
        if (isSwitchedOn) {
            isSwitchedOn = applianceManager.switchOnAppliance(appliance);
            if (isSwitchedOn) {
                checkSensorForStateChange(isMainCorridor, isDetected, appliance);
            }
        } else {
            if (appliance.getType() == AppConstants.APPLIANCES.AC) {
                if (!isMainCorridor && isEmergencyCriteria) {
                    //Switch off AC in sub corridor if is emergency scenario
                    applianceManager.switchOffAppliance(appliance);
                }
            } else {
                applianceManager.switchOffAppliance(appliance);
            }
        }
        if (callBack != null)
            callBack.onStateChanged();
    }

    public double getTotalPowerConsumed() {
        return hotel.getPowerConsumed();
    }

    public double getMaxPowerConsumed(int numberOfFloors, int numberOfMainCorridors, int numberOfSubCorridors) {
        double maxPowerForMainCorridor = numberOfMainCorridors * AppConstants.POWER_PER_MAINCORRIDOR;
        double maxPowerForSubCorridor = numberOfSubCorridors * AppConstants.POWER_PER_SUBCORRIDOR;
        return numberOfFloors * (maxPowerForMainCorridor + maxPowerForSubCorridor);
    }

    private void checkSensorForStateChange(boolean isMainCorridor, boolean isDetected, Appliance appliance) {
        final ScheduledExecutorService scheduledExecutorService = Executors
                .newScheduledThreadPool(1);
        scheduledExecutorService
                .scheduleAtFixedRate(
                        () -> {
                            if (!isDetected) {
                                if (appliance.getType() == AppConstants.APPLIANCES.AC) {
                                    handleAppliance(isMainCorridor, isDetected, appliance, true, false);
                                } else if (appliance.getType() == AppConstants.APPLIANCES.LIGHT) {
                                    handleAppliance(isMainCorridor, isDetected, appliance, false, false);
                                }
                            } else {
                                //stop monitoring
                                stopService(scheduledExecutorService);
                            }
                            System.out.println(hotel.toString());
                        }, AppConstants.SENSOR_INTERVAL,
                        AppConstants.SENSOR_INTERVAL, TimeUnit.SECONDS);
    }

    private void stopService(ScheduledExecutorService scheduledExecutorService) {
        Runtime.getRuntime()
                .addShutdownHook(new Thread(scheduledExecutorService::shutdownNow));
    }


    /**
     * required for unit tests to now if the state of the hotel has changed or not
     * @param callBack
     */
    public void setCallBack(HotelCallBack callBack) {
        this.callBack = callBack;
    }

    public interface HotelCallBack {
        void onStateChanged();
    }

    private HotelCallBack callBack;
}
