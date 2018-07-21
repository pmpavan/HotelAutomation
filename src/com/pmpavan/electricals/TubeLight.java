package com.pmpavan.electricals;

public class TubeLight implements Appliance {

    private boolean isSwitchedOn;


    public void setSwitchedOn(boolean switchedOn) {
        isSwitchedOn = switchedOn;
    }

    @Override
    public double getPowerConsumed() {
        return 5;
    }

    @Override
    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

}
