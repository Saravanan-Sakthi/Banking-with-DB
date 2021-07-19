package banking;
import java.util.HashMap;
public class Customers {
    static HashMap<Integer,Customers> customerdetails= new HashMap<>();
    HashMap<Integer,Integer> accountdetails= new HashMap<>();
    int cid;
    int acc;
    String name;
    String email;
    long mobile;
    String city;
    @Override
    public String toString(){
        String output="\nCustomer Details\n"+
                      "Customer ID   : "+cid+"\n"+
                      "Name          : "+name+"\n"+
                      "Email ID      : "+email+"\n"+
                      "Mobile Number : "+mobile+"\n"+
                      "City          : "+city+"\n"+
                      "Account Details\n";
        for(int acc: accountdetails.keySet()){
            output+="Account Number : "+acc+"    Account Balance : "+accountdetails.get(acc)+"\n";
        }
        return output;
    }
}
