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
public abstract class Account {

    private String accountNumber;
    private Customer customer;
    private double balance;
    private Address[] Address;
    private ArrayList<Address> addresses = new ArrayList<Address>();

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getCurrentBalance() {
        return balance;
    }

    public Address[] getAddresses() {
        Address[] alladdress = {};
        alladdress = addresses.toArray(alladdress);
        return alladdress;
    }

    public boolean addAddress(Address a) {
        if (addresses.contains(a)) {
            return false;
        } else {
            addresses.add(a);
            return true;
        }
    }

    public boolean removeAddress(Address a) {
        for (int i = 0; i <= addresses.size(); i++) {
            if (addresses.get(i).equals(a)) {
                addresses.remove(addresses.get(i));
                return true;
            }
        }
        return false;
    }

    public void setBalance(double b) {
        balance = b;
    }

    public abstract void updateBalance();

    public Account(String n, Customer c) {
        customer = c;
        accountNumber = n;
        balance = 0;
    }
    
    public String toString(){
        return "Account Number: " + accountNumber +" " + customer;
    }
}
