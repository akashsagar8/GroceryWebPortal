
<%@include file="Header1.jsp" %>
<%@page import="java.sql.ResultSet"%>
<%
    String id = request.getParameter("id");
    
    ResultSet rss = db.DB.getProductDetail(id);
    rss.next();
    String ar[] = db.DB.isExist(rss.getString(1)).split(":");
    
%>

<div  class="row" >
    <div class="col-md-6">
        <div  style="text-align: center; ">
            <img src="Photo?id=<%=rss.getString(2)%>" style='height:410px;' width='50%' class=' img-thumbnail'>
        </div>
        <div style="padding: 10px; text-align: center; margin-top: 10px">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AddToCart?id=<%=rss.getString(1)%> class='btn btn-primary' style='margin-left:10px'  title="<%=ar[1]%> Items Available">Cart</a> <a href="AddToCart?id=<%=rss.getString(1)%>&b=y" class='btn btn-primary' style='margin-left:10px' title="<%=ar[1]%> Items Available">Buy Now.</a>  </div>
    </div>
        
    <div class="col-md-6">
        <div style="padding-top: 10px;">
            <h2  style=" margin-bottom: 20px;"><%=rss.getString(3)%></h2>
            <div  >
                <p  ><%=rss.getString(8)%></p>
                <p>Rating 4 156 Reviews</p>
                <h3 style="margin-bottom: 20px"><s><%=rss.getString(4)%></s><b style="margin-left: 20px"><%=rss.getString(5)%> INR</b></h3>
                <table cellpadding="10">
                    <tr>
                        <th>Specifications</th>
                        <th>Description</th>
                    </tr>
                    <tr>
                        <td>Quality</td>
                        <td> very good </td>
                    </tr>
                    <tr>
                        <td>Quantity</td>
                        <td>1 pcs</td>
                    </tr>
                    <tr>
                        <td>Expiry</td>
                        <td><%=rss.getString(7)%></td>
                    </tr>
                    <tr>
                        <td>Manufactured</td>
                        <td><%=rss.getString(6)%></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>  
                </table> 
            </div>
        </div>
    </div>
</div>


<%@include file="Footer.jsp" %>



