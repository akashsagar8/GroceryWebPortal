package master;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MasterStockAction extends HttpServlet {
@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String pid = req.getParameter("pid");
       String qty = req.getParameter("qty");
       String price = req.getParameter("price");
       String billno = req.getParameter("billno");
       String billdate = req.getParameter("bdate");
       String salesman = req.getParameter("salesman");
       String msg = db.UserDAO.getRef().addItem(pid, qty, price, billno, billdate, salesman);
       req.setAttribute("msg", msg);
       req.getRequestDispatcher("MasterStock.jsp").forward(req, resp);
       
    }
}
