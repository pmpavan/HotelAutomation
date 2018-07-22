package com.pmpavan.floor;

import com.pmpavan.corridor.MainCorridor;
import com.pmpavan.corridor.SubCorridor;

import java.util.ArrayList;

public class Floor {

    private int floorNumber;

    private ArrayList<MainCorridor> mainCorridors = new ArrayList<>();
    private ArrayList<SubCorridor> subCorridors = new ArrayList<>();


    public ArrayList<MainCorridor> getMainCorridors() {
        return mainCorridors;
    }

    public void setMainCorridors(ArrayList<MainCorridor> mainCorridors) {
        this.mainCorridors = mainCorridors;
    }

    public ArrayList<SubCorridor> getSubCorridors() {
        return subCorridors;
    }

    public void setSubCorridors(ArrayList<SubCorridor> subCorridors) {
        this.subCorridors = subCorridors;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorNumber=" + floorNumber +
                ", mainCorridors=" + mainCorridors +
                ", subCorridors=" + subCorridors +
                '}';
    }
}
