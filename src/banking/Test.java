package banking;
import java.util.Scanner;
public class Test {
    public static Scanner scan= new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.print("1. Add Account\n2. View details\n3. Exit\nEnter the option: ");
            int option=CreateAccount.scan.nextInt();
            if (option==1) new CreateAccount().create();
            else if(option==2) getData();
            else if(option==3) break;
            else System.out.println("Invalid input\n");
        }
    }
    public static void getData(){
        Database.getCustomer();
        System.out.print("Enter your Customer ID: ");
        int cid=scan.nextInt();
        System.out.print(Customers.customerdetails.get(cid)+"\n");
    }
}
