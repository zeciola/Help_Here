/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.CertificadoAction;

import Command.ICommand;
import DAO.DAOCertificado;
import Model.Certificado;
import Model.Evento;
import Model.Pessoa;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego
 */
public class BuscarPCertificadoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {     
        
        HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
        
        DAOCertificado daoc = new DAOCertificado();
        
        Evento e = new Evento();
        e.setIdEvento(Integer.parseInt(request.getParameter("idEvento")));
                
        Certificado c = new Certificado();
        c.setEvento(e);
        
        ArrayList<Pessoa> pendente = daoc.ListarVoluntariosP(c);
        c.setPessoasPendesntes(pendente);
        
        sessaoUsuario.setAttribute("pessoasPendentes", c);
        return "acessologado/ValidaCert.jsp";
    }
}
