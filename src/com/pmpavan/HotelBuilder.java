package com.pmpavan;

import com.pmpavan.electricals.AC;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.TubeLight;
import com.pmpavan.hotel.*;

import java.util.ArrayList;

public class HotelBuilder {


    private Hotel hotel;

    public HotelBuilder() {
        hotel = new Hotel();
    }

    private HotelBuilder setStructure(int numberOfFloors,
                                      int numberOfMainCorridors, int numberOfACAppliancesInMainCorridor, int numberOfLightAppliancesInMainCorridor,
                                      int numberOfSubCorridors, int numberOfACAppliancesInSubCorridor, int numberOfLightAppliancesInSubCorridor) {
        ArrayList<Floor> floors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = new Floor();
            ArrayList<MainCorridor> mainCorridors = new ArrayList<>();
            ArrayList<SubCorridor> subCorridors = new ArrayList<>();
            for (int j = 0; j < numberOfMainCorridors; j++) {
                MainCorridor mainCorridor = new MainCorridor();
                ArrayList<Appliance> appliances = new ArrayList<>();
                for (int k = 0; k < numberOfACAppliancesInMainCorridor; k++) {
                    AC ac = new AC();
                    appliances.add(ac);
                }
                for (int k = 0; k < numberOfLightAppliancesInMainCorridor; k++) {
                    TubeLight tubeLight = new TubeLight();
                    appliances.add(tubeLight);
                }
                mainCorridor.setAppliances(appliances);
                mainCorridors.add(mainCorridor);
            }
            for (int k = 0; k < numberOfSubCorridors; k++) {
                SubCorridor subCorridor = new SubCorridor();
                ArrayList<Appliance> appliances = new ArrayList<>();
                for (int l = 0; l < numberOfACAppliancesInSubCorridor; l++) {
                    AC ac = new AC();
                    appliances.add(ac);
                }
                for (int l = 0; l < numberOfLightAppliancesInSubCorridor; l++) {
                    TubeLight tubeLight = new TubeLight();
                    appliances.add(tubeLight);
                }
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

    void initHotelState(int numberOfFloors,
                        int numberOfMainCorridors, int numberOfACAppliancesInMainCorridor, int numberOfLightAppliancesInMainCorridor,
                        int numberOfSubCorridors, int numberOfACAppliancesInSubCorridor, int numberOfLightAppliancesInSubCorridor) {
        setStructure(numberOfFloors,
                numberOfMainCorridors, numberOfACAppliancesInMainCorridor, numberOfLightAppliancesInMainCorridor,
                numberOfSubCorridors, numberOfACAppliancesInSubCorridor, numberOfLightAppliancesInSubCorridor);
    }

    String getCurrentHotelState() {
        return hotel != null ? hotel.toString() : "";
    }
}
