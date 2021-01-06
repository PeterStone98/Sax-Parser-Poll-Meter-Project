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
public class Commercial extends Address{
    private String unit;
   // private String type = "commercial";
    public Commercial(String s, int n, String z, String t) {
        super(s, n, z, t);
       // type = t;
    }

    @Override
    public String getType() {
        return "commercial";
    }
    
    
    
}
