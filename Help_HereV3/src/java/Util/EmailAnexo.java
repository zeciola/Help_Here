/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.File;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author Diego
 */
public class EmailAnexo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File f = new File("C:/Users/Diego/Documents/kraken/Help_Here/Help_HereV3/web/pdf/MeuPrimeiroBoleto2.pdf");

        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(f.getPath()); // Obtem o caminho do arquivo
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("File");
        attachment.setName(f.getName()); // Obtem o nome do arquivo

        try {
            // Create the email message
            MultiPartEmail email = new MultiPartEmail();
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setAuthentication("HelpHereBr@gmail.com", "helphere123");
            email.setSSL(true);
            email.addTo("diegoselzzo13@hotmail.com"); //pode ser qualquer um email
            email.setFrom("HelpHereBr@gmail.com"); //aqui necessita ser o email que voce fara a autenticacao
            email.setSubject("The file");
            email.setMsg("The file");

            // add the attachment
            email.attach(attachment);

            // send the email
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
