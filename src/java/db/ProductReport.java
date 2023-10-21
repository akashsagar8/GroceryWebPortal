package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ProductReport extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
       
        int startctr = 0,endctr=1;
     String name = req.getParameter("n");
     if(name == null)
         name="";
     req.getRequestDispatcher("Header1.jsp").include(req, resp);
     try 
     {
         String q = req.getParameter("q");
         if(q==null) q = "";
         ResultSet rs = db.UserDAO.getRef().getProductReport(q);
      PrintWriter out = resp.getWriter();
      out.println();
      while(rs.next())
      {
         if(startctr%4==0) 
             out.println("  <div class=row>");
         out.println("     <div class='col-xs-12 col-sm-12 col-md-6 col-lg-3 g-3'>");
         out.println("       <div class='card' style='height:480px;margin-top:20px; border:1px solid gray;box-shadow:4px 4px 5px gray '>");
         out.println("        <img src=Photo?id="+rs.getString(2)+" style='height:250px;' width='100%' class='card-img-top img-thumbnail'><br>");
         out.println("         <div class='cardbody'>");
           
         out.println("<h4 class='card-title' style='margin-left:10px'>  " + rs.getString(3)+"</h1>");
         out.println("<h4 class='card-title' style='margin-left:10px'> mrp "+" "+ rs.getString(4)+" rs </h4>");
         out.println("<h4 style='margin-left:10px'>Price : "+rs.getString(5)+"</h4>");
          out.println("<hr>");
          out.println("<h4 style='margin-left:10px'> "+rs.getString(8) +"</h4>");
         
          
//          HttpSession ses = req.getSession(true); // if session exist then cond.. with that, else design the new session
//           ses.setAttribute("id", rs.getString(1));
//        
//           
//           req.getRequestDispatcher("UpdateProduct.jsp").forward(req, resp);
           HttpSession ses = req.getSession();
           String umode = (String) ses.getAttribute("mode");
           if(umode==null) umode="";
           if(umode.equals("ADMIN"))
             out.println("<a href=UpdateProduct.jsp?id="+rs.getString(1)+" class='btn btn-warning' style='margin-left:10px'>update</a> <a href=DeleteProduct?id="+rs.getString(1)+" class='btn btn-danger' style='margin-left:10px'>Delete</a> ");
           else
             out.println("<a href=AddToCart?id="+rs.getString(1)+" class='btn btn-warning' style='margin-left:10px'>Cart</a>");
               
         out.println("       </div>");
         out.println("     </div>");
         
         
         out.println("            </div>");
         if(endctr%4==0) 
             out.println("     </div>");
         
         startctr++;
         endctr++;
         
      }
    //  out.println("</div>");
    //  out.println("</body>");
    //  out.println("</html>");
     }catch(Exception ex) {}  
    }
   
}

