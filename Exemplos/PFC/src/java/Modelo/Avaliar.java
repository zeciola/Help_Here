/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.DAOEvento;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Avaliar {
    DAOEvento edao = new DAOEvento();
    public void atualizarDivul(){
        ArrayList<Evento> evlist= edao.Listar2();
        Date datahoje = new Date(System.currentTimeMillis());
                for(Evento e: evlist){
                    if(e.getInicio().after(datahoje)  ){
                        edao.setEvento(e);
                        edao.Ativar();
                    }
                     if(e.getDataFim().before(datahoje)  ){
                        edao.setEvento(e);
                        edao.Desativar();
                    }
                }   
    }
}
