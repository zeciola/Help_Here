/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.CertificadoAction;

import Command.ICommand;
import DAO.DAOCertificado;
import Model.Certificado;
import Model.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego
 */
public class ListarProntoCertificadoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
        Usuario user = (Usuario) sessaoUsuario.getAttribute("usuarioAutenticado");
        
        Certificado c = new Certificado();
        c.setUsuario(user);
        
        DAOCertificado daoc = new DAOCertificado();
        ArrayList<Certificado> certs = daoc.ListaCertificadosLiberadosPorUser(c);
        
        sessaoUsuario.setAttribute("certificadosok", certs);        
        return "acessologado/Certificados.jsp";
    }
    
}
