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
public class House extends Address {
    //private String type = "house";

    public House(String s, int n, String z, String t) {
        super(s, n, z, t);
        //type = t;
    }
    @Override
    public String getType() {
        return "house";
        }
    
}
