/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

import java.time.LocalDateTime;

/**
 *
 * @author Pete
 */
public class MeterReading {

    private double reading;
    private Meter meter;
    private String flag;
    private LocalDateTime date;

    public double getReading() {
        return reading;
    }

    public LocalDateTime getDateTime() {
        return date;
    }

    public String getFlag() {
        return this.flag;
    }

    public Meter getMeter() {
        return meter;
    }

    public MeterReading(double r, LocalDateTime t, String f, Meter m) {
        reading = r;
        date = t;
        flag = f;
        meter = m;
    }

    @Override
    public String toString() {
        return "Reading: " + meter.getID() + " " + reading + " " + flag + " " + date;
    }
}
