package com.pmpavan.electricals;

import static com.pmpavan.AppConstants.DEFAULT_AC_STATUS;

public class AC implements Appliance {

    private boolean isSwitchedOn = DEFAULT_AC_STATUS;


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
