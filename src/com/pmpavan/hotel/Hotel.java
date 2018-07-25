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
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("------------------");
        builder.append("\n");
        builder.append("Hotel")
                .append("\n");
        for (int i = 0; i < floors.size(); i++) {
            builder.append("Floor ").append(i).append("\n").append(floors.get(i)).append("\n");
        }
        builder.append("------------------");
        builder.append("\n");
        return builder.toString();
    }
}
