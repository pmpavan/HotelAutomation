package com.pmpavan.sensor;

public class MotionSensor implements Sensor {

    private boolean isDetected;


    public void setDetected(boolean detected) {
        isDetected = detected;
    }

    @Override
    public boolean isDetected() {
        return isDetected;
    }
}
