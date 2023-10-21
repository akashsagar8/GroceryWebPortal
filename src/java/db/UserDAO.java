
package db;

import db.impl.UserDAOImpl;
import java.sql.ResultSet;
import org.apache.commons.fileupload.FileItem;

public interface UserDAO {
   String addUser(String userid,String pass,String name, String photoid,String mobile,String mailid,String dob,String registerIP);     
   String checkId(String userid,String pass); 
   public String changePass(String userid,String oldPass,String newpass);
   ResultSet getUsers() throws Exception;
   String delUser(String userid );
   String forget(String userid);
   public ResultSet getProfile(String userid) throws Exception ;
   public String updProfile(String userid,String name,String photoid,String dob,String mobile,String mailid);
      
   // ----------- Contact us --------------------------------
   public String addContact(String name,String userid,String mailid,String mobile,String msg);
   public ResultSet getContactInfo() throws Exception;
   public String deleteContact(String sno);
   // ----------- Feedback Module --------------------------------
   public String addFeedback(String name,String userid,String mailid,String mobile,String msg);
   public ResultSet getFeedbackReport() throws Exception;
   public String deleteFeedback(String sno);
   // ----------------- Complaints Module -----------------
   public String addComplaint(String userid,String subject,String message);
   public ResultSet complaintsReport() throws Exception;
   public ResultSet userComplaintsReport(String uid) throws Exception;
   public String deleteComplaint(String id);
   public ResultSet getComplaint(String id) throws Exception;
   public String complaintResolve(String sno,String resolvemsg);
   public  String addProduct(String photoid, String name, String pmrp,String price,String mfdate,String expdate,String dicp);
 public  ResultSet getProductReport(String q) throws Exception;
public  ResultSet getProduct(String id) throws Exception;
    public String deleteProduct(String id) throws Exception;
    
    public String updateProduct(String id,String photoid,String name,String max,String price,String mfdate,String expdate,String disc);
    public ResultSet getOutOfStockItems(String q) throws Exception;
   String addPhoto(FileItem ph);
     ResultSet getPhoto(String id) throws Exception;
     
      // --------------------  Customer Address module ----------------------------------------
    public String addCustomerAddress(String name,String mobile,String hno,String sector,String street,String city,String landmark,String state,String pin,String uid);
    public ResultSet getState() throws Exception;
    public ResultSet getCity(String state) throws Exception;
    public ResultSet getReport() throws Exception;
    public ResultSet getCustomerAddress(String uid) throws Exception;
    public String updateCustomerAddress(String sno,String name,String mobile,String hno,String sector,String street,String city,String landmark,String state,String pin,String uid);
    public String deleteAddress(String id) ;
    public ResultSet getCustAddress(String sno) throws Exception;
    
    //------------------------- Master Stock -----------------------
    public ResultSet getProductIds() throws Exception;
    public String addItem(String pid,String qty,String price,String billno,String billdate,String salesman); 
    public ResultSet getMasterStock() throws Exception;
    public String deleteMaster(String sno) throws Exception;
    
    // ------------------  CART ----------------------
    public String addToCart(String pid,String qty,String userid);
    public String getCartItems(String userid); 
    public ResultSet viewCart(String userid) throws Exception;
    public String deleteCartItem(String pid,String userid) ;
    public String isExist(String pid); 
    public void addOrder(String userid);
    public String addPayment(String userid,String paymode,String trid,String addr);
    public String updateorderStatus(String sno,String orderstatus,String deliveredTo, String deliveredBy,String delivereddate);
    public ResultSet getPayment(String sno) throws Exception;
    public ResultSet paymentreport() throws Exception;
    public ResultSet getProductDetail(String pid) throws Exception;
    public ResultSet getCustOrdersDetails(String userid) throws Exception;
    public ResultSet canReturn(String date) throws Exception;
    public static UserDAO getRef() { return new UserDAOImpl(); }
    
  
   
}

