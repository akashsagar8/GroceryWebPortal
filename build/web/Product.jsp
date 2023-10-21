<%@include file="Header1.jsp" %>
<style>
    tr { height:70px;}
    .lbl { text-align: right;font-family: verdana;font-size:13px;}
    .form-control { height:55px;font-family: verdana;font-size:13px;}
</style>
<script>
                                                                    
                                                                    
    function view()//this method is for upload file 
    {
        document.frm.action = "PrPhotoAction";
        document.frm.enctype = "multipart/form-data";

//              alert("THanxxxxxxxxxxxxxx- "+document.forms[0].elements[0].value);
        document.frm.submit();
    }




</script>

<!--s--------------------------------- this is the form ------------------------------>


<form action="ProductAction"  method="post" name='frm' style="margin-top: 10px;">

    <div class="row"  id="myform1" >

        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12" style="border:2px solid darkgray; border-radius: 15px;height:490px;"   >


            <% String id = (String) request.getAttribute("id");
                             if (id != null) { %> 
            <img src="Photo?id=${id}" width=100% class="img-thumbnail" style="height: 480px;width:100%;"> 
            <%}%>

        </div>

        <!--                <div class=" close myclose" onclick="item()" style="margin-top: 5px; height:30px; margin-right:5px"><i class="fa fa-close fa-2xl" aria-hidden="true"></i></div>-->


        <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 "> 

         <table class="table table-hover table-striped">
            <tr>
              <td class="lbl">Product Name</td>
              <td><input type="text" name="pname" class="form-control"class="form-control" value="${pname}"id=""/></td>
              <td class="lbl">Product Photo</td>
              <td><input type="hidden" name="pid" value="${id}" />
                  <input type="file" name="photo" onchange="view()"class="form-control "/> </td>
            </tr>
            <tr>
               <td class="lbl">Maximum MRP</td>
               <td><input type="text" name="pmrp"class="form-control"/></td>
               <td class="lbl">Sale Price</td>
               <td> <input type="text" name="price" class="form-control"/></td>
            </tr>   
            <tr>
               <td class="lbl">MFG Date</td>
               <td><input type="date" name="mfgdate" value="2023-01-01" class="form-control" /></td>
               <td class="lbl">Expire Date</td>
               <td><input type="date" name="expdate" value="2025-01-01" class="form-control"/></td>
            </tr>   
            <tr>
                <td class="lbl">Discription</td>
                <td colspan="3"><textarea name="dicp" rows="5 cols=50" class="form-control"></textarea></td>
            </tr>
            <tr>
                <td colspan="4"><input type="submit"value="Add Product Details."  class="btn btn-primary btn-block btn-lg" /></td>
            </tr>
            <tr>
                <td colspan="4"> ${prmsg} </td>
            </tr>    
         </table>
        </div>
    </div>

      
</form>








<%@include file="Footer.jsp" %>  

