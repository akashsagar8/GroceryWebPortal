package cart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AddToCart extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession ses = req.getSession(true);
      String userid = (String)ses.getAttribute("uid");
      if(userid==null)
      {
         req.setAttribute("usermsg", "Sorry U can't add Items before Sign In, Plz Login with your id.");
         req.getRequestDispatcher("index.jsp").forward(req, resp);
      }
      else
      {    
        String pid = req.getParameter("id");
        String b = req.getParameter("b");
        if(b==null) b = "";
        String msg = db.UserDAO.getRef().addToCart(pid, "1", userid);
        req.setAttribute("cmsg", msg);
        if(b.equals("y"))
            req.getRequestDispatcher("ProceedToBuy.jsp").forward(req, resp);
        else 
            req.getRequestDispatcher("index.jsp").forward(req, resp);
      }
    }      
}
