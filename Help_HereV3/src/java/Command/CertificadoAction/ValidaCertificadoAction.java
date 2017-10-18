/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.CertificadoAction;

import Command.ICommand;
import DAO.DAOCertificado;
import Model.Certificado;
import Model.Pessoa;
import Model.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego
 */
public class ValidaCertificadoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
        
        Certificado c = (Certificado) sessaoUsuario.getAttribute("pessoasPendentes");

        DAOCertificado cdao = new DAOCertificado();
        
        
        for(int i=0; i<c.getPessoasPendesntes().size(); i++){
            //o forma radio tem como id o id de pessoa)
            String v = ""+c.getPessoasPendesntes().get(i).getId();
            //recupera status
            Boolean t = Boolean.parseBoolean(request.getParameter(v));
            
            Certificado c1 = new Certificado();
            c1.setValido(t);
            c1.setAnalisado(true);
            c1.setPessoa(c.getPessoasPendesntes().get(i));

            cdao.AnalisaCertificado(c1);    
        }

        sessaoUsuario.removeAttribute("itensvalidar");
        sessaoUsuario.removeAttribute("pessoasPendentes");
        
        return "acessologado/PerfilEmpresa.jsp";
    }

}
