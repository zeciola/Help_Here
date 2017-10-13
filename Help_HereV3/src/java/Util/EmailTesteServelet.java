/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Diego
 */
public class EmailTesteServelet {
    public void Enviar(){
        SimpleEmail email = new SimpleEmail();

	try {
	email.setDebug(true);
	email.setHostName("smtp.gmail.com");
	email.setAuthentication("HelpHereBr@gmail.com","helphere123");
	email.setSSL(true);
	email.addTo("diegoselzzo13@hotmail.com"); //pode ser qualquer um email
	email.setFrom("HelpHereBr@gmail.com"); //aqui necessita ser o email que voce fara a autenticacao
	email.setSubject("Teste s");
	email.setMsg("Mensagem Testando por servelet");
	email.send();

	} catch (EmailException e) {

	System.out.println(e.getMessage());

	} 
    }
}
