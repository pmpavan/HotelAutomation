package com.pmpavan.sensor;

public class MotionSensor implements Sensor {


    private String sensorId;
    private boolean isDetected;

    private int floorNumber, corridorNumber;
    private boolean isMainCorridor;

    private SensorListener listener;

    public MotionSensor(String sensorId, int floorNumber, int corridorNumber, boolean isMainCorridor, SensorListener listener) {
        this.sensorId = sensorId;
        this.floorNumber = floorNumber;
        this.corridorNumber = corridorNumber;
        this.isMainCorridor = isMainCorridor;
        this.listener = listener;
    }


    @Override
    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public int getCorridorNumber() {
        return corridorNumber;
    }

    @Override
    public void setCorridorNumber(int corridorNumber) {
        this.corridorNumber = corridorNumber;
    }

    @Override
    public boolean isMainCorridor() {
        return isMainCorridor;
    }

    @Override
    public void setMainCorridor(boolean mainCorridor) {
        isMainCorridor = mainCorridor;
    }

    @Override
    public String getSensorId() {
        return sensorId;
    }

    @Override
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public void setDetected(boolean detected) {
        isDetected = detected;
        if (listener != null) {
            listener.onSensorDetected(this);
        }
    }

    @Override
    public boolean isDetected() {
        return isDetected;
    }

    @Override
    public String toString() {
        return "MotionSensor{" +
                "sensorId='" + sensorId + '\'' +
                ", isDetected=" + isDetected +
                ", floorNumber=" + floorNumber +
                ", corridorNumber=" + corridorNumber +
                ", isMainCorridor=" + isMainCorridor +
                ", listener=" + listener +
                '}';
    }
}
