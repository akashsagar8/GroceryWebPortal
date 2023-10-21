<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>  
     <style>
      .frm { padding: 30px; border-left:3px solid #6d4419; border-right:3px solid #6d4419; border-radius:15px; }
      .contact { position:fixed;left:-50px; top:48%; border-radius:15px; height:70px;width:70px;z-index:2;}
      .contact:hover{left:-1px;}
      
    </style>
    <script>  
          function forget(f) 
          {
              f.action="ForgetAction";
              f.submit();
          }
          
           function viewMyProduct(nm)
           {
             x = new XMLHttpRequest(); // AJAX object design kiya
             x.open("GET","ProductList.jsp?q="+nm.value,true); // true - synchronized 
            // alert("CustomerReport.jsp?n="+nm.value);
             x.onreadystatechange = myproductstate;
             x.send(null); //send method ke inside POST method ke argument aayega
           }
           function myproductstate()
           {
             // alert("state is - "+x.readyState)
              if(x.readyState==4)
                 document.getElementById("rpt").innerHTML = x.responseText;
               
           }
       </script>  
    </script>    
   <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/bootstrap-theme.min.css">
   <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
   <link rel="stylesheet" href="css/style.css">
   <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="contact">
       <a href="Contactus.jsp" class="contact"><img src="images/contactus.png" class=contact></a>
   </div>
    
  <%
       String usermsg = (String)request.getAttribute("usermsg");
       if(usermsg!=null)  out.println("<script>alert(\""+usermsg+"\"); </script>");
       String mode = (String)session.getAttribute("mode");
       if(mode==null) mode = "";
  %>
  <nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation"> 
     <div>
      <ul class="nav navbar-nav"> 
        <li><a href="index.jsp"><b>Home</b></a></li>
        <li><a href="Clients.jsp"><b>Clients</b></a></li>
        <li><a href="Info.jsp"><b>Information</b></a></li> 
        <li><a href="Aboutus.jsp"><b>About us</b></a></li> 
        <%  if(!mode.equals("ADMIN")) {  // Abhishek is a ADMIN  %>
        <li><a href="Feedback.jsp"><b>Feedback</b></a></li>
        <li><a href="Contactus.jsp"><b>Contact us</b></a></li>
        <% } %>
        <%  if(mode.equals("ADMIN")) {  // Abhishek is a ADMIN  %>
         <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Admin Menu </b><b class="caret"></b> </a> 
            <ul class="dropdown-menu"> 
               <li><a href="ComplaintsReport"><b>List of All Complaints</b></a></li> 
               <li class="divider"></li> 
               <li><a href="FeedbackReport"><b>List of All Feedbacks</b></a></li> 
               <li class="divider"></li> 
               <li><a href="ContactInfoReport"><b>List of All Contact Info</b></a></li> 
               <li class="divider"></li> 
               <li><a href="UserReport"><b>List of All Users</b></a></li> 
            </ul>
          </li>
          <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Product</b><b class="caret"></b> </a> 
              <ul class="dropdown-menu">
                   <li  ><a href= "Product.jsp">Add Product</a></li>
                   <li class="divider"></li>
                   <li><a href="ProductReport">Product List</a></li>
                   <li class="divider"></li>
                   <li><a href="MasterStock.jsp">Add Master Stock.</a></li>
                   <li class="divider"></li>
                   <li><a href="OrderReport">Order Report.</a></li>
                   
              </ul>
              
          </li>
          <% } %> 
          <li><input type="search" class="form-control" onkeyup="viewMyProduct(this)" style="    margin-top: 10px;"> </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
       <%
          String uid = (String)session.getAttribute("uid"); // get userid from session  
          if(uid==null) // if session not exist.
        	    out.print("<li><a href=#  data-toggle='modal' data-target=\"#signin\"><span class=\"glyphicon glyphicon-user\"></span><b>Sign In</b></a></li><li><a href=SignUp.jsp><span class=\"glyphicon glyphicon-log-in\"></span><b>Sign Up. &nbsp;&nbsp;</b></a></li>");
        	    // out.print("<li><a href=#  data-toggle='modal' data-target=\"#signin\"><span class=\"glyphicon glyphicon-user\"></span><b>Sign In</b></a></li><li><a href=#  data-toggle='modal' data-target=\"#forget\"><b>Forget</b></a></li><li><a href=SignUp.jsp><span class=\"glyphicon glyphicon-log-in\"></span><b>Sign Up. &nbsp;&nbsp;</b></a></li>");
         else
         {
      %>
      <li class="dropdown"><img src="images/cart.jpeg" height="30" width="30" style="margin-top:13px;border-radius:15px;" title="<%=db.DB.getCartItems(uid)%> Items in Cart" onclick="location.href='ViewCart';">  <a href="#" class="nav navbar-nav navbar-right dropdown-toggle" data-toggle="dropdown"><b> Welcome <%=uid %></b> <b class="caret"></b> &nbsp;&nbsp;&nbsp; </a> 
            <ul class="dropdown-menu"> 
               <li><a href="ViewProfile.jsp"><b>View Profile</b></a></li> 
               <li class="divider"></li> 
               <li><a href="Profile.jsp"><b>Update Profile</b></a></li> 
               <li class="divider"></li> 
               <li><a href="UpdateCustomerAddress.jsp"><b>View/Add Customer Address</b></a></li> 
               <li class="divider"></li>
               <li><a href="ChangePass.jsp"><b>Change Password</b></a></li> 
               <li class="divider"></li> 
               <% if(!mode.equals("ADMIN")) { %>
               <li><a href="Feedback.jsp"><b>Feedback</b></a></li> 
               <li class="divider"></li> 
               <li><a href="Complaints.jsp"><b>Complaints</b></a></li> 
               <li class="divider"></li> 
               <li><a href="UserComplaintsReport"><b>List of All Complaints</b></a></li> 
               <li class="divider"></li> 
               <li><a href="CustOrderReport"><b>Order History</b></a></li> 
               <li class="divider"></li> 
               
               <% } %>
               <li><a href="Logout.jsp"><b>Logout</b></a></li> 
            </ul>
        </li>
        <%} %>
        </ul>
    </div>
    </nav>
    <%@include file="model.jsp"%>
    <div class="container-fluid" style="padding-top:70px;padding-left:30px;padding-right:30px;padding-bottom:20px;">
     
    
