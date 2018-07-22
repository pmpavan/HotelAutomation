package com.pmpavan.electricals;

public class AC implements Appliance {

    private boolean isSwitchedOn;


    public void setSwitchedOn(boolean switchedOn) {
        isSwitchedOn = switchedOn;
    }

    @Override
    public String getName() {
        return AC.class.getName();
    }

    @Override
    public double getPowerConsumed() {
        return 10;
    }

    @Override
    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }


    @Override
    public String toString() {
        return "AC{" +
                "isSwitchedOn=" + isSwitchedOn +
                '}';
    }
}
