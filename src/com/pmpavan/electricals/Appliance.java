package com.pmpavan.electricals;

import com.pmpavan.AppConstants;

public interface Appliance {

    void setSwitchedOn(boolean switchedOn);

    String getName();

    AppConstants.APPLIANCES getType();

    double getPowerConsumed();

    boolean isSwitchedOn();
}
