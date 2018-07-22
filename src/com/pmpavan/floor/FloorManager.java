package com.pmpavan.floor;

import com.pmpavan.corridor.main.MainCorridor;
import com.pmpavan.corridor.sub.SubCorridor;

import java.util.ArrayList;

public class FloorManager {

    public MainCorridor getMainCorridor(Floor floor, int mainCorridorNumber) {
        MainCorridor mainCorridor = null;
        for (MainCorridor corridor : floor.getMainCorridors()) {
            if (corridor.getCorridorId() == mainCorridorNumber) {
                mainCorridor = corridor;
            }
        }
        return mainCorridor;
    }

    public SubCorridor getSubCorridor(Floor floor, int subCorridorNumber) {
        SubCorridor subCorridor = null;
        for (SubCorridor corridor : floor.getSubCorridors()) {
            if (corridor.getCorridorId() == subCorridorNumber) {
                subCorridor = corridor;
            }
        }
        return subCorridor;
    }

    public ArrayList<SubCorridor> getSubCorridors(Floor floor) {
        return floor.getSubCorridors();
    }
}
