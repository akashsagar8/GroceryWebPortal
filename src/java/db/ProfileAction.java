package db;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ProfileAction extends HttpServlet {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses = req.getSession();
        String userid = (String)ses.getAttribute("uid");
        String name = req.getParameter("name");
        String pid = req.getParameter("pid");
        String dob = req.getParameter("dob");
        String mobile = req.getParameter("mobile");
        String mailId = req.getParameter("mailid");
        String msg = db.UserDAO.getRef().updProfile(userid,name,pid,dob, mobile,mailId);
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("Profile.jsp").forward(req, resp);
    }
   
}

