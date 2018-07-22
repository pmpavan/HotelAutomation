package com.pmpavan.electricals.ac;

import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.ApplianceManager;

public class ACManager implements ApplianceManager {
    @Override
    public void switchOnAppliance(Appliance appliance) {
        appliance.setSwitchedOn(true);
    }

    @Override
    public void switchOffAppliance(Appliance appliance) {
        appliance.setSwitchedOn(false);
    }
}
