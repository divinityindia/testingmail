/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class SendMailSSLMocha {  
 public static void main(String[] args) {  
  
 String to="praveencs.srm@gmail.com";//change accordingly  
// Address[] address={abc@gmail.com};
  
  //Get the session object  
  Properties props = new Properties();  
  props.put("mail.smtp.host","mail.pdeaetender.org");  
 //props.put("mail.smtp.socketFactory.port", "26");  
  //props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
 // props.put("mail.smtp.starttls.enable", "true");
  //props.put("mail.smtp.socketFactory.fallback", "true");
  props.put("mail.smtp.reportsuccess","true");
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "2525");  
   
  Session session = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("info@pdeaetender.org","techdivinity");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session);  
//   message.setFrom(new InternetAddress("yourgmailid@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
   message.setSubject("Hello1");  
   message.setText("Testing1.......");  
  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) 
  {
     throw new RuntimeException(e);
  }  
   
 }  
}  
