package com.pmpavan;

import java.time.LocalTime;

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

    public static final int POWER_PER_MAINCORRIDOR = 15;
    public static final int POWER_PER_SUBCORRIDOR = 10;

    public static int SENSOR_INTERVAL = 60;

    public static final boolean DEFAULT_AC_STATUS = true;

    public static final LocalTime beforeTime = LocalTime.of(6, 0);
    public static final LocalTime afterTime = LocalTime.of(18, 0);
}
