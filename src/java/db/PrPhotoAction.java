package db;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
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
public class PrPhotoAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
               if(n.getFieldName().equals("pname"))
                  name = n.getString();
           }
           else 
               ph = n;
           resp.getWriter().println(""+n);
        }   
        String str = db.UserDAO.getRef().addPhoto(ph);
        req.setAttribute("id", str);
        req.setAttribute("pname", name);
       }catch(FileUploadException ex) { req.setAttribute("id","0");}
       req.getRequestDispatcher("Product.jsp").forward(req, resp);
    }
}


