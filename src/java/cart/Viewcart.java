package cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Viewcart extends HttpServlet 
{
	  private static final long serialVersionUID = 1L;
          @Override
	  protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     req.getRequestDispatcher("Header1.jsp").include(req, res); // include the Header page in servlets.	
	     PrintWriter out = res.getWriter();
	     HttpSession ses = req.getSession(true);
             String uid = (String) ses.getAttribute("uid");
	     out.println("<div class=\"col-xs-1 col-sm-1 col-md-1 col-lg-1\"></div>");
	     out.println("<div class=\"col-xs-10 col-sm-10 col-md-10 col-lg-10\"></div>");
	     out.println("<table class=\"table table-striped table-hover\">");
	     out.println("<hread>");
	     out.println("<tr>");
	     try
	     {
	    	ResultSet rs = db.UserDAO.getRef().viewCart(uid); 
	        ResultSetMetaData mt = rs.getMetaData(); // get meta data for col infi
	        for(int i=1;i<=mt.getColumnCount();i++)
	            out.print("<th>"+mt.getColumnName(i).toUpperCase()+"</th>");
	        out.println("<th>Action</tr>");
	        out.println("</thead><tbody>");
                int qty = 0;
                double total = 0;
	        while(rs.next())
	        {
	        	out.println("<tr>");
	        	for(int i=1;i<=mt.getColumnCount();i++)
	        	{
                           if(i==4)
                           { 
                              if(rs.getInt(i)>0) 
                                 out.print("<td><a href=QuantityP?id="+rs.getString(1)+"><img src=images/plus.jpg height=30 width=30></a> "+String.format("%02d",rs.getInt(i))+" <a href=QuantityM?id="+rs.getString(1)+"><img src=images/minus.png height=30 width=30></a></td>");
                              else
                                 out.print("<td><a href=QuantityP?id="+rs.getString(1)+"><img src=images/plus.jpg height=30 width=30></a> "+String.format("%02d",rs.getInt(i))+" <img src=images/minus.png height=30 style='cursor:pointer;' width=30></td>");
                           }
                           else if(i==5)
                               out.print("<td>"+rs.getDouble(i)+" INR</td>");
                           else 
                               out.print("<td>"+rs.getString(i)+"</td>");
	        	}	
                        total += rs.getDouble(5);
                        qty += rs.getInt(4);
                       	out.println("<td><a href=DeleteCart?id="+rs.getString(1)+"><span class='glyphicon glyphicon-trash'></span</a>");
	            out.println("</tr>");
	        }
                out.println("<tr><td></td><td></td><td></td><td>Total : "+qty+" Items</td><td>"+total+" INR</td><td></td>");
                out.println("<tr><td colspan=6><center><a href=index.jsp><b class='btn btn-primary btn-lg'>Add More Items</b> <a href=ProceedToBuy.jsp><b class='btn btn-primary btn-lg'>Proceed to Buy</b></a></center>");
                
	        out.println("</tbody>");
	        out.println("</table>");
	        String msg = (String)req.getAttribute("msg");
	        if(msg!=null)
	        	out.print(msg);
	        ses.setAttribute("qty", ""+qty);
	        ses.setAttribute("total", ""+total);
	     }catch(Exception ex) {}
	     req.getRequestDispatcher("Footer.jsp").include(req, res);	
	     
	}
}
