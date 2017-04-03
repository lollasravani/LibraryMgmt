/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymgmt;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
/**
 *
 * @author Sravani
 */
public class Utilities {
    
    public static void registerDriver()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            System.out.println("Registration successful");

        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Include in your library path!");
            e.printStackTrace();
           return;
        }
    }
    
    public static Connection getSqlConnection()
    {
        Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/libraryManagementSystem", "postgres",
					"u4cse14142");

		} catch (SQLException e) {

			System.out.println("Connection for database failed");
			e.printStackTrace();
		

		}

		if (connection != null) {
			System.out.println("Database ------> ok");
                        return connection;
		} else {
			System.out.println("Failed to make connection!");
                        return null;
		}
    }
    
    public static ResultSet getResultSet(Connection connection,String sql)
    {
    
                Statement st = null;
                ResultSet rs = null;
        
        try
        {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            
       
        }
        catch(Exception e)
        {
            
        }
        
        return rs;
    }
    
    public static void sendEmail(String emailTo,String subject, String msg)
    {
         // Recipient's email ID needs to be mentioned.
      String to = emailTo;

      // Sender's email ID needs to be mentioned

      // Assuming you are sending email from localhost
      String host = "smtp.gmail.com";
	  String username = "kumari.lolla";
	  String password = "kumari1973";
      String from = "kumari.lolla@gmail.com";
	  
      // Get system properties
      Properties properties = System.getProperties();
	  properties.setProperty("mail.smtp.auth", "true");
	  properties.setProperty("mail.smtp.port", "587");
	  
      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

	  properties.setProperty("mail.smtp.starttls.enable","true");
	  
      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties,
			new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
					  }
					}	  
				  );

	  
	  
      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject(subject);

         // Send the actual HTML message, as big as you like
         message.setContent(msg, "text/html");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
    }
    
}
