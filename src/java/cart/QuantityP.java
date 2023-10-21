package cart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class QuantityP extends HttpServlet {
 @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String pid = req.getParameter("id");
      HttpSession ses = req.getSession(true);
      String userid = (String)ses.getAttribute("uid");
      String msg = db.UserDAO.getRef().addToCart(pid, "1", userid);
      req.setAttribute("cmsg", msg);
      req.getRequestDispatcher("ViewCart").forward(req, resp);
    }}
