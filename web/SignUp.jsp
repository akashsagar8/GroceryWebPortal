<%@include file="Header1.jsp" %>
<script>
    function view()
          {
              document.frm.action="PhotoAction";
              document.frm.enctype="multipart/form-data";
              document.frm.submit();
          }
</script>    
  <style>
      .lbl { text-align: right;font-family: verdana; font-size:14px; font-weight: bold;  } 
      .frm { border-left:3px solid #6d4419; border-right:3px solid #6d4419; border-radius:15px; }
  </style>
  <div class="row" style="margin-top:70px;margin-bottom: 80px;">
    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7 ">
      <form action="RegisterAction" role="form" method="post" name=frm 00class="frm">
         <table class="table table-md" width="100%"> 
           <tbody> 
       ${id}
               
            <tr>
                <td colspan='4' style='text-align:center;'><big>Customer Registration Form<big></td>
            </tr>
            <tr>
                <td class="lbl">Name</td><td><input type="text" name="name" value="${name}" placeholder="Plz Enter Name" class="form-control" required /></td>
                <input type="hidden" name="pid" value="${id}" />
                <td class="lbl">Photo</td><td><input type="file" name="ph" class="form-control" onchange="view()"/></td>
            </tr>
            <tr>
                <td class="lbl">User Id</td><td><input type="text" name="userid" placeholder="Plz Enter User Id" class="form-control" required /></td>
                <td class="lbl">Password</td><td><input type="password" name="pass" placeholder="Plz Enter ur Password" class="form-control" required /></td>
            </tr>
            <tr>
                <td class="lbl">D.O.B.</td><td><input type="date" name="dob" value="2004-01-01" max="2004-12-31" min="1947-08-15" class="form-control" required /></td>
                 <td class="lbl">Mobile</td><td><input type="number" name="mobile" placeholder="9990046906" class="form-control" /></td>
            </tr>
            <tr>
                 <td class="lbl">Mailid</td><td><input type="email" name="mailid" placeholder="abc@gmail.com" class="form-control" /></td>
            </tr>
            <tr>
               <td colspan="4"><input type="submit" value="Sign Up" class="btn btn-lg btn-primary btn-block" /> </td>
            </tr>    
            <tr>
               <td colspan="4"><%
                 String msg = (String)request.getAttribute("msg");
                 if(msg!=null) out.print(msg);
               %></td>
            </tr>    
           </tbody>
         </table> 
         </form>   
      </div>
      <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
             <% String id = (String)request.getAttribute("id"); if(id!=null) { %> 
            <img src="Photo?id=${id}" class="frm img-thumbnail" style="margin-top:40px;" height="100%" width="100%" border="1px" style="border-radius:10px;"> 
       <%}else {%>
       <img src="Photo?id=${id}"height="100%" style="margin-top:40px;" class='frm img-thumbnail' width="100%" border="1px" style="border-radius:10px;"> 
       <%}%>
      </div>
       
 <%@include file="Footer.jsp" %>
