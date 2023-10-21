<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
        <style>
            .myrow { height:50px;} 
            .lbl {text-align: right; font-family: verdana; font-size:13px;}
        </style>
      <div class="row">  
       <div class="col-xs-1 col-sm-1 col-lg-1 col-md-1"></div> 
       <div class="col-xs-7 col-sm-7 col-lg-7 col-md-7"> 
        <h2>1. Select a delivery address.</h2>   
        <%
          ResultSet rs = db.DB.getCustomerAddress(uid);
          int ctr = 0;
          while(rs.next())
          {
            out.println(" <form action=PaymentMethod.jsp>");
            out.println("  <div class='col-xs-12 col-sm-12 col-md-12 col-lg-12'>");
            if(ctr==0)
              out.println("<input type=radio name=addr checked value="+rs.getString(1)+">&nbsp;&nbsp;" + rs.getString(2)+", ");
            else
              out.println("<input type=radio name=addr value="+rs.getString(1)+"> &nbsp;&nbsp;" + rs.getString(2)+", ");
            out.println("House No : "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)+", ");
            out.println(rs.getString(8)+" , "+rs.getString(7)+", "+rs.getString(9)+", Pin : "+rs.getString(10));
            out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mobile : "+rs.getString(3)+"<hr size=3 color=green>");
            out.println("       </div>");
            ctr++;
           }
          
       %>
       <input type='submit' value='Use this Address' class='btn btn-success btn-lg'>  <a href="UpdateCustomerAddress.jsp"><b  class='btn btn-success btn-lg'>Add New Address</b></a> 
        <hr size="2" color="green">
      <h2>2. Payment method.</h2>   
        <hr size="2" color="green">    
      <h2>3. items & delivery.</h2>  
         <hr size="2" color="green">
      <p>
            Need help? Check our help pages or contact us
When your order is placed, we'll send you an e-mail message acknowledging receipt of your order. If you choose to pay using an electronic payment method (credit card, debit card or net banking), you will be directed to your bank's website to complete your payment. Your contract to purchase an item will not be complete until we receive your electronic payment and dispatch your item. If you choose to pay using Pay on Delivery (POD), you can pay using cash/card/net banking when you receive your item.
<br>See our Return Policy.
            
        </p>
        
    </div>
     <div class="col-xs-3 col-sm-3 col-lg-3 col-md-3"> 
        <center> 
        <input type="submit" value="Use this Address" class="btn btn-success btn-lg"><br>
        Choose  a shipping address and payment method to calculate shipping, handling and tax.
        </center>
        <hr size="2" color="green">
        <h1>Order Summary</h1>
        <h3>Order Total (${qty} Item) : ${total} INR.</h3>
        <hr size="2" color="green">
        <h3>inauguration Offer : free delivery.</h3>
        <hr size="2" color="green">
      
     </div>
    </div>
 <%@include file="Footer.jsp" %>
