package banking.banking;

import banking.details.*;
import banking.databasemanagement.DatabaseUtil;
import java.util.HashMap;
import java.util.Scanner;

public class AccountManagement {
    public static Scanner scan= BankingDriver.scan;
    public static DatabaseUtil db= DatabaseUtil.getObject();
    public void create(){
        while (true){
            System.out.print("1. Existing customer\n2. New customer\n3. Exit\nEnter the option: ");
            int option= scan.nextInt();
            scan.nextLine();
            if (option==1) existingCustomer();
            else if (option==2) newCustomer();
            else if (option==3) break;
            else System.out.println("Invalid input");
        }
    }
    public void existingCustomer(){
        Accounts details= new Accounts();
        System.out.print("Enter your Customer ID: ");
        details.setcid(scan.nextInt());
        System.out.print("Enter the initial deposit: ");
        details.setaccountbalance(scan.nextInt());
        scan.nextLine();
        System.out.print("Enter the branch: ");
        details.setbranch(scan.next());
        db.setAccount(details);
    }
    public void newCustomer(){
        Customers cusdetails = new Customers();
        Accounts accdetails= new Accounts();
        System.out.print("Enter your name: ");
        cusdetails.setname(scan.nextLine());
        System.out.print("Enter your Email ID: ");
        cusdetails.setemail(scan.nextLine());
        System.out.print("Enter your Mobile number: ");
        cusdetails.setmobile(scan.nextLong());
        scan.nextLine();
        System.out.print("Enter your city: ");
        cusdetails.setcity(scan.nextLine());
        System.out.print("Enter the initial deposit: ");
        accdetails.setaccountbalance(scan.nextInt());
        scan.nextLine();
        System.out.print("Enter the branch: ");
        accdetails.setbranch(scan.next());
        db.setCustomer(cusdetails,accdetails);
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
        System.out.print(Customers.customerdetails.get(cid)+"\n");
        HashMap <Integer, Accounts> accountmap=Accounts.accountdetails.get(cid);
        for(Accounts detail:accountmap.values()){
            System.out.print(detail);
        }
    }
    void getAccountData(){
        System.out.print("Enter your Customer ID: ");
        int cid=scan.nextInt();
        DatabaseUtil.getCustomer();
        DatabaseUtil.getAccount();
        System.out.print(Customers.customerdetails.get(cid)+"\n");
        HashMap <Integer, Accounts> accountmap=Accounts.accountdetails.get(cid);
        for(Accounts detail:accountmap.values()){
            System.out.print(detail);
        }
    }
}
