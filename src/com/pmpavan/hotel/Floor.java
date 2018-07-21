package com.pmpavan.hotel;

import java.util.ArrayList;

public class Floor {

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
}
