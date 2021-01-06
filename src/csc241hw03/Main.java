/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Pete
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        Meter m1 = new PollMeter("1225", "Sony", "house");
        House a1 = new House("Farr Lane", 96, "12804", "house");
        Customer c1 = new Customer("bob", "lane", a1);
        Account acc1 = new ResidentialAccount("123456", c1);
        MeterReading mr1 = new MeterReading(12, LocalDateTime.now(), "poll", m1);

        a1.addMeter(m1);
        m1.addReading(mr1);
        c1.addAccount(acc1);
        acc1.addAddress(a1);
        */
        Scanner kb = new Scanner(System.in);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            
            System.out.println("Enter the input file name:");
            String fileName = kb.nextLine();
            File input = new File(fileName);
            saxParser.parse(input, handler);
            System.out.println("Enter the account number:");
            String accountNumber = kb.nextLine();
            handler.searchAccounts(accountNumber);      
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
