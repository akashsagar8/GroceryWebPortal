

package db;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteProduct extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String id = req.getParameter("id");
        
        try
        {
        String msg = db.UserDAO.getRef().deleteProduct(id);
        
         req.setAttribute("usrmsg", msg);
        req.getRequestDispatcher("ProductReport").forward(req, resp);
      
        
        
        }
        catch(Exception ex){ ex.printStackTrace();}
        
        
        
    }

    
    
    
    
}
