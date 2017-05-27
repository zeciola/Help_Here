/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.EventoAction;

import Command.ICommand;
import DAO.DAOEvento;
import DAO.DAOInstituicao;
import Model.Instituicao;
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
        String CNP = null;
        String Sen = null;
        String NomeEV = null;
        
        String acao = request.getParameter("acao");
            if (acao.equals("Remover")) {
                
                NomeEV=(request.getParameter("txtnomeEV"));
 
            }else {
                return "erro.jsp";
            }
        
         HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
        Instituicao usuarioLogado =(Instituicao)sessaoUsuario.getAttribute("usuarioAutenticado");
        
            
         CNP=usuarioLogado.getCnpj();
                
         Sen = usuarioLogado.getSenha();
            
        
         daoi.Deletar(NomeEV,Sen);
         
        return "/sucesso.jsp";
    }
    
}
