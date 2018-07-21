package com.pmpavan.hotel;

import com.pmpavan.electricals.Appliance;

import java.util.ArrayList;

public class SubCorridor {

    private ArrayList<Appliance> appliances = new ArrayList<>();

    public ArrayList<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(ArrayList<Appliance> appliances) {
        this.appliances = appliances;
    }

    @Override
    public String toString() {
        return "SubCorridor{" +
                "appliances=" + appliances +
                '}';
    }
}
