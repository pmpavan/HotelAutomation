package com.pmpavan;

public class AppUtils {
    public static String getSensorUniqueId(int floorNumber, int corridorNumber, boolean isMainCorridor) {
        StringBuilder builder = new StringBuilder("F");
        builder.append(floorNumber);
        if (isMainCorridor)
            builder.append("M");
        else
            builder.append("S");
        builder.append(corridorNumber);
        return builder.toString();
    }
}
