package banking.details;

import java.util.HashMap;

public class Accounts {
    private long accountNumber;
    private long customerID;
    private float accountBalance;
    private String branch;
    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }
    public void setCustomerID(long customerID){
        this.customerID = customerID;
    }
    public void setBranch(String branch){
        this.branch=branch;
    }
    public void setAccountBalance(float accountBalance){
        this.accountBalance = accountBalance;
    }
    public long getAccountNumber(){
        return this.accountNumber;
    }
    public long getCustomerID(){
        return this.customerID;
    }
    public float getAccountBalance(){
        return this.accountBalance;
    }
    public String getBranch(){
        return this.branch;
    }
    @Override
    public String toString(){
        String output="\nAccount Details\n"+
                "Account Number   : "+this.accountNumber +"\n"+
                "Account Branch   : "+this.branch+"\n"+
                "Account Balance  : "+this.accountBalance +"\n\n";
        return output;
    }
}
