package cart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class DeleteCart extends HttpServlet {
 @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession ses = req.getSession(); 
       String userid = (String) ses.getAttribute("uid");
       String pid = req.getParameter("id");
       String msg = db.UserDAO.getRef().deleteCartItem(pid, userid);
       req.setAttribute("msg", msg);
       req.getRequestDispatcher("ViewCart").forward(req, resp);
    }
  
}
