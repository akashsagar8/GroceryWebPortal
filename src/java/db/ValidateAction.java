package db;
import db.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ValidateAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String userid = req.getParameter("userid");
         String pass = req.getParameter("pass");
         String msg = UserDAO.getRef().checkId(userid, pass);
         req.setAttribute("usermsg", msg);
         if(!msg.startsWith("Sorry"))
         {
             HttpSession ses = req.getSession(true);
             ses.setAttribute("uid", userid);
             ses.setAttribute("mode", msg);
         }    
         req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

