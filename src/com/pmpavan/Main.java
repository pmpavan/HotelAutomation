package com.pmpavan;

public class Main {

    private static int NUMBER_OF_FLOORS = 2;
    private static int NUMBER_OF_MAINCORRIDORS = 1;
    private static int NUMBER_OF_AC_IN_MAINCORRIDORS = 1;
    private static int NUMBER_OF_LIGHT_IN_MAINCORRIDORS = 1;
    private static int NUMBER_OF_SUBCORRIDORS = 2;
    private static int NUMBER_OF_AC_IN_SUBCORRIDORS = 1;
    private static int NUMBER_OF_LIGHT_IN_SUBCORRIDORS = 1;

    public static void main(String[] args) {

        HotelBuilder hotelBuilder = new HotelBuilder();
        hotelBuilder.initHotelState(NUMBER_OF_FLOORS,
                NUMBER_OF_MAINCORRIDORS, NUMBER_OF_AC_IN_MAINCORRIDORS, NUMBER_OF_LIGHT_IN_MAINCORRIDORS,
                NUMBER_OF_SUBCORRIDORS, NUMBER_OF_AC_IN_SUBCORRIDORS, NUMBER_OF_LIGHT_IN_SUBCORRIDORS);
        System.out.println(hotelBuilder.getCurrentHotelState());
    }


}
