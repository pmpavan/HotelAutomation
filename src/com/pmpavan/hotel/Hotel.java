package com.pmpavan.hotel;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Floor> floors = new ArrayList<>();

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }
}