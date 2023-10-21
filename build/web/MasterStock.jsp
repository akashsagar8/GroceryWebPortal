

<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
        <style>
            .myrow { height:50px;} 
            .lbl {text-align: right; font-family: verdana; font-size:13px;}
        </style>
        <div class="row">
          <div class="col-xs-12 col-sm-12 col-lg-4 col-md-4">
            <form action="MasterStockAction" method="POST">
              <table class="table-striped table-hover" width="100%">
               <tr class="myrow">   
                <td class="lbl">Product Id.</td> <td><select name="pid" class="form-control" required/>
               <option value=""> Select Product.</option>
                 <% 
               
                       java.sql.ResultSet rs = db.DB.getProductIds();
                       String str;
                       while(rs.next())
                       {
                           String ar[] = db.DB.isExist(rs.getString(1)).split(":");
                           if(ar[1].equals("null")) ar[1] = "0";
                           str = String.format("<option value='%s'>%s (%s Items Available)</option>", rs.getString(1),rs.getString(2),ar[1]);
                           out.println(str); 
                       }
                  %>    
            
                    </select>
                 </td>
               </tr>   
               <tr class="myrow">   
                <td class="lbl">Quantity.</td><td><input type="text" name="qty" class="form-control" placeholder="0" required /></td>
               </tr>   
               <tr class="myrow">   
                <td class="lbl">Price.</td><td><input type="text" name="price" class="form-control" placeholder="price" required /></td>
               </tr>   
               <tr class="myrow">
                   <td class="lbl">Bill No</td><td> <input type="text" name="billno" placeholder="Plz Enter Bill No" class="form-control" required/> </td>
               </tr>               
               <tr class="myrow">
                   <td class="lbl">Bill Date</td><td><input type="date" name="bdate" class="form-control" placeholder="Plz Enter ur street"  required />
               </tr>               
               <tr class="myrow">
                   <td class="lbl">Salesman</td><td><input type="text" class="form-control" placeholder="Plz Enter Salesman Name" name="salesman" /></td>
               </tr>  
               <tr class="myrow"><td colspan="2"><input type="submit" class="btn btn-primary btn-block" value="S a v e" /></td></tr>
               <tr><td colspan="2"> ${msg} </td></tr>
           </table>   
      </form>
    
    </div>
    <div class="col-xs-12 col-sm-12 col-lg-8 col-md-8">
        <table class="table-striped table-hover" width="100%">
       <%
                rs = db.DB.getMasterStock(); 
	        ResultSetMetaData mt = rs.getMetaData(); // get meta data for col infi
	        for(int i=1;i<=mt.getColumnCount();i++)
	            out.print("<th>"+mt.getColumnName(i).toUpperCase()+"</th>");
	        out.println("<th>Action</tr>");
	        out.println("</thead><tbody>");
	        while(rs.next())
	        {
	        	out.println("<tr>");
	        	for(int i=1;i<=mt.getColumnCount();i++)
	        	   out.print("<td>"+rs.getString(i)+"</td>");
	               	out.println("<td> <a href=DeleteMaster?sno="+rs.getString(1)+"><span class='glyphicon glyphicon-trash'></span</a>");
	            out.println("</tr>");
	        }
	        out.println("</tbody>");
	        out.println("</table>");
    %> 
    </div>
   </div> 
 <%@include file="Footer.jsp" %>
