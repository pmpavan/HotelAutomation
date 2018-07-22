package com.pmpavan.corridor;

import com.pmpavan.AppConstants;
import com.pmpavan.electricals.ac.AC;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.tubelight.TubeLight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CorridorHelper {

    public ArrayList<Appliance> getAppliances(HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor, boolean isInMainCorridor) {
        ArrayList<Appliance> appliances = new ArrayList<>();
        for (Map.Entry<AppConstants.APPLIANCES, Integer> entry : appliancesInMainCorridor.entrySet()) {
            Appliance appliance = null;
            switch (entry.getKey()) {
                case AC:
                    appliance = new AC();
                    break;
                case LIGHT:
                    appliance = new TubeLight();
                    break;
            }
            appliance.setInMainCorridor(isInMainCorridor);
            appliances.add(appliance);
        }
        return appliances;
    }
}
