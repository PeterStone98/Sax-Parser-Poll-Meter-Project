/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Scanner;

/**
 *
 * @author Pete
 */
public class MyHandler extends DefaultHandler {

    ArrayList<Customer> customerList = new ArrayList<Customer>();
    Customer cus = null;
    ArrayList<Address> addressList = new ArrayList<Address>();
    Address add = null;
    ArrayList<Meter> meterList = new ArrayList<Meter>();
    Meter met = null;
    ArrayList<MeterReading> readingList = new ArrayList<MeterReading>();
    MeterReading read = null;
    ArrayList<Account> accountList = new ArrayList<Account>();
    Account acc;
    private String ln;
    private String fn;
    private String Comaccnum;
    private String Resaccnum;
    private String accType;
    private LocalDateTime time;
    private double reading;
    private String flag;
    private double sum = 0;
    private double n;
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public void searchAccounts(String accountNumber) {
        for (Customer c : customerList) {
            for (Account a : c.getAccounts()) {
                if (a.getAccountNumber().equals(accountNumber)) {
                    a.updateBalance();
                    n = a.getCurrentBalance();
                }
            }
        }
        if (n > 0) {
            System.out.println("Balance: $" + df2.format(n));
        } else {
            System.out.println("Account number " + accountNumber + " not found.");
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("customer")) {
            ln = attributes.getValue("lastName");
            fn = attributes.getValue("firstName");
        }

        if (qName.equalsIgnoreCase("address")) {
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.getQName(i).equals("type")) {
                    if (attributes.getValue(i).equalsIgnoreCase("commercial")) {
                        add = new Commercial(attributes.getValue("street"), Integer.parseInt(attributes.getValue("number")), attributes.getValue("zipCode"), attributes.getValue("type"));
                        addressList.add(add);
                    }
                    if (attributes.getValue(i).equalsIgnoreCase("apartment")) {
                        add = new Apartment(attributes.getValue("street"), Integer.parseInt(attributes.getValue("number")), attributes.getValue("zipCode"), attributes.getValue("type"), attributes.getValue("unit"));
                        addressList.add(add);
                    }
                }
            }
        }

        if (qName.equalsIgnoreCase("meter")) {
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.getQName(i).equals("type")) {
                    if (attributes.getValue(i).equalsIgnoreCase("push")) {
                        met = new PushMeter(attributes.getValue("id"), attributes.getValue("brand"), attributes.getValue("type"));
                        met.setLocation(add, attributes.getValue("location"));
                        meterList.add(met);
                    }
                    if (attributes.getValue(i).equalsIgnoreCase("poll")) {
                        met = new PollMeter(attributes.getValue("id"), attributes.getValue("brand"), attributes.getValue("type"));
                        met.setLocation(add, attributes.getValue("location"));
                        meterList.add(met);
                    }
                }
            }
        }

        if (qName.equalsIgnoreCase("account")) {
            accType = null;
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.getQName(i).equals("type")) {
                    if (attributes.getValue(i).equalsIgnoreCase("commercial")) {
                        Comaccnum = attributes.getValue("accountNumber");
                        accType = "com";
                    }
                    if (attributes.getValue(i).equalsIgnoreCase("residential")) {
                        Resaccnum = attributes.getValue("accountNumber");
                        accType = "res";
                    }
                }
            }
        }

        if (qName.equalsIgnoreCase("meterReading")) {
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.getQName(i).equals("reading")) {
                    reading = Double.parseDouble(attributes.getValue(i));
                }
                if (attributes.getQName(i).equals("date")) {
                    time = LocalDateTime.parse(attributes.getValue(i));
                }
                if (attributes.getQName(i).equals("flag")) {
                    flag = attributes.getValue(i);
                }
            }
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("customer")) {
            cus = new Customer(ln, fn, add);
            customerList.add(cus);
            if (accType == "res") {
                acc = new ResidentialAccount(Resaccnum, cus);
                accountList.add(acc);
                for (Address a : addressList) {
                    acc.addAddress(a);
                }
            }
            if (accType == "com") {
                acc = new CommercialAccount(Comaccnum, cus);
                accountList.add(acc);
                for (Address a : addressList) {
                    acc.addAddress(a);
                }
            }
            addressList.clear();
            for (Account a : accountList) {
                cus.addAccount(a);
            }
            accountList.clear();
        }

        if (qName.equalsIgnoreCase("address")) {
            for (Meter m : meterList) {
                add.addMeter(m);
            }
            meterList.clear();
        }

        if (qName.equalsIgnoreCase("meter")) {
            for (MeterReading rding : readingList) {
                met.addReading(rding);
            }
            readingList.clear();
        }

        if (qName.equalsIgnoreCase("meterReading")) {
            read = new MeterReading(reading, time, flag, met);
            readingList.add(read);
        }
    }
}
