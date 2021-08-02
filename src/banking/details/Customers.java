package banking.details;

import java.util.HashMap;

public class Customers {
    public static HashMap<Integer,Customers> customerDetails = new HashMap<>();
    private int cid;
    private String name;
    private String email;
    private long mobile;
    private String city;
    public void setCid(int cid){
        this.cid=cid;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setMobile(long mobile){
        this.mobile=mobile;
    }
    public void setCity(String city){
        this.city=city;
    }
    public int getCid(){
        return this.cid;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public long getMobile(){
        return this.mobile;
    }
    public String getCity(){
        return this.city;
    }
    @Override
    public String toString(){
        String output="\nCustomer Details\n"+
                "Customer ID      : "+cid+"\n"+
                "Name             : "+name+"\n"+
                "Email ID         : "+email+"\n"+
                "Mobile Number    : "+mobile+"\n"+
                "City             : "+city+"\n";
        return output;
    }
}
