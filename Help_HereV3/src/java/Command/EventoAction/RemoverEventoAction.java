/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.EventoAction;

import Command.ICommand;
import DAO.DAOEvento;
import DAO.DAOInstituicao;
import Model.Evento;
import Model.Instituicao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 11141104689
 */
public class RemoverEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAOEvento daoi = new DAOEvento();
        
        DAOEvento idao = new DAOEvento();
        ArrayList<Evento> eve = new ArrayList();
        
        
        HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
        Instituicao usuarioLogado =(Instituicao)sessaoUsuario.getAttribute("usuarioAutenticado");
        String SEN = usuarioLogado.getSenha();
        String CNP = usuarioLogado.getCnpj();
        String url = request.getParameter("url");
        
      
            

                String NomeEV = request.getParameter("txtnomeEV");
                
                eve = idao.ConsultarEVinst(NomeEV,SEN);

                if (eve.isEmpty())
                {
                    return "/EventoErrado.jsp"; 
                       
                }else {
                        daoi.Deletar(NomeEV,SEN);
                }
        return "/sucesso.jsp";
    }
    
}
