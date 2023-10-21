

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
    
  
  <nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation"> 
     <div>
      <ul class="nav navbar-nav"> 
        <li><a href="index.jsp"><b>Home</b></a></li>
        <li><a href="Clients.jsp"><b>Clients</b></a></li>
        <li><a href="Info.jsp"><b>Information</b></a></li> 
        <li><a href="Aboutus.jsp"><b>About us</b></a></li> 
        
        <li><a href="Feedback.jsp"><b>Feedback</b></a></li>
        <li><a href="Contactus.jsp"><b>Contact us</b></a></li>
        
         
        </ul>
        <ul class="nav navbar-nav navbar-right">
       
      <li class="dropdown"> <img src="images/cart.jpeg" height="30" width="30" style="margin-top:13px;border-radius:15px;" title="7 Items in Cart"><a href="#" class="nav navbar-nav navbar-right dropdown-toggle" data-toggle="dropdown"><b> Welcome ayush</b> <b class="caret"></b> &nbsp;&nbsp;&nbsp; </a> 
            <ul class="dropdown-menu"> 
               <li><a href="ViewProfile.jsp"><b>View Profile</b></a></li> 
               <li class="divider"></li> 
               <li><a href="Profile.jsp"><b>Update Profile</b></a></li> 
               <li class="divider"></li> 
               <li><a href="UpdateCustomerAddress.jsp"><b>View/Add Customer Address</b></a></li> 
               <li class="divider"></li>
               <li><a href="ChangePass.jsp"><b>Change Password</b></a></li> 
               <li class="divider"></li> 
               
               <li><a href="Feedback.jsp"><b>Feedback</b></a></li> 
               <li class="divider"></li> 
               <li><a href="Complaints.jsp"><b>Complaints</b></a></li> 
               <li class="divider"></li> 
               <li><a href="UserComplaintsReport"><b>List of All Complaints</b></a></li> 
               <li class="divider"></li> 
               
               <li><a href="Logout.jsp"><b>Logout</b></a></li> 
            </ul>
        </li>
        
        </ul>
    </div>
    </nav>
      <!-- Modal dialog for Sign In -->
<div class="modal fade" id="signin" tabindex="-1" role="dialog" aria-labelledby="title" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="title"><b>Customer Sign In Form</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"><b>&times;</b></span>
        </button>
      </div>
      <div class="modal-body">
        <form action="ValidateAction" role="form" class='frm' method="post">
       <div class="form-group">
              User Id  <input type="text" name="userid" placeholder="Plz Enter User Id" class="form-control" />
          </div>
          <div class="form-group">
              Password <input type="password" name="pass" placeholder="Plz Enter ur Password" class="form-control" />
          </div>
          <center><input type="submit" value="Sign In" class="btn btn-primary" />   <input type="button" value="Forget Password" class="btn btn-primary" onclick="forget(document.forms[0])" /></center>
         </form>  
      </div>
      <div class="modal-footer">
         <big>Powered by ur Project Title&copy;2023, All Rights Reserved..</big> 
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="forget" tabindex="-1" role="dialog" aria-labelledby="title" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="title"><b>Please Enter ur User Id for forget Password</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true"><b>&times;</b></span>
        </button>
      </div>
      <div class="modal-body">
        <form action="ForgetAction" role="form" class='frm' method="post">
         <div class="form-group">
              User Id  <input type="text" name="userid" placeholder="Plz Enter User Id" class="form-control" />
          </div>
          <input type="submit" value="Forget Password" class="btn btn-primary btn-block" />   
        </form>  
      </div>
      <div class="modal-footer">
            <big>Powered by ur Project Title&copy;2022, All Rights Reserved..</big> 
      </div>
    </div>
  </div>
</div>


    <div class="container-fluid" style="padding-top:70px;padding-left:30px;padding-right:30px;padding-bottom:20px;">
     
    


  <div class=row>
     <div class='col-xs-12 col-sm-12 col-md-6 col-lg-3'>
       <div class='card' style='height:380px;margin-top:20px; border-radius:10px; border:1px solid gray;box-shadow:4px 4px 5px gray '>
        <img src=Photo?id=45 style='height:250px;' width='100%' class='card-img-top img-thumbnail'><br>
         <div class='cardbody'>
<P style='FONT-FAMILY:VERDANA;FONT-SIZE:14PX;margin-left:10px'>  JUMLEBAAZ INSAAN<BR>
 <S>MRP. : 998 INR</S>,
OFFER PRICE : 900
<hr size=2 color=green>&nbsp;&nbsp;&nbsp;<A HREF=#>View Details</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AddToCart?id=17 class='btn btn-primary' style='margin-left:10px'>Cart</a> <a href=AddToCart?id=17 class='btn btn-primary' style='margin-left:10px'>Buy Now.</a>
       </div>
     </div>
            </div>
  <div class=row>
     <div class='col-xs-12 col-sm-12 col-md-6 col-lg-3 g-3'>
       <div class='card' style='height:380px;margin-top:20px; border-radius:10px; border:1px solid gray;box-shadow:4px 4px 5px gray '>
        <img src=Photo?id=46 style='height:250px;' width='100%' class='card-img-top img-thumbnail'><br>
         <div class='cardbody'>
<P style='FONT-FAMILY:VERDANA;FONT-SIZE:14PX;margin-left:10px'>  YAMRAJ<BR>
 <S>MRP. : 150 INR</S>,
OFFER PRICE : 200
<hr size=2 color=green>&nbsp;&nbsp;&nbsp;<A HREF=#>View Details</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AddToCart?id=22 class='btn btn-primary' style='margin-left:10px'>Cart</a> <a href=AddToCart?id=22 class='btn btn-primary' style='margin-left:10px'>Buy Now.</a>
       </div>
     </div>
            </div>
  
Item Successfully add in Cart.
</div>






    </div>  
<footer class="text-center" style="background-color:#303030;color:white; margin-top:20px; border-radius:10px;font-family:'Courier New';font-size:15px;font-weight:bold;">
    <div class="row">
      <div style="padding:5px;">
        <a href="index.jsp">Home</a> |  <a href="Aboutus.jsp">About Us</a> |  <a href="Info.jsp">Information</a> | <a href="Feedback.jsp">Feedback</a> |  <a href="FAQ.jsp">FAQ</a> |  <a href="Contactus.jsp">Contact us</a> 
      </div>
    </div>  
 
  <div class="text-center" style="background-color: rgba(0, 0, 0, 0.2);border-radius:1px;">
    Powered by ur Project Title&copy;2023, All Rights Reserved..:
    <a class="text-dark" href="#">www.yoururl.com</a>, <br>Mail us: urmailid@gmail.com.
  </div>
</footer>
    </div>
  </body>
</html>




