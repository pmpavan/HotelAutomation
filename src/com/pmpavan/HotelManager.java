package com.pmpavan;

import com.pmpavan.hotel.builder.HotelBuilder;
import com.pmpavan.hotel.builder.HotelBuilderImpl;

import java.util.HashMap;

public class HotelManager {
    private HotelBuilder hotelBuilderImpl;

    public HotelManager(int numberOfFloors,
                        int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                        int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor) {
        hotelBuilderImpl = new HotelBuilderImpl();
        hotelBuilderImpl.initHotelState(
                numberOfFloors,
                numberOfMainCorridors,
                appliancesInMainCorridor,
                numberOfSubCorridors,
                appliancesInSubCorridor);
    }


    String getCurrentHotelState() {
        return hotelBuilderImpl != null ? hotelBuilderImpl.toString() : "";
    }
}
