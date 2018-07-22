package com.pmpavan.electricals;

import com.pmpavan.AppConstants;

public class TubeLight implements Appliance {

    private boolean isSwitchedOn;

    @Override
    public void setSwitchedOn(boolean switchedOn) {
        isSwitchedOn = switchedOn;
    }

    @Override
    public String getName() {
        return TubeLight.class.getName();
    }

    @Override
    public AppConstants.APPLIANCES getType() {
        return AppConstants.APPLIANCES.LIGHT;
    }

    @Override
    public double getPowerConsumed() {
        return 5;
    }

    @Override
    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    @Override
    public String toString() {
        return "TubeLight{" +
                "isSwitchedOn=" + isSwitchedOn +
                '}';
    }
}
