/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.CertificadoAction;

import Command.ICommand;
import DAO.DAOCertificado;
import Model.Certificado;
import Model.Instituicao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego
 */
public class BuscaCertificadoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAOCertificado daoc = new DAOCertificado();
        Certificado c = new Certificado();

        HttpSession sessaoUsuario = request.getSession();
        Instituicao ints = (Instituicao) sessaoUsuario.getAttribute("instAutenticado");

        c.setInstituicao(ints);

        ArrayList<Certificado> r = daoc.ListarPendentes(c);

        request.setAttribute("itensvalidar", r);
        return "acessologado/PerfilEmpresa.jsp";
    }

}
