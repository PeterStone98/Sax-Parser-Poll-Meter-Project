/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

import java.util.ArrayList;

/**
 *
 * @author Pete
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Address address;
    //private String pop = "pop";
    private String[] Account;
    private ArrayList<Account> accounts = new ArrayList<Account>();

   
    
    public String getLastName(){
        return this.lastName;
    }
    
    
    public String getFirstName(){
        return firstName;
    }
    
    public Address getMailingAddress(){
        return address;
    }
    
    public Account[] getAccounts(){
        Account[]allaccounts = {};
        allaccounts = accounts.toArray(allaccounts);
        return allaccounts;
    }
    
    public boolean addAccount(Account a){
        if(accounts.contains(a)){
            return false;
        }else{
            accounts.add(a);
            return true;
        }
    }
    
    public boolean removeAccount(Account a){     
       for (int i = 0; i <= accounts.size(); i++) {
          //  System.out.println(accounts.get(i));
         //  System.out.println( meters.get(i) + "OOPOP");
            if (accounts.contains(a)) {
               // System.out.println("YEEES");
                accounts.remove(accounts.get(i));
                return true;
            }
        }
        return false;
    }
    
    public Customer(String l, String f, Address a){
        firstName = f;
        lastName = l;
        address = a;   
    }
    
    @Override
    public String toString(){
       return firstName + " " + lastName + address;
    }
    
}
