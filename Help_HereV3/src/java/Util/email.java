/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Diego
 */
public class email {

    private static String HostName = "smtp.gmail.com";
    private static String EmailFrom = "helpherebr@gmail.com";
    private static String Passw = "helphere123";
    //private String EmailTo = "jr.ciola.bricio@gmail.com";
    //private String Subject = "Teste de Email do HelpHere";
    //private String Msg = "Teste de email";
    
    
    public void sendEmail(String EmailTo, String Subject, String Msg) throws EmailException {

        SimpleEmail email = new SimpleEmail();

        try {
            email.setDebug(true);
            email.setHostName(HostName);
            email.setSmtpPort(465);
            email.setAuthentication("helpherebr@gmail.com", "helphere123");
            email.setSSL(true);
            email.addTo(EmailTo); //pode ser qualquer um email
            email.setFrom(EmailFrom); //aqui necessita ser o email que voce fara a autenticacao
            email.setSubject(Subject);
            email.setMsg(Msg);
            email.send();

        } catch (EmailException e) {

            System.out.println(e.getMessage());

        }
    }

}
