package banking;
import java.sql.*;
import java.util.HashMap;
public class Database {
    public static HashMap getAccount(int cid){
        HashMap<Integer, Integer> accountdetails= new HashMap<>();
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Sara@2303")){
            PreparedStatement st=con.prepareStatement("SELECT * FROM Accounts WHERE Cid=?;");
            st.setInt(1,cid);
            ResultSet resset= st.executeQuery();
            while(resset.next()){
                accountdetails.put(resset.getInt("Acc"),resset.getInt("Account_Balance"));
            }
            resset.close();
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return accountdetails;
    }
    public static void getCustomer(){
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Sara@2303")){
            Statement st=con.createStatement();
            ResultSet resset= st.executeQuery("SELECT * FROM Customers");
            while(resset.next()){
                Customers detail= new Customers();
                detail.cid=resset.getInt("Cid");
                detail.name=resset.getString("Name");
                detail.email=resset.getString("Email");
                detail.mobile=resset.getLong("Mobile");
                detail.city=resset.getString("City");
                detail.accountdetails=getAccount(detail.cid);
                Customers.customerdetails.put(detail.cid,detail);
            }
            resset.close();
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void setCustomer(Customers details){
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Sara@2303")){
            PreparedStatement st=con.prepareStatement("INSERT INTO Customers (Name,Email,City,Mobile) VALUES (?,?,?,?)");
            st.setString(1,details.name);
            st.setString(2,details.email);
            st.setString(3,details.city);
            st.setLong(4,details.mobile);
            st.executeUpdate();
            ResultSet resset=st.executeQuery("SELECT * FROM Customers WHERE Cid=(SELECT MAX(Cid) FROM Customers);");
            int cid=0;
            while(resset.next()){
                cid= resset.getInt("Cid");
            }
            resset.close();
            setAccount(cid);
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void setAccount(int cid){
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Sara@2303")){
            PreparedStatement st=con.prepareStatement("INSERT INTO Accounts (Cid,Account_Balance) VALUES (?,100000)");
            st.setInt(1,cid);
            st.executeUpdate();
            st.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
