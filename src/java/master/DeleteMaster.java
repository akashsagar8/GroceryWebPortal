package master;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ayush
 */
public class DeleteMaster extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = req.getParameter("sno");
        try
        {
          String msg = db.UserDAO.getRef().deleteMaster(sno);
        
         req.setAttribute("msg", msg);
        req.getRequestDispatcher("MasterStock.jsp").forward(req, resp);
      
        
        
        }
        catch(Exception ex){ ex.printStackTrace();}
        
        
    }

     
}
