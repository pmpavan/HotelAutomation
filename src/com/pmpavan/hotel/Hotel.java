package com.pmpavan.hotel;

import com.pmpavan.floor.Floor;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Floor> floors = new ArrayList<>();


    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "floors=" + floors +
                '}';
    }
}
