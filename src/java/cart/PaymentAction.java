package cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class PaymentAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession ses = req.getSession(true);
          String userid = (String) ses.getAttribute("uid");
          if(userid == null)
          {
              req.setAttribute("usermsg", "Sorry U can't contd.. without Login");
              req.getRequestDispatcher("index.jsp").forward(req, resp);
          }
          String sno = req.getParameter("addr");
          String paymode = req.getParameter("paymode");
          try {  
            ResultSet rs = db.DB.getCustAddress(sno);
            String addr = ""; 
            if(rs.next())
            {
              addr = rs.getString(2)+", House No : "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)+", "+rs.getString(8)+" , "+rs.getString(7)+", "+rs.getString(9)+", "+rs.getString(10)+", Mobile : "+rs.getString(3);
            }
            db.UserDAO.getRef().addOrder(userid);
            String msg = db.UserDAO.getRef().addPayment(userid, paymode, "0", addr);
            req.setAttribute("usermsg", msg);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
          }catch(Exception ex) { }  
     }
    
}
