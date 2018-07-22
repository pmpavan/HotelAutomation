package com.pmpavan.electricals.ac;

import com.pmpavan.AppConstants;
import com.pmpavan.electricals.Appliance;

import static com.pmpavan.AppConstants.DEFAULT_AC_STATUS;

public class AC implements Appliance {

    private boolean isSwitchedOn = DEFAULT_AC_STATUS;

    private boolean isInMainCorridor;

    @Override
    public void setSwitchedOn(boolean switchedOn) {
        isSwitchedOn = switchedOn;
    }

    @Override
    public String getName() {
        return AC.class.getName();
    }

    @Override
    public AppConstants.APPLIANCES getType() {
        return AppConstants.APPLIANCES.AC;
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

    public boolean isInMainCorridor() {
        return isInMainCorridor;
    }

    public void setInMainCorridor(boolean inMainCorridor) {
        isInMainCorridor = inMainCorridor;
    }
}
