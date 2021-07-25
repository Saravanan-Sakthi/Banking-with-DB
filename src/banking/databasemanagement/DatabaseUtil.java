package banking.databasemanagement;

import banking.details.*;
import java.sql.*;
import java.util.HashMap;

public class DatabaseUtil {
    private static Connection con =null;
    private static DatabaseUtil db= null;
    private DatabaseUtil(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Sara@2303");
        }
        //catch( ClassNotFoundException e){
           // e.printStackTrace();
       // }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static DatabaseUtil getObject(){
        if(db==null) db=new DatabaseUtil();
        return db;
    }
    public static void closeConnection(){
        if(con!=null) {
            try {
                con.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void getAccount(){
        try{
            Statement st=con.createStatement();
            ResultSet resset= st.executeQuery("SELECT * FROM Accounts;");
            while(resset.next()){
                Accounts detail= new Accounts();
                detail.setcid(resset.getInt("Cid"));
                detail.setacc(resset.getInt("Acc"));
                detail.setbranch(resset.getString("Branch"));
                detail.setaccountbalance(resset.getInt("Account_Balance"));
                if (Accounts.accountdetails.containsKey(detail.getcid())){
                    Accounts.accountdetails.get(detail.getcid()).put(detail.getacc(),detail);
                }
                else{
                    HashMap<Integer, Accounts> accountdetails= new HashMap<>();
                    accountdetails.put(detail.getacc(),detail);
                    Accounts.accountdetails.put(detail.getcid(),accountdetails);
                }
            }
            resset.close();
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void getCustomer(){
        try{
            Statement st=con.createStatement();
            ResultSet resset= st.executeQuery("SELECT * FROM Customers");
            while(resset.next()){
                Customers detail= new Customers();
                detail.setcid(resset.getInt("Cid"));
                detail.setname(resset.getString("Name"));
                detail.setemail(resset.getString("Email"));
                detail.setmobile(resset.getLong("Mobile"));
                detail.setcity(resset.getString("City"));
                Customers.customerdetails.put(detail.getcid(),detail);
            }
            resset.close();
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void setCustomer(Customers cusdetails, Accounts accdetails){
        try{
            PreparedStatement st=con.prepareStatement("INSERT INTO Customers (Name,Email,City,Mobile) VALUES (?,?,?,?)");
            st.setString(1, cusdetails.getname());
            st.setString(2, cusdetails.getemail());
            st.setString(3, cusdetails.getcity());
            st.setLong(4, cusdetails.getmobile());
            st.executeUpdate();
            ResultSet resset=st.executeQuery("SELECT * FROM Customers WHERE Cid=(SELECT MAX(Cid) FROM Customers);");
            int cid=0;
            while(resset.next()){
                cid= resset.getInt("Cid");
                accdetails.setcid(cid);
            }
            resset.close();
            setAccount(accdetails);
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void setAccount(Accounts details){
        try{
            PreparedStatement st=con.prepareStatement("INSERT INTO Accounts (Cid,Account_Balance,Branch) VALUES (?,?,?)");
            st.setInt(1,details.getcid());
            st.setInt(2,details.getaccountbalance());
            st.setString(3, details.getbranch());
            st.executeUpdate();
            st.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}
