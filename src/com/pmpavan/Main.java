package com.pmpavan;

import java.util.HashMap;

import static com.pmpavan.AppConstants.*;

public class Main {

    private static int NUMBER_OF_FLOORS = 2;
    private static int NUMBER_OF_MAINCORRIDORS = 1;
    private static int NUMBER_OF_SUBCORRIDORS = 2;

    public static void main(String[] args) {

        HashMap<AppConstants.APPLIANCES, Integer> mainCorriderParams = new HashMap<>();
        mainCorriderParams.put(AppConstants.APPLIANCES.AC, NUMBER_OF_AC_IN_MAINCORRIDORS);
        mainCorriderParams.put(AppConstants.APPLIANCES.LIGHT, NUMBER_OF_LIGHT_IN_MAINCORRIDORS);
        HashMap<AppConstants.APPLIANCES, Integer> subCorriderParams = new HashMap<>();
        subCorriderParams.put(AppConstants.APPLIANCES.AC, NUMBER_OF_AC_IN_SUBCORRIDORS);
        subCorriderParams.put(AppConstants.APPLIANCES.LIGHT, NUMBER_OF_LIGHT_IN_SUBCORRIDORS);

        HotelManager hotelBuilder = new HotelManager(NUMBER_OF_FLOORS,
                NUMBER_OF_MAINCORRIDORS, mainCorriderParams,
                NUMBER_OF_SUBCORRIDORS, subCorriderParams);
        System.out.println(hotelBuilder.getCurrentHotelState());
    }


}
