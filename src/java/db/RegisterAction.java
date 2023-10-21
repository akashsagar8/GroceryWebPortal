package db;
import db.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegisterAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String userid = req.getParameter("userid");
         String pass = req.getParameter("pass");
         String mobile = req.getParameter("mobile");
         String mailid = req.getParameter("mailid");
         String pid    = req.getParameter("pid");
         String dob = req.getParameter("dob");
         String name = req.getParameter("name");
         String registerIP = req.getRemoteAddr();
         String msg = UserDAO.getRef().addUser(userid, pass, name, pid, dob,mobile, mailid, registerIP);
         req.setAttribute("usermsg", msg);
         req.getRequestDispatcher("SignUp.jsp").forward(req, resp);
    }
}

