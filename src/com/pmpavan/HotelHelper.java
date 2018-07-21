package com.pmpavan;

import com.pmpavan.hotel.Floor;
import com.pmpavan.hotel.Hotel;
import com.pmpavan.hotel.MainCorridor;
import com.pmpavan.hotel.SubCorridor;

import java.util.ArrayList;

public class HotelHelper {

    private static HotelHelper hotelInstance;
    private static Hotel hotel;


    public static HotelHelper getInstance() {
        if (hotelInstance == null)
            hotelInstance = new HotelHelper();
        return hotelInstance;
    }


    public Hotel initHotelState(int numberOfFloors, int numberOfMainCorridors, int numberOfSubCorridors) {
        Hotel hotel = new Hotel();
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
        this.hotel = hotel;
        return hotel;
    }
}
