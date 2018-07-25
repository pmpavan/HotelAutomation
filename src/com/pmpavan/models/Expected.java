package com.pmpavan.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Expected {
    @SerializedName("floor_number")
    @Expose
    private Integer floorNumber;
    @SerializedName("is_main_corridor")
    @Expose
    private Boolean isMainCorridor;
    @SerializedName("corridor_number")
    @Expose
    private Integer corridorNumber;
    @SerializedName("applianceData")
    @Expose
    private List<ApplianceData> applianceData = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Expected() {
    }

    /**
     *
     * @param isMainCorridor
     * @param floorNumber
     * @param corridorNumber
     * @param applianceData
     */
    public Expected(Integer floorNumber, Boolean isMainCorridor, Integer corridorNumber, List<ApplianceData> applianceData) {
        super();
        this.floorNumber = floorNumber;
        this.isMainCorridor = isMainCorridor;
        this.corridorNumber = corridorNumber;
        this.applianceData = applianceData;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Boolean getIsMainCorridor() {
        return isMainCorridor;
    }

    public void setIsMainCorridor(Boolean isMainCorridor) {
        this.isMainCorridor = isMainCorridor;
    }

    public Integer getCorridorNumber() {
        return corridorNumber;
    }

    public void setCorridorNumber(Integer corridorNumber) {
        this.corridorNumber = corridorNumber;
    }

    public List<ApplianceData> getApplianceData() {
        return applianceData;
    }

    public void setApplianceData(List<ApplianceData> applianceData) {
        this.applianceData = applianceData;
    }
}
