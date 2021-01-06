/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

import java.util.Arrays;
import java.util.ArrayList;

/**
 *
 * @author Pete
 */
public abstract class Meter {

    private String id;
    private String brand;
    private String type;
    private ArrayList<MeterReading> readings = new ArrayList<MeterReading>();
    // private String[] MeterReading;
    private Address address;
    private String notes;

    public String getID() {
        return id;
    }

    public void addReading(MeterReading m) {
        readings.add(m);
    }

    public MeterReading getCurrentReading() {
        if (!readings.isEmpty()) {
            return readings.get(readings.size() - 1);
        }
        return null;
    }

    public MeterReading[] getReadings() {
        if (!readings.isEmpty()) {
            MeterReading[] allreadings = {};
            allreadings = readings.toArray(allreadings);
            return allreadings;
        }
        return null;
    }

    public String getBrand() {
        return brand;
    }

    public abstract String getType();

    public String getLocation() {
        return notes;
    }

    public Address getAddress() {
        return address;
    }

    public void setLocation(Address a, String n) {
        address = a;
        notes = n;
    }

    public Meter(String i, String b, String t) {
        id = i;
        brand = b;
        type = t;
    }

    @Override
    public String toString() {
        return "Meter: " + id + " " + brand + " " + type;
    }
}
