package com.pmpavan.corridor;

import com.pmpavan.AppConstants;
import com.pmpavan.electricals.AC;
import com.pmpavan.electricals.Appliance;
import com.pmpavan.electricals.TubeLight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CorridorHelper {

    public ArrayList<Appliance> getAppliances(HashMap<AppConstants.APPLIANCES, Integer> appliancesInMainCorridor) {
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
            appliances.add(appliance);
        }
        return appliances;
    }
}
