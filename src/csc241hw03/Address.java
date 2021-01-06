/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Pete
 */
public abstract class Address {

    private String streetName;
    private int houseNumber;
    private String zipcode;
    private Account accounts;
    private String type;
    private Meter[] Meter;
    private ArrayList<Meter> meters = new ArrayList<Meter>();

    public String getStreet() {
        return streetName;
    }

    public int getNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipcode;
    }

    public String type() {
        return type;
    }

    public abstract String getType();

    public Meter[] getMeters() {
        Meter[] allmeters = {};
        allmeters = meters.toArray(allmeters);
        return allmeters;
    }

    public boolean addMeter(Meter m) {
        if (meters.contains(m)) {
            return false;
        } else {
            meters.add(m);
            return true;
        }
    }

    public boolean removeMeter(String id) {
        for (int i = 0; i < meters.size(); i++) {
            if (meters.get(i).getID().equals(id)) {
                meters.remove(meters.get(i));
                return true;
            }
        }
        return false;
    }

    public Account getAccount() {
        return accounts;
    }

    public void setAccount(Account a) {
        this.accounts = a;
    }

    public Address(String s, int n, String z, String t) {
        streetName = s;
        houseNumber = n;
        zipcode = z;
        type = t;
    }

    @Override
    public String toString() {
        return "Address: " + this.type + ": " + this.houseNumber + (" ") + this.streetName + " " + this.zipcode;
    }
}
