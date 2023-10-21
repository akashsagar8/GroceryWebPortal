package db;

import java.sql.DriverManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
public class MyListener implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
         db.DB.setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/wagner","root",""));
         System.out.println("Connection Successfully Designed on - load on startup");
         
      }catch(Exception ex) { System.err.println("Sorry Connection not design - "+ex);}
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         DB.setCon(null);
         System.out.println("Connection Destroy.............");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        DB.ctr++;
        System.out.println("New Session designed , now active users r - "+DB.ctr);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        DB.ctr--;
        System.out.println("Current Session designed , now active users r - "+DB.ctr);
    }
}
