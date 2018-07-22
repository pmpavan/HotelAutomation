package com.pmpavan.electricals.ac;

import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.ApplianceManager;

public class ACManager implements ApplianceManager {
    @Override
    public boolean switchOnAppliance(Appliance appliance) {
        boolean isSwitchedOn = true;
        appliance.setSwitchedOn(isSwitchedOn);
        return isSwitchedOn;
    }

    @Override
    public boolean switchOffAppliance(Appliance appliance) {
        boolean isSwitchedOn = false;
        appliance.setSwitchedOn(isSwitchedOn);
        return isSwitchedOn;
    }
}
