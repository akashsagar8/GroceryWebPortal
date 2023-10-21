

package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UpdateProduct extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
        
            String id = req.getParameter("prid");
            String photo = req.getParameter("pid");
            String pname = req.getParameter("pname");
            
            String pmrp = req.getParameter("pmrp");
            String price = req.getParameter("price");
            String mfdate = req.getParameter("mfdate");
            String expdate = req.getParameter("expdate");
            String disc = req.getParameter("dicp");
            
            PrintWriter out = resp.getWriter();
            
            out.println(id);
            out.println(photo);

            out.println(pname);
            out.println(pmrp);
            out.println(price);
            out.println(mfdate);
            out.println(expdate);
            out.println(disc);

            String msg = db.UserDAO.getRef().updateProduct(id, photo, pname, pmrp, price, mfdate, expdate, disc);
            
            out.println(msg);
            
        
        

        
//            
         req.setAttribute("usrmsg", msg);
      req.getRequestDispatcher("ProductReport").forward(req, resp);
        
        
//    
    
    
    }
    
    
    
    




}

