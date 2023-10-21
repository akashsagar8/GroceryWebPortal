package db;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Security;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class ForgetAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String uid = req.getParameter("userid");
      String msg = db.UserDAO.getRef().forget(uid);
      if(msg.startsWith("Sorry"))     
      {
         req.setAttribute("usrmsg", msg);
         req.getRequestDispatcher("index.jsp").forward(req, resp);
      }
      else
      {
        String ar[] = msg.split(":");
        PrintWriter out = resp.getWriter();
        try {  
          String[] EMAILADDR = {ar[1],"manojrajora.agile@gmail.com"}; 
          Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
          Properties props = new Properties();
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.auth", "true");
          props.put("mail.debug", "true");
          props.put("mail.smtp.port", "465");
          props.put("mail.smtp.socketFactory.port", "465");
          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
          props.put("mail.smtp.socketFactory.fallback", "false");
          Session ses = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
             protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication("devildd643","thankyou2k18");//Please Provide The Sender Address
               }
         });
         ses.setDebug(true);
         Message msgg = new MimeMessage(ses); // Multipurpose Internet Mail Extension 
         InternetAddress addressFrom = new InternetAddress("devildd643@gmail.com");
         msgg.setFrom(addressFrom);
         InternetAddress[] ADDRESS_TO = new InternetAddress[EMAILADDR.length];
         for (int i = 0; i < EMAILADDR.length; i++) {
            ADDRESS_TO[i] = new InternetAddress(EMAILADDR[i]);
       }
       msgg.setRecipients(Message.RecipientType.BCC, ADDRESS_TO);
      // Setting the Subject and Content Type
       msgg.setSubject("Hello "+uid+", ur Password is - "+ar[0]);
       msgg.setContent("Hello "+uid+", this mail send on request for password recovery & ur password is - "+ar[0], "text/html");
       
       Transport.send(msgg);
      } catch(Exception e){ req.setAttribute("usermsg", e.toString());}
      req.setAttribute("usermsg","ur password successfully send on ur mail id. ");
      req.getRequestDispatcher("index.jsp").forward(req, resp);
    } 
  }
}

