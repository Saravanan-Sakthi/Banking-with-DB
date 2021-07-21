package banking.details;

import java.util.HashMap;

public class Accounts {
    public static HashMap<Integer, HashMap> accountdetails= new HashMap<>();
    private int acc;
    private int cid;
    private int accountbalance;
    private String branch;
    public void setacc(int acc) { this.acc=acc; }
    public void setcid(int cid){
        this.cid= cid;
    }
    public void setbranch(String branch){
        this.branch=branch;
    }
    public void setaccountbalance(int accountbalance){
        this.accountbalance=accountbalance;
    }
    public int getacc(){
        return this.acc;
    }
    public int getcid(){
        return this.cid;
    }
    public int getaccountbalance(){
        return this.accountbalance;
    }
    public String getbranch(){
        return this.branch;
    }
    @Override
    public String toString(){
        String output="\nAccount Details\n"+
                "Account Number   : "+this.acc+"\n"+
                "Account Branch   : "+this.branch+"\n"+
                "Account Balance  : "+this.accountbalance+"\n\n";
        return output;
    }
}
