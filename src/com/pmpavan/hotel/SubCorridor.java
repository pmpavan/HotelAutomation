package com.pmpavan.hotel;

import com.pmpavan.electricals.Appliance;

import java.util.ArrayList;

public class SubCorridor implements Corridor {

    private String sensorId;
    private String corridorId;

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

    @Override
    public String getCorridorId() {
        return corridorId;
    }

    @Override
    public boolean isMainCorridor() {
        return false;
    }

    @Override
    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public void setCorridorId(String corridorId) {
        this.corridorId = corridorId;
    }
}
