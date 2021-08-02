package banking.banking;

import banking.details.*;
import banking.databasemanagement.DatabaseUtil;
import java.util.HashMap;
import java.util.Scanner;

public class AccountManagement {
    public static Scanner scan= BankingDriver.scan;
    public DatabaseUtil db= DatabaseUtil.getObject();
    public void create(){
        while (true){
            System.out.print("1. Existing customer\n2. New customer\n3. Exit\nEnter the option: ");
            int option=0;
            if(scan.hasNextInt()){
                option=scan.nextInt();
                scan.nextLine();
            }
            else {
                scan.next();
            }
            if (option==1) existingCustomer();
            else if (option==2) newCustomer();
            else if (option==3) break;
            else System.out.println("Invalid input");
        }
    }
    public void existingCustomer(){
        Accounts details= new Accounts();
        System.out.print("Enter your Customer ID: ");
        details.setCid(scan.nextInt());
        System.out.print("Enter the initial deposit: ");
        details.setAccountBalance(scan.nextInt());
        scan.nextLine();
        System.out.print("Enter the branch: ");
        details.setBranch(scan.next());
        db.setAccount(details);
    }
    public void newCustomer(){
        Customers cusDetails = new Customers();
        Accounts accDetails = new Accounts();
        System.out.print("Enter your name: ");
        cusDetails.setName(scan.nextLine());
        System.out.print("Enter your Email ID: ");
        cusDetails.setEmail(scan.nextLine());
        System.out.print("Enter your Mobile number: ");
        cusDetails.setMobile(scan.nextLong());
        scan.nextLine();
        System.out.print("Enter your city: ");
        cusDetails.setCity(scan.nextLine());
        System.out.print("Enter the initial deposit: ");
        accDetails.setAccountBalance(scan.nextInt());
        scan.nextLine();
        System.out.print("Enter the branch: ");
        accDetails.setBranch(scan.next());
        db.setCustomer(cusDetails, accDetails);
    }
    public void getData(){
        while(true){
            System.out.print("1. Account Details\n2. Customer Details\n3. Exit\nEnter the option: ");
            int option=scan.nextInt();
            if (option==1) getAccountData();
            else if(option==2) getCustomerData();
            else if(option==3) break;
            else System.out.println("Invalid input\n");
        }
    }
    void getCustomerData(){
        System.out.print("Enter your Customer ID: ");
        int cid=scan.nextInt();
        DatabaseUtil.getCustomer();
        DatabaseUtil.getAccount();
        if(Customers.customerDetails.containsKey(cid)) {
            System.out.print(Customers.customerDetails.get(cid) + "\n");
            HashMap<Integer, Accounts> accountMap = Accounts.accountdetails.get(cid);
            for (Accounts detail : accountMap.values()) {
                System.out.print(detail);
            }
        }
        else System.out.println("No details available");
    }
    void getAccountData(){
        System.out.print("Enter your Customer ID: ");
        int cid=scan.nextInt();
        DatabaseUtil.getCustomer();
        DatabaseUtil.getAccount();
        if(Customers.customerDetails.containsKey(cid)) {
            System.out.print(Customers.customerDetails.get(cid) + "\n");
            HashMap<Integer, Accounts> accountMap = Accounts.accountdetails.get(cid);
            for (Accounts detail : accountMap.values()) {
                System.out.print(detail);
            }
        }
        else System.out.println("No details available");
    }
}
