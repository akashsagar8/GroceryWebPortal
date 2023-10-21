package db;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;                                                                  

public class DeleteAddress extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("id1");
       String msg = db.UserDAO.getRef().deleteAddress(id);
       req.setAttribute("msg", msg);
       req.getRequestDispatcher("UpdateCustomerAddress.jsp").forward(req, resp);
    }
  
}

