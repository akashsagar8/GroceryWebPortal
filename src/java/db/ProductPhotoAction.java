package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class ProductPhotoAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
        System.out.println("this is photo called");
        
        try { 
        String name=null;   
        FileItem ph = null;
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(req);
        for(FileItem n : items)
        {
           if(n.isFormField())
           {
               if(n.getFieldName().equals("name"))
                  name = n.getString();
           }
           else 
               ph = n;
        }   
        System.out.println("this is photo called");
        
        String str = db.UserDAO.getRef().addPhoto(ph);
        req.setAttribute("id", str);
        req.setAttribute("name", name);
            System.out.println(str);
       }catch(FileUploadException ex) { 
           ex.printStackTrace();
           
           req.setAttribute("msg",ex);}
       req.getRequestDispatcher("form.jsp").forward(req, resp);
        System.out.println("this is photo called");
    }
    
}

