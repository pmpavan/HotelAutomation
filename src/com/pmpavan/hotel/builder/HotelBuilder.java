package com.pmpavan.hotel.builder;

import com.pmpavan.AppConstants;

import java.util.HashMap;

public interface HotelBuilder {

    void initHotelState(int numberOfFloors,
                        int numberOfMainCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor,
                        int numberOfSubCorridors, HashMap<AppConstants.APPLIANCES, Integer> appliancesInSubCorridor);

}
