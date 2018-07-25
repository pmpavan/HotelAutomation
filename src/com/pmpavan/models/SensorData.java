package com.pmpavan.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SensorData {
    @SerializedName("floor_number")
    @Expose
    private Integer floorNumber;
    @SerializedName("is_main_corridor")
    @Expose
    private Boolean isMainCorridor;
    @SerializedName("corridor_number")
    @Expose
    private Integer corridorNumber;

    /**
     * No args constructor for use in serialization
     *
     */
    public SensorData() {
    }

    /**
     *
     * @param isMainCorridor
     * @param floorNumber
     * @param corridorNumber
     */
    public SensorData(Integer floorNumber, Boolean isMainCorridor, Integer corridorNumber) {
        super();
        this.floorNumber = floorNumber;
        this.isMainCorridor = isMainCorridor;
        this.corridorNumber = corridorNumber;
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
}
