package com.pmpavan.hotel;

import com.pmpavan.electricals.AC;
import com.pmpavan.electricals.TubeLight;

import java.util.ArrayList;

public class SubCorridor {

    private ArrayList<TubeLight> lights = new ArrayList<>();
    private AC ac;

    public ArrayList<TubeLight> getLights() {
        return lights;
    }

    public void setLights(ArrayList<TubeLight> lights) {
        this.lights = lights;
    }

    public AC getAc() {
        return ac;
    }

    public void setAc(AC ac) {
        this.ac = ac;
    }
}
