/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.CertificadoAction;

import Command.ICommand;
import DAO.DAOCertificado;
import DAO.DAOPenalisado;
import Model.Certificado;
import Model.Penalidade;
import Model.Pessoa;
import Model.Usuario;
import Util.email;
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
            c1.setEvento(c.getEvento());
            c1.setValido(t);
            c1.setAnalisado(true);
            c1.setPessoa(c.getPessoasPendesntes().get(i));
            
            cdao.AnalisaCertificado(c1);
            //se voluntario faltou realiza penalidade ao mesmo
            if(t == false){
                Penalidade pn = new Penalidade();
                pn.setP(c1.getPessoa());
                
                DAOPenalisado daopn = new DAOPenalisado();
                daopn.Penalisar(pn);
            }    
            if(t == true){
                email em = new email();
                em.sendEmail(c.getPessoasPendesntes().get(i).getEmail(), "Certificado Liberado", "boas noticias o seu certificado no evento "+c.getEvento().getNome()+" foi liberado ");
            }
        }
        //após terminar for mudar stats no evento como analisado
        cdao.UpAnalisadoev(c);
        
        sessaoUsuario.removeAttribute("itensvalidar");
        sessaoUsuario.removeAttribute("pessoasPendentes");
        
        return "acessologado/PerfilEmpresa.jsp";
    }
}
