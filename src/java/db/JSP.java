package db;
import java.sql.ResultSet;

public class JSP {
    public static ResultSet getProfile(String userid) throws Exception
    {
	  return UserDAO.getRef().getProfile(userid);
    }    
}

