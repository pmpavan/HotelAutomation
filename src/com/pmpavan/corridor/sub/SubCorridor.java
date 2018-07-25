package com.pmpavan.corridor.sub;

import com.pmpavan.corridor.Corridor;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Appliances ");
        for (Appliance appliance : appliances) {
            builder.append(appliance).append(" ");
        }
        return builder.toString();
    }
}
