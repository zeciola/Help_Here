/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/*
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
 */
import com.sun.javafx.tk.Toolkit.Task;
import java.util.Properties;
import javax.faces.bean.ApplicationScoped;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Lucas Puglia
 */
public class EmailJava {

    public void enviarEmail(String from, String subject, String msg, String to) {
        Properties props = new Properties();
        // Parâmetros de conexão com servidor Gmail 
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.ssl.enable", true);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("HelpHereBr@gmail.com", "helphere123");
            }
        });
        // Ativa Debug para sessão
        session.setDebug(true);
        try {
            //Remetente
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            //Destinatário(s)
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(msg);
            //Método para enviar a mensagem criada

            try {
                Transport.send(message);
                System.out.println("E-mail enviado com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Algum erro macabro ta ocorrendo");
            }
            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
