/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
/*
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
*/

/**
 *
 * @author Lucas Puglia
 */
public class EmailJava {
    
         
    public void enviarEmail(String from, String subject, String msg, String to){
        SimpleEmail email = new SimpleEmail();
        try {
            
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setDebug(true);
        email.setAuthentication("HelpHereBr@gmail.com", "helphere123");
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(true);
            
            
            email.setFrom(from);
            email.setSubject(subject);
            email.setMsg(msg);
            email.addTo(to);
            email.send();
        } catch (EmailException ex) {
            System.out.println("Erro"+ex);
            //Logger.getLogger(EmailJava.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("passou");
        }
        
    }
    
    /*
    public void enviarEmail(String from, String subject, String msg, String to){
    Properties props = new Properties();
            // Parâmetros de conexão com servidor Gmail 
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("HelpHereBr@gmail.com", "helphere123");
                             }
                        });
            // Ativa Debug para sessão
            session.setDebug(true);
            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(from)); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(to);  
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject(subject);//Assunto
                  message.setText(msg);
                  //Método para enviar a mensagem criada
                  Transport.send(message);
                  
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
    
    
    */
    
    
    
    
    
}
