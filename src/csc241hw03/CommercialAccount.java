/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

/**
 *
 * @author Pete
 */
public class CommercialAccount extends Account implements Constants {

    public CommercialAccount(String n, Customer c) {
        super(n, c);
        super.setBalance(0.0);
    }

    @Override
    public void updateBalance() {
        double sum = 0;

        for (Address addr : this.getAddresses()) {
            if(addr.getType().equals("house") ||addr.getType().equals("commercial")){
                for (Meter m : addr.getMeters()) {
                    for (MeterReading mr : m.getReadings()) {
                        sum = sum + mr.getReading();
                    }
                }
            }
        }
        this.setBalance(sum * commercialUnitRate);
    }
}
