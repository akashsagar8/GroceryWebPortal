package contact;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DeleteContact extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  String id = req.getParameter("id");
	  String msg = db.UserDAO.getRef().deleteContact(id);
	  req.setAttribute("msg", msg);
	  req.getRequestDispatcher("ContactInfoReport").forward(req, res);
	}
}

