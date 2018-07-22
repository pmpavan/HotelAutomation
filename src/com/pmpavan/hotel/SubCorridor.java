package com.pmpavan.hotel;

import com.pmpavan.electricals.Appliance;

import java.util.ArrayList;

public class SubCorridor implements Corridor {

    private String sensorId;
    private int corridorId;

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
    public int getCorridorId() {
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

    @Override
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public void setCorridorId(int corridorId) {
        this.corridorId = corridorId;
    }
}
