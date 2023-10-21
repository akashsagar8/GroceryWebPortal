<%@page import="db.UserDAO"%>
<%@page import="db.DB"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
<div style="width:100%;min-height:400px;color:Black  ">
 <%
    String sno = request.getParameter("id");
    ResultSet rs = DB.getPayment(sno);
    rs.next();
    String deliverto = (rs.getString(8)==null)?"":rs.getString(8);
    String deliverby = (rs.getString(9)==null)?"":rs.getString(9);
 %>
 <style>
     .lbl { text-align: right;}
 </style>
 <form action="UpdateOrderStatusAction" method="post">
     
     <table class="table table-hover table-striped">
         <input type="hidden" name="sno" value="<%=rs.getString(1)%>" />
       <tr>
         <td class="lbl">Order Placed by </td><td><input type="text" value="<%=rs.getString(2)%>" class="form-control" readonly/></td>
         <td class="lbl">Payment Method. </td><td><input type="text" value="<%=rs.getString(3)%>" class="form-control" readonly/></td>
         <td class="lbl">Transaction Id.</td><td><input type="text" value="<%=rs.getString(4)%>" class="form-control" readonly/></td>
       </tr>  
       <tr>
         <td class="lbl">Order Id</td><td><input type="text" value="<%=rs.getString(5)%>" class="form-control" readonly/></td>
         <td class="lbl">Order Date. </td><td><input type="text" value="<%=rs.getString(6)%>" class="form-control" readonly/></td>
         <td class="lbl">Order Status</td><td><select name=orderstatus type="text" class="form-control" required>
                                                  <option value="">Select Option</option>
                                                  <%if(rs.getString(7).equals("DELIVERED")) {%>  
                                                    <option value="DELIVERED" selected>DELIVERED</option>
                                                  <%} else {%>  
                                                    <option value="DELIVERED">DELIVERED</option>
                                                  <%} %>  
                                                  <%if(rs.getString(7).equals("UN-DELIVERED")) {%>  
                                                    <option value="UN-DELIVERED" selected>UN-DELIVERED</option>
                                                  <%} else {%>  
                                                    <option value="UN-DELIVERED">UN-DELIVERED</option>
                                                  <%} %>
                                                  <%if(rs.getString(7).equals("CANCELED")) {%>  
                                                    <option value="CANCELED" selected>CANCELED</option>
                                                  <%} else {%>  
                                                    <option value="CANCELED">CANCELED</option>
                                                  <%} %>
                                                  <%if(rs.getString(7).equals("ON-HOLD")) {%>  
                                                    <option value="ON-HOLD" selected>ON-HOLD</option>
                                                  <%} else {%>  
                                                    <option value="ON-HOLD">ON-HOLD</option>
                                                  <%} %>
                                              </select></td>
       </tr>  
       <tr>
           
           <td class="lbl">Delivered To</td><td><input type="text" name="deliveredTo" required value="<%=deliverto%>" class="form-control"/></td>
           <td class="lbl">Delivered By </td><td><input type="text" name="deliveredBy" required value="<%=deliverby%>" class="form-control" /></td>
         <td class="lbl">Update Date</td><td><input type="date" name="delivereddate" value="<%=rs.getString(11)%>" class="form-control" /></td>
       </tr>  
       <tr>
         <td class="lbl">Order Address</td><td colspan="5"><textarea name=addr class="form-control"><%=rs.getString(10)%></textarea></td>
       </tr>  
       <tr>
         <td colspan="6"><center><input type="submit" value=" U p d a t e  S t a t u s " class="btn btn-primary" /> <input type="reset" value=" R e f r e s h  D e t a i l s " class="btn btn-primary" /> </td>
       </tr>  
       
     </table>
 </form>
 
 
 
 
 
<%@include file="Footer.jsp" %>