package banking;
import java.util.Scanner;
public class CreateAccount {
    public static Scanner scan= Test.scan;
    public static Database db= new Database();
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
        System.out.print("Enter your Customer ID: ");
        int cid=scan.nextInt();
        scan.nextLine();
        db.setAccount(cid);
    }
    public void newCustomer(){
        Customers details= new Customers();
        System.out.print("Enter your name: ");
        details.name= scan.nextLine();
        System.out.print("Enter your Email ID: ");
        details.email= scan.nextLine();
        System.out.print("Enter your Mobile number: ");
        details.mobile= scan.nextLong();
        scan.nextLine();
        System.out.print("Enter your city: ");
        details.city=scan.nextLine();
        db.setCustomer(details);
    }
}
