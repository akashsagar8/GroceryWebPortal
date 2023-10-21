 <select name="city" class="form-control">
          <option value="">Select City</option>
          <%
             String st = request.getParameter("st");
             String cty = request.getParameter("cty");
             if(cty==null) cty="";
             java.sql.ResultSet rs = db.DB.getCity(st);
             String str;
             while(rs.next())
             {
                 if(rs.getString(1).equals(cty))
                    str = String.format("<option value='%s' selected>%s</option>", rs.getString(1),rs.getString(1));
                 else
                    str = String.format("<option value='%s'>%s</option>", rs.getString(1),rs.getString(1));
                 
                 out.println(str);
             }
          %>
      </select>