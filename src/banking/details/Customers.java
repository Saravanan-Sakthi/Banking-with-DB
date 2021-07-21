package banking.details;

import java.util.HashMap;

public class Customers {
    public static HashMap<Integer,Customers> customerdetails= new HashMap<>();
    private int cid;
    private String name;
    private String email;
    private long mobile;
    private String city;
    public void setcid(int cid){
        this.cid=cid;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setemail(String email){
        this.email=email;
    }
    public void setmobile(long mobile){
        this.mobile=mobile;
    }
    public void setcity(String city){
        this.city=city;
    }
    public int getcid(){
        return this.cid;
    }
    public String getname(){
        return this.name;
    }
    public String getemail(){
        return this.email;
    }
    public long getmobile(){
        return this.mobile;
    }
    public String getcity(){
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
