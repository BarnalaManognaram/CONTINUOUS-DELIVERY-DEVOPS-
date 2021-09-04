package loginServlet;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.event.*;

public class Mail {

   
    static final String FROM = "Dance";
    static final String FROMNAME = "Dance";

   
    public static   String TO ;
   static final String SMTP_USERNAME = "dancestudiobyrrc25@gmail.com";
   
   
    static final String SMTP_PASSWORD = "dance@25";
   
   
    static final String CONFIGSET = "ConfigSet";
   
   
    static final String HOST = "smtp.gmail.com";
   
    static final int PORT = 587;
   
    static final String SUBJECT = "DANCE WEBSITE";
   
    static final String BODY = String.join(
       System.getProperty("line.separator"),
       
       "<hr>",
       "<p>This email was sent because you created account in our DANCE website @Dance Till 'Dawn</p>"
        
    );

    public static void emsend(String eemail) throws Exception {

 
    Properties props = System.getProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.port", PORT);
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.auth", "true");

         
    Session session = Session.getDefaultInstance(props);

       
       
    MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        TO=eemail;
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/html");
       
       
        msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
           
       
        Transport transport = session.getTransport();
         
        try
        {
            System.out.println("Sending...");
           
             transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
       
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
           
            transport.close();
        }
       
    }
}