package com.pmpavan;

import com.pmpavan.hotel.*;

import java.util.ArrayList;

public class HotelBuilder {


    private Hotel hotel;

    private HotelBuilder() {
        hotel = new Hotel();
    }

    public HotelBuilder build() {
        return new HotelBuilder();
    }

    public HotelBuilder setFloors(ArrayList<Floor> floors) {
        hotel.setFloors(floors);
        return this;
    }

    private HotelBuilder setFloors(int numberOfFloors, int numberOfMainCorridors, int numberOfSubCorridors) {
        ArrayList<Floor> floors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = new Floor();
            ArrayList<MainCorridor> mainCorridors = new ArrayList<>();
            ArrayList<SubCorridor> subCorridors = new ArrayList<>();
            for (int j = 0; j < numberOfMainCorridors; j++) {
                MainCorridor mainCorridor = new MainCorridor();
                mainCorridors.add(mainCorridor);
            }
            for (int k = 0; k < numberOfSubCorridors; k++) {
                SubCorridor subCorridor = new SubCorridor();
                subCorridors.add(subCorridor);
            }
            floor.setMainCorridors(mainCorridors);
            floor.setSubCorridors(subCorridors);
            floors.add(floor);
        }
        hotel.setFloors(floors);
        return this;
    }

    public void initHotelState(int numberOfFloors, int numberOfMainCorridors, int numberOfSubCorridors) {
        HotelBuilder hotel = new HotelBuilder();
        hotel.setFloors(numberOfFloors, numberOfMainCorridors, numberOfSubCorridors);
    }
}
