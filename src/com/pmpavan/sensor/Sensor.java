package com.pmpavan.sensor;

public interface Sensor {

    String getSensorId();

    void setSensorId(String sensorId);

    void setDetected(boolean detected);

    boolean isDetected();

    int getFloorNumber();

    void setFloorNumber(int floorNumber);

    int getCorridorNumber();

    void setCorridorNumber(int corridorNumber);

    boolean isMainCorridor();

    void setMainCorridor(boolean mainCorridor);
}
