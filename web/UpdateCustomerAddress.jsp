

<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
  <script>
            function view(st,cty)
            {
                x = new XMLHttpRequest();
                x.open("GET","City.jsp?st="+st+"&cty="+cty,true);
                x.onreadystatechange = viewState;
                x.send(null);
            }
            function viewState()
            {
                if(x.readyState==4)
                    document.getElementById("cty").innerHTML=x.responseText;
            }
        </script> 
        <style>
            .myrow { height:50px;} 
            .lbl {text-align: right; font-family: verdana; font-size:13px;}
        </style>
        <div class="row">
          <%
              java.sql.ResultSet rs,rs1 = null;
             String sno = request.getParameter("id");
             if(sno==null) // for add new address 
             {    
          %>   
            <div class="col-xs-12 col-sm-12 col-lg-4 col-md-4">
            <form action="AddCustAddressAction" method="POST">
              <table class="table-striped table-hover" width="100%">
               <tr class="myrow">   
                <td class="lbl">Name.</td><td><input type="text" name="name" class="form-control" placeholder="enter ur name" required /></td>
               </tr>   
               <tr class="myrow">   
                <td class="lbl">Mobile.</td><td><input type="text" name="mobile" class="form-control" placeholder="9990046906" required /></td>
               </tr>   
               <tr class="myrow">   
                <td class="lbl">H.NO.</td><td><input type="text" name="HNO" class="form-control" placeholder="enter house number" required /></td>
               </tr>   
               <tr class="myrow">
                   <td class="lbl">Sector</td><td> <input type="text" name="Sector" placeholder="Plz Enter ur Sector" class="form-control" required/> </td>
               </tr>               
               <tr class="myrow">
                   <td class="lbl">Street</td><td><input type="text" name="Street" class="form-control" placeholder="Plz Enter ur street" required />
               </tr>               
               <tr class="myrow">
                   <td class="lbl">Landmark</td><td><input type="text" class="form-control" placeholder="Plz Enter ur Landmark" name="Landmark" /></td>
               </tr>    
               <tr class="myrow">
                 <td class="lbl">State</td><td><select name="State" class="form-control" required onchange="view(this.value,null)"/>
               <option value=""> Select State</option>
                 <% 
               
                       rs = db.DB.getState();
                       String str;
                       while(rs.next())
                       {
                           str = String.format("<option value='%s'>%s</option>", rs.getString(1),rs.getString(1));
                           out.println(str); 
                       }
                  %>    
            
                    </select>
                 </td>
               </tr>  
               <tr class="myrow">
                   <td class="lbl">City</td><td id="cty"><select name="City" class="form-control" required/>
               <option value=""> Select City</option>
                    </select>
                </td>   
               </tr>
               <tr class="myrow">
                   <td class="lbl">Pin</td> <td> <input type="number" placeholder="201002" name="Pin" class="form-control" required /></td>
               </tr> 
               <tr class="myrow"><td colspan="2"><input type="submit" class="btn btn-primary btn-block" value="S a v e" /></td></tr>
               <tr><td colspan="2"> ${msg} </td></tr>
           </table>   
      </form>
      <% } else {
             rs1 = db.DB.getCustAddress(sno);
             if(rs1.next()) 
             {
      %>
            <div class="col-xs-12 col-sm-12 col-lg-4 col-md-4">
            <form name=updfrm action="UpdateCustAddressAction" method="POST">
              <table class="table-striped table-hover" width="100%">
               <tr class="myrow">   
               <input type="hidden" name="sno" value="<%=rs1.getString(1)%>">  
                <td class="lbl">Name.</td><td><input type="text" name="name" class="form-control" placeholder="enter ur name"  value="<%=rs1.getString(2)%>" required /></td>
               </tr>   
               <tr class="myrow">   
                <td class="lbl">Mobile.</td><td><input type="text" name="mobile" class="form-control" placeholder="9990046906"  value="<%=rs1.getString(3)%>" required /></td>
               </tr>   
               <tr class="myrow">   
                <td class="lbl">H.NO.</td><td><input type="text" name="HNO" class="form-control" placeholder="enter house number"  value="<%=rs1.getString(4)%>" required /></td>
               </tr>   
               <tr class="myrow">
                   <td class="lbl">Sector</td><td> <input type="text" name="Sector" placeholder="Plz Enter ur Sector" class="form-control"  value="<%=rs1.getString(5)%>" required/> </td>
               </tr>               
               <tr class="myrow">
                   <td class="lbl">Street</td><td><input type="text" name="Street" class="form-control" placeholder="Plz Enter ur street"  value="<%=rs1.getString(6)%>" required />
               </tr>               
               <tr class="myrow">
                   <td class="lbl">Landmark</td><td><input type="text" class="form-control" placeholder="Plz Enter ur Landmark" name="Landmark"  value="<%=rs1.getString(8)%>" /></td>
               </tr>    
               <tr class="myrow">
                 <td class="lbl">State</td><td><select name="State" class="form-control" required onchange="view(this.value,null)"/>
               <option value=""> Select State</option>
                 <% 
               
                       java.sql.ResultSet rs2 = db.DB.getState();
                       String str;
                       while(rs2.next())
                       {
                           if(rs2.getString(1).equals(rs1.getString(9)))
                             str = String.format("<option value='%s' selected>%s</option>", rs2.getString(1),rs2.getString(1));
                           else
                             str = String.format("<option value='%s'>%s</option>", rs2.getString(1),rs2.getString(1));
                           out.println(str); 
                       }
                  %>    
            
                    </select>
                    <script> view("<%=rs1.getString(9)%>","<%=rs1.getString(7)%>"); </script>
                 </td>
               </tr>  
               <tr class="myrow">
                   <td class="lbl">City</td><td id="cty"><select name="City" class="form-control" required/>
               <option value=""> Select City</option>
                    </select>
                </td>   
               </tr>
               <tr class="myrow">
                   <td class="lbl">Pin</td> <td> <input type="number" placeholder="201002"  value="<%=rs1.getString(10)%>" name="Pin" class="form-control" required /></td>
               </tr> 
               <tr class="myrow"><td colspan="2"><input type="submit" class="btn btn-primary btn-block" value="U p d a t e" /></td></tr>
               <tr><td colspan="2"> ${msg} <hr size="2" color="green"><a href="UpdateCustomerAddress.jsp">Add New Address</a></td></tr>
           </table>   
      </form>
      <% } } %>
      
    </div>
    <div class="col-xs-12 col-sm-12 col-lg-8 col-md-8"> 
       <%
          rs = db.DB.getCustomerAddress(uid);
          while(rs.next())
          {
            int startctr = 0,endctr=1;
            out.println("     <div class='col-xs-12 col-sm-12 col-md-4 col-lg-4'>");
            out.println("       <div class='card' style='height:250px;margin-top:20px; border-radius:10px; border:2px solid gray;box-shadow:4px 4px 5px gray '>");
            out.println("         <div class='cardbody'>");
            out.println("<p style='margin-top:20px;margin-left:30px;'>Address : <br> " + rs.getString(2)+"<br>");
            out.println("Mobile : "+rs.getString(3));
            out.println("<br>House No : "+rs.getString(4)+", "+rs.getString(5)+",<br>"+rs.getString(6)+"<br>");
            out.println(rs.getString(8)+" , "+rs.getString(7)+",<br>"+rs.getString(9)+"<br>Pin : "+rs.getString(10));
            out.println("<br><br><a href=UpdateCustomerAddress.jsp?id="+rs.getString(1)+" class='btn btn-warning' style='margin-left:10px'>update</a> <a href=DeleteAddress?id1="+rs.getString(1)+" class='btn btn-danger' style='margin-left:10px'>Delete</a> ");
            out.println("       </div>");
            out.println("     </div>");
            out.println("   </div>");
           }
          
       %> 
    </div>
   </div> 
 <%@include file="Footer.jsp" %>
