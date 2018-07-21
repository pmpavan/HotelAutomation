package com.pmpavan.sensor;

public class MotionSensor implements Sensor {

    private boolean isSwitchedOn;


    public void setSwitchedOn(boolean switchedOn) {
        isSwitchedOn = switchedOn;
    }

    @Override
    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }
}
