package cart;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UpdateOrderStatusAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  String sno = req.getParameter("sno");
		  String orderstatus = req.getParameter("orderstatus");
                  String deliveredTo = req.getParameter("deliveredTo");
                  String deliveredBy = req.getParameter("deliveredBy");
                  
                  String delivereddate = req.getParameter("delivereddate");
		  String msg = db.UserDAO.getRef().updateorderStatus(sno, orderstatus, deliveredTo, deliveredBy, delivereddate);
		  req.setAttribute("pmsg", msg);
		  req.getRequestDispatcher("OrderReport").forward(req, res);
	   }
}




