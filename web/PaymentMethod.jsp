<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
       <script>
           function showcc()
           {
              //if(document.getElementById("rcc")).isChecked; 
               if(document.getElementById("rcc").checked==true)
               {    
                 document.getElementById("cc").style.display="block";
                 document.getElementById("upi").style.display="none";
               }  
           }
           function showupi()
           {
               if(document.getElementById("rupi").checked==true)
               {    
                  document.getElementById("cc").style.display="none";
                  document.getElementById("upi").style.display="block";
              }   
           }
           function showcod()
           {
               if(document.getElementById("rcod").checked==true)
               {    
                  document.getElementById("cc").style.display="none";
                  document.getElementById("upi").style.display="none";
              }   
           }
           
           
       </script>    
        <style>
            .myrow { height:50px;} 
            .lbl {text-align: right; font-family: verdana; font-size:13px;}
        </style>
      <div class="row">  
       <div class="col-xs-1 col-sm-1 col-lg-1 col-md-1"></div> 
       <div class="col-xs-7 col-sm-7 col-lg-7 col-md-7"> 
        <h2>1. Delivery Address.</h2>   
        <%
          String sno = request.getParameter("addr");
          ResultSet rs = db.DB.getCustAddress(sno);
          if(rs.next())
          {
            out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(2)+", ");
            out.println("House No : "+rs.getString(4)+", "+rs.getString(5)+", "+rs.getString(6)+", ");
            out.println(rs.getString(8)+" , "+rs.getString(7)+", "+rs.getString(9)+",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pin : "+rs.getString(10));
            out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mobile : "+rs.getString(3)+"<hr size=3 color=green>");
          }
       %>
       
       </div>
       <div class="row"> </div> 
       <div class="col-xs-1 col-sm-1 col-lg-1 col-md-1"></div> 
       <div class="col-xs-7 col-sm-7 col-lg-7 col-md-7">  
        <form action="PaymentAction" method="get">   
          <input type="hidden" value=<%=sno%> name=addr />   
        <h2>2. Payment mode.</h2>
        <h3><input type="radio" name="paymode" value="COD" id=rcod onchange="showcod()" checked/> COD</h3>  
             
            <h3><input type="radio" name="paymode" value="UPI" id="rupi" onchange="showupi()" /> UPI.</h3> 
            <span id="upi"  style='display:none;'>
                <input type="text" name="upi" class="form-control" style="margin-left:50px;width:20em;" placeholder="Plz Enter UPI ID">
            </span>    
            <h3><input type="radio" name="paymode" value="CC/DC" id="rcc" onchange="showcc()" /> Credit Card / Debit Card</h3> 
            <span id="cc" style='display:none;'>
                <input type="text" name="cc" class="form-control" style="margin-left:50px;width:20em;" placeholder="Plz Enter Card Number"><br>
                <b style="margin-left:30px;">Exp. Date<br>  
                          <select name=mon style="border:1px solid gray;height:36px;font-family:verdana;font-size:13px;margin-left:44px;width:6em;display:inline;" >
                            <option value=''>Month</option>
                            <%
                                  String str;
                                  for(int i=1;i<=12;i++)
                                  {
                                     str = String.format("<option value=%d>%d</option>", i,i);
                                     out.println(str);
                                  }  
                            %>
                          </select> <select name=yr  style="border:1px solid gray;height:36px;font-family:verdana;font-size:13px;margin-left:5px;width:6em;display:inline;">
                           <option value=''>Year</option>
                            <%
                                  for(int i=2023;i<=2032;i++)
                                  {
                                     str = String.format("<option value=%d>%d</option>", i,i);
                                     out.println(str);
                                  }  
                            %>
                          </select> <input type="text" name="cvv"  style="border:1px solid gray;height:36px;font-family:verdana;font-size:13px;margin-left:5px;width:6em;display:inline;" placeholder="CVV"><br>
              
            </span>    
            <h3><input type="radio" name="paymode" value="NB" disabled /> Net Banking </h3>
        <center> 
        <input type="submit" value="Pay" class="btn btn-success btn-lg"><br>
         
        </center> 
        </form> 
            </div>     
      <div class="col-xs-3 col-sm-3 col-lg-3 col-md-3"> 
        <hr size="2" color="green">
        <h1>Order Summary</h1>
        <h3>Order Total (${qty} Item) : ${total} INR.</h3>
        <hr size="2" color="green">
        <h3>inauguration Offer : free delivery.</h3>
        <hr size="2" color="green">
      
     </div>
    </div>
      
      
        
 <%@include file="Footer.jsp" %>
