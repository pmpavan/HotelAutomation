package com.pmpavan.electricals.tubelight;

import com.pmpavan.AppConstants;
import com.pmpavan.electricals.Appliance;

public class TubeLight implements Appliance {

    private boolean isSwitchedOn;
    private boolean isInMainCorridor;

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

    @Override
    public boolean isInMainCorridor() {
        return isInMainCorridor;
    }

    @Override
    public void setInMainCorridor(boolean inMainCorridor) {
        isInMainCorridor = inMainCorridor;
    }
}
