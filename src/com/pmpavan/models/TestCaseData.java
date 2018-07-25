package com.pmpavan.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TestCaseData {
    @SerializedName("number_of_floors")
    @Expose
    private Integer numberOfFloors;
    @SerializedName("number_of_maincorridors")
    @Expose
    private Integer numberOfMaincorridors;
    @SerializedName("number_of_subcorridors")
    @Expose
    private Integer numberOfSubcorridors;
    @SerializedName("test_cases")
    @Expose
    private List<TestCase> testCases = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public TestCaseData() {
    }

    /**
     *
     * @param numberOfSubcorridors
     * @param testCases
     * @param numberOfFloors
     * @param numberOfMaincorridors
     */
    public TestCaseData(Integer numberOfFloors, Integer numberOfMaincorridors, Integer numberOfSubcorridors, List<TestCase> testCases) {
        super();
        this.numberOfFloors = numberOfFloors;
        this.numberOfMaincorridors = numberOfMaincorridors;
        this.numberOfSubcorridors = numberOfSubcorridors;
        this.testCases = testCases;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getNumberOfMaincorridors() {
        return numberOfMaincorridors;
    }

    public void setNumberOfMaincorridors(Integer numberOfMaincorridors) {
        this.numberOfMaincorridors = numberOfMaincorridors;
    }

    public Integer getNumberOfSubcorridors() {
        return numberOfSubcorridors;
    }

    public void setNumberOfSubcorridors(Integer numberOfSubcorridors) {
        this.numberOfSubcorridors = numberOfSubcorridors;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }

}
