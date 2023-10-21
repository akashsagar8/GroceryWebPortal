package db;
import java.sql.Connection;
import java.sql.ResultSet;
public class DB {
    public static int ctr = 0;
    public static Connection getCon() {
        return con;
    }
    public static void setCon(Connection aCon) {
        con = aCon;
    }
    private static Connection con;
    public static ResultSet getProduct(String id) throws Exception
    {
        return db.UserDAO.getRef().getProduct(id);
    }
    public static ResultSet getProductReport(String q) throws Exception
    {
        return db.UserDAO.getRef().getProductReport(q);
    }
    public static ResultSet getOutOfStockItems(String q) throws Exception
    {
        return db.UserDAO.getRef().getOutOfStockItems(q);
    }
    public static ResultSet getState() throws Exception
    {
        return db.UserDAO.getRef().getState();
    }
    public static ResultSet getCity(String state) throws Exception
    {
        return db.UserDAO.getRef().getCity(state);
    }        
    public static ResultSet getCustomerAddress(String uid) throws Exception
    {
       return db.UserDAO.getRef().getCustomerAddress(uid);
    }
    public static ResultSet getCustAddress(String sno) throws Exception
    {
       return db.UserDAO.getRef().getCustAddress(sno);
    }
    public static ResultSet getProductIds() throws Exception
    {
       return db.UserDAO.getRef().getProductIds();
    }
    public static ResultSet getMasterStock() throws Exception
    { 
       return db.UserDAO.getRef().getMasterStock();
    }
    public static String getCartItems(String userid) 
    {
        return db.UserDAO.getRef().getCartItems(userid);
    }
    public static String isExist(String pid)
    {
        return db.UserDAO.getRef().isExist(pid);
    }   
      public static ResultSet getPayment(String sno) throws Exception
   {
	   return UserDAO.getRef().getPayment(sno);
   }
     public static ResultSet getProductDetail(String pid) throws Exception
    { 
       return db.UserDAO.getRef().getProductDetail(pid);
    }   
}
    
    
    


