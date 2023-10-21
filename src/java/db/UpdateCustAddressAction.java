
package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateCustAddressAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String sno = req.getParameter("sno");
       String name = req.getParameter("name");
       String mobile = req.getParameter("mobile");
       String HNO = req.getParameter("HNO");
       String Sector = req.getParameter("Sector");
       String Street = req.getParameter("Street");
       String City = req.getParameter("city");
       String Landmark = req.getParameter("Landmark");
       String State = req.getParameter("State");
       String Pin = req.getParameter("Pin");
        HttpSession ses = req.getSession(true);
        String uid = (String)ses.getAttribute("uid");
       String msg = db.UserDAO.getRef().updateCustomerAddress(sno, name, mobile, HNO, Sector, Street, City, Landmark, State, Pin, uid);
       req.setAttribute("msg", msg);
       req.getRequestDispatcher("UpdateCustomerAddress.jsp").forward(req, resp);
       
    }
 
}

