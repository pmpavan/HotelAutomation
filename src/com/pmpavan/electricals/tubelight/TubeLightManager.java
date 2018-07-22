package com.pmpavan.electricals.tubelight;

import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.ApplianceManager;

public class TubeLightManager implements ApplianceManager {
    @Override
    public void switchOnAppliance(Appliance appliance) {
        appliance.setSwitchedOn(true);
    }

    @Override
    public void switchOffAppliance(Appliance appliance) {
        appliance.setSwitchedOn(false);
    }
}
