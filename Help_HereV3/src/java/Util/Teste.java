/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Lucas Puglia
 */
public class Teste {
    public static void main (String[] args){

        EmailJava email = new EmailJava();
        String from = "HelpHereBr@gmail.com"; 
        String subject = "Bem Vindo ao HelpHere";
        String msg = "Seu cadastro foi efetuado com sucesso";
        String to = "lucas_puglia@hotmail.com";
        email.enviarEmail(from, subject, msg, to);
    }
}
