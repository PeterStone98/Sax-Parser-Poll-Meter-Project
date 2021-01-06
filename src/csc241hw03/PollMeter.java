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
public class PollMeter extends Meter{
    
    public PollMeter(String i, String b, String t) {
        super(i, b, t);
    }

    @Override
    public String getType() {
        return "poll";
    }
    
}
