package com.pmpavan.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplianceData {
    @SerializedName("ac")
    @Expose
    private Boolean ac;
    @SerializedName("light")
    @Expose
    private Boolean light;

    /**
     * No args constructor for use in serialization
     *
     */
    public ApplianceData() {
    }

    /**
     *
     * @param ac
     * @param light
     */
    public ApplianceData(Boolean ac, Boolean light) {
        super();
        this.ac = ac;
        this.light = light;
    }

    public Boolean getAc() {
        return ac;
    }

    public void setAc(Boolean ac) {
        this.ac = ac;
    }

    public Boolean getLight() {
        return light;
    }

    public void setLight(Boolean light) {
        this.light = light;
    }

    @Override
    public String toString() {
        return "ApplianceData{" +
                "ac=" + ac +
                ", light=" + light +
                '}';
    }
}
