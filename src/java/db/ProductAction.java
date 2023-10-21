package db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ProductAction extends HttpServlet 
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String pname = req.getParameter("pname");
      String pid = req.getParameter("pid");
      String pmrp = req.getParameter("pmrp");
      String price = req.getParameter("price");
      String mfdate = req.getParameter("mfgdate");
      String expdate = req.getParameter("expdate");
      String dicp = req.getParameter("dicp");
      
      

      String msg = db.UserDAO.getRef().addProduct(pid,pname, pmrp,price,mfdate,expdate,dicp);
      req.setAttribute("prmsg", msg);
      req.getRequestDispatcher("Product.jsp").forward(req, resp);
      
    }
   
}

