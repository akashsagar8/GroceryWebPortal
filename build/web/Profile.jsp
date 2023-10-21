<%@page import="db.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="Header1.jsp" %>
<script>
    function view()
          {
              document.frm.action="UpdPhotoAction";
              document.frm.enctype="multipart/form-data";
              document.frm.submit();
          }
</script>  
  <style>
      .lbl { text-align: right;font-family: verdana; font-size:14px; font-weight: bold;  } 
      .frm { border-left:3px solid #6d4419; border-right:3px solid #6d4419; border-radius:15px; }
  </style>
  <div class="row">
    <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
    <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7" >
      <form action="ProfileAction" role="form" method="post" class="frm" name="frm" style="padding-left:50px;padding-right:50px;">
         <table class="table table-md" width="100%"> 
           <tbody>
            ${id}   
            <tr>
                <td colspan='4' style='text-align:center;'><big><%=uid %> Customer Profile<big></td>
            </tr>
            <%
            // ResultSet rs = UserDAO.getRef().getProfile(uid);
            ResultSet rs = db.JSP.getProfile(uid);
            rs.next();
            %>
            <tr>
                <td class="lbl">Name</td><td><input type="text" name="name" value="<%=rs.getString(1) %>" class="form-control" required /></td>
                <td class="lbl">D.O.B.</td><td><input type="date" name="dob"  value="<%=rs.getString(3) %>" max="2004-12-31" min="1947-08-15" class="form-control" required /></td>
             <% String phid = (String)request.getAttribute("phid"); if(phid!=null) {%>    
                <input type="hidden" name="pid" value="${phid}" />
             <% }else {%>    
             <input type="hidden" name="pid" value="<%=rs.getString(2)%>" />
             <% } %>    
                <td class="lbl">Photo</td><td><input type="file" name="ph" class="form-control" onchange="view()" /></td>
            </tr>
            <tr>
                 <td class="lbl">Mobile</td><td><input type="text" name="mobile"  value="<%=rs.getString(4) %>" class="form-control" required /></td>
                 <td class="lbl">Mailid</td><td><input type="text" name="mailid"  value="<%=rs.getString(5) %>" class="form-control" required /></td>
            </tr>
            <tr>
               <td colspan="4"><input type="submit" value="Update Profile" class="btn btn-lg btn-primary btn-block" /> </td>
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
      <%if(phid!=null) {%>    
          <img src="Photo?id=<%=phid%>" class="frm img-thumbnail" style="margin-top:40px;" height="100%" width="100%" border="1px" style="border-radius:10px;"> 
      <% }else {%>    
          <img src="Photo?id=<%=rs.getString(2)%>" class="frm img-thumbnail" style="margin-top:40px;" height="100%" width="100%" border="1px" style="border-radius:10px;"> 
      <% }%>    
      </div>     
 <%@include file="Footer.jsp" %>
