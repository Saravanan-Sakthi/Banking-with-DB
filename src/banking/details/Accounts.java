package banking.details;

import java.util.HashMap;

public class Accounts {
    public static HashMap<Integer, HashMap> accountdetails= new HashMap<>();
    private int acc;
    private int cid;
    private int accountBalance;
    private String branch;
    public void setAcc(int acc) { this.acc=acc; }
    public void setCid(int cid){
        this.cid= cid;
    }
    public void setBranch(String branch){
        this.branch=branch;
    }
    public void setAccountBalance(int accountBalance){
        this.accountBalance = accountBalance;
    }
    public int getAcc(){
        return this.acc;
    }
    public int getCid(){
        return this.cid;
    }
    public int getAccountBalance(){
        return this.accountBalance;
    }
    public String getBranch(){
        return this.branch;
    }
    @Override
    public String toString(){
        String output="\nAccount Details\n"+
                "Account Number   : "+this.acc+"\n"+
                "Account Branch   : "+this.branch+"\n"+
                "Account Balance  : "+this.accountBalance +"\n\n";
        return output;
    }
}
