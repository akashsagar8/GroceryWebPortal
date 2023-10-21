<%
      String q = request.getParameter("q");
      if(q==null) q = "";
      java.sql.ResultSet rs = db.DB.getProductReport(q);       
      int startctr = 0,endctr=1;
      while(rs.next())
      {
         if(startctr%4==0) 
             out.println("  <div class=row>");
         out.println("     <div class='col-xs-12 col-sm-12 col-md-6 col-lg-3 g-3'>");
         out.println("       <div class='card' style='height:380px;margin-top:20px; border-radius:10px; border:1px solid gray;box-shadow:4px 4px 5px gray '>");
         out.println("        <img src=Photo?id="+rs.getString(2)+" style='height:250px;' width='100%' class='card-img-top img-thumbnail'><br>");
         out.println("         <div class='cardbody'>");
           
         out.println("<P style='FONT-FAMILY:VERDANA;FONT-SIZE:14PX;margin-left:10px'>  " + rs.getString(3).toUpperCase()+"<BR>");
         out.println(" <S>MRP. : "+ rs.getString(4)+" INR</S>,");
         out.println("OFFER PRICE : "+rs.getString(5));
         out.println("<hr size=2 color=green>&nbsp;&nbsp;&nbsp;<A HREF=Productdetails.jsp?id="+rs.getString(1) +">View Details</a>");
         String ar[] = db.DB.isExist(rs.getString(1)).split(":");
        // out.println(ar[0]);
         if(ar[0].equals("0"))
             out.println("Out Of Stock <b class='btn btn-primary' disabled style='margin-left:10px'>Cart</b> <b class='btn btn-primary' style='margin-left:10px' disabled title='0 Items Available'>Buy Now.</b>");
         else
             out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AddToCart?id="+rs.getString(1)+" class='btn btn-primary' style='margin-left:10px'  title='"+ar[1]+" Items Available'>Cart</a> <a href=AddToCart?id="+rs.getString(1)+"&b=y class='btn btn-primary' style='margin-left:10px' title='"+ar[1]+" Items Available'>Buy Now.</a>");
               
         out.println("       </div>");
         out.println("     </div>");
         out.println("            </div>");
         if(endctr%4==0) 
             out.println("     </div>");
         
         startctr++;
         endctr++;
      }
      rs = db.DB.getOutOfStockItems(q);
      while(rs.next())
      {
         if(startctr%4==0) 
             out.println("  <div class=row>");
         out.println("     <div class='col-xs-12 col-sm-12 col-md-6 col-lg-3 g-3'>");
         out.println("       <div class='card' style='height:380px;margin-top:20px; border-radius:10px; border:1px solid gray;box-shadow:4px 4px 5px gray '>");
         out.println("        <img src=Photo?id="+rs.getString(2)+" style='height:250px;' width='100%' class='card-img-top img-thumbnail'><br>");
         out.println("         <div class='cardbody'>");
           
         out.println("<P style='FONT-FAMILY:VERDANA;FONT-SIZE:14PX;margin-left:10px'>  " + rs.getString(3).toUpperCase()+"<BR>");
         out.println(" <S>MRP. : "+ rs.getString(4)+" INR</S>,");
         out.println("OFFER PRICE : "+rs.getString(5));
         out.println("<hr size=2 color=green>&nbsp;&nbsp;&nbsp;<A HREF=Productdetails.jsp?id="+rs.getString(1) +">View Details</a>");
         String ar[] = db.DB.isExist(rs.getString(1)).split(":");
        // out.println(ar[0]);
         if(ar[0].equals("0"))
             out.println("Out Of Stock <b class='btn btn-primary' disabled style='margin-left:10px'>Cart</b> <b class='btn btn-primary' style='margin-left:10px' disabled title='0 Items Available'>Buy Now.</b>");
         else
             out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AddToCart?id="+rs.getString(1)+" class='btn btn-primary' style='margin-left:10px'  title='"+ar[1]+" Items Available'>Cart</a> <a href=AddToCart?id="+rs.getString(1)+"&b=y  class='btn btn-primary' style='margin-left:10px' title='"+ar[1]+" Items Available'>Buy Now.</a>");
               
         out.println("       </div>");
         out.println("     </div>");
         out.println("            </div>");
         if(endctr%4==0) 
             out.println("     </div>");
         
         startctr++;
         endctr++;
      }
      
      if(endctr%4!=0)
        out.println("</div>");
%> 
${cmsg}

</div>




