package db.impl;

import db.UserDAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import org.apache.commons.fileupload.FileItem;

public   class UserDAOImpl implements UserDAO{
    @Override
    public String addUser(String userid, String pass, String name,String photoid,String dob, String mobile, String mailid, String registerIP) {
      try
      {
         String str = String.format("{ CALL addUser('%s','%s','%s',%s,'%s','+91-%s','%s','%s',?)}",userid,pass,name,photoid,dob,mobile,mailid,registerIP);
          System.out.println(str);
          CallableStatement cs = db.DB.getCon().prepareCall(str);
          cs.registerOutParameter(1, Types.VARCHAR);
          cs.execute();
          return cs.getString(1); // return out parameter value
      }catch(Exception ex) { return "Sorry Exception is - "+ex; }
    }
    @Override
    public String checkId(String userid, String pass) {
      try
      {
         String str = String.format("{ CALL checkId('%s','%s',?)}",userid,pass);
          CallableStatement cs = db.DB.getCon().prepareCall(str);
          cs.registerOutParameter(1, Types.VARCHAR);
          cs.execute();
          return cs.getString(1); // return out parameter value
      }catch(Exception ex) { return "Sorry Exception is - "+ex; }
    }
    @Override
    public String changePass(String userid, String oldPass, String newpass) {
      try
      {
        String str = String.format("{call changePass('%s','%s','%s',?)}",userid,oldPass,newpass);
        System.out.println(str);
        CallableStatement cs = db.DB.getCon().prepareCall(str);
        cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
        cs.execute();
        return cs.getString(1);
     }catch(Exception ex) { return "Sorry Exception is - "+ex;  }
   }
    @Override
    public ResultSet getUsers() throws Exception {
       return db.DB.getCon().prepareCall("{ call getUsers()}").executeQuery();
    }
    @Override
    public String delUser(String userid) {
      try
      {
        String str = String.format("{call delUser('%s',?) } ",userid);
        CallableStatement cs = db.DB.getCon().prepareCall(str);
        cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
        cs.execute();
        return cs.getString(1); // return out mode parameter value. 
      }catch(Exception ex) { return ex.getMessage();  }
    }  
    @Override
    public ResultSet getProfile(String userid) throws Exception
    {
	  CallableStatement cs = db.DB.getCon().prepareCall("{call getProfile(?)}");
	  cs.setString(1, userid);
	  return cs.executeQuery(); 
    }
    @Override
    public String updProfile(String userid, String name,String photoid, String dob, String mobile,String mailid)
    {
        try
   	    {
   	       String str = String.format("{call updProfile('%s','%s','%s','%s','%s','%s',?) } ",userid,name,photoid,dob,mobile,mailid);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
    @Override
    public String forget(String userid)
    {
        try
   	    {
   	       String str = String.format("{call forget('%s',?) } ",userid);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
   
   
    // -----------------  Contact us Module ----------------------------
    @Override
    public String addContact(String name, String userid, String mailid, String mobile, String msg) {
        try
   	    {
   	       String str = String.format("{call addContact('%s','%s','%s','%s','%s',?) } ",name,userid,mailid,mobile,msg);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
    
    @Override
    public ResultSet getContactInfo() throws Exception {
 		return db.DB.getCon().prepareCall("{call getContactInfo()}").executeQuery();
 	}
    @Override
    public String deleteContact(String sno) {
        try
   	    {
   	       String str = String.format("{call deleteContact(%s,?) } ",sno);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }

    
     //  ------------------- Feedback module --------------------------------------
    public String addFeedback(String name,String userid,String mailid,String mobile,String msg)
    {
        try
   	{
   	    String str = String.format("{call addFeedback('%s','%s','%s','%s','%s',?) } ",name,userid,mailid,mobile,msg);
   	    CallableStatement cs = db.DB.getCon().prepareCall(str);
   	    cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	    cs.execute();
   	    return cs.getString(1); // return out mode parameter value. 
   	}catch(Exception ex) { return ex.getMessage();  }
    }
    public ResultSet getFeedbackReport() throws Exception
    {
	return db.DB.getCon().prepareCall("{call getFeedbackReport()}").executeQuery();
    }
    public String deleteFeedback(String sno)
    {
        try
 	{
   	    String str = String.format("{call deleteFeedback(%s,?) } ",sno);
   	    CallableStatement cs = db.DB.getCon().prepareCall(str);
   	    cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	    cs.execute();
   	    return cs.getString(1); // return out mode parameter value. 
   	}catch(Exception ex) { return ex.getMessage();  }
    }
     // ---------------------------  Complaint module methods
    @Override
    public String addComplaint(String userid, String subject, String message) {
        try
   	    {
   	       String str = String.format("{call addComplaint('%s','%s','%s',?) } ",userid,subject,message);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
    @Override
    public ResultSet complaintsReport() throws Exception {
    	return db.DB.getCon().prepareCall("{call complaintsReport()}").executeQuery();
    }
    @Override
    public ResultSet userComplaintsReport(String uid) throws Exception {
    	return db.DB.getCon().prepareCall("{call userComplaintsReport('"+uid+"')}").executeQuery();
    }
    
    @Override
    public String deleteComplaint(String id) {
        try
   	    {
   	       String str = String.format("{call deleteComplaint(%s,?) } ",id);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }
    @Override
    public ResultSet getComplaint(String id) throws Exception {
        CallableStatement cs = db.DB.getCon().prepareCall("{call getComplaint(?) }");
        cs.setString(1, id); // set userid as 1st parameter - 1st ? value
        return cs.executeQuery(); // procedure execute & return procedure data as ResultSet
    
    }
    @Override
    public String complaintResolve(String sno,String resolvemsg) {
        try
   	    {
   	       String str = String.format("{call complaintResolve(%s,'%s',?) } ",sno,resolvemsg);
   	       CallableStatement cs = db.DB.getCon().prepareCall(str);
   	       cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
   	       cs.execute();
   	       return cs.getString(1); // return out mode parameter value. 
   	     }catch(Exception ex) { return ex.getMessage();  }
    }

    
    @Override
    public String addPhoto(FileItem ph) {
      try
     {
         CallableStatement cs = db.DB.getCon().prepareCall("{call addPhoto(?,?)}");
         cs.setBinaryStream(1, ph.getInputStream());
         cs.registerOutParameter(2, Types.NUMERIC);
         cs.execute();
         return cs.getString(2); 
     }    
     catch(Exception ex) { return "Sorry Exception is - "+ex; }    
    }   

    @Override
    public ResultSet getPhoto(String id) throws Exception {
    CallableStatement cs = db.DB.getCon().prepareCall("{call getPhoto(?)}");
    cs.setString(1, id);
    return cs.executeQuery();
    }
@Override
    public String addProduct(String photoid, String name, String pmrp,String price,String mfdate,String expdate,String dicp) {
       
       System.out.println("your id and name is " +photoid +" " + name);
       
        
       
       String str = String.format("{call addProduct(%s,'%s','%s','%s','%s','%s','%s',?)}",  photoid,name,  pmrp, price, mfdate, expdate, dicp);
      
       try
       {
          CallableStatement cs = db.DB.getCon().prepareCall(str);
          cs.registerOutParameter(1,Types.VARCHAR);
          cs.execute();
          return cs.getString(1); // return out mode parameter values
       }
       catch(Exception ex) { return "Sorry  exception is - "+ex; }
    }
    
     @Override
    public ResultSet getProductReport(String q) throws Exception {
        String str = "";
      
          str = String.format("{call getProduct('%s')}",q);
        return db.DB.getCon().prepareCall(str).executeQuery();
    }
    
      @Override
    public ResultSet getProduct(String id) throws Exception {
   
    String str = String.format("{call getProductForUpdate(%s)}", id);
    return db.DB.getCon().prepareCall(str).executeQuery();
    }
 
    @Override
    public String deleteProduct(String id)throws Exception
    {
        
        String str  = String.format("{call deleteProduct(%s,?)}",id);
        
        try
        {
            CallableStatement cs = db.DB.getCon().prepareCall(str);
            
            cs.registerOutParameter(1, Types.VARCHAR);
                                   
            cs.execute();
            return cs.getString(1);
        }
        catch(Exception ex){
        return "Sorry  exception is - "+ex;}
        
       
    }

    @Override
    public String updateProduct(String id, String photoid, String name, String max, String price, String mfdate, String expdate, String disc)
    {
       
        String str = String.format("{call updateProduct(%s,%s,'%s','%s','%s','%s','%s','%s',?)}", id,  photoid,  name,  max, price, mfdate,  expdate,  disc);
        
//        System.out.println("this is implemented method is called");
        
        try
        {
            CallableStatement cs = db.DB.getCon().prepareCall(str);
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.execute();
            
            return cs.getString(1);
        }
        catch(Exception ex){
             System.out.println("this is implemented method is called"); 
             ex.printStackTrace();
            return ex.getMessage();
        }
        
    }

    @Override
    public ResultSet getOutOfStockItems(String q) throws Exception {
         String str = "";
         str = String.format("{call getOutOfStockItems('%s')}",q);
         return db.DB.getCon().prepareCall(str).executeQuery();
    }
    
    
    // ---------------------  Customer Address Module ------------------------------ 
   public String addCustomerAddress(String name,String mobile,String hno,String sector,String street,String city,String landmark,String state,String pin,String uid)
   {
       try{
       String str = String.format("{call addCustomerAddress('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',?)}",name,mobile,hno,sector,street,city,landmark,state,pin,uid);
       CallableStatement cs = db.DB.getCon().prepareCall(str);
       cs.registerOutParameter(1,Types.VARCHAR);
       cs.execute();
       return cs.getString(1);
       }catch(Exception ex) {return "sorry Exception is -"+ex;}
   }
   public ResultSet getState() throws Exception
   {
      return db.DB.getCon().prepareCall("{call getState()}").executeQuery();
   }
   public ResultSet getCity(String state) throws Exception
   {
         String str = String.format("{call getCity('%s')}", state);
         return db.DB.getCon().prepareCall(str).executeQuery();
   }
   public ResultSet getReport() throws Exception
   {
      return db.DB.getCon().prepareCall("{call getReport()}").executeQuery();
   }

    @Override
    public ResultSet getCustomerAddress(String uid) throws Exception {
         String str = String.format("{call getCustomerAddress('%s')}", uid);
         return db.DB.getCon().prepareCall(str).executeQuery();
        
    }

    @Override
    public String deleteAddress(String id)
    {
        try {
         String str = String.format("{call deleteAddress(%s)}", id);
         db.DB.getCon().prepareCall(str).execute();
         return "Customer Address Successfully Deleted.";
        }
        catch(Exception ex) { return "Exception is "+ex; }
    }

    @Override
    public String updateCustomerAddress(String sno,String name, String mobile, String hno, String sector, String street, String city, String landmark, String state, String pin,String uid) {
      String str = String.format("{call updateCustomerAddress(%s,'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',?)}",sno, name,  mobile,  hno,  sector, street, city,  landmark,state,pin,uid);
        try
        {
            CallableStatement cs = db.DB.getCon().prepareCall(str);
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.execute();
            
            return cs.getString(1);
        }
        catch(Exception ex){
             ex.printStackTrace();
            return ex.getMessage();
        }  
        
    }

    @Override
    public ResultSet getCustAddress(String sno) throws Exception {
      String str = String.format("{call getCustAddress('%s')}", sno);
         return db.DB.getCon().prepareCall(str).executeQuery();
    }
    
   // ------------------------------ Master Stock ---------------------------

    @Override
    public ResultSet getProductIds() throws Exception {
         return db.DB.getCon().prepareCall("{call getProductIds()}").executeQuery();
    }

    @Override
    public String addItem(String pid, String qty, String price, String billno, String billdate, String salesman) {
      try{
       String str = String.format("{call addItem(%s,%s,%s,%s,'%s','%s',?)}",pid,qty,price,billno,billdate,salesman);
       CallableStatement cs = db.DB.getCon().prepareCall(str);
       cs.registerOutParameter(1,Types.VARCHAR);
       cs.execute();
       return cs.getString(1);
       }catch(Exception ex) {return "sorry Exception is -"+ex;}
    }

    @Override
    public ResultSet getMasterStock() throws Exception {
     return db.DB.getCon().prepareCall("{call getMasterStock()}").executeQuery();
    }
    @Override
    public String deleteMaster(String sno) {
      try{
       String str = String.format("{call deletemaster(%s)}",sno);
       CallableStatement cs = db.DB.getCon().prepareCall(str);
       cs.execute();
       return "Master Stock Deleted";
       }catch(Exception ex) {return "sorry Exception is -"+ex;}
    }
   //  ---------------------- CART -------------------------------
    @Override
    public String addToCart(String pid, String qty,String userid) {
      try{
       String str = String.format("{call addToCart(%s,%s,'%s',?)}",pid,qty,userid);
       CallableStatement cs = db.DB.getCon().prepareCall(str);
       cs.registerOutParameter(1,Types.VARCHAR);
       cs.execute();
       return cs.getString(1);
       }catch(Exception ex) {return "sorry Exception is -"+ex;}
    }
   
    @Override
    public String getCartItems(String userid) {
      try{
       String str = String.format("{call getCartItems('%s')}",userid);
       CallableStatement cs = db.DB.getCon().prepareCall(str);
       ResultSet rs = cs.executeQuery();
       if(rs.next())
          return rs.getString(1);
       else
           return "0"; 
       }catch(Exception ex) {return "0"; }
    }
    @Override
    public ResultSet viewCart(String userid) throws Exception {
        String str = String.format("{call viewCart('%s')}", userid);
       return db.DB.getCon().prepareCall(str).executeQuery();
    }

    @Override
    public String deleteCartItem(String pid, String userid)
    {
      try{
       String str = String.format("{call deleteCartItem(%s,'%s')}",pid,userid);
       CallableStatement cs = db.DB.getCon().prepareCall(str);
       cs.execute();
       return "Item Successfully deleted from Cart.";
       }catch(Exception ex) {return "0"; }
    }

    @Override
    public String isExist(String pid) {
      try{
          String str = String.format("{call isExist(%s)}",pid);
          CallableStatement cs = db.DB.getCon().prepareCall(str);
          ResultSet rs = cs.executeQuery();
          rs.next();
          return rs.getString(1)+":"+rs.getString(2);
       }catch(Exception ex) {return "0"; }
     
    }

    @Override
    public void addOrder(String userid) {
       try{
          String str = String.format("{call addOrder('%s')}",userid);
          CallableStatement cs = db.DB.getCon().prepareCall(str);
          cs.execute();
       }catch(Exception ex) { }
    
    }

    @Override
    public String addPayment(String userid, String paymode, String trid, String addr) {
    String str = String.format("{call addPayment('%s','%s',%s,'%s',?)}",userid,paymode,trid,addr);
    try{
          CallableStatement cs = db.DB.getCon().prepareCall(str);
          cs.execute();
          return cs.getString(1);
       }catch(Exception ex) {return "Exception is - "+ex+"---"+str; }
     
    }
     
    public String updateorderStatus(String sno, String orderstatus, String deliveredTo, String deliveredBy,String delivereddate)
    {
       try
       {    
         String str = String.format("{call updateorderStatus(%s,'%s','%s','%s','%s',?)}", sno,orderstatus,deliveredTo,deliveredBy,delivereddate);
         CallableStatement cs = db.DB.getCon().prepareCall(str);
         cs.registerOutParameter(1,Types.VARCHAR); // register out mode parameter as varchar for return
         cs.execute();
         return cs.getString(1); // return out mode parameter value. 
       }catch(Exception ex) { return ex.getMessage();  }
     }
    
    public ResultSet paymentreport() throws Exception {
    	return db.DB.getCon().prepareCall("{call paymentreport()}").executeQuery();
    }
    public ResultSet getPayment(String sno) throws Exception {
        CallableStatement cs = db.DB.getCon().prepareCall("{call getPayment(?) }");
        cs.setString(1, sno); // set userid as 1st parameter - 1st ? value
        return cs.executeQuery(); // procedur
    
    
    }
     @Override
    public ResultSet getProductDetail(String pid) throws Exception {
     String str = String.format("{call getProductDetail(%s)}", pid);
     return db.DB.getCon().prepareCall(str).executeQuery();
    }

    @Override
    public ResultSet getCustOrdersDetails(String userid) throws Exception {
     String str = String.format("{call getCustOrdersDetails('%s')}", userid);
     return db.DB.getCon().prepareCall(str).executeQuery();
    
    }

    @Override
    public ResultSet canReturn(String date) throws Exception {
     String str = String.format("{call canReturn('%s')}", date);
     return db.DB.getCon().prepareCall(str).executeQuery();
    }
    
    
}

    

    
    
    

    

   
    

    
    
    
    
    


