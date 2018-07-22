package com.pmpavan.electricals.tubelight;

import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.ApplianceManager;

import java.time.LocalTime;

import static com.pmpavan.AppConstants.afterTime;
import static com.pmpavan.AppConstants.beforeTime;

public class TubeLightManager implements ApplianceManager {
    @Override
    public boolean switchOnAppliance(Appliance appliance) {
        boolean isSwitchedOn = true;
        appliance.setSwitchedOn(isSwitchedOn);
        return isSwitchedOn;
    }

    @Override
    public boolean switchOffAppliance(Appliance appliance) {
        boolean isSwitchedOn = false;

        LocalTime now = LocalTime.now();

        if ((now.isBefore(beforeTime) && now.isAfter(afterTime))) {
            isSwitchedOn = true;
            if (appliance.isInMainCorridor()) {
                appliance.setSwitchedOn(isSwitchedOn);
            } else {
                appliance.setSwitchedOn(isSwitchedOn);
            }
        } else if (!appliance.isInMainCorridor()) {
            appliance.setSwitchedOn(isSwitchedOn);
        } else {
            isSwitchedOn = appliance.isSwitchedOn();
        }
        return isSwitchedOn;
    }
}
