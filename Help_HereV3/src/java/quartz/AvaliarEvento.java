/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quartz;

import DAO.DAOEvento;
import Model.Evento;
import java.sql.Date;
import java.util.ArrayList;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Diego
 */
public class AvaliarEvento implements Job {

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        DAOEvento edao = new DAOEvento();
        ArrayList<Evento> evlist = edao.Listar();
        Date datahoje = new Date(System.currentTimeMillis());
        for (Evento e : evlist) {
            if (e.getDataFim().before(datahoje)) {
                edao.Desativar(e);
                System.out.println("passou aqui");
            }
        }
        System.out.println("Operação de atualização realizada: "+new java.util.Date());
    }
}
