package cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSetMetaData;
public class OrderReport extends HttpServlet {
  private static final long serialVersionUID = 1L;
  protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     req.getRequestDispatcher("Header1.jsp").include(req, res);	
     PrintWriter out = res.getWriter();
     out.println("<div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\"></div>");
     out.println("<table class=\"table table-striped table-hover\">");
     out.println("<hread>");
     out.println("<tr>");
     try
     {
    	ResultSet rs = db.UserDAO.getRef().paymentreport();
        ResultSetMetaData mt = rs.getMetaData(); // get meta data for col infi
        for(int i=1;i<mt.getColumnCount();i++)
            out.print("<th>"+mt.getColumnName(i).toUpperCase()+"</th>");
        out.println("<th>Action</tr>");
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
               if(!rs.getString(7).equals("DELIVERED"))
                  out.println("<td><a href=UpdateOrderStatus.jsp?id="+rs.getString(1)+"><span class='glyphicon glyphicon-edit'></span></a> | <span class='glyphicon glyphicon-trash'></span");
               else
                  out.println("<td><a href=UpdateOrderStatus.jsp?id="+rs.getString(1)+"><span class='glyphicon glyphicon-edit'></span></a> | <a href=DeleteComplaint?id="+rs.getString(1)+"><span class='glyphicon glyphicon-trash'></span</a>");
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


