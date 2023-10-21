package cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSetMetaData;
import javax.servlet.http.HttpSession;
public class CustOrderReport extends HttpServlet {
  private static final long serialVersionUID = 1L;
  protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      HttpSession ses = req.getSession(true);
     String uid = (String)ses.getAttribute("uid");
     req.getRequestDispatcher("Header1.jsp").include(req, res);	
     PrintWriter out = res.getWriter();
     out.println("<div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\"></div>");
     out.println("<table class=\"table table-striped table-hover\">");
     out.println("<hread>");
     out.println("<tr>");
     try
     {
    	ResultSet rs = db.UserDAO.getRef().getCustOrdersDetails(uid);
        ResultSetMetaData mt = rs.getMetaData(); // get meta data for col infi
        for(int i=1;i<mt.getColumnCount();i++)
            out.print("<th>"+mt.getColumnName(i).toUpperCase()+"</th>");
        out.println("</td>Action.<td>");
        out.println("</thead><tbody>");
        while(rs.next())
        {
        	out.println("<tr>");
        	for(int i=1;i<mt.getColumnCount();i++)
                {    
                  if(rs.getString(i)!=null)
                    out.print("<td>"+rs.getString(i)+"</td>");
                  else
                    out.print("<td></td>");
                } 
                if(rs.getString(11)==null)
                    out.println("<td><a href=CancelOrder?n="+rs.getString(1)+">Cancel</a>");
                else
                {
                    ResultSet rst = db.UserDAO.getRef().canReturn(rs.getString(11));
                    rst.next();
                    out.println(rs.getInt(1)+" --- "+rs.getString(11));
                    if(rst.getInt(1)>0)
                      out.println("<td><a href=ReturnOrder?n="+rs.getString(1)+">Return</a>");
                    else
                      out.println("<td><u>Return Order</u>");
                }    
                out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        String msg = (String)req.getAttribute("pmsg");
        if(msg!=null)
        	out.print(msg);
        
     }catch(Exception ex) {}
     req.getRequestDispatcher("Footer.jsp").include(req, res);	
     
  }

}


