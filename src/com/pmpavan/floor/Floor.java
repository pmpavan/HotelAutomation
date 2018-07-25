package com.pmpavan.floor;

import com.pmpavan.corridor.main.MainCorridor;
import com.pmpavan.corridor.sub.SubCorridor;

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

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mainCorridors.size(); i++) {
            builder.append("Main Corridor").append(" ").append(i).append("\n").append(mainCorridors.get(i)).append("\n");
        }
        for (int i = 0; i < subCorridors.size(); i++) {
            builder.append("Sub Corridor").append(" ").append(i).append("\n").append(subCorridors.get(i)).append("\n");
        }
        return builder.toString();
    }
}
