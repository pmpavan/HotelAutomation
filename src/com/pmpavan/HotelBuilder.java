package com.pmpavan;

import com.pmpavan.electricals.AC;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.TubeLight;
import com.pmpavan.hotel.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HotelBuilder {


    private Hotel hotel;

    public HotelBuilder() {
        hotel = new Hotel();
    }

    private HotelBuilder setStructure(int numberOfFloors,
                                      int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                                      int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor) {
        ArrayList<Floor> floors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = new Floor();
            ArrayList<MainCorridor> mainCorridors = new ArrayList<>();
            ArrayList<SubCorridor> subCorridors = new ArrayList<>();
            for (int j = 0; j < numberOfMainCorridors; j++) {
                MainCorridor mainCorridor = new MainCorridor();
                ArrayList<Appliance> appliances = getAppliances(appliancesInMainCorridor);
                mainCorridor.setAppliances(appliances);
                mainCorridors.add(mainCorridor);
            }
            for (int k = 0; k < numberOfSubCorridors; k++) {
                SubCorridor subCorridor = new SubCorridor();
                ArrayList<Appliance> appliances = getAppliances(appliancesInSubCorridor);
                subCorridor.setAppliances(appliances);
                subCorridors.add(subCorridor);
            }
            floor.setMainCorridors(mainCorridors);
            floor.setSubCorridors(subCorridors);
            floors.add(floor);
        }
        hotel.setFloors(floors);
        return this;
    }

    private ArrayList<Appliance> getAppliances(HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor) {
        ArrayList<Appliance> appliances = new ArrayList<>();
        for (Map.Entry<AppConstants.APPLIANCES, Integer> entry : appliancesInMainCorridor.entrySet()) {
            Appliance appliance = null;
            switch (entry.getKey()) {
                case AC:
                    appliance = new AC();
                    break;
                case LIGHT:
                    appliance = new TubeLight();
                    break;
            }
            appliances.add(appliance);
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        return appliances;
    }

    void initHotelState(int numberOfFloors,
                        int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                        int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor) {
        setStructure(numberOfFloors,
                numberOfMainCorridors, appliancesInMainCorridor,
                numberOfSubCorridors, appliancesInSubCorridor);
    }

    String getCurrentHotelState() {
        return hotel != null ? hotel.toString() : "";
    }
}
