/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Evento;
import Model.Notificacao;
import java.util.ArrayList;

public class DAONotificacao {
    
    
    public ArrayList ListarParaNotificar(){
        ArrayList<Evento> e = new ArrayList();        
        String sql="select id from evento where tipo = 'Voluntariado' and datainicio between current_date and current_date+5 and status = true";
        return e;
    }
    
    public void ListarContatos(Notificacao n2){
        String sql2 = "select p.email from voluntario v, pessoa p, evento e, instituicao i, instituicaoevento instv where v.idpessoa = p.id and v.idevento = e.id and instv.idevento = e.id and instv.idinstituicao = i.id AND e.id = ?";
    }
    
}
