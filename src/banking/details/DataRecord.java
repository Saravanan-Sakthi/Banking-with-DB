package banking.details;

import java.util.HashMap;

public class DataRecord {
    private HashMap<Long, HashMap> accountDetails = new HashMap<>();
    private HashMap<Long,Customers> customerDetails = new HashMap<>();
    private static DataRecord record = null;
    private DataRecord(){
    }
    public static DataRecord getRecord(){
        if(record==null){
            record= new DataRecord();
        }
        return record;
    }
    public void addCustomer (Customers detail) {
        customerDetails.put(detail.getCustomerID(),detail);
    }
    public void addAccount(Accounts detail){
        if (this.accountDetails.containsKey(detail.getCustomerID())){
            this.accountDetails.get(detail.getCustomerID()).put(detail.getAccountNumber(),detail);
        }
        else{
            HashMap<Long, Accounts> accountDetails = new HashMap<>();
            accountDetails.put(detail.getAccountNumber(),detail);
            this.accountDetails.put(detail.getCustomerID(), accountDetails);
        }
    }
    public HashMap getAccountDetails() {
        return this.accountDetails;
    }
    public HashMap getCustomerDetails() {
        return this.customerDetails;
    }
}
