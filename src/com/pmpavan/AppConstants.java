package com.pmpavan;

public class AppConstants {

    public enum APPLIANCES {
        LIGHT(1),
        AC(2);
        public int id;

        APPLIANCES(int id) {
            this.id = id;
        }
    }

    public static int NUMBER_OF_AC_IN_MAINCORRIDORS = 1;
    public static int NUMBER_OF_LIGHT_IN_MAINCORRIDORS = 1;
    public static int NUMBER_OF_AC_IN_SUBCORRIDORS = 1;
    public static int NUMBER_OF_LIGHT_IN_SUBCORRIDORS = 1;

    public static final boolean DEFAULT_AC_STATUS = true;
}
