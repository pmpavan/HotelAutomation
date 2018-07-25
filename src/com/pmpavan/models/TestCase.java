package com.pmpavan.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TestCase {
    @SerializedName("sensor")
    @Expose
    private SensorData sensor;
    @SerializedName("expected")
    @Expose
    private List<Expected> expected = null;

    /**
     * No args constructor for use in serialization
     */
    public TestCase() {
    }

    /**
     * @param sensor
     * @param expected
     */
    public TestCase(SensorData sensor, List<Expected> expected) {
        super();
        this.sensor = sensor;
        this.expected = expected;
    }

    public SensorData getSensor() {
        return sensor;
    }

    public void setSensor(SensorData sensor) {
        this.sensor = sensor;
    }

    public List<Expected> getExpected() {
        return expected;
    }

    public void setExpected(List<Expected> expected) {
        this.expected = expected;
    }
}
