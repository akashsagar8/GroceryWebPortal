<% 
   session.invalidate();
   request.setAttribute("usermsg", "U r Successfully Logout....");
   request.getRequestDispatcher("index.jsp").forward(request, response);
%>


