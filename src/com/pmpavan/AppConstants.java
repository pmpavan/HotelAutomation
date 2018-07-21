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
}
