package com.pmpavan.floor;

import com.pmpavan.AppConstants;
import com.pmpavan.corridor.main.MainCorridor;
import com.pmpavan.corridor.main.MainCorridorBuilder;
import com.pmpavan.corridor.main.MainMainCorridorBuilderImpl;
import com.pmpavan.corridor.sub.SubCorridor;
import com.pmpavan.corridor.sub.SubCorridorBuilder;
import com.pmpavan.corridor.sub.SubCorridorBuilderImpl;
import com.pmpavan.sensor.Sensor;
import com.pmpavan.sensor.SensorListener;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class FloorBuilderImpl implements FloorBuilder {

    private Floor floor;

    public FloorBuilderImpl() {
        floor = new Floor();
    }

    public FloorBuilderImpl(Floor floor) {
        this.floor = floor;
    }

    public Floor createFloor(int floorNumber, int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                             int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
                             HashMap<String, Sensor> sensorMap, SensorListener listener) {
        floor.setFloorNumber(floorNumber);
        Pair<ArrayList<MainCorridor>, ArrayList<SubCorridor>> pair = createCorridors(floorNumber, numberOfMainCorridors, appliancesInMainCorridor, numberOfSubCorridors, appliancesInSubCorridor, sensorMap, listener);
        ArrayList<MainCorridor> mainCorridors = pair.getKey();
        ArrayList<SubCorridor> subCorridors = pair.getValue();
        floor.setMainCorridors(mainCorridors);
        floor.setSubCorridors(subCorridors);
        return floor;
    }

    @Override
    public Pair<Double, Double> getPowerConsumed() {
        double mainCorridorTotal = 0;
        double subCorridorTotal = 0;
        for (MainCorridor mainCorridor : floor.getMainCorridors()) {
            MainCorridorBuilder mainCorridorBuilder = new MainMainCorridorBuilderImpl(mainCorridor);
            mainCorridorTotal += mainCorridorBuilder.getPowerConsumed();
        }
        for (SubCorridor subCorridor : floor.getSubCorridors()) {
            SubCorridorBuilder subCorridorBuilder = new SubCorridorBuilderImpl(subCorridor);
            subCorridorTotal += subCorridorBuilder.getPowerConsumed();
        }
        return new Pair<>(mainCorridorTotal, subCorridorTotal);
    }

    private Pair<ArrayList<MainCorridor>, ArrayList<SubCorridor>> createCorridors(
            int floorNumber, int numberOfMainCorridors,
            HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
            int numberOfSubCorridors,
            HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor,
            HashMap<String, Sensor> sensorMap, SensorListener listener) {

        ArrayList<MainCorridor> mainCorridors = new ArrayList<>();
        ArrayList<SubCorridor> subCorridors = new ArrayList<>();
        for (int mainCorridorId = 0; mainCorridorId < numberOfMainCorridors; mainCorridorId++) {
            MainCorridorBuilder mainCorridorBuilder = new MainMainCorridorBuilderImpl();
            MainCorridor mainCorridor = mainCorridorBuilder.createCorridor(floorNumber, mainCorridorId, appliancesInMainCorridor, sensorMap, listener);
            mainCorridors.add(mainCorridor);
        }
        for (int subCorridorId = 0; subCorridorId < numberOfSubCorridors; subCorridorId++) {
            SubCorridorBuilder builder = new SubCorridorBuilderImpl();
            SubCorridor subCorridor = builder.createCorridor(floorNumber, subCorridorId, appliancesInSubCorridor, sensorMap, listener);
            subCorridors.add(subCorridor);
        }
        return new Pair<>(mainCorridors, subCorridors);
    }
}
